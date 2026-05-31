import { Pencil, Trash2 } from 'lucide-react';
import type { Product } from '../types/product';

type ProductListProps = {
  isLoading: boolean;
  products: Product[];
  onDelete: (id: number) => void;
  onEdit: (product: Product) => void;
};

const currencyFormatter = new Intl.NumberFormat('en-PH', {
  style: 'currency',
  currency: 'PHP',
});

export function ProductList({ isLoading, products, onDelete, onEdit }: ProductListProps) {
  return (
    <section className="list-panel" aria-labelledby="product-list-title">
      <div className="panel-title">
        <h2 id="product-list-title">Products</h2>
        <span className="counter">{products.length}</span>
      </div>

      {isLoading ? (
        <p className="empty-state">Loading products...</p>
      ) : products.length === 0 ? (
        <p className="empty-state">No products yet.</p>
      ) : (
        <div className="table-wrap">
          <table>
            <thead>
              <tr>
                <th>Name</th>
                <th>Price</th>
                <th>Qty</th>
                <th>Description</th>
                <th aria-label="Actions" />
              </tr>
            </thead>
            <tbody>
              {products.map((product) => (
                <tr key={product.id}>
                  <td>{product.name}</td>
                  <td>{currencyFormatter.format(product.price)}</td>
                  <td>{product.quantity}</td>
                  <td>{product.description || '-'}</td>
                  <td>
                    <div className="row-actions">
                      <button className="icon-button" onClick={() => onEdit(product)} aria-label={`Edit ${product.name}`}>
                        <Pencil size={16} />
                      </button>
                      <button className="icon-button danger" onClick={() => onDelete(product.id)} aria-label={`Delete ${product.name}`}>
                        <Trash2 size={16} />
                      </button>
                    </div>
                  </td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
      )}
    </section>
  );
}
