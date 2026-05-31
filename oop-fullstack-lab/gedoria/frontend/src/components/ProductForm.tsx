import { FormEvent, useEffect, useState } from 'react';
import { Check, X } from 'lucide-react';
import type { Product, ProductPayload } from '../types/product';

type ProductFormProps = {
  product: Product | null;
  onCancel: () => void;
  onSubmit: (payload: ProductPayload) => void;
};

const emptyForm: ProductPayload = {
  name: '',
  price: 0,
  quantity: 0,
  description: '',
};

export function ProductForm({ product, onCancel, onSubmit }: ProductFormProps) {
  const [form, setForm] = useState<ProductPayload>(emptyForm);

  useEffect(() => {
    setForm(product ? {
      name: product.name,
      price: product.price,
      quantity: product.quantity,
      description: product.description ?? '',
    } : emptyForm);
  }, [product]);

  const handleSubmit = (event: FormEvent<HTMLFormElement>) => {
    event.preventDefault();
    onSubmit({
      name: form.name.trim(),
      price: Number(form.price),
      quantity: Number(form.quantity),
      description: form.description?.trim() ?? '',
    });

    if (!product) {
      setForm(emptyForm);
    }
  };

  return (
    <form className="product-form" onSubmit={handleSubmit}>
      <label>
        Name
        <input
          required
          value={form.name}
          onChange={(event) => setForm({ ...form, name: event.target.value })}
          placeholder="USB-C Dock"
        />
      </label>

      <div className="field-row">
        <label>
          Price
          <input
            required
            min="0"
            step="0.01"
            type="number"
            value={form.price}
            onChange={(event) => setForm({ ...form, price: Number(event.target.value) })}
          />
        </label>

        <label>
          Quantity
          <input
            required
            min="0"
            type="number"
            value={form.quantity}
            onChange={(event) => setForm({ ...form, quantity: Number(event.target.value) })}
          />
        </label>
      </div>

      <label>
        Description
        <textarea
          rows={4}
          value={form.description ?? ''}
          onChange={(event) => setForm({ ...form, description: event.target.value })}
          placeholder="Short product note"
        />
      </label>

      <div className="form-actions">
        {product && (
          <button type="button" className="secondary" onClick={onCancel}>
            <X size={16} />
            Cancel
          </button>
        )}
        <button type="submit" className="primary">
          <Check size={16} />
          {product ? 'Save' : 'Add'}
        </button>
      </div>
    </form>
  );
}
