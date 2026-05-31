import type { Employee } from "../types/Employee";

type Props = {
  employee: Employee;
};

export default function EmployeeCredentials({ employee }: Props) {
  return (
    <div style={{ padding: 20, border: "1px solid black" }}>
      <h2>Employee Profile</h2>

      <p>ID: {employee.employeeId}</p>
      <p>Name: {employee.employeeName}</p>
      <p>Email: {employee.employeeEmail}</p>
      <p>Position: {employee.employeePosition}</p>
      <p>
        Shift Status:{" "}
        {employee.currentlyInShift ? "Currently Working" : "Not On Shift"}
      </p>
    </div>
  );
}