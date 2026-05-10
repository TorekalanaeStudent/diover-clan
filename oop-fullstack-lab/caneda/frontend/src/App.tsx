import { useEffect, useState } from "react";
import type { User } from "./types/User";
import { getUsers } from "./services/UserService";
import UserPanel from "./components/UserPanel";
import CoinFlipPanel from "./components/CoinFlipPanel";
import "./App.css";

function App() {
  const [users, setUsers] = useState<User[]>([]);
  const [selectedUser, setSelectedUser] = useState<User | null>(null);

  useEffect(() => {
    fetchUsers();
  }, []);

  const fetchUsers = async () => {
    const data = await getUsers();
    setUsers(data);
  };

  return (
    <div className="app">
      <header className="app-header">
        <div className="header-logo">🪙</div>
        <h1>CoinFlip Manager</h1>
        <span className="header-sub">Select a user · Flip a coin</span>
      </header>

      <main className="app-body">
        <UserPanel
          users={users}
          selectedUser={selectedUser}
          onSelectUser={setSelectedUser}
          onRefresh={fetchUsers}
        />
        <CoinFlipPanel selectedUser={selectedUser} />
      </main>
    </div>
  );
}

export default App;
