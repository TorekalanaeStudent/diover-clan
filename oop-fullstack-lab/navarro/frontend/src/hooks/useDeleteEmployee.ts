import { useState } from 'react';
import EmployeeService from '../api/employeeService';

export default function useDeleteEmployee() {
  const [isDeleting, setIsDeleting] = useState(false);
  const [error, setError] = useState<string | null>(null);

  const deleteEmployee = async (id: number) => {
    setIsDeleting(true);
    setError(null);

    try {
      await EmployeeService.remove(id);
      return true;
    } catch (err) {
      setError(err instanceof Error ? err.message : 'An error occurred');
      return false;
    } finally {
      setIsDeleting(false);
    }
  };

  return { deleteEmployee, isDeleting, error };
}