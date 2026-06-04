import { useEffect, useState } from 'react';
import type { Product } from './services/productService';
import { getAllProducts, createProduct, updateProduct, deleteProduct } from './services/productService';
import ProductForm from './components/ProductForm';
import ProductList from './components/ProductList';
import './App.css';

function App() {
  const [products, setProducts] = useState<Product[]>([]);
  const [editingProduct, setEditingProduct] = useState<Product | null>(null);
  const [loading, setLoading] = useState(false);

  const fetchProducts = async () => {
    setLoading(true);
    try {
      const data = await getAllProducts();
      setProducts(data);
    } catch (error) {
      console.error('Error fetching products:', error);
    } finally {
      setLoading(false);
    }
  };

  useEffect(() => {
    fetchProducts();
  }, []);

  const handleSubmit = async (product: Product) => {
    try {
      if (editingProduct?.id) {
        await updateProduct(editingProduct.id, product);
        setEditingProduct(null);
      } else {
        await createProduct(product);
      }
      fetchProducts();
    } catch (error) {
      console.error('Error saving product:', error);
    }
  };

  const handleDelete = async (id: number) => {
    if (confirm('Delete this product?')) {
      try {
        await deleteProduct(id);
        fetchProducts();
      } catch (error) {
        console.error('Error deleting product:', error);
      }
    }
  };

return (
    <div className="app-container">
      <div className="app-header">
        <h1>🛒 Product Manager</h1>
        <p>Manage your products easily!</p>
      </div>
      <div className="form-card">
        <ProductForm
          onSubmit={handleSubmit}
          editingProduct={editingProduct}
          onCancel={() => setEditingProduct(null)}
        />
      </div>
      <div className="table-card">
        {loading ? (
          <p className="loading-msg">Loading...</p>
        ) : (
          <ProductList
            products={products}
            onEdit={setEditingProduct}
            onDelete={handleDelete}
          />
        )}
      </div>
    </div>
  );
}

export default App;