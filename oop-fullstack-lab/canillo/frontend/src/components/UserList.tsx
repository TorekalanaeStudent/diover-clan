import { useState, Fragment } from 'react';
import { useUsers } from '../hooks/useUsers';
import { AddUserForm } from './AddUserForm';
import { deleteUser } from '../api/userService';
import type { User } from '../types/User';
import './UserList.css';

export function UserList() {
	const { users, loading, error, refetch } = useUsers();
	const [expandedIds, setExpandedIds] = useState<Set<number>>(new Set());
	const [selectedIds, setSelectedIds] = useState<Set<number>>(new Set());
	const [editingUser, setEditingUser] = useState<User | null>(null);

	const toggleExpand = (id: number) => {
		const newExpanded = new Set(expandedIds);
		if (newExpanded.has(id)) {
			newExpanded.delete(id);
		} else {
			newExpanded.add(id);
		}
		setExpandedIds(newExpanded);
	};

	const toggleSelectUser = (id: number) => {
		const newSelected = new Set(selectedIds);
		if (newSelected.has(id)) {
			newSelected.delete(id);
		} else {
			newSelected.add(id);
		}
		setSelectedIds(newSelected);
	};

	const toggleSelectAll = () => {
		if (selectedIds.size === users.length) {
			setSelectedIds(new Set());
		} else {
			setSelectedIds(new Set(users.map(u => u.id)));
		}
	};

	const maskPassword = (password: string): string => {
		return '*'.repeat(Math.min(password.length, 8));
	};

	const handleDeleteSelected = async () => {
		if (selectedIds.size === 0) return;
		
		const usernames = users
			.filter(u => selectedIds.has(u.id))
			.map(u => u.username)
			.join(', ');
		
		if (confirm(`Are you sure you want to delete ${selectedIds.size} user(s)? (${usernames})`)) {
			try {
				const deletePromises = Array.from(selectedIds).map(id => deleteUser(id));
				await Promise.all(deletePromises);
				setSelectedIds(new Set());
				await refetch();
			} catch (error) {
				console.error('Failed to delete users:', error);
				alert('Failed to delete some users');
			}
		}
	};

	const handleEdit = (user: User) => {
		setEditingUser(user);
		setExpandedIds(new Set()); // Close all expanded rows
	};

	const handleEditCancel = () => {
		setEditingUser(null);
	};

	if (loading && users.length === 0) return <div className="userlist-container"><p>Loading users...</p></div>;

	return (
		<div className="userlist-wrapper">
			<AddUserForm onUserAdded={refetch} editingUser={editingUser} onEditCancel={handleEditCancel} />
			<div className="userlist-container">
				{error && <p className="error">⚠️ {error}</p>}
				<div className="userlist-header">
					<h2>Users</h2>
					<div className="header-actions">
						{selectedIds.size > 0 && (
							<button onClick={handleDeleteSelected} className="delete-selected-btn">
								🗑️ Delete Selected ({selectedIds.size})
							</button>
						)}
						<button onClick={refetch} className="refresh-btn">Refresh</button>
					</div>
				</div>

			<table className="userlist-table">
				<thead>
					<tr>
						<th className="checkbox-col">
							<input 
								type="checkbox" 
								checked={selectedIds.size === users.length && users.length > 0}
								onChange={toggleSelectAll}
								title="Select all users"
							/>
						</th>
						<th>ID</th>
						<th>Username</th>
						<th>Password</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					{users.map((user: User) => (
						<Fragment key={user.id}>
							<tr className="user-row">
								<td className="checkbox-col">
									<input 
										type="checkbox" 
										checked={selectedIds.has(user.id)}
										onChange={() => toggleSelectUser(user.id)}
									/>
								</td>
								<td>{user.id}</td>
								<td>{user.username}</td>
								<td>{maskPassword(user.password)}</td>
								<td>
									<div className="actions">
										<button
											onClick={() => toggleExpand(user.id)}
											className="expand-btn"
										>
											{expandedIds.has(user.id) ? 'Hide Details' : 'Show Details'}
										</button>
									</div>
								</td>
							</tr>
							{expandedIds.has(user.id) && (
								<tr className="expanded-row">
									<td colSpan={5}>
										<div className="expanded-content">
											<div className="detail-row">
												<span className="label">Password:</span>
												<span className="value">{user.password}</span>
											</div>
											<div className="detail-row">
												<span className="label">Email:</span>
												<span className="value">{user.email}</span>
											</div>
											<div className="detail-row">
												<span className="label">Phone:</span>
												<span className="value">{user.phone}</span>
											</div>
											<div className="detail-row">
												<span className="label">Is Admin:</span>
												<span className="value">
													<input
														type="checkbox"
														checked={user.isAdmin}
														disabled
													/>
												</span>
											</div>
											<div className="detail-row">
												<button
													onClick={() => handleEdit(user)}
													className="edit-btn-expanded"
													title="Edit user"
												>
													✏️ Edit
												</button>
											</div>
										</div>
									</td>
								</tr>
							)}
						</Fragment>
					))}
				</tbody>
			</table>

			{users.length === 0 && (
				<p className="no-users">No users found</p>
			)}
			</div>
		</div>
	);
}
