export interface Product {
  id?: string;
  name: string;
  description: string;
  price: number;
}
export interface Review {
  product: string;
  rating: number;
  text: string;
}
