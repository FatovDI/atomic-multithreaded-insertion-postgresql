# Acceleration Insertion for PostgreSQL from multithreading to atomicity 🚀

## **Description**

This branch for testing the atomicity through save transaction id in two table. For other approaches use branches:
- [ready_to_read](https://github.com/FatovDI/atomic-multithreaded-insertion-postgresql/tree/ready_to_read) - for testing the atomicity through the `ready_to_read` flag.
- [transaction_id_in_other_table](https://github.com/FatovDI/atomic-multithreaded-insertion-postgresql/tree/transaction_id_in_other_table) - for testing the atomicity through `transaction id` in the other table.

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
# Atomic Multi-threaded Insertion with Spring by transaction id
http://localhost:8080/test-insertion/save-concurrent-and-atomic-by-transaction-id-another-table/{count}

# Insert by Spring
http://localhost:8080/test-insertion/spring/{count}

# Insert by Spring with async approach
http://localhost:8080/test-insertion/save-by-spring-with-async/{count}

# Update using Spring
http://localhost:8080/test-insertion/spring-update/{count}

# Update using stateless session hibernate
http://localhost:8080/test-insertion/spring-update-by-session/{count}
```