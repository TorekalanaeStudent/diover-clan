import { useState } from 'react';
import EmployeeService from '../api/employeeService';

interface EmployeeData {
  username: string;
  password: string;
  email: string;
  phoneNumber: string;
  isAdmin: boolean;
}

export default function useAddEmployee() {
  const [isAdding, setIsAdding] = useState(false);
  const [error, setError] = useState<string | null>(null);

  const addEmployee = async (data: EmployeeData) => {
    setIsAdding(true);
    setError(null);

    try {
      await EmployeeService.create(data);
      return true;
    } catch (err) {
      setError(err instanceof Error ? err.message : 'An error occurred');
      return false;
    } finally {
      setIsAdding(false);
    }
  };

  return { addEmployee, isAdding, error };
}