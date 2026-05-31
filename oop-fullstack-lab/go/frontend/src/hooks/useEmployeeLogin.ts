import { useState } from "react";
import apiClient from "../api/axios";
import type { Employee } from "../types/Employee";

export function useEmployeeLogin() {
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState<string | null>(null);

  const login = async (email: string, password: string): Promise<Employee | null> => {
    setLoading(true);
    setError(null);

    try {
      const res = await apiClient.post("/login", {
        employeeEmail: email,
        employeePassword: password,
      });

      return res.data; // MUST return Employee
    } catch (err: any) {
      console.error(err);

      setError(
        err?.response?.data?.message ||
        err?.response?.data?.error ||
        "Login failed"
      );

      return null;
    } finally {
      setLoading(false);
    }
  };

  return { login, loading, error };
}