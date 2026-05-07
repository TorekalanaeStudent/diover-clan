import { useState, useEffect } from 'react';
import type { User } from '../types/User';
import { getUsers } from '../api/userService';

// Mock data for testing
const MOCK_USERS: User[] = [
	{
		id: 1,
		username: 'john_doe',
		password: 'SecurePass123',
		email: 'john@example.com',
		phone: '555-1234',
		isAdmin: true,
	},
	{
		id: 2,
		username: 'jane_smith',
		password: 'MyPassword456',
		email: 'jane@example.com',
		phone: '555-5678',
		isAdmin: false,
	},
];

export function useUsers() {
	const [users, setUsers] = useState<User[]>(MOCK_USERS);
	const [loading, setLoading] = useState(false);
	const [error, setError] = useState<string | null>(null);

	const fetchUsers = async () => {
		try {
			setLoading(true);
			setError(null);
			const data = await getUsers();
			setUsers(data);
		} catch (err) {
			const errorMessage = err instanceof Error ? err.message : 'Failed to fetch users';
			console.error('Error fetching users:', err);
			// Keep mock data on error
			setUsers(MOCK_USERS);
			setError(`Using demo data. Backend error: ${errorMessage}`);
		} finally {
			setLoading(false);
		}
	};

	useEffect(() => {
		// Try to fetch real data, but don't block on error
		fetchUsers();
	}, []);

	return { users, loading, error, refetch: fetchUsers };
}
