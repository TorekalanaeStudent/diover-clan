import apiClient from "./axios";
import type { Employee } from "../types/Employee.ts";
import axios from "axios";

/*
GET ALL EMPLOYEES
*/
export const getAllEmployees = async (): Promise<Employee[]> => {
  try {
    const response = await apiClient.get<Employee[]>("/");
    return response.data;
  } catch (error) {
    handleAxiosError(error);
    return [];
  }
};

/*
GET EMPLOYEE BY ID
*/
export const getEmployeeById = async (
  id: number
): Promise<Employee | null> => {
  try {
    const response = await apiClient.get<Employee>(`/${id}`);
    return response.data;
  } catch (error) {
    handleAxiosError(error);
    return null;
  }
};

/*
CREATE EMPLOYEE
*/
export const createEmployee = async (
  employee: Employee
): Promise<Employee | null> => {
  try {
    const response = await apiClient.post<Employee>("/", employee);
    return response.data;
  } catch (error) {
    handleAxiosError(error);
    return null;
  }
};

/*
UPDATE EMPLOYEE
*/
export const updateEmployee = async (
  id: number,
  employee: Employee
): Promise<Employee | null> => {
  try {
    const response = await apiClient.put<Employee>(`/${id}`, employee);
    return response.data;
  } catch (error) {
    handleAxiosError(error);
    return null;
  }
};

/*
DELETE EMPLOYEE
*/
export const deleteEmployee = async (
  id: number
): Promise<boolean> => {
  try {
    await apiClient.delete(`/${id}`);
    return true;
  } catch (error) {
    handleAxiosError(error);
    return false;
  }
};

/*
ERROR HANDLER
*/
const handleAxiosError = (error: unknown): void => {
  if (axios.isAxiosError(error)) {
    console.error("Axios Error:", error.response?.data || error.message);
  } else {
    console.error("Unexpected Error:", error);
  }
};