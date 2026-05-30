import { useState } from 'react';
import useUpdateEmployee from '../hooks/useUpdateEmployee';
import type { Employee } from '../types/Employee';

interface UpdateEmployeeProps {
  employee: Employee;
  onUpdated?: () => void;
  onCancel?: () => void;
}

export default function UpdateEmployee({ employee, onUpdated, onCancel }: UpdateEmployeeProps) {
  const { updateEmployee, isUpdating, error } = useUpdateEmployee();
  const [formData, setFormData] = useState({
    username: employee.username,
    password: employee.password,
    email: employee.email,
    phoneNumber: employee.phoneNumber,
    isAdmin: employee.isAdmin ?? false,
  });

  const handleChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    const { name, value, type, checked } = e.target;
    setFormData({ ...formData, [name]: type === 'checkbox' ? checked : value });
  };

  const handleSubmit = async (e: React.FormEvent) => {
    e.preventDefault();
    const success = await updateEmployee(employee.id, formData);
    if (success) onUpdated?.();
  };

  return (
    <section className="card section-card form-card">
      <div className="section-title">
        <h2>Edit Employee</h2>
        {error && <p className="form-error">Error: {error}</p>}
      </div>
      <form className="employee-form" onSubmit={handleSubmit}>
        <input className="form-field" type="text" name="username" placeholder="Username" value={formData.username} onChange={handleChange} required />
        <input className="form-field" type="password" name="password" placeholder="Password" value={formData.password} onChange={handleChange} required />
        <input className="form-field" type="email" name="email" placeholder="Email" value={formData.email} onChange={handleChange} required />
        <input className="form-field" type="tel" name="phoneNumber" placeholder="Phone Number" value={formData.phoneNumber} onChange={handleChange} required />
        <label className="checkbox-row">
          <input type="checkbox" name="isAdmin" checked={formData.isAdmin} onChange={handleChange} />
          Admin
        </label>
        <div className="form-actions">
          <button className="button button-primary" type="submit" disabled={isUpdating}>
            {isUpdating ? 'Saving...' : 'Save Changes'}
          </button>
          <button className="button button-secondary" type="button" onClick={onCancel}>
            Cancel
          </button>
        </div>
      </form>
    </section>
  );
}