import { useState, useEffect } from 'react';
import type { User } from '../types/User';
import { getUsers } from '../api/userService';

export function useUsers() {
    const [users, setUsers] = useState<User[]>([]);
    const [loading, setLoading] = useState(false);
    const [error, setError] = useState<string | null>(null);

    const fetchUsers = async () => {
        try {
            setLoading(true);
            setError(null);
            const data = await getUsers();
            setUsers(data);
        } catch (err) {
            const msg = err instanceof Error ? err.message : 'Failed to fetch users';
            console.error('Error fetching users:', err);
            setError(`Backend error: ${msg}`);
        } finally {
            setLoading(false);
        }
    };

    useEffect(() => {
        fetchUsers();
    }, []);

    return { users, loading, error, refetch: fetchUsers };
}