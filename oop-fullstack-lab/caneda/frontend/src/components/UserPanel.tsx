import { useState } from "react";
import type { User } from "../types/User";
import { createUser, updateUser, deleteUser, getUserSummary, getAllUserSummaries } from "../services/UserService";

interface Props {
  users: User[];
  selectedUser: User | null;
  onSelectUser: (user: User) => void;
  onRefresh: () => void;
}

const UserPanel = ({ users, selectedUser, onSelectUser, onRefresh }: Props) => {
  const [showForm, setShowForm] = useState(false);
  const [editingUser, setEditingUser] = useState<User | null>(null);
  const [name, setName] = useState("");
  const [email, setEmail] = useState("");
  const [role, setRole] = useState("");
  const [summary, setSummary] = useState<any>(null);
  const [allSummaries, setAllSummaries] = useState<any[]>([]);

  const openAdd = () => {
    setEditingUser(null);
    setName("");
    setEmail("");
    setRole("");
    setShowForm(true);
  };

  const openEdit = (user: User) => {
    setEditingUser(user);
    setName(user.name);
    setEmail(user.email);
    setRole(user.role);
    setShowForm(true);
  };

  const handleSubmit = async () => {
    if (!name || !email || !role) return;
    if (editingUser?.id) {
      await updateUser(editingUser.id, { name, email, role });
    } else {
      await createUser({ name, email, role });
    }
    setShowForm(false);
    onRefresh();
  };

  const handleDelete = async (id: number) => {
    await deleteUser(id);
    if (selectedUser?.id === id) {
      onSelectUser(null as any);
    }
    setSummary(null);
    setAllSummaries([]);
    onRefresh();
  };

  const handleViewSummary = async (user: User) => {
    if (summary && summary.username === user.name) {
      setSummary(null);
      return;
    }
    if (user.id) {
      const data = await getUserSummary(user.id);
      setSummary(data);
    }
  };

  const handleViewAllSummaries = async () => {
    if (allSummaries.length > 0) {
      setAllSummaries([]);
      return;
    }
    const data = await getAllUserSummaries();
    setAllSummaries(data);
  };

  return (
      <div className="panel">
        <div className="panel-header">
          <h2>Users</h2>
          <button className="btn-add" onClick={openAdd}>+ Add User</button>
          <button className="btn-ghost" onClick={handleViewAllSummaries}>📊 All Summaries</button>
        </div>

        {showForm && (
            <div className="form-card">
              <h3>{editingUser ? "Edit User" : "New User"}</h3>
              <input placeholder="Name" value={name} onChange={e => setName(e.target.value)} />
              <input placeholder="Email" value={email} onChange={e => setEmail(e.target.value)} />
              <input placeholder="Role" value={role} onChange={e => setRole(e.target.value)} />
              <div className="form-actions">
                <button className="btn-primary" onClick={handleSubmit}>{editingUser ? "Update" : "Create"}</button>
                <button className="btn-ghost" onClick={() => setShowForm(false)}>Cancel</button>
              </div>
            </div>
        )}

        <div className="user-list">
          {users.length === 0 && <p className="empty">No users yet. Add one above.</p>}
          {users.map(user => (
              <div
                  key={user.id}
                  className={`user-row ${selectedUser?.id === user.id ? "active" : ""}`}
                  onClick={() => onSelectUser(user)}
              >
                <div className="user-avatar">{user.name.charAt(0).toUpperCase()}</div>
                <div className="user-info">
                  <span className="user-name">{user.name}</span>
                  <span className="user-meta">{user.role} · {user.email}</span>
                </div>
                <div className="user-actions" onClick={e => e.stopPropagation()}>
                  <button className="icon-btn" onClick={() => openEdit(user)} title="Edit">✏️</button>
                  <button className="icon-btn danger" onClick={() => handleDelete(user.id!)} title="Delete">🗑️</button>
                  <button className="icon-btn" onClick={() => handleViewSummary(user)} title="Summary">📊</button>
                </div>
              </div>
          ))}
        </div>

        {summary && (
            <div className="form-card" style={{ marginTop: "16px" }}>
              <h3>Summary</h3>
              <p>👤 {summary.username}</p>
              <p>📧 {summary.email}</p>
              <p>🎭 {summary.role}</p>
              <p>✅ Wins: {summary.wins}</p>
              <p>❌ Losses: {summary.losses}</p>
              <p>🪙 Total Flips: {summary.totalFlips}</p>
            </div>
        )}

        {allSummaries.length > 0 && (
            <div className="form-card" style={{ marginTop: "16px" }}>
              <h3>All Summaries</h3>
              {allSummaries.map((s, i) => (
                  <p key={i}>👤 {s.username} — ✅ {s.wins} wins · ❌ {s.losses} losses · 🪙 {s.totalFlips} flips</p>
              ))}
            </div>
        )}
      </div>
  );
};

export default UserPanel;