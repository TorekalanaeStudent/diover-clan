import { useState } from "react";
import { useCrudLogic } from "../hooks/useCrudLogic";
import type { Employee } from "../types/Employee";

export default function CrudUI() {
  const {
    employees,
    loading,
    error,
    createEmployee,
    updateEmployee,
    deleteEmployee,
  } = useCrudLogic();

  const emptyForm: Employee = {
    employeeName: "",
    employeeEmail: "",
    employeePassword: "",
    employeePosition: "",
    currentlyInShift: false,
    isAdmin: false,
  };

  const [form, setForm] = useState<any>(emptyForm);
  const [editingId, setEditingId] = useState<number | null>(null);

  const handleChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    const { name, value, type, checked } = e.target;

    setForm({
      ...form,
      [name]: type === "checkbox" ? checked : value,
    });
  };

  const handleSubmit = async () => {
    if (editingId !== null) {
      await updateEmployee(editingId, form);
      setEditingId(null);
    } else {
      const { employeeId, ...cleanForm } = form;
await createEmployee(cleanForm);
    }

    setForm(emptyForm);
  };

  const handleEdit = (emp: Employee) => {
    setForm(emp);

      if (emp.employeeId !== undefined) {
    setEditingId(emp.employeeId);
  }
  };

  const handleDelete = async (id?: number) => {
    if (!id) return;
    await deleteEmployee(id);
  };

  return (
    <div style={{ padding: 20 }}>
      <h2>Admin CRUD Panel</h2>

      {/* FORM */}
      <div style={{ marginBottom: 20 }}>
        <input
          name="employeeName"
          placeholder="Name"
          value={form.employeeName}
          onChange={handleChange}
        />

        <input
          name="employeeEmail"
          placeholder="Email"
          value={form.employeeEmail}
          onChange={handleChange}
        />

        <input
          name="employeePassword"
          placeholder="Password"
          type="password"
          value={form.employeePassword}
          onChange={handleChange}
        />

        <input
          name="employeePosition"
          placeholder="Position"
          value={form.employeePosition}
          onChange={handleChange}
        />

        <label>
          On Shift:
          <input
            type="checkbox"
            name="currentlyInShift"
            checked={form.currentlyInShift}
            onChange={handleChange}
          />
        </label>

        <button onClick={handleSubmit}>
          {editingId ? "Update Employee" : "Add Employee"}
        </button>
      </div>

      {/* STATUS */}
      {loading && <p>Loading...</p>}
      {error && <p style={{ color: "red" }}>{error}</p>}

      {/* LIST */}
      <h3>Employee List</h3>

      {employees.map((emp) => (
        <div
          key={emp.employeeId}
          style={{
            border: "1px solid #ccc",
            padding: 10,
            marginBottom: 10,
          }}
        >
          <p><b>{emp.employeeName}</b></p>
          <p>{emp.employeeEmail}</p>
          <p>{emp.employeePosition}</p>
          <p>{emp.currentlyInShift ? "On Shift" : "Off Shift"}</p>

          <button onClick={() => handleEdit(emp)}>Edit</button>
          <button onClick={() => handleDelete(emp.employeeId)}>
            Delete
          </button>
        </div>
      ))}
    </div>
  );
}