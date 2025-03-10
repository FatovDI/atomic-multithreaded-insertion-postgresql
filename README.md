# Acceleration Insertion for PostgreSQL from multithreading to atomicity 🚀

## **Description**

This branch for testing the atomicity through the `ready_to_read` flag. For other approaches use branches:
- [transaction_id_in_other_table](https://github.com/FatovDI/atomic-multithreaded-insertion-postgresql/tree/transaction_id_in_other_table) - for testing the atomicity through `transaction id` in the other table. 
- [transaction_id_in_two_table](https://github.com/FatovDI/atomic-multithreaded-insertion-postgresql/tree/transaction_id_in_two_table) - for testing the atomicity through `transaction id` in the two table. 

## **Application**

This application is designed to test various methods for inserting data into a PostgreSQL database. It's built with:
- A Kotlin-based backend.
- A preloaded PostgreSQL database with over 100 million rows in the "payment_document" table.
- Multiple indexes in the "payment_document" table to influence the insertion process.

## **Prerequisites**

- **Storage:** Ensure you have at least 32GB of free space on your machine to work with the preloaded database.

## **Working with the Preloaded Database**

1. **Download the Image:** Grab the PostgreSQL image with preloaded data [here](https://disk.yandex.ru/d/lzqUyby5aIFadw) named `db_joker.tar.gz`.
2. **Load Image:** Import the image to your local Docker registry using:
   ```bash
   sudo docker load < db_joker.tar.gz
   ```
3. **Start Application:** Using git bash:
   ```bash
   sh start.sh
   ```
4. **Stop Application:** Using git bash:
   ```bash
   sh stop.sh
   ```

## **Working with an Empty Database**

1. **Configure Image:** Update `docker-compose.yaml` and change the line:
   ```yaml
   image: db_joker:1
   ```
   to:
   ```yaml
   image: postgres:latest
   ```
2. **Start Application:**
   ```bash
   sudo docker-compose up -d --build
   ```
3. **Stop Application:** Using git bash:
   ```bash
   sudo docker-compose down -v
   ```

## **API Endpoints**

Use the following endpoints to test different insertion methods. You can specify the number of rows to generate in the database and retrieve results with performance metrics. For convenience, utilize `curl -X POST` to interact with these endpoints. The number of rows to create is specified by the `count` path parameter.

```bash
# Insert by Spring
http://localhost:8080/test-insertion/spring/{count}

# Insert by Spring with async approach
http://localhost:8080/test-insertion/save-by-spring-with-async/{count}

# Update using Spring
http://localhost:8080/test-insertion/spring-update/{count}

# Update using stateless session hibernate
http://localhost:8080/test-insertion/spring-update-by-session/{count}

# Set ready to read by list of payment document id
http://localhost:8080/test-insertion/set-ready-to-read/{count}

# Set ready to read using `any(?)`
http://localhost:8080/test-insertion/set-ready-to-read-array/{count}

# Set ready to read using `any(?)` after insert
http://localhost:8080/test-insertion/set-ready-to-read-array-after-insert/{count}

# Set ready to read using select by unnest method
http://localhost:8080/test-insertion/set-ready-to-read-unnest/{count}

# Set ready to read by transaction id
http://localhost:8080/test-insertion/set-ready-to-read-by-transaction-id/{transactionId}

# Atomic Multi-threaded Insertion with Spring by list id of payment document
http://localhost:8080/test-insertion/save-concurrent-and-atomic/{count}

# Atomic Multi-threaded Insertion with Spring by transaction id
http://localhost:8080/test-insertion/save-concurrent-and-atomic-by-transaction-id/{count}
```