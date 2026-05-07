import { useState, useEffect } from 'react';
import { createUser, updateUser } from '../api/userService';
import type { User } from '../types/User';
import './AddUserForm.css';

interface AddUserFormProps {
	onUserAdded?: () => void;
	editingUser?: User | null;
	onEditCancel?: () => void;
}

export function AddUserForm({ onUserAdded, editingUser, onEditCancel }: AddUserFormProps) {
	const [formData, setFormData] = useState({
		id: editingUser?.id || 0,
		username: editingUser?.username || '',
		password: editingUser?.password || '',
		email: editingUser?.email || '',
		phone: editingUser?.phone || '',
		isAdmin: editingUser?.isAdmin || false,
	});
	const [loading, setLoading] = useState(false);
	const [message, setMessage] = useState<{ type: 'success' | 'error'; text: string } | null>(null);

	// Update form when editingUser changes
	useEffect(() => {
		if (editingUser) {
			setFormData({
				id: editingUser.id,
				username: editingUser.username,
				password: editingUser.password,
				email: editingUser.email,
				phone: editingUser.phone,
				isAdmin: editingUser.isAdmin,
			});
		} else {
			setFormData({
				id: 0,
				username: '',
				password: '',
				email: '',
				phone: '',
				isAdmin: false,
			});
		}
		setMessage(null);
	}, [editingUser]);

	const handleChange = (e: React.ChangeEvent<HTMLInputElement>) => {
		const { name, value, type, checked } = e.target;
		setFormData(prev => ({
			...prev,
			[name]: type === 'checkbox' ? checked : value,
		}));
	};

	const handleSubmit = async (e: React.FormEvent) => {
		e.preventDefault();
		setLoading(true);
		setMessage(null);

		try {
			if (editingUser) {
				console.log('📝 Form submitted with data (edit):', formData);
				await updateUser({
					id: formData.id,
					username: formData.username,
					password: formData.password,
					email: formData.email,
					phone: formData.phone,
					isAdmin: formData.isAdmin,
				});
				setMessage({ type: 'success', text: 'User updated successfully!' });
			} else {
				console.log('📝 Form submitted with data (create):', formData);
				await createUser({
					username: formData.username,
					password: formData.password,
					email: formData.email,
					phone: formData.phone,
					isAdmin: formData.isAdmin,
				});
				setMessage({ type: 'success', text: 'User created successfully!' });
				setFormData({
					id: 0,
					username: '',
					password: '',
					email: '',
					phone: '',
					isAdmin: false,
				});
			}
			// Refresh user list after a short delay
			setTimeout(() => {
				onUserAdded?.();
				if (editingUser) {
					onEditCancel?.();
				}
			}, 500);
		} catch (error) {
			const errorMessage = error instanceof Error ? error.message : 'Failed to process user';
			setMessage({ type: 'error', text: errorMessage });
		} finally {
			setLoading(false);
		}
	};

	const handleCancel = () => {
		setFormData({
			id: 0,
			username: '',
			password: '',
			email: '',
			phone: '',
			isAdmin: false,
		});
		setMessage(null);
		onEditCancel?.();
	};

	return (
		<div className="add-user-form-container">
			<div className="form-header">
				{editingUser && (
					<button type="button" className="back-btn" onClick={handleCancel} title="Back to add user">
						&lt; Back
					</button>
				)}
				<h2>{editingUser ? 'Edit User' : 'Add New User'}</h2>
			</div>
			{message && (
				<div className={`message ${message.type}`}>
					{message.type === 'success' ? '✓' : '✗'} {message.text}
				</div>
			)}
			<form onSubmit={handleSubmit} className="add-user-form">
				<div className="form-group">
					<label htmlFor="username">Username *</label>
					<input
						type="text"
						id="username"
						name="username"
						value={formData.username}
						onChange={handleChange}
						required
						placeholder="Enter username"
						disabled={loading}
					/>
				</div>

				<div className="form-group">
					<label htmlFor="password">Password *</label>
					<input
						type="password"
						id="password"
						name="password"
						value={formData.password}
						onChange={handleChange}
						required
						placeholder="Enter password"
						disabled={loading}
					/>
				</div>

				<div className="form-group">
					<label htmlFor="email">Email *</label>
					<input
						type="email"
						id="email"
						name="email"
						value={formData.email}
						onChange={handleChange}
						required
						placeholder="Enter email"
						disabled={loading}
					/>
				</div>

				<div className="form-group">
					<label htmlFor="phone">Phone *</label>
					<input
						type="tel"
						id="phone"
						name="phone"
						value={formData.phone}
						onChange={handleChange}
						required
						placeholder="Enter phone number"
						disabled={loading}
					/>
				</div>

				<div className="form-group checkbox">
					<input
						type="checkbox"
						id="isAdmin"
						name="isAdmin"
						checked={formData.isAdmin}
						onChange={handleChange}
						disabled={loading}
					/>
					<label htmlFor="isAdmin">Is Admin</label>
				</div>

				<button type="submit" className="submit-btn" disabled={loading}>
					{loading ? 'Processing...' : editingUser ? 'Update User' : 'Create User'}
				</button>
			</form>
		</div>
	);
}
