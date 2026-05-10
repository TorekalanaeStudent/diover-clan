import apiClient from './axios';
import type { User } from '../types/User';

export async function getUsers(): Promise<User[]> {
    try {
        const response = await apiClient.get('/users');
        return response.data as User[];
    } catch (error) {
        console.error('Error fetching users:', error);
        throw error;
    }
}

export async function createUser(userData: {
    title: string;
    description: string;
    completed: boolean;
}): Promise<User> {
    try {
        const response = await apiClient.post('/users', userData);
        return response.data as User;
    } catch (error) {
        console.error('Error creating user:', error);
        throw error;
    }
}

export async function updateUser(id: number, userData: {
    title: string;
    description: string;
    completed: boolean;
}): Promise<User> {
    try {
        const response = await apiClient.put(`/users/${id}`, userData);
        return response.data as User;
    } catch (error) {
        console.error('Error updating user:', error);
        throw error;
    }
}

export async function deleteUser(id: number): Promise<void> {
    try {
        await apiClient.delete(`/users/${id}`);
    } catch (error) {
        console.error('Error deleting user:', error);
        throw error;
    }
}