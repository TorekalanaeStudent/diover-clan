import { useState } from 'react';
import useAddEmployee from '../hooks/useAddEmployee';

interface AddEmployeeProps {
  onEmployeeAdded?: () => void;
}

export default function AddEmployee({ onEmployeeAdded }: AddEmployeeProps) {
  const { addEmployee, isAdding, error } = useAddEmployee();
  const [formData, setFormData] = useState({
    username: '',
    password: '',
    email: '',
    phoneNumber: '',
    isAdmin: false,
  });

  const handleChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    const { name, value, type, checked } = e.target;
    setFormData({ ...formData, [name]: type === 'checkbox' ? checked : value });
  };

  const handleSubmit = async (e: React.FormEvent) => {
    e.preventDefault();
    const success = await addEmployee(formData);
    if (success) {
      setFormData({ username: '', password: '', email: '', phoneNumber: '', isAdmin: false });
      onEmployeeAdded?.();
    }
  };

  return (
    <section className="card section-card form-card">
      <div className="section-title">
        <h2>Add New Employee</h2>
        {error && <p className="form-error">Error: {error}</p>}
      </div>
      <form className="employee-form" onSubmit={handleSubmit}>
        <input
          className="form-field"
          type="text"
          name="username"
          placeholder="Username"
          value={formData.username}
          onChange={handleChange}
          required
        />
        <input
          className="form-field"
          type="password"
          name="password"
          placeholder="Password"
          value={formData.password}
          onChange={handleChange}
          required
        />
        <input
          className="form-field"
          type="email"
          name="email"
          placeholder="Email"
          value={formData.email}
          onChange={handleChange}
          required
        />
        <input
          className="form-field"
          type="tel"
          name="phoneNumber"
          placeholder="Phone Number"
          value={formData.phoneNumber}
          onChange={handleChange}
          required
        />
        <label className="checkbox-row">
          <input
            type="checkbox"
            name="isAdmin"
            checked={formData.isAdmin}
            onChange={handleChange}
          />
          Admin
        </label>
        <button className="button button-primary" type="submit" disabled={isAdding}>
          {isAdding ? 'Adding...' : 'Add Employee'}
        </button>
      </form>
    </section>
  );
}