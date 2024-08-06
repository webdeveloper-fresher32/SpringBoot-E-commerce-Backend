Here are the list of API endpoints for your e-commerce application, from user registration and login to CRUD operations on products:

### User Authentication Endpoints

1. **Register User**

   - **Endpoint**: `/api/auth/register`
   - **Method**: `POST`
   - **Description**: Registers a new user.
   - **Request Body**:
     ```json
     {
       "username": "string",
       "email": "string",
       "password": "string"
     }
     ```
   - **Responses**:
     - `200 OK`: User registered successfully.
     - `400 Bad Request`: Username or email already exists.

2. **Login User**
   - **Endpoint**: `/api/auth/login`
   - **Method**: `POST`
   - **Description**: Authenticates a user and returns an access token (if implemented).
   - **Request Body**:
     ```json
     {
       "username": "string",
       "password": "string"
     }
     ```
   - **Responses**:
     - `200 OK`: Login successful.
     - `400 Bad Request`: Invalid username or password.

### Product CRUD Endpoints

1. **Create Product**

   - **Endpoint**: `/api/products`
   - **Method**: `POST`
   - **Description**: Creates a new product.
   - **Request Body**:
     ```json
     {
       "name": "string",
       "description": "string",
       "price": "number",
       "stock": "number"
     }
     ```
   - **Responses**:
     - `201 Created`: Product created successfully.
     - `400 Bad Request`: Validation errors.

2. **Get All Products**

   - **Endpoint**: `/api/products`
   - **Method**: `GET`
   - **Description**: Retrieves a list of all products.
   - **Responses**:
     - `200 OK`: List of products.

3. **Get Product by ID**

   - **Endpoint**: `/api/products/{id}`
   - **Method**: `GET`
   - **Description**: Retrieves a product by its ID.
   - **Path Parameter**:
     - `id`: The ID of the product.
   - **Responses**:
     - `200 OK`: Product details.
     - `404 Not Found`: Product not found.

4. **Update Product**

   - **Endpoint**: `/api/products/{id}`
   - **Method**: `PUT`
   - **Description**: Updates an existing product.
   - **Path Parameter**:
     - `id`: The ID of the product.
   - **Request Body**:
     ```json
     {
       "name": "string",
       "description": "string",
       "price": "number",
       "stock": "number"
     }
     ```
   - **Responses**:
     - `200 OK`: Product updated successfully.
     - `400 Bad Request`: Validation errors.
     - `404 Not Found`: Product not found.

5. **Delete Product**
   - **Endpoint**: `/api/products/{id}`
   - **Method**: `DELETE`
   - **Description**: Deletes a product by its ID.
   - **Path Parameter**:
     - `id`: The ID of the product.
   - **Responses**:
     - `200 OK`: Product deleted successfully.
     - `404 Not Found`: Product not found.
