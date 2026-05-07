import { useCallback, useEffect, useState } from 'react'
import EmployeeService from '../api/employeeService'
import type { Employee } from '../types/Employee'

export interface UseEmployeesResult {
  employees: Employee[]
  isLoading: boolean
  error: string | null
  refresh: () => Promise<void>
}

export default function useEmployees(): UseEmployeesResult {
  const [employees, setEmployees] = useState<Employee[]>([])
  const [isLoading, setIsLoading] = useState(false)
  const [error, setError] = useState<string | null>(null)

  const loadEmployees = useCallback(async () => {
    setIsLoading(true)
    setError(null)

    try {
      const data = await EmployeeService.getAll()
      setEmployees(data)
    } catch (err) {
      const message = err instanceof Error ? err.message : 'Failed to load employees.'
      setError(message)
    } finally {
      setIsLoading(false)
    }
  }, [])

  useEffect(() => {
    void loadEmployees()
  }, [loadEmployees])

  return {
    employees,
    isLoading,
    error,
    refresh: loadEmployees,
  }
}