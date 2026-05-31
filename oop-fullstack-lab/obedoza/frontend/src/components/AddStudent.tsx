import React, { useState } from 'react';
import { createStudent } from '../api/studentService';

const AddStudent: React.FC = () => {
  const [fullName, setFullName] = useState('');
  const [course, setCourse] = useState('');
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState<string | null>(null);
  const [success, setSuccess] = useState(false);

  const handleSubmit = async (e: React.FormEvent) => {
    e.preventDefault();
    setLoading(true);
    setError(null);
    setSuccess(false);

    try {
      await createStudent(fullName, course);
      setSuccess(true);
      setFullName('');
      setCourse('');
      setTimeout(() => setSuccess(false), 3000);
    } catch (err) {
      setError((err as Error)?.message ?? 'Failed to create student');
    } finally {
      setLoading(false);
    }
  };

  return (
    <div style={{ marginBottom: '2rem' }}>
      <h2>Add New Student</h2>
      <form onSubmit={handleSubmit} style={{ display: 'flex', flexDirection: 'column', gap: '1rem', maxWidth: '400px' }}>
        <div>
          <label htmlFor="fullName" style={{ display: 'block', marginBottom: '0.5rem' }}>
            Full Name
          </label>
          <input
            id="fullName"
            type="text"
            value={fullName}
            onChange={(e) => setFullName(e.target.value)}
            required
            disabled={loading}
            style={{ width: '100%', padding: '0.5rem', fontSize: '1rem' }}
            placeholder="Enter full name"
          />
        </div>

        <div>
          <label htmlFor="course" style={{ display: 'block', marginBottom: '0.5rem' }}>
            Course
          </label>
          <input
            id="course"
            type="text"
            value={course}
            onChange={(e) => setCourse(e.target.value)}
            required
            disabled={loading}
            style={{ width: '100%', padding: '0.5rem', fontSize: '1rem' }}
            placeholder="Enter course"
          />
        </div>

        {error && <div style={{ color: 'red' }}>Error: {error}</div>}
        {success && <div style={{ color: 'green' }}>Student added successfully!</div>}

        <button type="submit" disabled={loading} style={{ padding: '0.5rem 1rem', fontSize: '1rem' }}>
          {loading ? 'Adding...' : 'Add Student'}
        </button>
      </form>
    </div>
  );
};

export default AddStudent;
