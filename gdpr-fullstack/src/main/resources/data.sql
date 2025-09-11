-- Optional: seed a sample customer
INSERT INTO customer (uuid, first_name, last_name, email, phone, address, is_anonymized, created_at, updated_at)
VALUES ('{seed-uuid}', 'John', 'Doe', 'john.doe@example.com', '1234567890', '123 Street', false, now(), now());
