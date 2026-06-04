import { useMemo, useState } from 'react';
import type { FormEvent } from 'react';
import useCreateTeacher from '../hooks/useCreateTeacher.ts';

const AddTeacher = () => {
  const [fullName, setFullName] = useState('');
  const [subject, setSubject] = useState('');
  const { creating, error, create } = useCreateTeacher();
  const isSubmitDisabled = useMemo(
    () => creating || !fullName.trim() || !subject.trim(),
    [creating, fullName, subject]
  );

  const handleSubmit = async (event: FormEvent<HTMLFormElement>) => {
    event.preventDefault();
    await create(fullName.trim(), subject.trim());
    setFullName('');
    setSubject('');
  };

  return (
    <section className="add-teacher">
      <h2>Add Teacher</h2>
      <form onSubmit={handleSubmit}>
        <div>
          <label htmlFor="fullname">Full name</label>
          <input
            id="fullname"
            type="text"
            value={fullName}
            onChange={(event) => setFullName(event.target.value)}
            placeholder="Enter full name"
          />
        </div>
        <div>
          <label htmlFor="subject">Subject</label>
          <input
            id="subject"
            type="text"
            value={subject}
            onChange={(event) => setSubject(event.target.value)}
            placeholder="Enter subject"
          />
        </div>
        <button type="submit" disabled={isSubmitDisabled}>
          {creating ? 'Creating…' : 'Add Teacher'}
        </button>
      </form>
      {error && <p className="error">{error.message}</p>}
    </section>
  );
};

export default AddTeacher;
