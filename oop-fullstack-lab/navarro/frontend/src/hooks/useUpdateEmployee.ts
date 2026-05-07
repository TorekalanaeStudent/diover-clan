import { useState } from 'react';
import EmployeeService from '../api/employeeService';

interface EmployeeData {
  username: string;
  password: string;
  email: string;
  phoneNumber: string;
  isAdmin: boolean;
}

export default function useUpdateEmployee() {
  const [isUpdating, setIsUpdating] = useState(false);
  const [error, setError] = useState<string | null>(null);

  const updateEmployee = async (id: number, data: EmployeeData) => {
    setIsUpdating(true);
    setError(null);

    try {
      await EmployeeService.update(id, data);
      return true;
    } catch (err) {
      setError(err instanceof Error ? err.message : 'An error occurred');
      return false;
    } finally {
      setIsUpdating(false);
    }
  };

  return { updateEmployee, isUpdating, error };
}