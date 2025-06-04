# Microservices Sample Project

This repository contains a simple microservices architecture built with **Spring Boot 3** and **Java 18**. It demonstrates a basic setup for an e-commerce scenario with independent services communicating via HTTP APIs.

## Architecture Overview

The project is organized as a Maven multi‑module build. Each service resides in its own module and can be run independently.

- **product-service** – stores product data in MongoDB.
- **order-service** – manages customer orders using a relational database.
- **inventory-service** – keeps track of product stock levels.

```
+-------------------+     +------------------+     +-------------------+
| product-service   | <--->| order-service    | <--->| inventory-service |
+-------------------+     +------------------+     +-------------------+
```

Communication between services is performed over REST endpoints. The order service calls the inventory service before placing an order to ensure that items are in stock.

## Technology Stack

- **Spring Boot 3.1.2**
- **Java 18**
- **Maven** (multi-module project)
- **MongoDB** for product data
- **MySQL** for order and inventory data
- **Spring WebFlux WebClient** for inter-service HTTP calls
- **Lombok** for boilerplate reduction
- **Testcontainers** for integration testing of the MongoDB layer

## Project Modules

### product-service

Provides CRUD operations for products stored in MongoDB. Key files:

- `ProductController` – REST endpoints under `/api/product`.
- `ProductService` – business logic for product creation and retrieval.
- `ProductRepository` – Spring Data MongoDB repository.
- Integration tests use Testcontainers to start a MongoDB instance on demand.

```
POST /api/product        # Create a product
GET  /api/product        # List all products
```

### order-service

Handles order placement. It persists orders to MySQL and queries the inventory service to verify stock. Highlights:

- `OrderController` exposes `/api/order`.
- `OrderService` transforms `OrderRequest` DTOs into entities.
- Uses Spring WebFlux `WebClient` for calling the inventory service.

```
POST /api/order          # Place an order
```

### inventory-service

Stores inventory quantities in MySQL. It exposes an API to check stock availability for product SKUs.

- `InventoryController` exposes `/api/inventory`.
- `InventoryService` contains business logic.

```
GET /api/inventory?skuCode=iphone-13
```

## Building the Project

Use Maven to compile the entire project. From the repository root:

```bash
mvn clean install
```

Each module can also be built separately by running Maven in the respective directory.

## Running the Services

Each service is a Spring Boot application and can be started from its module directory:

```bash
cd product-service
mvn spring-boot:run
```

Default port assignments can be found in each module's `application.yml` file:

- `product-service` – runs on port **8080** and requires a MongoDB instance.
- `order-service` – runs on port **8081** with a MySQL database.
- `inventory-service` – runs on port **8083** with a MySQL database.

Update the database connection URLs in the `application.yml` files if your database instances use different addresses.

## Testing

Unit and integration tests are located under the `src/test/java` directories of each module. Product service tests spin up MongoDB via Testcontainers. Run all tests with:

```bash
mvn test
```

## Further Improvements

This project forms a minimal foundation for a microservices system. Potential next steps include:

- Dockerizing each service and adding a Docker Compose configuration.
- Adding service discovery (e.g., Spring Cloud Netflix Eureka).
- Implementing API Gateway and centralized configuration.

## Contributing

Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

## License

This project is released under the MIT License.
