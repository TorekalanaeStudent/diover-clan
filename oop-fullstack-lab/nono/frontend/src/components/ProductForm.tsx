import React, { useState, useEffect } from 'react';
import { Product, ProductFormData, EMPTY_FORM } from '../types/Product';

interface ProductFormProps {
  onSubmit: (data: ProductFormData) => void;
  editingProduct: Product | null;
  onCancelEdit: () => void;
  loading: boolean;
}

/**
 * OOP - Encapsulation:
 * Form state is encapsulated inside this component.
 * The parent only gets the final form data via onSubmit.
 *
 * OOP - Separation of Concerns:
 * This component ONLY handles form input — no API calls here.
 */
const ProductForm: React.FC<ProductFormProps> = ({
  onSubmit,
  editingProduct,
  onCancelEdit,
  loading,
}) => {
  const [formData, setFormData] = useState<ProductFormData>(EMPTY_FORM);
  const [errors, setErrors] = useState<Partial<ProductFormData>>({});

  // Populate form when editing
  useEffect(() => {
    if (editingProduct) {
      setFormData({
        name: editingProduct.name,
        description: editingProduct.description,
        price: editingProduct.price,
        stock: editingProduct.stock,
        category: editingProduct.category,
      });
    } else {
      setFormData(EMPTY_FORM);
    }
    setErrors({});
  }, [editingProduct]);

  const validate = (): boolean => {
    const newErrors: Partial<ProductFormData> = {};
    if (!formData.name.trim()) newErrors.name = 'Name is required';
    if (!formData.price || Number(formData.price) <= 0) newErrors.price = 'Price must be > 0';
    if (formData.stock === '' || Number(formData.stock) < 0) newErrors.stock = 'Stock cannot be negative';
    if (!formData.category.trim()) newErrors.category = 'Category is required';
    setErrors(newErrors);
    return Object.keys(newErrors).length === 0;
  };

  const handleChange = (e: React.ChangeEvent<HTMLInputElement | HTMLTextAreaElement | HTMLSelectElement>) => {
    setFormData(prev => ({ ...prev, [e.target.name]: e.target.value }));
  };

  const handleSubmit = (e: React.FormEvent) => {
    e.preventDefault();
    if (!validate()) return;
    onSubmit({
      ...formData,
      price: Number(formData.price),
      stock: Number(formData.stock),
    });
  };

  const handleCancel = () => {
    setFormData(EMPTY_FORM);
    setErrors({});
    onCancelEdit();
  };

  return (
    <div className="form-card">
      <h2>{editingProduct ? '✏️ Edit Product' : '➕ Add New Product'}</h2>
      <form onSubmit={handleSubmit} noValidate>
        <div className="form-group">
          <label htmlFor="name">Product Name *</label>
          <input
            id="name"
            name="name"
            type="text"
            placeholder="e.g. Laptop Pro X"
            value={formData.name}
            onChange={handleChange}
            className={errors.name ? 'input-error' : ''}
          />
          {errors.name && <span className="error-msg">{errors.name}</span>}
        </div>

        <div className="form-group">
          <label htmlFor="description">Description</label>
          <textarea
            id="description"
            name="description"
            placeholder="Optional product description..."
            value={formData.description}
            onChange={handleChange}
            rows={3}
          />
        </div>

        <div className="form-row">
          <div className="form-group">
            <label htmlFor="price">Price (₱) *</label>
            <input
              id="price"
              name="price"
              type="number"
              min="0.01"
              step="0.01"
              placeholder="0.00"
              value={formData.price}
              onChange={handleChange}
              className={errors.price ? 'input-error' : ''}
            />
            {errors.price && <span className="error-msg">{errors.price}</span>}
          </div>

          <div className="form-group">
            <label htmlFor="stock">Stock *</label>
            <input
              id="stock"
              name="stock"
              type="number"
              min="0"
              placeholder="0"
              value={formData.stock}
              onChange={handleChange}
              className={errors.stock ? 'input-error' : ''}
            />
            {errors.stock && <span className="error-msg">{errors.stock}</span>}
          </div>
        </div>

        <div className="form-group">
          <label htmlFor="category">Category *</label>
          <select
            id="category"
            name="category"
            value={formData.category}
            onChange={handleChange}
            className={errors.category ? 'input-error' : ''}
          >
            <option value="">-- Select Category --</option>
            <option value="Electronics">Electronics</option>
            <option value="Clothing">Clothing</option>
            <option value="Food">Food</option>
            <option value="Books">Books</option>
            <option value="Sports">Sports</option>
            <option value="Tools">Tools</option>
            <option value="Other">Other</option>
          </select>
          {errors.category && <span className="error-msg">{errors.category}</span>}
        </div>

        <div className="form-actions">
          <button type="submit" className="btn-primary" disabled={loading}>
            {loading ? '⏳ Saving...' : editingProduct ? '💾 Update' : '➕ Add Product'}
          </button>
          {editingProduct && (
            <button type="button" className="btn-secondary" onClick={handleCancel}>
              ✖ Cancel
            </button>
          )}
        </div>
      </form>
    </div>
  );
};

export default ProductForm;
