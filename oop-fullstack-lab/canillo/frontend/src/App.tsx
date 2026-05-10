import { useState, useEffect } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from './assets/vite.svg'
import heroImg from './assets/hero.png'
import './App.css'
import { UserList } from './components/UserList'

function App() {
  const [count, setCount] = useState(0)
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
          <UserList />
        </div>
        <button
          type="button"
          className="counter"
          onClick={() => setCount((count) => count + 1)}
        >
          Count is {count}
        </button>
      </section>

    </>
  )
}

export default App
