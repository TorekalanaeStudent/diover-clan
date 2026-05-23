import { useState } from 'react';
import { useProducts } from '../hooks/useProducts';
import type { Product } from '../types/Product';
import './ProductList.css';

function ProductList() {
  const { products, loading, error, refresh, editProduct, removeProduct } = useProducts();
  const [editingId, setEditingId] = useState<number | null>(null);
  const [editForm, setEditForm] = useState({ name: '', description: '', price: '', quantity: '' });
  const [editError, setEditError] = useState<string | null>(null);

  const startEdit = (product: Product) => {
    setEditingId(product.id);
    setEditError(null);
    setEditForm({
      name: product.name,
      description: product.description,
      price: product.price.toString(),
      quantity: product.quantity?.toString() ?? '',
    });
  };

  const cancelEdit = () => {
    setEditingId(null);
    setEditError(null);
  };

  const saveEdit = async (id: number) => {
    setEditError(null);
    const priceNum = parseFloat(editForm.price);
    if (isNaN(priceNum) || priceNum < 0) {
      setEditError('Please enter a valid price.');
      return;
    }
    const qty = editForm.quantity === '' ? null : parseInt(editForm.quantity, 10);
    if (qty !== null && isNaN(qty)) {
      setEditError('Please enter a valid quantity.');
      return;
    }
    await editProduct(id, {
      name: editForm.name,
      description: editForm.description,
      price: priceNum,
      quantity: qty,
    });
    setEditingId(null);
  };

  const handleDelete = async (id: number) => {
    if (window.confirm('Are you sure you want to delete this product?')) {
      await removeProduct(id);
    }
  };

  if (loading) {
    return (
      <div className="product-list-loading">
        <div className="spinner"></div>
        <p>Loading products...</p>
      </div>
    );
  }

  if (error) {
    return (
      <div className="product-list-error">
        <p>{error}</p>
        <button className="retry-btn" onClick={refresh}>Retry</button>
      </div>
    );
  }

  return (
    <section className="product-list">
      <div className="product-list-header">
        <div className="product-list-title-row">
          <div>
            <h1>Our Products</h1>
            <p className="product-count">{products.length} item{products.length !== 1 ? 's' : ''} available</p>
          </div>
          <button className="refresh-btn" onClick={refresh} title="Refresh products">
            <svg viewBox="0 0 24 24" fill="none" stroke="currentColor" strokeWidth="2" strokeLinecap="round" strokeLinejoin="round">
              <polyline points="23 4 23 10 17 10" />
              <polyline points="1 20 1 14 7 14" />
              <path d="M3.51 9a9 9 0 0 1 14.85-3.36L23 10M1 14l4.64 4.36A9 9 0 0 0 20.49 15" />
            </svg>
            Refresh
          </button>
        </div>
      </div>

      {products.length === 0 ? (
        <div className="product-list-empty">
          <p>No products found. Add some products to get started!</p>
        </div>
      ) : (
        <div className="product-grid">
          {products.map((product) => (
            <article key={product.id} className={`product-card ${editingId === product.id ? 'editing' : ''}`}>
              {editingId === product.id ? (
                <div className="edit-form">
                  <div className="form-group">
                    <label htmlFor={`edit-name-${product.id}`}>Name</label>
                    <input
                      id={`edit-name-${product.id}`}
                      type="text"
                      value={editForm.name}
                      onChange={(e) => setEditForm({ ...editForm, name: e.target.value })}
                    />
                  </div>
                  <div className="form-group">
                    <label htmlFor={`edit-price-${product.id}`}>Price</label>
                    <input
                      id={`edit-price-${product.id}`}
                      type="number"
                      min="0"
                      step="0.01"
                      value={editForm.price}
                      onChange={(e) => setEditForm({ ...editForm, price: e.target.value })}
                    />
                  </div>
                  <div className="form-group">
                    <label htmlFor={`edit-qty-${product.id}`}>Quantity</label>
                    <input
                      id={`edit-qty-${product.id}`}
                      type="number"
                      min="0"
                      value={editForm.quantity}
                      onChange={(e) => setEditForm({ ...editForm, quantity: e.target.value })}
                    />
                  </div>
                  <div className="form-group full-width">
                    <label htmlFor={`edit-desc-${product.id}`}>Description</label>
                    <textarea
                      id={`edit-desc-${product.id}`}
                      rows={3}
                      value={editForm.description}
                      onChange={(e) => setEditForm({ ...editForm, description: e.target.value })}
                    />
                  </div>
                  {editError && <p className="form-error">{editError}</p>}
                  <div className="edit-actions">
                    <button className="save-btn" onClick={() => saveEdit(product.id)}>Save</button>
                    <button className="cancel-btn" onClick={cancelEdit}>Cancel</button>
                  </div>
                </div>
              ) : (
                <div className="product-card-content">
                  <div className="product-card-top">
                    <span className={`stock-badge ${product.quantity !== null && product.quantity > 0 ? 'in-stock' : 'out-of-stock'}`}>
                      {product.quantity !== null && product.quantity > 0 ? 'In Stock' : 'Out of Stock'}
                    </span>
                    <div className="product-card-actions">
                      <button className="icon-btn edit-btn" onClick={() => startEdit(product)} title="Edit">
                        <svg viewBox="0 0 24 24" fill="none" stroke="currentColor" strokeWidth="2" strokeLinecap="round" strokeLinejoin="round">
                          <path d="M11 4H4a2 2 0 0 0-2 2v14a2 2 0 0 0 2 2h14a2 2 0 0 0 2-2v-7" />
                          <path d="M18.5 2.5a2.121 2.121 0 0 1 3 3L12 15l-4 1 1-4 9.5-9.5z" />
                        </svg>
                      </button>
                      <button className="icon-btn delete-btn" onClick={() => handleDelete(product.id)} title="Delete">
                        <svg viewBox="0 0 24 24" fill="none" stroke="currentColor" strokeWidth="2" strokeLinecap="round" strokeLinejoin="round">
                          <polyline points="3 6 5 6 21 6" />
                          <path d="M19 6l-1 14a2 2 0 0 1-2 2H8a2 2 0 0 1-2-2L5 6" />
                          <path d="M10 11v6" />
                          <path d="M14 11v6" />
                          <path d="M9 6V4a1 1 0 0 1 1-1h4a1 1 0 0 1 1 1v2" />
                        </svg>
                      </button>
                    </div>
                  </div>
                  <h2 className="product-name">{product.name}</h2>
                  <p className="product-description">{product.description}</p>
                  <div className="product-card-footer">
                    <span className="product-price">${product.price.toFixed(2)}</span>
                    <span className="product-quantity">
                      {product.quantity !== null ? `${product.quantity} left` : 'Unlimited'}
                    </span>
                  </div>
                </div>
              )}
            </article>
          ))}
        </div>
      )}
    </section>
  );
}

export default ProductList;
