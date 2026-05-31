import { useState, useEffect, useCallback } from 'react';
import { Product, ProductFormData } from '../types/Product';
import {
  fetchAllProducts,
  createProduct,
  updateProduct,
  deleteProduct,
} from '../api/productApi';

/**
 * OOP - Encapsulation:
 * All product state and CRUD logic is encapsulated in this hook.
 * Components just call hook functions — they don't manage state themselves.
 *
 * OOP - Abstraction:
 * Components don't know HOW data is fetched/mutated, only that it works.
 */
export const useProducts = () => {
  const [products, setProducts] = useState<Product[]>([]);
  const [loading, setLoading] = useState(false);
  const [formLoading, setFormLoading] = useState(false);
  const [error, setError] = useState<string | null>(null);
  const [successMsg, setSuccessMsg] = useState<string | null>(null);

  const showSuccess = (msg: string) => {
    setSuccessMsg(msg);
    setTimeout(() => setSuccessMsg(null), 3000);
  };

  const loadProducts = useCallback(async () => {
    setLoading(true);
    setError(null);
    try {
      const data = await fetchAllProducts();
      setProducts(data);
    } catch {
      setError('❌ Failed to load products. Is the backend running?');
    } finally {
      setLoading(false);
    }
  }, []);

  useEffect(() => {
    loadProducts();
  }, [loadProducts]);

  const addProduct = async (data: ProductFormData) => {
    setFormLoading(true);
    setError(null);
    try {
      await createProduct(data);
      showSuccess('✅ Product added successfully!');
      await loadProducts();
    } catch {
      setError('❌ Failed to add product. Please try again.');
    } finally {
      setFormLoading(false);
    }
  };

  const editProduct = async (id: number, data: ProductFormData) => {
    setFormLoading(true);
    setError(null);
    try {
      await updateProduct(id, data);
      showSuccess('✅ Product updated successfully!');
      await loadProducts();
    } catch {
      setError('❌ Failed to update product. Please try again.');
    } finally {
      setFormLoading(false);
    }
  };

  const removeProduct = async (id: number) => {
    setError(null);
    try {
      await deleteProduct(id);
      showSuccess('🗑️ Product deleted.');
      await loadProducts();
    } catch {
      setError('❌ Failed to delete product.');
    }
  };

  return {
    products,
    loading,
    formLoading,
    error,
    successMsg,
    setError,
    addProduct,
    editProduct,
    removeProduct,
    loadProducts,
  };
};
