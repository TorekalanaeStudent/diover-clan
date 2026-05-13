import { useState } from "react";
import apiClient from "../api/axios";
import type { Employee } from "../types/Employee";

export function useSignupLogic() {
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState<string | null>(null);

  const signup = async (form: Employee) => {
    setLoading(true);
    setError(null);

    try {
      const res = await apiClient.post("/signup", {
        employeeName: form.employeeName,
        employeeEmail: form.employeeEmail,
        employeePassword: form.employeePassword,
        employeePosition: form.employeePosition,
        currentlyInShift: form.currentlyInShift,
      });

      return res.data;
    } catch (err: any) {
      console.error("Signup error:", err);

      const message =
        err?.response?.data?.message ||
        err?.response?.data?.error ||
        "Signup failed";

      setError(message);

      return null;
    } finally {
      setLoading(false);
    }
  };

  return { signup, loading, error };
}