// =============================================
// OOP - Encapsulation via TypeScript interfaces
// These define the shape of our data objects
// =============================================

export interface Product {
  id: number;
  name: string;
  description: string;
  price: number;
  stock: number;
  category: string;
}

// Used when creating/updating (no id needed)
export interface ProductFormData {
  name: string;
  description: string;
  price: number | string;
  stock: number | string;
  category: string;
}

export const EMPTY_FORM: ProductFormData = {
  name: '',
  description: '',
  price: '',
  stock: '',
  category: '',
};
