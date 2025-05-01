
# ⌚ Watch Store System – RESTful CRUD API

A Spring Boot-based RESTful API backend for managing a watch store. It includes functionalities for managing watches, customers, orders, and cart operations. The system follows clean architecture principles and provides interactive API documentation via Swagger.

## 🚀 Features

- **CRUD operations** for Watches and Customers
- **Order management** (Place, Retrieve Orders by customer or ID)
- **Cart management** (Add, View, Update, Delete items)
- API documentation via **Swagger UI**
- Manual API testing with **Postman**

## 🛠️ Tech Stack

- **Java 17**
- **Spring Boot**
- **Spring Data JPA**
- **SQL Server**
- **Postman** (for manual API testing)
- **Swagger** (for interactive API documentation)

## 📂 Project Structure

```
src
├── controller
├── service
├── repository
├── pojo
└── config
```

## 🔗 API Endpoints

### 🕒 Watches
- `GET /api/watches` – Get all watches
- `GET /api/watches/{id}` – Get watch by ID
- `GET /api/watches?brand={brand}` – Get watch by brand
- `POST /api/watches` – Add a new watch
- `PUT /api/watches/{id}` – Update watch details

### 👤 Customers
- `POST /api/customers` – Create a new customer
- `GET /api/customers/{id}` – Get customer by ID
- `PATCH /api/customers/{id}` – Update customer info

### 🛒 Cart
- `POST /api/cart/{customerId}/add/{watchId}` – Add item to cart
- `GET /api/cart/{customerId}` – View cart
- `PATCH /api/cart/{cartItemId}` – Update cart item
- `DELETE /api/cart/{cartItemId}` – Remove cart item

### 📦 Orders
- `POST /api/orders` – Place an order
- `GET /api/orders/{id}` – Get order by ID
- `GET /api/orders/customer/{customerId}` – Get all orders by customer ID

## 🧪 API Testing
- Manual testing was performed using **Postman**.

## 📖 Swagger API Docs
Once the application is running, visit:

```
http://localhost:1122/swagger-ui/index.html
```

This interactive UI allows you to test and explore all API endpoints.

## ⚙️ Getting Started

1. **Clone the Repository:**
```bash
git clone https://github.com/yourusername/WatchStore.git
cd WatchStore
```

2. **Configure SQL Server in `application.properties`:**
```properties
spring.datasource.url=jdbc:sqlserver://localhost:1433;databaseName=watchstore
spring.datasource.username=your_username
spring.datasource.password=your_password
```

3. **Run the Application:**
```bash
mvn spring-boot:run
```

4. **Access API Docs:**
```
http://localhost:1122/swagger-ui/index.html
```

## 📌 Future Improvements

- JWT-based authentication
- Role-based authorization
- Unit & integration tests
- Docker containerization
```
