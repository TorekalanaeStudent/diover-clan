import React, { useState } from 'react';
import { useStudents } from '../hooks/useStudents';
import type { Student } from '../types/Student';

const StudentList: React.FC = () => {
  const { students, loading, error, refresh, deleteStudent, updateStudent } = useStudents();
  const [editingId, setEditingId] = useState<number | null>(null);
  const [editFullName, setEditFullName] = useState('');
  const [editCourse, setEditCourse] = useState('');

  const startEditing = (student: Student) => {
    setEditingId(student.id);
    setEditFullName(student.fullName);
    setEditCourse(student.course);
  };

  const cancelEditing = () => {
    setEditingId(null);
    setEditFullName('');
    setEditCourse('');
  };

  const saveEdit = async () => {
    if (editingId === null) return;

    await updateStudent(editingId, editFullName, editCourse);
    cancelEditing();
  };

  return (
    <div>
      <h2>Student List</h2>
      <button onClick={refresh} disabled={loading}>
        Refresh
      </button>
      {loading && <p>Loading...</p>}
      {error && <p style={{ color: 'red' }}>Error loading students: {error}</p>}
      <table>
        <thead>
          <tr>
            <th>Student ID</th>
            <th>Full Name</th>
            <th>Course</th>
            <th>Actions</th>
          </tr>
        </thead>
        <tbody>
          {students.length === 0 && !loading ? (
            <tr>
              <td colSpan={4}>No students available.</td>
            </tr>
          ) : (
            students.map(student => (
              <tr key={student.id}>
                <td>{student.id}</td>
                <td>
                  {editingId === student.id ? (
                    <input
                      value={editFullName}
                      onChange={e => setEditFullName(e.target.value)}
                    />
                  ) : (
                    student.fullName
                  )}
                </td>
                <td>
                  {editingId === student.id ? (
                    <input
                      value={editCourse}
                      onChange={e => setEditCourse(e.target.value)}
                    />
                  ) : (
                    student.course
                  )}
                </td>
                <td>
                  {editingId === student.id ? (
                    <>
                      <button type="button" onClick={saveEdit} disabled={loading}>
                        Save
                      </button>
                      <button type="button" onClick={cancelEditing} disabled={loading}>
                        Cancel
                      </button>
                    </>
                  ) : (
                    <>
                      <button
                        type="button"
                        onClick={() => startEditing(student)}
                        aria-label="Edit student"
                      >
                        ✏️
                      </button>
                      <button
                        type="button"
                        onClick={() => deleteStudent(student.id)}
                        aria-label="Delete student"
                        disabled={loading}
                      >
                        ❌
                      </button>
                    </>
                  )}
                </td>
              </tr>
            ))
          )}
        </tbody>
      </table>
    </div>
  );
};

export default StudentList;
