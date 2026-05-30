import axios from "axios";
import type { CoinFlip } from "../types/CoinFlip";

const BASE_URL = "http://localhost:8080/api/users";

export const flipCoin = async (userId: number, choice: string): Promise<CoinFlip> => {
  const res = await axios.post(`${BASE_URL}/${userId}/flips?choice=${choice}`);
  return res.data;
};

export const getFlipsByUser = async (userId: number): Promise<CoinFlip[]> => {
  const res = await axios.get(`${BASE_URL}/${userId}/flips`);
  return res.data;
};
