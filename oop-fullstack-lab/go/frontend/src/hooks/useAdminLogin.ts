import { useState } from "react";
import apiClient from "../api/axios";
import type { Employee } from "../types/Employee";

export function useAdminLogin() {
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState<string | null>(null);

  const adminLogin = async (
    email: string,
    password: string
  ): Promise<Employee | null> => {
    setLoading(true);
    setError(null);

    try {
const res = await apiClient.post<Employee>("/login", {
  employeeEmail: email,
  employeePassword: password,
});

const user = res.data;

return user;

      // safety check (optional but good)
      if (!user.isAdmin) {
        throw new Error("Not an admin account");
      }

      return user;
    } catch (err: any) {
      console.error("Admin login error:", err);

      const message =
        err?.response?.data?.message ||
        err?.response?.data?.error ||
        err?.message ||
        "Admin login failed";

      setError(message);
      return null;
    } finally {
      setLoading(false);
    }
  };

  return { adminLogin, loading, error };
}