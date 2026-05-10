import axios from "axios";
import type { User } from "../types/User";

const BASE_URL = "http://localhost:8080/api/users";

export const getUsers = async (): Promise<User[]> => {
  const res = await axios.get(BASE_URL);
  return res.data;
};

export const createUser = async (user: User): Promise<User> => {
  const res = await axios.post(BASE_URL, user);
  return res.data;
};

export const updateUser = async (id: number, user: User): Promise<User> => {
  const res = await axios.put(`${BASE_URL}/${id}`, user);
  return res.data;
};

export const deleteUser = async (id: number): Promise<void> => {
  await axios.delete(`${BASE_URL}/${id}`);
};

export const getUserSummary = async (id: number) => {
  const res = await axios.get(`${BASE_URL}/${id}/summary`);
  return res.data;
};

export const getAllUserSummaries = async () => {
  const res = await axios.get(`${BASE_URL}/summaries`);
  return res.data;
};
