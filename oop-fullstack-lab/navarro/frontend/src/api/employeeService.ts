import apiClient from './axios';
import type { Employee } from '../types/Employee';

const EmployeeService = {
    async getAll(): Promise<Employee[]> {
    const response = await apiClient.get<Employee[]>('');
    return response.data;
},

    async getById(id: number): Promise<Employee> {
        const response = await apiClient.get<Employee>(`/${id}`);
        return response.data;
    },

    async create(employee: Omit<Employee, 'id'>): Promise<Employee> {
        const response = await apiClient.post<Employee>('/create', employee);
        return response.data;
    },

    async update(id: number, employee: Omit<Employee, 'id'>): Promise<Employee> {
        const response = await apiClient.put<Employee>(`/update/${id}`, employee);
        return response.data;
    },

    async patch(id: number, employee: Partial<Omit<Employee, 'id'>>): Promise<Employee> {
        const response = await apiClient.patch<Employee>(`/${id}`, employee);
        return response.data;
    },

    async remove(id: number): Promise<void> {
        await apiClient.delete(`/${id}`);
    },
};

export default EmployeeService;