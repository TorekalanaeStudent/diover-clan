    package com.navarro.app.controller;

    import com.navarro.app.model.Employee;
    import com.navarro.app.service.EmployeeService;

    import lombok.RequiredArgsConstructor;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.*;
    import java.util.List;

    @RestController
    @RequestMapping("/api/employees")
    @RequiredArgsConstructor
    @CrossOrigin(origins = "http://localhost:5173", allowedHeaders = "*")
    public class EmployeeController {

        private final EmployeeService employeeService;

        @GetMapping
        public ResponseEntity<List<Employee>> getUsers() {
            return ResponseEntity.ok(employeeService.getAllUser());
        }

        @PostMapping("/create")
        public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
            return ResponseEntity.ok(employeeService.createEmployee(employee));
        }

        @PutMapping("/update/{id}")
        public ResponseEntity<Employee> updateEmployee(
                @PathVariable Long id,
                @RequestBody Employee employee
        ) {
            return ResponseEntity.ok(employeeService.updateEmployee(id, employee));
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
            employeeService.deleteEmployee(id);
            return ResponseEntity.noContent().build();
        }
    }