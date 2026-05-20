import { useState, type FormEvent } from 'react';
import type { Product } from '../types/Product';

interface AddProductProps {
  onAdd: (product: Omit<Product, 'id'>) => Promise<void>;
}

function AddProduct({ onAdd }: AddProductProps) {
  const [name, setName] = useState('');
  const [description, setDescription] = useState('');
  const [price, setPrice] = useState('');
  const [quantity, setQuantity] = useState('0');
  const [submitting, setSubmitting] = useState(false);
  const [error, setError] = useState<string | null>(null);

  const handleSubmit = async (e: FormEvent) => {
    e.preventDefault();
    setError(null);

    if (!name.trim() || !description.trim() || !price) {
      setError('Please fill in all required fields.');
      return;
    }

    const priceNum = parseFloat(price);
    if (isNaN(priceNum) || priceNum < 0) {
      setError('Please enter a valid price.');
      return;
    }

    const quantityNum = quantity === '' ? 0 : parseInt(quantity, 10);
    if (isNaN(quantityNum) || quantityNum < 0) {
      setError('Please enter a valid quantity.');
      return;
    }

    try {
      setSubmitting(true);
      await onAdd({
        name: name.trim(),
        description: description.trim(),
        price: priceNum,
        quantity: quantityNum,
      });

      setName('');
      setDescription('');
      setPrice('');
      setQuantity('0');
    } catch {
      setError('Failed to create product. Please try again.');
    } finally {
      setSubmitting(false);
    }
  };

  return (
    <section className="add-product">
      <h2>Add New Product</h2>
      <form className="add-product-form" onSubmit={handleSubmit} noValidate>
        <div className="form-row">
          <div className="form-group">
            <label htmlFor="product-name">Name</label>
            <input
              id="product-name"
              type="text"
              placeholder="Product name"
              value={name}
              onChange={(e) => setName(e.target.value)}
              required
            />
          </div>
          <div className="form-group">
            <label htmlFor="product-price">Price ($)</label>
            <input
              id="product-price"
              type="number"
              placeholder="0.00"
              min="0"
              step="0.01"
              value={price}
              onChange={(e) => setPrice(e.target.value)}
              required
            />
          </div>
          <div className="form-group">
            <label htmlFor="product-quantity">Quantity</label>
            <input
              id="product-quantity"
              type="number"
              placeholder="Optional"
              min="0"
              value={quantity}
              onChange={(e) => setQuantity(e.target.value)}
            />
          </div>
        </div>
        <div className="form-group full-width">
          <label htmlFor="product-desc">Description</label>
          <textarea
            id="product-desc"
            placeholder="Product description"
            rows={3}
            value={description}
            onChange={(e) => setDescription(e.target.value)}
            required
          />
        </div>
        {error && <p className="form-error">{error}</p>}
        <button type="submit" className="submit-btn" disabled={submitting}>
          {submitting ? (
            <>
              <span className="btn-spinner"></span>
              Adding...
            </>
          ) : (
            <>
              <svg viewBox="0 0 24 24" fill="none" stroke="currentColor" strokeWidth="2" strokeLinecap="round">
                <line x1="12" y1="5" x2="12" y2="19" />
                <line x1="5" y1="12" x2="19" y2="12" />
              </svg>
              Add Product
            </>
          )}
        </button>
      </form>
    </section>
  );
}

export default AddProduct;
