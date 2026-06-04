import { useCallback, useState } from 'react';
import { updateTeacher } from '../api/teacherService';

interface UseUpdateTeacherResult {
  updating: boolean;
  error: Error | null;
  update: (id: number, fullName: string, subject: string) => Promise<void>;
}

const useUpdateTeacher = (): UseUpdateTeacherResult => {
  const [updating, setUpdating] = useState(false);
  const [error, setError] = useState<Error | null>(null);

  const update = useCallback(async (id: number, fullName: string, subject: string) => {
    setUpdating(true);
    setError(null);

    try {
      await updateTeacher(id, fullName, subject);
    } catch (updateError) {
      setError(updateError instanceof Error ? updateError : new Error('Failed to update teacher'));
    } finally {
      setUpdating(false);
    }
  }, []);

  return {
    updating,
    error,
    update,
  };
};

export default useUpdateTeacher;
