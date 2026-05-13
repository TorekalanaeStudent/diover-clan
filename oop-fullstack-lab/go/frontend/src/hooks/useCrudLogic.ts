import { useEffect, useState } from "react";
import apiClient from "../api/axios";
import type { Employee } from "../types/Employee";

export function useCrudLogic() {
  const [employees, setEmployees] = useState<Employee[]>([]);
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState<string | null>(null);

  const fetchEmployees = async () => {
    setLoading(true);
    setError(null);

    try {
      const res = await apiClient.get("");
      setEmployees(res.data);
    } catch (err: any) {
      setError("Failed to load employees");
      console.error(err);
    } finally {
      setLoading(false);
    }
  };

  const deleteEmployee = async (id: number) => {
    await apiClient.delete(`/${id}`);
    fetchEmployees();
  };

  const updateEmployee = async (id: number, updated: Employee) => {
    await apiClient.put(`/${id}`, updated);
    fetchEmployees();
  };

  const createEmployee = async (emp: Employee) => {
    await apiClient.post("", emp);
    fetchEmployees();
  };

  useEffect(() => {
    fetchEmployees();
  }, []);

  return {
    employees,
    loading,   
    error,
    fetchEmployees,
    deleteEmployee,
    updateEmployee,
    createEmployee,
  };
}