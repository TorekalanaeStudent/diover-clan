import { useCrudLogic } from "../hooks/useCrudLogic";

export default function EmployeeList() {
  const { employees, loading, error } = useCrudLogic();

  if (loading) return <p>Loading employees...</p>;
  if (error) return <p>{error}</p>;

  return (
    <div style={{ padding: 20 }}>
      <h2>Employee List (Admin View)</h2>

      {employees.map((emp) => (
        <div key={emp.employeeId} style={{ borderBottom: "1px solid #ccc", padding: 10 }}>
          <p>Name: {emp.employeeName}</p>
          <p>Email: {emp.employeeEmail}</p>
          <p>Position: {emp.employeePosition}</p>
          <p>Status: {emp.currentlyInShift ? "On Shift" : "Off Shift"}</p>
        </div>
      ))}
    </div>
  );
}