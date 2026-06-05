import { useCallback, useState } from 'react';
import { createTeacher } from '../api/teacherService';

interface UseCreateTeacherResult {
  creating: boolean;
  error: Error | null;
  create: (fullName: string, subject: string) => Promise<void>;
}

const useCreateTeacher = (): UseCreateTeacherResult => {
  const [creating, setCreating] = useState(false);
  const [error, setError] = useState<Error | null>(null);

  const create = useCallback(async (fullName: string, subject: string) => {
    setCreating(true);
    setError(null);

    try {
      await createTeacher(fullName, subject);
    } catch (createError) {
      setError(createError instanceof Error ? createError : new Error('Failed to create teacher'));
    } finally {
      setCreating(false);
    }
  }, []);

  return {
    creating,
    error,
    create,
  };
};

export default useCreateTeacher;
