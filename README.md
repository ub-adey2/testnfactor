# Readme

## Database Used

The database being used is MySQL.

## Running the Code

To run the code, follow these steps:

1. Create a database in MySQL named `test`:
    ```sql
    CREATE DATABASE test;
    ```

2. Use the database named `test` in MySQL:
    ```sql
    USE test;
    ```

3. Create a table inside the `test` database named `responses`:
    ```sql
    CREATE TABLE responses (
        id INT AUTO_INCREMENT PRIMARY KEY,
        question VARCHAR(255),
        response TEXT
    );
    ```

4. Populate the `responses` table with questions and responses. Here's an example SQL command:

    ```sql
    INSERT INTO responses (question, response) VALUES
        ('How are you?', 'I am amazing!'),
        ('What is the weather like today?', 'It is quite cold in Buffalo'),
        ('Who are you?', 'I am a Chatbot');
    ```

   You can add more rows as needed.

5. Navigate to the location where your Java class file (`abcd.java`) is located.

6. Compile the Java class file using the following command:

    ```bash
    javac -cp mysql-connector-j-8.3.0.jar abcd.java
    ```

7. Run the compiled Java program using the following command:

    ```bash
    java -cp .:mysql-connector-j-8.3.0.jar abcd
    ```

   Make sure to replace `mysql-connector-j-8.3.0.jar` with the correct filename if it differs.