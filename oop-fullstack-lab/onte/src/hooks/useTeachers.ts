import { useCallback, useEffect, useState } from 'react';
import { getTeachers } from '../api/teacherService';
import type { Teacher } from '../types/Teacher';

interface UseTeachersResult {
  teachers: Teacher[];
  loading: boolean;
  error: Error | null;
  refresh: () => Promise<void>;
}

const useTeachers = (groupId: number): UseTeachersResult => {
  const [teachers, setTeachers] = useState<Teacher[]>([]);
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState<Error | null>(null);

  const fetchTeachers = useCallback(async () => {
    setLoading(true);
    setError(null);

    try {
      const data = await getTeachers();
      setTeachers(data);
    } catch (fetchError) {
      setError(fetchError instanceof Error ? fetchError : new Error('Failed to load teachers'));
    } finally {
      setLoading(false);
    }
  }, [groupId]);

  useEffect(() => {
    const loadTeachers = async () => {
      await fetchTeachers();
    };

    void loadTeachers();
  }, [fetchTeachers]);

  return {
    teachers,
    loading,
    error,
    refresh: fetchTeachers,
  };
};

export default useTeachers;
