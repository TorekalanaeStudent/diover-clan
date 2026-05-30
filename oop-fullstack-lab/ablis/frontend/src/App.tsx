import { useState, useEffect } from 'react'
import './App.css'
import { UserList } from './components/UserList'
import type { User } from './types/User'
import { getUsers, deleteUser } from './api/userService'
import { AddUserForm } from './components/AddUserForm'

function App() {
  const [users, setUsers] = useState<User[]>([])
  const [editingUser, setEditingUser] = useState<User | null>(null)
  const [isDark, setIsDark] = useState(() => {
    const saved = localStorage.getItem('theme')
    if (saved) return saved === 'dark'
    return window.matchMedia('(prefers-color-scheme: dark)').matches
  })

  useEffect(() => {
    const htmlElement = document.documentElement
    if (isDark) {
      htmlElement.setAttribute('data-theme', 'dark')
      localStorage.setItem('theme', 'dark')
    } else {
      htmlElement.setAttribute('data-theme', 'light')
      localStorage.setItem('theme', 'light')
    }
  }, [isDark])

  useEffect(() => {
    getUsers().then(setUsers).catch(console.error)
  }, [])

  const handleDelete = async (id: number) => {
    await deleteUser(id)
    const updated = await getUsers()
    setUsers(updated)
  }

  const handleEdit = (user: User) => {
    setEditingUser(user)
  }

  return (
    <>
      <button
        onClick={() => setIsDark(!isDark)}
        style={{
          position: 'fixed',
          top: '20px',
          right: '20px',
          padding: '8px 16px',
          borderRadius: '6px',
          border: '1px solid var(--border)',
          background: 'var(--accent-bg)',
          color: 'var(--accent)',
          cursor: 'pointer',
          zIndex: 1000,
          fontSize: '14px',
          fontWeight: '500'
        }}
      >
        {isDark ? '☀️ Light' : '🌙 Dark'}
      </button>
      <section id="center">
        <div>
          <h1>Table for Users</h1>
          <AddUserForm
            onUserAdded={() => getUsers().then(setUsers)}
            editingUser={editingUser}
            onEditCancel={() => setEditingUser(null)}
          />
          <UserList users={users} onDelete={handleDelete} onEdit={handleEdit} />
        </div>
      </section>
    </>
  )
}

export default App