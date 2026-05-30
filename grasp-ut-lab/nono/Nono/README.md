# 📦 Product Management System — GRASP + Unit Testing Lab

**Student:** Nono  
**Branch:** `grasp-ut-Nono`

---

## 🚀 Quick Start (IntelliJ)

1. **Open project** → `File > Open` → select the `Nono/` folder
2. IntelliJ will auto-detect the Maven project and download dependencies
3. Wait for indexing to finish (bottom progress bar)
4. Run `ProductManagementApplication.java` → right-click → **Run**
5. API is live at `http://localhost:8080`
6. H2 Console: `http://localhost:8080/h2-console` (JDBC URL: `jdbc:h2:mem:productdb`)

> No PostgreSQL setup needed — the app uses **H2 in-memory** by default.

---

## 🧪 Running Tests

```bash
# Run all tests
mvn clean test

# Run tests + generate Jacoco coverage report
mvn clean verify

# Open coverage report (after mvn verify)
open target/site/jacoco/index.html
```

Or in IntelliJ: right-click `src/test` → **Run All Tests**  
For coverage: right-click → **Run All Tests with Coverage**

---

## 🌐 API Endpoints

| Method | URL | Description |
|--------|-----|-------------|
| `POST`   | `/api/products`                    | Create product |
| `GET`    | `/api/products`                    | List all |
| `GET`    | `/api/products/{id}`               | Get by ID |
| `GET`    | `/api/products/category/{cat}`     | Filter by category |
| `GET`    | `/api/products/available`          | In-stock only |
| `PUT`    | `/api/products/{id}`               | Update product |
| `DELETE` | `/api/products/{id}`               | Delete product |
| `GET`    | `/api/products/{id}/discounted-price` | Apply discount strategy |
| `POST`   | `/api/products/{id}/sell?quantity=N`  | Sell / deduct stock |

### Sample Request Body (POST / PUT)
```json
{
  "name": "Laptop Pro",
  "category": "Electronics",
  "price": 999.99,
  "stockQuantity": 20,
  "description": "High-performance laptop"
}
```

---

## 🧠 GRASP Principles Applied

| Principle | Where |
|-----------|-------|
| **Information Expert** | `Product` — calculates discount, tax, stock checks |
| **Creator** | `ProductMapper` creates `Product` from `ProductRequest` |
| **Controller** | `ProductController` — HTTP only, no business logic |
| **Low Coupling** | `ProductService` depends on interfaces, not concrete classes |
| **High Cohesion** | Each class has exactly one responsibility |
| **Polymorphism** | `DiscountStrategy` → `PercentageDiscountStrategy`, `FlatDiscountStrategy` |
| **Pure Fabrication** | `ProductService`, `ProductMapper`, `GlobalExceptionHandler` |
| **Indirection** | `ProductRepository` between service and DB; `DiscountStrategy` between service and discount logic |
| **Protected Variations** | `DiscountStrategy` interface shields service from strategy changes; `GlobalExceptionHandler` shields controllers from error-format changes |

---

## 🔄 Git Workflow

```bash
# 1. Clone your repo
git clone https://github.com/<your-org>/<your-repo>.git
cd <your-repo>

# 2. Create your branch
git checkout -b grasp-ut-Nono

# 3. Copy this project folder in
cp -r /path/to/Nono .

# 4. Stage and commit
git add .
git commit -m "feat: GRASP + Unit Testing Lab — Products (Nono)"

# 5. Push and open PR
git push origin grasp-ut-Nono
```

Then open a Pull Request on GitHub and request **2 approvals**.

---

## 📝 Retrospect

**What GRASP principle was hardest?**  
*Indirection* — remembering to always inject interfaces rather than concretes takes deliberate practice.

**What design mistake did you fix?**  
Originally put discount logic inside the service; moved it to `DiscountStrategy` + `Product` to respect Information Expert.

### Changelog

#### Team Changelog
- `GRASP-UT Completed`

#### Personal Log
> I learned how GRASP principles guide responsibility assignment, and improved my ability to write testable, loosely coupled Spring Boot services.

#### Peer Feedback
> **Strength:** Clean separation between controller and service layers.  
> **Improvement:** Add more edge-case tests for null inputs.
