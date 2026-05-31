export interface Employee {

  employeeId?: number;
  employeeName: string;
  employeeEmail: string;
  employeePassword: string;
  employeePosition: string;
  currentlyInShift: boolean;
  isAdmin: boolean;

}

export type {Employee as default};