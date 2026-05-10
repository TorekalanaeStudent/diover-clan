export interface User {
	id: number ;
    username: string;
    password: string;
    email: string;
    phone: string;
    isAdmin: boolean;
}

export type { User as default };