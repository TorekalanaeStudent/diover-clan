import { useEffect, useState } from 'react';
import { TaskService } from '../api/TaskService';

export const useTasks = () => {
  const [tasks, setTasks] = useState([]);

  const refresh = async () => {
    try {
      const data = await TaskService.getAll(); // Ensure this matches your service
      setTasks(data);
    } catch (error) {
      console.error("Failed to fetch tasks:", error);
    }
  };

  useEffect(() => {
    refresh();
  }, []);

  return { tasks, refresh };
};