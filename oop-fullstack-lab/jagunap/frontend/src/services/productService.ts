import axios from 'axios';

const BASE_URL = 'http://localhost:8080/api/products';

export interface Product {
  id?: number;
  name: string;
  description: string;
  price: number;
}

export const getAllProducts = async (): Promise<Product[]> => {
  const response = await axios.get(BASE_URL);
  return response.data;
};

export const createProduct = async (product: Product): Promise<Product> => {
  const response = await axios.post(BASE_URL, product);
  return response.data;
};

export const updateProduct = async (id: number, product: Product): Promise<Product> => {
  const response = await axios.put(`${BASE_URL}/${id}`, product);
  return response.data;
};

export const deleteProduct = async (id: number): Promise<void> => {
  await axios.delete(`${BASE_URL}/${id}`);
};