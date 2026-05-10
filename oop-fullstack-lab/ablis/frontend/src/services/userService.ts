import axios from 'axios';
import type { User } from '../types/User';

const BASE_URL = 'http://localhost:8080/api/users';

export const getUsers = (): Promise<User[]> =>
  axios.get(BASE_URL).then(res => res.data);

export const createUser = (data: {
  username: string;
  password: string;
  email: string;
  phone: string;
  isAdmin: boolean;
}): Promise<User> =>
  axios.post(`${BASE_URL}/create`, null, {
    params: {
      username: data.username,
      password: data.password,
      email: data.email,
      phoneNumber: data.phone,
      isAdmin: data.isAdmin,
    }
  }).then(res => res.data);

export const updateUser = (id: number, data: {
  username: string;
  password: string;
  email: string;
  phone: string;
  isAdmin: boolean;
}): Promise<User> =>
  axios.put(`${BASE_URL}/update`, null, {
    params: {
      id,
      username: data.username,
      password: data.password,
      email: data.email,
      phoneNumber: data.phone,
      isAdmin: data.isAdmin,
    }
  }).then(res => res.data);

export const deleteUser = (id: number): Promise<void> =>
  axios.delete(`${BASE_URL}/${id}`).then(res => res.data);