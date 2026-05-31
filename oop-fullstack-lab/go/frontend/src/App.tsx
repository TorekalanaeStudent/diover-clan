import { useState } from "react";
import "./App.css";

import LoginUI from "./components/loginUI";
import SignupUI from "./components/signupUI";
import CrudUI from "./components/crudUI";
import EmployeeCredentials from "./components/employeeCredentials";
import type { Employee } from "./types/Employee";

type View = "login" | "signup" | "admin" | "employee";

export default function App() {
  const [view, setView] = useState<View>("login");
  const [currentEmployee, setCurrentEmployee] = useState<Employee | null>(null);

  /* ---------------- LOGIN ---------------- */
  const handleLoginSuccess = (employee: Employee) => {
    setCurrentEmployee(employee);

    if (employee.isAdmin) {
      setView("admin");
    } else {
      setView("employee");
    }
  };

  /* ---------------- SIGNUP SUCCESS ---------------- */
  const handleSignupSuccess = () => {
    setView("login");
  };

  /* ---------------- LOGOUT ---------------- */
  const logout = () => {
    setCurrentEmployee(null);
    setView("login");
  };

  return (
    <div className="app">

      {/* HEADER */}
      <div className="header">
        <div>
          <h1>Employee System</h1>
          <p>Login • Signup • Admin CRUD</p>
        </div>

        {view !== "login" && view !== "signup" && (
          <button className="logout" onClick={logout}>
            Logout
          </button>
        )}
      </div>

      {/* NAV BUTTONS */}
      {view === "login" && (
        <div className="nav-buttons">
          <button onClick={() => setView("login")}>
            Login
          </button>

          <button onClick={() => setView("signup")}>
            Sign Up
          </button>
        </div>
      )}

      {/* MAIN CONTENT */}
      <div className="content">

        {/* LOGIN */}
        {view === "login" && (
          <LoginUI onLoginSuccess={handleLoginSuccess} />
        )}

        {/* SIGNUP */}
        {view === "signup" && (
          <SignupUI
            onSignupSuccess={handleSignupSuccess}
            onBackToLogin={() => setView("login")}
          />
        )}

        {/* ADMIN */}
        {view === "admin" && (
          <CrudUI />
        )}

        {/* EMPLOYEE */}
        {view === "employee" && currentEmployee && (
          <EmployeeCredentials employee={currentEmployee} />
        )}

      </div>
    </div>
  );
}