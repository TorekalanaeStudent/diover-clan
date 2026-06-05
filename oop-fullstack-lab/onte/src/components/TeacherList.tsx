import { useState } from 'react';
import useTeachers from '../hooks/useTeachers.ts';
import useDeleteTeacher from '../hooks/useDeleteTeacher.ts';
import useUpdateTeacher from '../hooks/useUpdateTeacher.ts';
import type { Teacher } from '../types/Teacher.ts';

interface TeacherListProps {
  groupId?: number;
}

const TeacherList = ({ groupId = 1 }: TeacherListProps) => {
  const { teachers, loading, error, refresh } = useTeachers(groupId);
  const { deleting, error: deleteError, remove } = useDeleteTeacher();
  const { updating, error: updateError, update } = useUpdateTeacher();
  const [editingId, setEditingId] = useState<number | null>(null);
  const [editFullName, setEditFullName] = useState('');
  const [editSubject, setEditSubject] = useState('');

  const actionLoading = deleting || updating;
  const actionError = deleteError ?? updateError;

  const startEdit = (teacher: Teacher) => {
    setEditingId(teacher.id);
    setEditFullName(teacher.fullName ?? '');
    setEditSubject(teacher.subject ?? '');
  };

  const cancelEdit = () => {
    setEditingId(null);
  };

  const handleDelete = async (id: number) => {
    await remove(id);
    await refresh();
    if (editingId === id) {
      cancelEdit();
    }
  };

  const handleSave = async (id: number) => {
    await update(id, editFullName.trim(), editSubject.trim());
    await refresh();
    cancelEdit();
  };

  return (
    <section className="teacher-list">
      <div className="teacher-list__header">
        <h2>Teachers</h2>
        <button type="button" onClick={refresh} disabled={loading || actionLoading}>
          {loading ? 'Refreshing…' : 'Refresh'}
        </button>
      </div>

      {actionError && <p className="error">{actionError.message}</p>}
      {error && <p className="error">Unable to load teachers: {error.message}</p>}
      {loading && !teachers.length && <p>Loading teachers…</p>}
      {!loading && !teachers.length && !error && <p>No teachers found.</p>}

      {teachers.length > 0 && (
        <ul className="teacher-list__items">
          {teachers.map((teacher: Teacher) => {
            const isEditing = editingId === teacher.id;

            return (
              <li key={teacher.id} className="teacher-list__item">
                {isEditing ? (
                  <div className="teacher-list__edit-row">
                    <input
                      value={editFullName}
                      onChange={(event) => setEditFullName(event.target.value)}
                      placeholder="Full name"
                    />
                    <input
                      value={editSubject}
                      onChange={(event) => setEditSubject(event.target.value)}
                      placeholder="Subject"
                    />
                    <button
                      type="button"
                      onClick={() => handleSave(teacher.id)}
                      disabled={actionLoading || !editFullName.trim() || !editSubject.trim()}
                    >
                      Save
                    </button>
                    <button type="button" onClick={cancelEdit} disabled={actionLoading}>
                      Cancel
                    </button>
                  </div>
                ) : (
                  <div className="teacher-list__display-row">
                    <div>
                      <strong>{teacher.fullName ?? 'No name'}</strong>
                      <div>{teacher.subject ?? 'No subject'}</div>
                    </div>
                    <div className="teacher-list__actions">
                      <button
                        type="button"
                        onClick={() => startEdit(teacher)}
                        disabled={actionLoading}
                        aria-label={`Edit ${teacher.fullName ?? 'teacher'}`}
                      >
                        ✏️
                      </button>
                      <button
                        type="button"
                        onClick={() => handleDelete(teacher.id)}
                        disabled={actionLoading}
                        aria-label={`Delete ${teacher.fullName ?? 'teacher'}`}
                      >
                        ❌
                      </button>
                    </div>
                  </div>
                )}
              </li>
            );
          })}
        </ul>
      )}
    </section>
  );
};

export default TeacherList;