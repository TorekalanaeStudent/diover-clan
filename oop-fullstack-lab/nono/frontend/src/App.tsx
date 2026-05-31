import { useState } from 'react';
import ProductForm from './components/ProductForm';
import ProductList from './components/ProductList';
import { Product, ProductFormData } from './types/Product';
import { useProducts } from './hooks/useProducts';
import './App.css';

/**
 * OOP - Separation of Concerns:
 * App.tsx = layout + orchestration only
 * useProducts hook = all state + CRUD logic
 * ProductForm = form UI
 * ProductList = display UI
 * api/productApi.ts = all HTTP calls
 */
function App() {
  const [editingProduct, setEditingProduct] = useState<Product | null>(null);

  const {
    products,
    loading,
    formLoading,
    error,
    successMsg,
    setError,
    addProduct,
    editProduct,
    removeProduct,
  } = useProducts();

  const handleFormSubmit = async (data: ProductFormData) => {
    if (editingProduct) {
      await editProduct(editingProduct.id, data);
      setEditingProduct(null);
    } else {
      await addProduct(data);
    }
  };

  return (
    <div className="app">
      <header className="app-header">
        <h1>🛒 Product Manager</h1>
        <p>Mary Angeline B. Nono| BS Computer Science | React + Spring Boot + PostgreSQL</p>
      </header>

      <main className="app-main">
        {error && (
          <div className="alert alert-error" role="alert">
            {error}
            <button onClick={() => setError(null)}>✖</button>
          </div>
        )}
        {successMsg && (
          <div className="alert alert-success" role="status">
            {successMsg}
          </div>
        )}

        <div className="layout">
          <aside className="sidebar">
            <ProductForm
           key={editingProduct ? editingProduct.id : 'new'}
           onSubmit={handleFormSubmit}
           editingProduct={editingProduct}
           onCancelEdit={() => setEditingProduct(null)}
           loading={formLoading}
/>
          </aside>
          <section className="content">
            <ProductList
              products={products}
              onEdit={setEditingProduct}
              onDelete={removeProduct}
              loading={loading}
            />
          </section>
        </div>
      </main>

      <footer className="app-footer">
        <p>Mary Angeline B. Nono | Product Manager System • React + Spring Boot + PostgreSQL</p>
      </footer>
    </div>
  );
}

export default App;
