import { useState, useEffect, useRef } from 'react'

interface Idol {
  id?: number
  name: string
  group: string
  company: string
}

interface Sparkle {
  id: number
  x: number
  y: number
}

const API_URL = 'http://localhost:8080/api/idols'

function App() {
  const [idols, setIdols] = useState<Idol[]>([])
  const [form, setForm] = useState<Idol>({ name: '', group: '', company: '' })
  const [editingId, setEditingId] = useState<number | null>(null)
  const [sparkles, setSparkles] = useState<Sparkle[]>([])
  const [btnHover, setBtnHover] = useState(false)
  const btnRef = useRef<HTMLButtonElement>(null)

  useEffect(() => { fetchIdols() }, [])

  const fetchIdols = async () => {
    const res = await fetch(API_URL)
    const data = await res.json()
    setIdols(data)
  }

  const triggerSparkles = () => {
    if (!btnRef.current) return
    const rect = btnRef.current.getBoundingClientRect()
    const newSparkles: Sparkle[] = Array.from({ length: 12 }, (_, i) => ({
      id: Date.now() + i,
      x: rect.left + rect.width / 2 + (Math.random() - 0.5) * 120,
      y: rect.top + rect.height / 2 + (Math.random() - 0.5) * 80,
    }))
    setSparkles(prev => [...prev, ...newSparkles])
    setTimeout(() => {
      setSparkles(prev => prev.filter(s => !newSparkles.find(n => n.id === s.id)))
    }, 800)
  }

  const handleSubmit = async () => {
    if (!form.name || !form.group || !form.company) return
    triggerSparkles()
    if (editingId !== null) {
      await fetch(`${API_URL}/${editingId}`, {
        method: 'PUT',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(form)
      })
    } else {
      await fetch(API_URL, {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(form)
      })
    }
    setForm({ name: '', group: '', company: '' })
    setEditingId(null)
    fetchIdols()
  }

  const handleKeyDown = (e: React.KeyboardEvent) => {
    if (e.key === 'Enter') handleSubmit()
  }

  const handleEdit = (idol: Idol) => {
    setForm({ name: idol.name, group: idol.group, company: idol.company })
    setEditingId(idol.id!)
  }

  const handleDelete = async (id: number) => {
    await fetch(`${API_URL}/${id}`, { method: 'DELETE' })
    fetchIdols()
  }

  return (
      <div style={{
        minHeight: '100vh',
        background: '#fdf6f8',
        fontFamily: '"Georgia", serif',
        position: 'relative',
        overflow: 'hidden',
      }}>

        <style>{`
        @keyframes marquee {
          0% { transform: translateX(0); }
          100% { transform: translateX(-50%); }
        }
        @keyframes float {
          0%, 100% { transform: translateY(0px); }
          50% { transform: translateY(-6px); }
        }
        @keyframes sparkle-pop {
          0% { transform: scale(0) rotate(0deg); opacity: 1; }
          60% { transform: scale(1.4) rotate(180deg); opacity: 1; }
          100% { transform: scale(0) rotate(360deg); opacity: 0; }
        }
        @keyframes fadeInRow {
          from { opacity: 0; transform: translateY(-8px); }
          to { opacity: 1; transform: translateY(0); }
        }
        @keyframes pulse {
          0%, 100% { opacity: 1; }
          50% { opacity: 0.3; }
        }
      `}</style>

        {/* Sparkles */}
        {sparkles.map(s => (
            <div key={s.id} style={{
              position: 'fixed',
              left: s.x,
              top: s.y,
              pointerEvents: 'none',
              zIndex: 9999,
              animation: 'sparkle-pop 0.8s ease-out forwards',
              fontSize: Math.random() > 0.5 ? '18px' : '12px',
            }}>
              {['✦', '✿', '♡', '＊', '★'][Math.floor(Math.random() * 5)]}
            </div>
        ))}

        {/* Background doodles */}
        <svg style={{
          position: 'fixed', top: 0, left: 0,
          width: '100%', height: '100%',
          pointerEvents: 'none', zIndex: 0, opacity: 0.1,
        }}>
          <text x="2%" y="15%" fontSize="28" fill="#9b2335">✦</text>
          <text x="91%" y="10%" fontSize="16" fill="#9b2335">♡</text>
          <text x="4%" y="45%" fontSize="20" fill="#9b2335">♪</text>
          <text x="93%" y="40%" fontSize="24" fill="#9b2335">♫</text>
          <text x="2%" y="75%" fontSize="16" fill="#9b2335">✿</text>
          <text x="92%" y="70%" fontSize="20" fill="#9b2335">✦</text>
          <text x="5%" y="92%" fontSize="12" fill="#9b2335">＊</text>
          <text x="90%" y="90%" fontSize="18" fill="#9b2335">♡</text>
          {[0,1,2,3,4,5].map(i => (
              <circle key={i} cx="3%" cy={`${20 + i * 13}%`} r="2.5" fill="#e8a0b0"/>
          ))}
          {[0,1,2,3,4,5].map(i => (
              <circle key={i} cx="97%" cy={`${20 + i * 13}%`} r="2.5" fill="#e8a0b0"/>
          ))}
          <path d="M 30,300 Q 55,285 80,300 Q 105,315 130,300" stroke="#e8a0b0" strokeWidth="1.5" fill="none"/>
          <path d="M 30,320 Q 55,305 80,320 Q 105,335 130,320" stroke="#e8a0b0" strokeWidth="1.5" fill="none"/>
          <path d="M calc(100% - 130px),400 Q calc(100% - 105px),385 calc(100% - 80px),400 Q calc(100% - 55px),415 calc(100% - 30px),400" stroke="#e8a0b0" strokeWidth="1.5" fill="none"/>
          <path d="M calc(100% - 130px),420 Q calc(100% - 105px),405 calc(100% - 80px),420 Q calc(100% - 55px),435 calc(100% - 30px),420" stroke="#e8a0b0" strokeWidth="1.5" fill="none"/>
        </svg>

        {/* Window bar */}
        <div style={{
          background: 'linear-gradient(to bottom, #e8c0cc, #d4a0b4)',
          padding: '4px 8px',
          display: 'flex',
          alignItems: 'center',
          justifyContent: 'space-between',
          position: 'relative', zIndex: 2,
        }}>
          <div style={{ display: 'flex', alignItems: 'center', gap: '8px' }}>
            <span style={{ fontSize: '13px' }}>⭐</span>
            <span style={{ color: '#6b1a2a', fontSize: '12px', fontFamily: 'sans-serif', fontWeight: 'bold', letterSpacing: '0.05em' }}>
            kang.ster — Idol Registry
          </span>
          </div>
          <div style={{ display: 'flex', gap: '4px' }}>
            {['—', '□', '✕'].map((c, i) => (
                <div key={i} style={{
                  width: '18px', height: '18px',
                  background: i === 2 ? '#c9485b' : '#e8c0cc',
                  border: '1px solid rgba(155,80,100,0.3)',
                  borderRadius: '2px',
                  display: 'flex', alignItems: 'center', justifyContent: 'center',
                  fontSize: '10px', color: i === 2 ? '#fff' : '#6b1a2a', cursor: 'pointer',
                  fontFamily: 'sans-serif',
                }}>{c}</div>
            ))}
          </div>
        </div>

        {/* Marquee */}
        <div style={{
          background: '#9b2335',
          padding: '5px 0',
          overflow: 'hidden',
          whiteSpace: 'nowrap',
          position: 'relative', zIndex: 2,
        }}>
        <span style={{
          display: 'inline-block',
          animation: 'marquee 24s linear infinite',
          fontSize: '11px',
          color: '#ffd0d8',
          fontFamily: 'sans-serif',
          letterSpacing: '0.12em',
          fontWeight: 'bold',
        }}>
          ✦ WELCOME TO kang.ster ✦ IDOL REGISTRY ✦ ADD YOUR FAVES ✦ NEWJEANS NEVER DIE ✦ THIS IS AURA ✦ CLINT TANONG MO NGA KUNG SA PPT GAGAWIN ✦ &nbsp;&nbsp;&nbsp;&nbsp;
          ✦ WELCOME TO kang.ster ✦ IDOL REGISTRY ✦ ADD YOUR FAVES ✦ NEWJEANS NEVER DIE ✦ THIS IS AURA ✦ CLINT TANONG MO NGA KUNG SA PPT GAGAWIN ✦
        </span>
        </div>

        {/* Main */}
        <main style={{
          maxWidth: '800px',
          margin: '0 auto',
          padding: '40px 24px',
          position: 'relative', zIndex: 1,
        }}>

          {/* Header */}
          <div style={{
            textAlign: 'center',
            marginBottom: '32px',
            animation: 'float 3s ease-in-out infinite',
          }}>
            <h1 style={{
              margin: 0,
              fontSize: '52px',
              fontFamily: '"Playfair Display", serif',
              fontStyle: 'italic',
              color: '#9b2335',
              fontWeight: 900,
              textShadow: '2px 2px 0px #e8a0b0',
              letterSpacing: '0.02em',
            }}>kang.ster </h1>
            <p style={{
              margin: '20px 0 0',
              fontSize: '11px',
              color: '#c08090',
              letterSpacing: '0.28em',
              textTransform: 'uppercase',
              fontFamily: 'sans-serif',
              animation: 'pulse 2.5s ease-in-out infinite',
            }}>✦ your idol registry ✦</p>
          </div>

          {/* Form Card */}
          <div style={{
            background: '#9b2335',
            border: '3px solid #6b1020',
            borderRadius: '20px',
            padding: '28px 32px',
            marginBottom: '24px',
            boxShadow: '6px 6px 0px #6b1020',
            position: 'relative',
          }}>
            <span style={{ position: 'absolute', top: 10, right: 16, fontSize: '18px', opacity: 0.3, color: '#ffd0d8' }}>✿</span>
            <span style={{ position: 'absolute', bottom: 10, left: 16, fontSize: '14px', opacity: 0.3, color: '#ffd0d8' }}>✦</span>

            <p style={{
              margin: '0 0 18px 0',
              fontSize: '11px',
              letterSpacing: '0.2em',
              color: '#ffd0d8',
              textTransform: 'lowercase',
              fontFamily: 'sans-serif',
              fontWeight: 'bold',
            }}>{editingId !== null ? '~ editing idol ~' : ' ~ add your idol ~'}</p>

            <div style={{
              display: 'grid',
              gridTemplateColumns: '1fr 1fr 1fr',
              gap: '16px',
              marginBottom: '18px',
            }}>
              {(['name', 'group', 'company'] as const).map(field => (
                  <div key={field}>
                    <label style={{
                      display: 'block',
                      fontSize: '10px',
                      letterSpacing: '0.18em',
                      color: '#ffd0d8',
                      textTransform: 'uppercase',
                      marginBottom: '6px',
                      fontFamily: 'sans-serif',
                      fontWeight: 'bold',
                    }}>{field}</label>
                    <input
                        value={form[field]}
                        onChange={e => setForm({ ...form, [field]: e.target.value })}
                        onKeyDown={handleKeyDown}
                        placeholder={field === 'name' ? 'Kang Haerin' : field === 'group' ? 'NewJeans' : 'ADOR'}
                        style={{
                          width: '100%',
                          boxSizing: 'border-box',
                          border: '2px solid #c9485b',
                          borderRadius: '10px',
                          background: 'rgba(255,255,255,0.1)',
                          padding: '8px 12px',
                          fontSize: '13px',
                          color: '#fff',
                          outline: 'none',
                          fontFamily: '"Georgia", serif',
                          transition: 'background 0.2s',
                        }}
                        onFocus={e => e.target.style.background = 'rgba(255,255,255,0.2)'}
                        onBlur={e => e.target.style.background = 'rgba(255,255,255,0.1)'}
                    />
                  </div>
              ))}
            </div>

            <div style={{ display: 'flex', gap: '10px' }}>
              <button
                  ref={btnRef}
                  onClick={handleSubmit}
                  onMouseEnter={() => setBtnHover(true)}
                  onMouseLeave={() => setBtnHover(false)}
                  style={{
                    background: btnHover ? '#ffe0e8' : '#fff',
                    color: '#9b2335',
                    border: '2px solid #fff',
                    padding: '10px 28px',
                    fontSize: '11px',
                    letterSpacing: '0.18em',
                    textTransform: 'uppercase',
                    cursor: 'pointer',
                    fontFamily: 'sans-serif',
                    borderRadius: '20px',
                    fontWeight: 'bold',
                    boxShadow: btnHover ? '4px 4px 0px #6b1020' : '2px 2px 0px #6b1020',
                    transform: btnHover ? 'translateY(-2px)' : 'translateY(0)',
                    transition: 'all 0.2s ease',
                  }}>
                {editingId !== null ? 'update ✦' : 'add! ✦'}
              </button>
              {editingId !== null && (
                  <button onClick={() => { setForm({ name: '', group: '', company: '' }); setEditingId(null) }} style={{
                    background: 'transparent',
                    color: '#ffd0d8',
                    border: '2px solid #c9485b',
                    padding: '10px 20px',
                    fontSize: '11px',
                    letterSpacing: '0.1em',
                    textTransform: 'uppercase',
                    cursor: 'pointer',
                    fontFamily: 'sans-serif',
                    borderRadius: '20px',
                    transition: 'all 0.2s ease',
                  }}>cancel</button>
              )}
            </div>
          </div>

          {/* Table */}
          <div style={{
            background: '#fff',
            border: '3px solid #e8c0cc',
            borderRadius: '20px',
            boxShadow: '6px 6px 0px #e8c0cc',
            overflow: 'hidden',
          }}>
            <div style={{
              display: 'grid',
              gridTemplateColumns: '1fr 1fr 1fr 110px',
              padding: '14px 24px',
              background: '#fdf0f4',
              fontSize: '10px',
              letterSpacing: '0.2em',
              color: '#9b2335',
              textTransform: 'uppercase',
              fontFamily: 'sans-serif',
              fontWeight: 'bold',
              borderBottom: '2px solid #e8c0cc',
            }}>
              <span>✦ Name</span>
              <span>✦ Group</span>
              <span>✦ Company</span>
              <span>✦ Actions</span>
            </div>

            {idols.length === 0 ? (
                <div style={{
                  padding: '48px 24px',
                  textAlign: 'center',
                  color: '#c4aab0',
                  fontStyle: 'italic',
                  fontSize: '15px',
                }}> empty ~ add smth! ♡</div>
            ) : (
                idols.map((idol, i) => (
                    <div key={idol.id} style={{
                      display: 'grid',
                      gridTemplateColumns: '1fr 1fr 1fr 110px',
                      padding: '14px 24px',
                      borderTop: '1px dashed #f0c8d0',
                      fontSize: '14px',
                      color: '#2a1218',
                      background: i % 2 === 0 ? '#fff' : '#fdf6f8',
                      alignItems: 'center',
                      animation: `fadeInRow 0.4s ease ${i * 0.05}s both`,
                    }}>
                      <span style={{ fontWeight: 'bold', color: '#9b2335' }}>{idol.name}</span>
                      <span style={{ color: '#555' }}>{idol.group}</span>
                      <span style={{ color: '#999' }}>{idol.company}</span>
                      <span style={{ display: 'flex', gap: '8px' }}>
                  <button onClick={() => handleEdit(idol)} style={{
                    background: '#fdf0f4',
                    border: '1px solid #e8c0cc',
                    color: '#9b2335',
                    cursor: 'pointer',
                    fontSize: '10px',
                    letterSpacing: '0.1em',
                    textTransform: 'uppercase',
                    fontFamily: 'sans-serif',
                    padding: '4px 10px',
                    borderRadius: '8px',
                    fontWeight: 'bold',
                    transition: 'all 0.15s ease',
                  }}
                          onMouseEnter={e => (e.currentTarget.style.background = '#f5d0da')}
                          onMouseLeave={e => (e.currentTarget.style.background = '#fdf0f4')}
                  >edit</button>
                  <button onClick={() => handleDelete(idol.id!)} style={{
                    background: '#fdf6f8',
                    border: '1px solid #e8c0cc',
                    color: '#c4aab0',
                    cursor: 'pointer',
                    fontSize: '10px',
                    letterSpacing: '0.1em',
                    textTransform: 'uppercase',
                    fontFamily: 'sans-serif',
                    padding: '4px 10px',
                    borderRadius: '8px',
                    transition: 'all 0.15s ease',
                  }}
                          onMouseEnter={e => (e.currentTarget.style.color = '#9b2335')}
                          onMouseLeave={e => (e.currentTarget.style.color = '#c4aab0')}
                  >del</button>
                </span>
                    </div>
                ))
            )}
          </div>

          {/* Footer */}
          <div style={{
            textAlign: 'center',
            marginTop: '24px',
            fontSize: '11px',
            color: '#c08090',
            fontFamily: 'sans-serif',
            letterSpacing: '0.15em',
            opacity: 0.8,
          }}>
            ✦ made with ♡ by jay ✦ newjeans never die ✦
          </div>
        </main>
      </div>
  )
}

export default App