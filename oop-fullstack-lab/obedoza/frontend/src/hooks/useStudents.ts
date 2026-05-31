import { useCallback, useEffect, useState } from 'react';
import type { Student } from '../types/Student';
import {
  getStudent,
  deleteStudent as deleteStudentService,
  updateStudent as updateStudentService,
} from '../api/studentService';

export const useStudents = () => {
  const [students, setStudents] = useState<Student[]>([]);
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState<string | null>(null);

  const refresh = useCallback(async () => {
    setLoading(true);
    setError(null);

    try {
      const data = await getStudent();
      setStudents(data);
    } catch (err) {
      setError((err as Error)?.message ?? 'Failed to load students.');
    } finally {
      setLoading(false);
    }
  }, []);

  const deleteStudent = useCallback(
    async (id: number) => {
      setLoading(true);
      setError(null);

      try {
        await deleteStudentService(id);
        await refresh();
      } catch (err) {
        setError((err as Error)?.message ?? 'Failed to delete student.');
      } finally {
        setLoading(false);
      }
    },
    [refresh]
  );

  const updateStudent = useCallback(
    async (id: number, fullName: string, course: string) => {
      setLoading(true);
      setError(null);

      try {
        await updateStudentService(id, fullName, course);
        await refresh();
      } catch (err) {
        setError((err as Error)?.message ?? 'Failed to update student.');
      } finally {
        setLoading(false);
      }
    },
    [refresh]
  );

  useEffect(() => {
    refresh();
  }, [refresh]);

  return {
    students,
    loading,
    error,
    refresh,
    deleteStudent,
    updateStudent,
  };
};
