import { useState } from 'react'
import useEmployees from '../hooks/useEmployees'
import useDeleteEmployee from '../hooks/useDeleteEmployee'
import UpdateEmployee from './UpdateEmployee'
import type { Employee } from '../types/Employee'

export default function EmployeeList() {
  const { employees, isLoading, error, refresh } = useEmployees()
  const { deleteEmployee, isDeleting, error: deleteError } = useDeleteEmployee()
  const [editingEmployee, setEditingEmployee] = useState<Employee | null>(null)

  const handleDelete = async (employee: Employee) => {
    if (!employee.id || !window.confirm(`Delete ${employee.username}?`)) {
      return
    }

    const success = await deleteEmployee(employee.id)
    if (success) {
      await refresh()
    }
  }

  return (
    <section className="card section-card">
      <div className="section-header">
        <div>
          <h2>Employee List</h2>
          <p className="section-subtitle">The Active team members and management tools</p>
        </div>
        <button className="button button-primary" type="button" onClick={refresh} disabled={isLoading || isDeleting}>
          {isLoading ? 'Refreshing...' : 'Refresh'}
        </button>
      </div>

      {error && <p className="form-error">Error: {error}</p>}
      {deleteError && <p className="form-error">Delete error: {deleteError}</p>}

      {editingEmployee && (
        <section className="inline-edit-card">
          <UpdateEmployee
            employee={editingEmployee}
            onUpdated={async () => {
              setEditingEmployee(null)
              await refresh()
            }}
            onCancel={() => setEditingEmployee(null)}
          />
        </section>
      )}

      {employees.length === 0 && !isLoading && !error ? (
        <p className="empty-state">No employees found.</p>
      ) : (
        <div className="table-card">
          <table className="data-table">
            <thead>
              <tr>
                <th>Name</th>
                <th>Email</th>
                <th>Phone Number</th>
                <th>Admin</th>
                <th>Tools</th>
              </tr>
            </thead>
            <tbody>
              {employees.map((employee) => (
                <tr key={employee.id ?? employee.username}>
                  <td>{employee.username}</td>
                  <td>{employee.email}</td>
                  <td>{employee.phoneNumber}</td>
                  <td>{employee.isAdmin ? 'Yes' : 'No'}</td>
                  <td>
                    <div className="table-actions">
                      <button className="button button-primary" type="button" onClick={() => setEditingEmployee(employee)}>
                        Edit
                      </button>
                      <button
                        className="button button-danger"
                        type="button"
                        onClick={() => void handleDelete(employee)}
                        disabled={isDeleting || !employee.id}
                      >
                        {isDeleting ? 'Deleting...' : 'Delete'}
                      </button>
                    </div>
                  </td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
      )}
    </section>
  )
}
