# Gedoria Product Inventory

Full-stack CRUD application for managing products.

## Structure

- `frontend/` - React, Vite, and TypeScript product UI
- `backend/` - Spring Boot, JPA, and PostgreSQL REST API
- `evidence/` - screenshots or recordings for submission

## Backend

Create a PostgreSQL database named `gedoria_products`, then run:

```powershell
cd backend
.\mvnw.cmd spring-boot:run
```

The backend uses these defaults:

- `DB_URL=jdbc:postgresql://localhost:5432/gedoria_products`
- `DB_USERNAME=postgres`
- `DB_PASSWORD=postgres`
- `FRONTEND_ORIGIN=http://localhost:5173`

## Frontend

```powershell
cd frontend
npm install
npm run dev
```

The frontend calls `http://localhost:8080/api` by default. Override with `VITE_API_BASE_URL` if needed.
