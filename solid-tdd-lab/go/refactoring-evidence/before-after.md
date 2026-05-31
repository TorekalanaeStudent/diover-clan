# Refactoring Evidence (Before vs After)

This section documents key refactoring improvements applied to the Employee Management System using SOLID principles and OOP best practices.

## 1. Validation Logic (SRP + DRY)

Before, validation logic was directly inside the service layer, causing mixed responsibilities.

public EmployeeResponseDTO createEmployee(EmployeeDTO dto) {

    if (dto == null) {
        throw new IllegalArgumentException("DTO cannot be null");
    }

    if (dto.getName() == null || dto.getName().isBlank()) {
        throw new IllegalArgumentException("Name is required");
    }

    Employee employee = new Employee();
    employee.setName(dto.getName());
    employee.setBaseSalary(dto.getBaseSalary());
    employee.setBonus(dto.getBonus());

    return repository.save(employee);
}

After refactoring, validation is delegated to a dedicated utility class.

public EmployeeResponseDTO createEmployee(EmployeeDTO dto) {

    EmployeeValidator.validate(dto);

    Employee employee = new Employee();
    employee.setName(dto.getName());
    employee.setBaseSalary(dto.getBaseSalary());
    employee.setBonus(dto.getBonus());

    Employee saved = repository.save(employee);

    return new EmployeeResponseDTO(
            saved.getId(),
            saved.getName(),
            saved.calculateTotalSalary()
    );
}

Improvement:
- SRP applied (validation separated from business logic)
- DRY improved (centralized validation logic)
- Service layer simplified and focused

## 2. Hardcoded Logic → Strategy Pattern (OCP + LSP)

Before, salary computation used conditional logic inside service.

public double computeSalary(Employee emp) {

    if (emp.getType().equals("MONTHLY")) {
        return emp.getBaseSalary();
    } else if (emp.getType().equals("HOURLY")) {
        return emp.getHoursWorked() * emp.getHourlyRate();
    }

    return 0;
}

After refactoring, Strategy Pattern was introduced.

public interface PayrollStrategy {
double computeSalary(Employee employee);
}

public class MonthlyPayroll implements PayrollStrategy {
public double computeSalary(Employee employee) {
return employee.getBaseSalary();
}
}

public class HourlyPayroll implements PayrollStrategy {
public double computeSalary(Employee employee) {
return employee.getHoursWorked() * employee.getHourlyRate();
}
}

Improvement:
- OCP applied (new payroll types can be added without modifying existing code)
- LSP satisfied (interchangeable implementations)
- Removed if/else logic

## 3. Tight Coupling (DIP)

Before, service directly handled validation and repository logic.

public EmployeeResponseDTO createEmployee(EmployeeDTO dto) {

    if (dto.getName().isBlank()) {
        throw new IllegalArgumentException();
    }

    Employee employee = new Employee();

    return repository.save(employee);
}

After refactoring, dependencies are injected and abstracted.

public class EmployeeServiceImpl {

    private final EmployeeRepository repository;
    private final EmployeeValidator validator;

    public EmployeeServiceImpl(EmployeeRepository repository,
                               EmployeeValidator validator) {
        this.repository = repository;
        this.validator = validator;
    }

    public EmployeeResponseDTO createEmployee(EmployeeDTO dto) {

        validator.validate(dto);

        Employee employee = new Employee();
        employee.setName(dto.getName());

        Employee saved = repository.save(employee);

        return new EmployeeResponseDTO(
                saved.getId(),
                saved.getName(),
                saved.calculateTotalSalary()
        );
    }
}

Improvement:
- DIP applied (depends on abstractions)
- Improved testability (Mockito-friendly)
- Reduced coupling

## 4. Mutable DTO → Immutable DTO

Before:

public class EmployeeResponseDTO {

    private Long id;
    private String name;
    private double totalSalary;

    public void setName(String name) {
        this.name = name;
    }
}

After:

@Getter
@AllArgsConstructor
public class EmployeeResponseDTO {

    private final Long id;
    private final String name;
    private final double totalSalary;
}

Improvement:
- Immutable object design
- Thread-safe DTO
- Prevents accidental modification

## 5. Repository Safety (DIP + Exception Handling)

Before:

Employee employee = repository.findById(id).get();

After:

return repository.findById(id)
.orElseThrow(() ->
new ResourceNotFoundException("Employee not found"));

Improvement:
- Safe null handling
- Clear domain exception
- Improved service reliability