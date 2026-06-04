import { useState, useEffect } from 'react';
import type { Product } from '../services/productService';

interface Props {
  onSubmit: (product: Product) => void;
  editingProduct?: Product | null;
  onCancel?: () => void;
}

const ProductForm = ({ onSubmit, editingProduct, onCancel }: Props) => {
  const [name, setName] = useState('');
  const [description, setDescription] = useState('');
  const [price, setPrice] = useState('');

  useEffect(() => {
    if (editingProduct) {
      setName(editingProduct.name);
      setDescription(editingProduct.description);
      setPrice(editingProduct.price.toString());
    } else {
      setName('');
      setDescription('');
      setPrice('');
    }
  }, [editingProduct]);

  const handleSubmit = (e: React.FormEvent) => {
    e.preventDefault();
    onSubmit({ name, description, price: parseFloat(price) });
    setName('');
    setDescription('');
    setPrice('');
  };

return (
    <form onSubmit={handleSubmit}>
      <h3>{editingProduct ? '✏️ Edit Product' : '➕ Add Product'}</h3>
      <div className="form-row" style={{ marginTop: '1rem' }}>
        <input
          placeholder="Name"
          value={name}
          onChange={e => setName(e.target.value)}
          required
        />
        <input
          placeholder="Description"
          value={description}
          onChange={e => setDescription(e.target.value)}
          required
        />
        <input
          placeholder="Price"
          type="number"
          value={price}
          onChange={e => setPrice(e.target.value)}
          required
        />
        <button type="submit" className="btn-add">
          {editingProduct ? 'Update' : 'Add'}
        </button>
        {editingProduct && (
          <button type="button" className="btn-cancel" onClick={onCancel}>
            Cancel
          </button>
        )}
      </div>
    </form>
  );
};

export default ProductForm;