import apiClient from './axios';
import type { Product } from '../types/Product';

export const getProducts = async (): Promise<Product[]> => {
    const response = await apiClient.get<Product[]>('/api/product/');
    return response.data;
};

export const createProduct = async (product: Omit<Product, 'id'>): Promise<Product> => {
    const response = await apiClient.post<Product>('/api/product/create', null, {
        params: {
            name: product.name,
            price: product.price,
            description: product.description,
            quantity: product.quantity,
        },
    });
    return response.data;
};

export const updateProduct = async (id: number, product: Omit<Product, 'id'>): Promise<Product> => {
    const response = await apiClient.put<Product>(`/api/product/update/${id}`, product);
    return response.data;
};

export const deleteProduct = async (id: number): Promise<void> => {
    await apiClient.delete(`/api/product/delete/${id}`);
};
