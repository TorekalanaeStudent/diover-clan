import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from './assets/vite.svg'
import heroImg from './assets/hero.png'
import ProductList from './components/ProductList'
import AddProduct from './components/AddProduct'
import { useProducts } from './hooks/useProducts'
import './App.css'
import './components/AddProduct.css'

function App() {
  const [count, setCount] = useState(0)
  const { addProduct } = useProducts();

  return (
    <>
      <section id="center">
        <div className="hero">
          <img src={heroImg} className="base" width="170" height="179" alt="" />
          <img src={reactLogo} className="framework" alt="React logo" />
          <img src={viteLogo} className="vite" alt="Vite logo" />
        </div>
        <div>
          <h1>Get started</h1>
          <p>
            Edit <code>src/App.tsx</code> and save to test <code>HMR</code>
          </p>
        </div>
        <button
          type="button"
          className="counter"
          onClick={() => setCount((count) => count + 1)}
        >
          Count is {count}
        </button>
      </section>

      <div className="ticks"></div>

      <AddProduct onAdd={addProduct} />

      <div className="ticks"></div>

      <ProductList />
    </>
  )
}

export default App
