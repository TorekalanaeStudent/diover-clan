import { useState } from 'react';
import { TaskService } from '../api/TaskService';

interface Task { id: number; title: string; completed: boolean; }

export const TaskList = ({ tasks, refresh }: { tasks: Task[], refresh: () => void }) => {
  const [editingId, setEditingId] = useState<number | null>(null);
  const [editTitle, setEditTitle] = useState('');

  const handleDelete = async (id: number) => {
    await TaskService.delete(id);
    refresh();
  };

  const handleSave = async (id: number) => {
    await TaskService.update(id, { title: editTitle, completed: false });
    setEditingId(null);
    refresh();
  };

  if (!tasks || !Array.isArray(tasks)) {
    return <div>Loading tasks...</div>;
  }

  return (
    <ul className="space-y-3">
      {tasks.map(t => (
        <li 
          key={t.id} 
          className="flex items-center justify-between p-4 bg-white border border-pink-50 rounded-2xl shadow-sm hover:shadow-md transition-all"
        >
          {editingId === t.id ? (
            <div className="flex gap-2 w-full">
              <input 
                className="flex-1 border-b-2 border-pink-200 outline-none" 
                value={editTitle} 
                onChange={(e) => setEditTitle(e.target.value)} 
              />
              <button className="text-sm font-bold text-pink-500" onClick={() => handleSave(t.id)}>Save</button>
            </div>
          ) : (
            <>
              <span className="text-lg text-[#594a4e]">
                {t.title}
              </span>
              <div className="flex gap-1">
                {}
                <button 
                  className="px-3 py-1 bg-green-50 text-green-500 rounded-lg text-xs font-bold" 
                  onClick={() => handleDelete(t.id)}
                >
                  Delete
                </button>
                <button 
                  className="px-3 py-1 bg-pink-50 text-pink-400 rounded-lg text-xs" 
                  onClick={() => { setEditingId(t.id); setEditTitle(t.title); }}
                >
                  Update
                </button>
              </div>
            </>
          )}
        </li>
      ))}
    </ul>
  );
};