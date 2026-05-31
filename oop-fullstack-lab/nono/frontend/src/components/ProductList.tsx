import React from 'react';
import { Product } from '../types/Product';

interface ProductListProps {
  products: Product[];
  onEdit: (product: Product) => void;
  onDelete: (id: number) => void;
  loading: boolean;
}

/**
 * OOP - Separation of Concerns:
 * This component ONLY displays products.
 * Delete and edit are delegated up via callbacks.
 */
const ProductList: React.FC<ProductListProps> = ({ products, onEdit, onDelete, loading }) => {
  if (loading) {
    return (
      <div className="loading-state">
        <div className="spinner" />
        <p>Loading products...</p>
      </div>
    );
  }

  if (products.length === 0) {
    return (
      <div className="empty-state">
        <span className="empty-icon">📦</span>
        <p>No products yet. Add your first product!</p>
      </div>
    );
  }

  return (
    <div className="product-list">
      <h2>📋 Product List <span className="badge">{products.length}</span></h2>
      <div className="table-wrapper">
        <table>
          <thead>
            <tr>
              <th>#</th>
              <th>Name</th>
              <th>Category</th>
              <th>Price</th>
              <th>Stock</th>
              <th>Description</th>
              <th>Actions</th>
            </tr>
          </thead>
          <tbody>
            {products.map((product) => (
              <tr key={product.id}>
                <td><span className="id-badge">{product.id}</span></td>
                <td><strong>{product.name}</strong></td>
                <td><span className="category-tag">{product.category}</span></td>
                <td className="price">₱{Number(product.price).toFixed(2)}</td>
                <td>
                  <span className={`stock-badge ${product.stock === 0 ? 'out' : product.stock < 10 ? 'low' : 'ok'}`}>
                    {product.stock}
                  </span>
                </td>
                <td className="desc-cell">{product.description || <em>—</em>}</td>
                <td className="action-cell">
                  <button
                    className="btn-edit"
                    onClick={() => onEdit(product)}
                    title="Edit"
                  >
                    ✏️ Edit
                  </button>
                  <button
                    className="btn-delete"
                    onClick={() => {
                      if (window.confirm(`Delete "${product.name}"?`)) {
                        onDelete(product.id);
                      }
                    }}
                    title="Delete"
                  >
                    🗑️ Delete
                  </button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
};

export default ProductList;
