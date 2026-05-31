import { useState } from "react";
import { useEmployeeLogin } from "../hooks/useEmployeeLogin";
import type { Employee } from "../types/Employee";

type Props = {
  onLoginSuccess: (employee: Employee) => void;
};

export default function LoginUI({ onLoginSuccess }: Props) {
  const { login, loading, error } = useEmployeeLogin();

  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");

  const handleSubmit = async () => {
    const user = await login(email, password);

    if (user) {
      onLoginSuccess(user); // ✅ THIS FIXES EVERYTHING
    }
  };

  return (
    <div className="login-container">
      <h2>Login</h2>

      <input
        placeholder="Email"
        value={email}
        onChange={(e) => setEmail(e.target.value)}
      />

      <input
        placeholder="Password"
        type="password"
        value={password}
        onChange={(e) => setPassword(e.target.value)}
      />

      <button onClick={handleSubmit} disabled={loading}>
        {loading ? "Logging in..." : "Login"}
      </button>

      {error && <p style={{ color: "red" }}>{error}</p>}
    </div>
  );
}