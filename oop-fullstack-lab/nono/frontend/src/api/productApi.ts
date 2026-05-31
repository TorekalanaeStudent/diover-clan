import axios from 'axios';
import { Product, ProductFormData } from '../types/Product';

const BASE_URL = 'http://localhost:8080/api/products';

const api = axios.create({
  baseURL: BASE_URL,
  headers: {
    'Content-Type': 'application/json',
  },
});

// GET all products
export const fetchAllProducts = async (): Promise<Product[]> => {
  const response = await api.get<Product[]>('');
  return response.data;
};

// GET single product
export const fetchProductById = async (id: number): Promise<Product> => {
  const response = await api.get<Product>(`/${id}`);
  return response.data;
};

// POST create product
export const createProduct = async (data: ProductFormData): Promise<Product> => {
  const response = await api.post<Product>('', data);
  return response.data;
};

// PUT update product
export const updateProduct = async (id: number, data: ProductFormData): Promise<Product> => {
  const response = await api.put<Product>(`/${id}`, data);
  return response.data;
};

// DELETE product
export const deleteProduct = async (id: number): Promise<void> => {
  await api.delete(`/${id}`);
};