export type Product = {
  id: number;
  name: string;
  price: number;
  quantity: number;
  description: string | null;
};

export type ProductPayload = {
  name: string;
  price: number;
  quantity: number;
  description: string;
};
