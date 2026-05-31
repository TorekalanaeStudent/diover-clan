import { useTasks } from './hooks/useTasks';
import { TaskList } from './components/taskList';
import { TaskService } from './api/TaskService';
import { useState } from 'react';

function App() {
  const { tasks, refresh } = useTasks();
  const [title, setTitle] = useState("");

  const add = async () => {
    await TaskService.create({ title, completed: false });
    setTitle("");
    refresh(); 
  };

  return (
  <div className="min-h-screen bg-slate-50 flex items-center justify-center p-4"> {
    }
    <div className="relative w-full max-w-md bg-white p-8 rounded-3xl shadow-xl border border-pink-100 mt-6"> {
      }
      <div className="absolute -top-4 -left-4 bg-pink-400 text-white text-xs font-bold px-3 py-1 rounded-full shadow-md transform -rotate-12">
        My Goals ✨
      </div>

      <h1 className="text-3xl font-bold text-[#594a4e] mb-6 text-center">My Tasks List</h1>
      
      <div className="flex gap-2 mb-6">
        <input 
          className="flex-1 p-3 border-2 border-pink-100 rounded-2xl focus:border-pink-300 outline-none"
          placeholder="Add a new task..."
          value={title} 
          onChange={e => setTitle(e.target.value)} 
        />
        <button 
          className="bg-[#ffc1cc] text-white px-6 rounded-2xl font-bold hover:bg-pink-300 transition-all"
          onClick={add}>Add</button>
      </div>
      
      <TaskList tasks={tasks} refresh={refresh} />
    </div>
  </div>
);
}

export default App;