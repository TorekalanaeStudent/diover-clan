import type { Product } from '../services/productService';
interface Props {
  products: Product[];
  onEdit: (product: Product) => void;
  onDelete: (id: number) => void;
}

const ProductList = ({ products, onEdit, onDelete }: Props) => {
  if (products.length === 0) return <p>No products yet. Add one!</p>;

if (products.length === 0) return <p className="empty-msg">No products yet. Add one!</p>;

  return (
    <table className="product-table">
      <thead>
        <tr>
          <th>ID</th>
          <th>Name</th>
          <th>Description</th>
          <th>Price</th>
          <th>Actions</th>
        </tr>
      </thead>
      <tbody>
        {products.map(product => (
          <tr key={product.id}>
            <td>{product.id}</td>
            <td>{product.name}</td>
            <td>{product.description}</td>
            <td>₱{product.price.toFixed(2)}</td>
            <td>
              <button className="btn-edit" onClick={() => onEdit(product)}>Edit</button>
              <button className="btn-delete" onClick={() => onDelete(product.id!)}>Delete</button>
            </td>
          </tr>
        ))}
      </tbody>
    </table>
  );
};

export default ProductList;