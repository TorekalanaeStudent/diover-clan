import { useEffect, useMemo, useState } from 'react';
import { PackagePlus, RefreshCcw } from 'lucide-react';
import { ProductApi } from './api/ProductApi';
import { ProductForm } from './components/ProductForm';
import { ProductList } from './components/ProductList';
import type { Product, ProductPayload } from './types/product';
import './styles.css';

function App() {
  const api = useMemo(() => new ProductApi(), []);
  const [products, setProducts] = useState<Product[]>([]);
  const [editingProduct, setEditingProduct] = useState<Product | null>(null);
  const [isLoading, setIsLoading] = useState(true);
  const [error, setError] = useState<string | null>(null);

  const loadProducts = async () => {
    setIsLoading(true);
    setError(null);
    try {
      setProducts(await api.getAll());
    } catch (err) {
      setError(err instanceof Error ? err.message : 'Unable to load products.');
    } finally {
      setIsLoading(false);
    }
  };

  useEffect(() => {
    void loadProducts();
  }, []);

  const handleSubmit = async (payload: ProductPayload) => {
    setError(null);
    try {
      if (editingProduct) {
        const updated = await api.update(editingProduct.id, payload);
        setProducts((current) => current.map((product) => (product.id === updated.id ? updated : product)));
        setEditingProduct(null);
        return;
      }

      const created = await api.create(payload);
      setProducts((current) => [...current, created]);
    } catch (err) {
      setError(err instanceof Error ? err.message : 'Unable to save product.');
    }
  };

  const handleDelete = async (id: number) => {
    setError(null);
    try {
      await api.delete(id);
      setProducts((current) => current.filter((product) => product.id !== id));
      if (editingProduct?.id === id) {
        setEditingProduct(null);
      }
    } catch (err) {
      setError(err instanceof Error ? err.message : 'Unable to delete product.');
    }
  };

  return (
    <main className="app-shell">
      <section className="workspace">
        <header className="page-header">
          <div>
            <p className="eyebrow">Gedoria Full-Stack Lab</p>
            <h1>Product Inventory</h1>
          </div>
          <button className="icon-button secondary" onClick={() => void loadProducts()} aria-label="Refresh products">
            <RefreshCcw size={18} />
          </button>
        </header>

        {error && <div className="alert">{error}</div>}

        <div className="content-grid">
          <section className="form-panel" aria-labelledby="product-form-title">
            <div className="panel-title">
              <PackagePlus size={20} />
              <h2 id="product-form-title">{editingProduct ? 'Update Product' : 'Add Product'}</h2>
            </div>
            <ProductForm
              product={editingProduct}
              onCancel={() => setEditingProduct(null)}
              onSubmit={(payload) => void handleSubmit(payload)}
            />
          </section>

          <ProductList
            isLoading={isLoading}
            products={products}
            onDelete={(id) => void handleDelete(id)}
            onEdit={setEditingProduct}
          />
        </div>
      </section>
    </main>
  );
}

export default App;
