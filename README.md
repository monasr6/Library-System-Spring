# Library-System-Spring
# Library Management System API Documentation

## Project Overview

This project is a Library Management System API built using Spring Boot. The system allows librarians to manage books, patrons, and borrowing records.

## Requirements

### Entities

#### Book

- **Attributes**:
  - `id` (Long): Unique identifier for the book.
  - `title` (String): Title of the book.
  - `author` (String): Author of the book.
  - `publicationYear` (Integer): Year the book was published.
  - `isbn` (String): ISBN of the book.
  - Other relevant attributes.

#### Patron

- **Attributes**:
  - `id` (Long): Unique identifier for the patron.
  - `name` (String): Name of the patron.
  - `contactInfo` (String): Contact information of the patron.
  - Other relevant attributes.

#### Borrowing Record

- **Attributes**:
  - `id` (Long): Unique identifier for the borrowing record.
  - `bookId` (Long): ID of the borrowed book.
  - `patronId` (Long): ID of the patron who borrowed the book.
  - `borrowDate` (LocalDate): Date when the book was borrowed.
  - `returnDate` (LocalDate): Date when the book was returned (if returned).

#### User

- **Attributes**:
  - `id` (Long): Unique identifier for the user.
  - `username` (String): Username of the user.
  - `password` (String): Encrypted password of the user.
  - `role` (Role): Role of the user (e.g., LIBRARIAN, ADMIN).

### Enums

#### Role

- **Values**:
  - `LIBRARIAN`
  - `ADMIN`

### API Endpoints

#### Book Management Endpoints

- **GET /api/books**: Retrieve a list of all books.
- **GET /api/books/{id}**: Retrieve details of a specific book by ID.
- **POST /api/books**: Add a new book to the library.
- **PUT /api/books/{id}**: Update an existing book's information.
- **DELETE /api/books/{id}**: Remove a book from the library.

#### Patron Management Endpoints

- **GET /api/patrons**: Retrieve a list of all patrons.
- **GET /api/patrons/{id}**: Retrieve details of a specific patron by ID.
- **POST /api/patrons**: Add a new patron to the system.
- **PUT /api/patrons/{id}**: Update an existing patron's information.
- **DELETE /api/patrons/{id}**: Remove a patron from the system.

#### Borrowing Endpoints

- **POST /api/borrow/{bookId}/patron/{patronId}**: Allow a patron to borrow a book.
- **PUT /api/return/{bookId}/patron/{patronId}**: Record the return of a borrowed book by a patron.

#### Authentication Endpoints

- **POST /api/auth/register**: Register a new user.
- **POST /api/auth/login**: Authenticate a user and return a JWT.

### Data Storage

- PostgreSQL is used to persist book, patron, and borrowing record details.
- Proper relationships are set up between entities, such as one-to-many between books and borrowing records.

### Validation and Error Handling

- Input validation is implemented for API requests, validating required fields and data formats.
- Exceptions are handled gracefully, returning appropriate HTTP status codes and error messages.

### Security

- JWT-based authorization is implemented to protect the API endpoints.

### Transaction Management

- Declarative transaction management is implemented using Spring's `@Transactional` annotation to ensure data integrity during critical operations.

### Testing

- Unit tests are written to validate the functionality of API endpoints.
- Testing frameworks like JUnit, Mockito, and SpringBootTest are used for testing.

## Project Structure

### Configuration

Located in the `config` folder, this contains configurations for the application and security, including JWT services.

### User Management

Located in the `user` folder, this contains:

- **User Entity**: Defines the user attributes and relationships.
- **Role Enum**: Defines the roles available in the system.
- **Auth**: Contains registration and login services.

## Getting Started

### Prerequisites

- Java 11 or higher
- Maven
- PostgreSQL

### Installation

1. Clone the repository:

    ```bash
    git clone https://github.com/monasr6/Library-System-Spring
    cd Library-System-Spring
    ```

2. Configure the database in `src/main/resources/application.properties`:

    ```properties
    spring.datasource.url=jdbc:postgresql://localhost:5433/libsystemspring
    spring.datasource.username=postgres
    spring.datasource.password=postgres
    spring.jpa.hibernate.ddl-auto=update
    ```

3. Build and run the application:

    ```bash
    mvn clean install
    mvn spring-boot:run
    ```

### API Usage

- Use tools like Postman or curl to interact with the API endpoints.
- For example, to add a new book:

    ```bash
    curl -X POST -H "Content-Type: application/json" -d '{"title":"Book Title","author":"Author Name","publicationYear":2021,"isbn":"1234567890123"}' http://localhost:8080/api/books
    ```

### Testing

- Run the unit tests using Maven:

    ```bash
    mvn test
    ```

## Contributing

1. Fork the repository.
2. Create a feature branch (`git checkout -b feature-branch`).
3. Commit your changes (`git commit -m 'Add some feature'`).
4. Push to the branch (`git push origin feature-branch`).
5. Open a pull request.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

---

This documentation provides an overview of the project, outlines the requirements, and gives instructions on how to set up and use the Library Management System API.
