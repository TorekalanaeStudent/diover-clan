import { useEffect, useState } from 'react';
import type { Product } from '../types/Product';
import { getProducts, createProduct, updateProduct, deleteProduct } from '../api/ProductService';

export function useProducts() {
    const [products, setProducts] = useState<Product[]>([]);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState<string | null>(null);

    const fetchProducts = async () => {
        try {
            setLoading(true);
            setError(null);
            const data = await getProducts();
            setProducts(data);
        } catch {
            setError('Failed to load products. Please try again.');
        } finally {
            setLoading(false);
        }
    };

    const addProduct = async (product: Omit<Product, 'id'>) => {
        const created = await createProduct(product);
        setProducts((prev) => [...prev, created]);
    };

    const editProduct = async (id: number, product: Omit<Product, 'id'>) => {
        const updated = await updateProduct(id, product);
        setProducts((prev) => prev.map((p) => (p.id === id ? updated : p)));
    };

    const removeProduct = async (id: number) => {
        await deleteProduct(id);
        setProducts((prev) => prev.filter((p) => p.id !== id));
    };

    useEffect(() => {
        fetchProducts();
    }, []);

    return { products, loading, error, refresh: fetchProducts, addProduct, editProduct, removeProduct };
}
