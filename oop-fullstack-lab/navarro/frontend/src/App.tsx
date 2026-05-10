import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from './assets/vite.svg'
import heroImg from './assets/hero.png'
import './App.css'
import EmployeeList from './components/EmployeeList'
import AddEmployee from './components/AddEmployee'

function App() {
  const [count, setCount] = useState(0)
  const [refreshKey, setRefreshKey] = useState(0)

  return (
    <main className="app-container">
      <header className="page-header">
        <div className="hero-copy">
          <div className="hero-badge">Employee Dashboard</div>
          <h1>Team Management</h1>
          <p>Easily create, update, and remove employee records in a single click!.</p>
          <button
            type="button"
            className="button button-primary counter"
            onClick={() => setCount((count) => count + 1)}
          >
            Count is {count}
          </button>
        </div>
        <div className="hero-visual">
          <img src={heroImg} className="hero-base" width="170" height="179" alt="Hero" />
          <img src={reactLogo} className="hero-framework" alt="React logo" />
          <img src={viteLogo} className="hero-vite" alt="Vite logo" />
        </div>
      </header>

      <div className="section-grid">
        <section className="card section-card">
          <AddEmployee onEmployeeAdded={() => setRefreshKey((k) => k + 1)} />
        </section>

        <section className="card section-card">
          <EmployeeList key={refreshKey} />
        </section>
      </div>

      <section id="next-steps">
        <div id="docs">
          <svg className="icon" role="presentation" aria-hidden="true">
            <use href="/icons.svg#documentation-icon"></use>
          </svg>
          <h2>Documentation</h2>
          <p>Your questions, answered</p>
          <ul>
            <li>
              <a href="https://vite.dev/" target="_blank">
                <img className="logo" src={viteLogo} alt="" />
                Explore Vite
              </a>
            </li>
            <li>
              <a href="https://react.dev/" target="_blank">
                <img className="button-icon" src={reactLogo} alt="" />
                Learn more
              </a>
            </li>
          </ul>
        </div>
        <div id="social">
          <svg className="icon" role="presentation" aria-hidden="true">
            <use href="/icons.svg#social-icon"></use>
          </svg>
          <h2>Connect with us</h2>
          <p>Join the Vite community</p>
          <ul>
            <li>
              <a href="https://github.com/vitejs/vite" target="_blank">
                <svg
                  className="button-icon"
                  role="presentation"
                  aria-hidden="true"
                >
                  <use href="/icons.svg#github-icon"></use>
                </svg>
                GitHub
              </a>
            </li>
            <li>
              <a href="https://chat.vite.dev/" target="_blank">
                <svg
                  className="button-icon"
                  role="presentation"
                  aria-hidden="true"
                >
                  <use href="/icons.svg#discord-icon"></use>
                </svg>
                Discord
              </a>
            </li>
            <li>
              <a href="https://x.com/vite_js" target="_blank">
                <svg
                  className="button-icon"
                  role="presentation"
                  aria-hidden="true"
                >
                  <use href="/icons.svg#x-icon"></use>
                </svg>
                X.com
              </a>
            </li>
            <li>
              <a href="https://bsky.app/profile/vite.dev" target="_blank">
                <svg
                  className="button-icon"
                  role="presentation"
                  aria-hidden="true"
                >
                  <use href="/icons.svg#bluesky-icon"></use>
                </svg>
                Bluesky
              </a>
            </li>
          </ul>
        </div>
      </section>
    </main>
  )
}

export default App
