import apiClient from './axios';
import type { User } from '../types/User';

export async function getUsers(): Promise<User[]> {
	try {
		const response = await apiClient.get('/users');
		console.log('📥 API Response:', response.data);
		console.log('   First user:', response.data[0]);
		return response.data as User[];
	} catch (error) {
		console.error('Error fetching Users:', error);
		throw error;
	}
}

export async function getUser(id: number | string): Promise<User> {
    try {
		const response = await apiClient.get(`/${id}`);
		return response.data as User;
    } catch (error) {
        console.error('Error fetching User:', error);
        throw error;
    }
}

export async function createUser(userData: {
	username: string;
	password: string;
	email: string;
	phone: string;
	isAdmin: boolean;
}): Promise<User> {
	try {
		const params = new URLSearchParams({
			username: userData.username,
			password: userData.password,
			email: userData.email,
			phoneNumber: userData.phone, 
			isAdmin: userData.isAdmin ? 'true' : 'false',
		});

		const fullUrl = `/users/create?${params.toString()}`;
		console.log('📤 Creating user with URL:', fullUrl);
		console.log('   isAdmin value:', userData.isAdmin, 'stringified:', userData.isAdmin ? 'true' : 'false');

		const response = await apiClient.post(fullUrl);
		return response.data as User;
	} catch (error) {
		console.error('Error creating User:', error);
		throw error;
	}
}

export async function updateUser(userData: {
	id: number;
	username: string;
	password: string;
	email: string;
	phone: string;
	isAdmin: boolean;
}): Promise<User> {
	try {
		const params = new URLSearchParams({
			id: userData.id.toString(),
			username: userData.username,
			password: userData.password,
			email: userData.email,
			phoneNumber: userData.phone,
			isAdmin: userData.isAdmin ? 'true' : 'false',
		});

		const fullUrl = `/users/update?${params.toString()}`;
		console.log('📝 Updating user with URL:', fullUrl);

		const response = await apiClient.put(fullUrl);
		return response.data as User;
	} catch (error) {
		console.error('Error updating User:', error);
		throw error;
	}
}

export async function deleteUser(id: number): Promise<void> {
	try {
		console.log('🗑️ Deleting user with ID:', id);
		await apiClient.delete('/users/', { data: id });
	} catch (error) {
		console.error('Error deleting User:', error);
		throw error;
	}
}

