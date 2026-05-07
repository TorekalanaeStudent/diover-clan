export interface Employee {
    id: number;
    username: string;
    password: string;
    email: string;
    phoneNumber: string;
    isAdmin: boolean;
}

export type { Employee as default };