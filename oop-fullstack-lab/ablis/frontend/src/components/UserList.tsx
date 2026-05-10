import type { User } from '../types/User';

interface Props {
  users: User[];
  onDelete: (id: number) => void;
  onEdit: (user: User) => void;
}

export function UserList({ users, onDelete, onEdit }: Props) {
  return (
    <table className="task-table">
      <thead>
        <tr>
          <th>ID</th>
          <th>Name</th>
        <th>Email</th>
        <th>Actions</th>
      </tr>
    </thead>
    <tbody>
      {users.length === 0 ? (
        <tr><td colSpan={5}>No users found.</td></tr>
      ) : (
        users.map(user => (
          <tr key={user.id}>
            <td>{user.id}</td>
            <td>{user.username}</td>
            <td>{user.email}</td>
            <td>
              <button className="btn-edit" onClick={() => onEdit(user)}>Edit</button>
              <button className="btn-delete" onClick={() => onDelete(user.id!)}>Delete</button>
            </td>
          </tr>
        ))
      )}
    </tbody>
  </table>
);
}
