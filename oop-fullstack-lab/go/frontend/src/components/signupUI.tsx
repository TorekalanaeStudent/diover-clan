import { useState } from "react";
import { useSignupLogic } from "../hooks/useSignupLogic";
import type { Employee } from "../types/Employee";

type Props = {
  onSignupSuccess: () => void;
  onBackToLogin: () => void;
};

export default function SignupUI({ onSignupSuccess, onBackToLogin }: Props) {
  const { signup, loading, error } = useSignupLogic();

  const [form, setForm] = useState<Employee>({
    employeeId: 0,
    employeeName: "",
    employeeEmail: "",
    employeePassword: "",
    employeePosition: "",
    currentlyInShift: false,
    isAdmin: false,
  });

  const handleChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    const { name, value, type, checked } = e.target;

    setForm({
      ...form,
      [name]: type === "checkbox" ? checked : value,
    });
  };

  const handleSubmit = async () => {
    const res = await signup(form);

    if (res) {
      onSignupSuccess(); 
    }
  };

  return (
    <div className="login-container">
      <h2>Employee Signup</h2>

      <input name="employeeName" placeholder="Name" onChange={handleChange} />
      <input name="employeeEmail" placeholder="Email" onChange={handleChange} />
      <input name="employeePassword" placeholder="Password" type="password" onChange={handleChange} />
      <input name="employeePosition" placeholder="Position" onChange={handleChange} />

      <label>
        On Shift:
        <input
          type="checkbox"
          name="currentlyInShift"
          checked={form.currentlyInShift}
          onChange={handleChange}
        />
      </label>

      <button onClick={handleSubmit} disabled={loading}>
        Sign Up
      </button>

      <button type="button" onClick={onBackToLogin}>
       Back to Login
      </button>

      {error && <p style={{ color: "red" }}>{error}</p>}
    </div>
  );
}