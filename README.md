# Acceleration Insertion for PostgreSQL from multithreading to atomicity 🚀

## **Description**

This application is designed to test various methods for inserting data into a PostgreSQL database. It's built with:
- A Kotlin-based backend.
- A preloaded PostgreSQL database with over 100 million rows in the "payment_document" table.
- Multiple indexes in the "payment_document" table to influence the insertion process.

## **For testing approaches and view code examples, use the branches:** 
- [ready_to_read](https://github.com/FatovDI/atomic-multithreaded-insertion-postgresql/tree/ready_to_read) - for testing the atomicity through the `ready_to_read` flag.
- [transaction_id_in_two_table](https://github.com/FatovDI/atomic-multithreaded-insertion-postgresql/tree/transaction_id_in_two_table) - for testing the atomicity through `transaction id` in two tables.
- [transaction_id_in_other_table](https://github.com/FatovDI/atomic-multithreaded-insertion-postgresql/tree/transaction_id_in_other_table) - for testing the atomicity through `transaction id` in another table.
