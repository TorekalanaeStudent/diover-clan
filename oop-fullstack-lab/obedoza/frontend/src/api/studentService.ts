import apiClient from './axios';
import type { Student } from '../types/Student';

export const getStudent = async (): Promise<Student[]> => {
  try {
    const response = await apiClient.get('/api/students/');
    return response.data;
  } catch (error) {
    console.error('Error fetching students:', error);
    throw error;
  }
};

export const createStudent = async (fullName: string, course: string): Promise<Student> => {
  const response = await apiClient.post('/api/students/create', null, {
    params: { fullName, course },
  });
  return response.data;
};

export const deleteStudent = async (id: number): Promise<void> => {
  await apiClient.delete('/api/students/', {
    params: { id },
  });
};

export const updateStudent = async (
  id: number,
  fullName: string,
  course: string
): Promise<Student> => {
  const response = await apiClient.put('/api/students/update', null, {
    params: { id, fullName, course },
  });
  return response.data;
};
