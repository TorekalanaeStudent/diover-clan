import { useCallback, useState } from 'react';
import { deleteTeacher } from '../api/teacherService';

interface UseDeleteTeacherResult {
  deleting: boolean;
  error: Error | null;
  remove: (id: number) => Promise<void>;
}

const useDeleteTeacher = (): UseDeleteTeacherResult => {
  const [deleting, setDeleting] = useState(false);
  const [error, setError] = useState<Error | null>(null);

  const remove = useCallback(async (id: number) => {
    setDeleting(true);
    setError(null);

    try {
      await deleteTeacher(id);
    } catch (deleteError) {
      setError(deleteError instanceof Error ? deleteError : new Error('Failed to delete teacher'));
    } finally {
      setDeleting(false);
    }
  }, []);

  return {
    deleting,
    error,
    remove,
  };
};

export default useDeleteTeacher;
