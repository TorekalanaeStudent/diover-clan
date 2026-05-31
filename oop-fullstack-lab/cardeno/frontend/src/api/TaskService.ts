import api from './axios';

export const TaskService = {
  getAll: () => api.get('/api/tasks').then((res: { data: any }) => res.data),
  
  create: async (task: { title: string; completed: boolean }) => {
    try {
      const res = await api.post('/api/tasks', task);
      return res.data;
    } catch (err: any) {
      alert("Failed to create task: " + (err.response?.data?.message || "Check your input"));
      throw err;
    }
  },
  
  delete: async (id: number) => {
    try {
      await api.delete(`/api/tasks/${id}`);
    } catch (err: any) {
      alert("Failed to delete task");
      throw err;
    }
  },
  
  update: async (id: number, task: { title: string; completed: boolean }) => {
    try {
      const res = await api.put(`/api/tasks/${id}`, task);
      return res.data;
    } catch (err: any) {
      alert("Failed to update task: " + (err.response?.data?.message || "Check your input"));
      throw err;
    }
  }
};