import axios from 'axios';
import type { Teacher } from '../types/Teacher';

const apiClient = axios.create({
    baseURL: 'http://localhost:8080',
    timeout: 10000,
    headers: {
        'Content-Type': 'application/json',
    },
});

export const getTeachers = async (): Promise<Teacher[]> => {
  try {
    const response = await apiClient.get<Teacher[]>('/api/teacher/');
    return response.data;
  } catch (error) {
    console.error('Error fetching teachers:', error);
    throw error;
  }
};

export const createTeacher = async (fullname: string, subject: string): Promise<void> => {
  try {
    await apiClient.post('/api/teacher/', { fullName: fullname, subject });
  } catch (error) {
    console.error('Error creating teacher:', error);
    throw error;
  }
};

export const deleteTeacher = async (id: number): Promise<void> => {
  try {
    await apiClient.delete(`/api/teacher/${id}`);
  } catch (error) {
    console.error(`Error deleting teacher ${id}:`, error);
    throw error;
  }
};

export const updateTeacher = async (id: number, fullname: string, subject: string): Promise<void> => {
  try {
    await apiClient.put(`/api/teacher/update?id=${id}&fullName=${fullname}&subject=${subject}`, {});
  } catch (error) {
    console.error(`Error updating teacher ${id}:`, error);
    throw error;
  }
};