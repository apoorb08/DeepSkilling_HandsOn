BEGIN
   EXECUTE IMMEDIATE 'DROP TABLE loans';
   EXECUTE IMMEDIATE 'DROP TABLE customers';
EXCEPTION
   WHEN OTHERS THEN
      IF SQLCODE != -942 THEN
         RAISE;
      END IF;
END;
/

-- Create the customers table
CREATE TABLE customers (
    customer_id   NUMBER PRIMARY KEY,
    customer_name VARCHAR2(100),
    date_of_birth DATE,
    balance       NUMBER(10, 2),
    is_vip        CHAR(1) DEFAULT 'N'
);

-- Create the loans table
CREATE TABLE loans (
    loan_id       NUMBER PRIMARY KEY,
    customer_id   NUMBER,
    interest_rate NUMBER(5, 2),
    due_date      DATE,
    CONSTRAINT fk_customers FOREIGN KEY (customer_id) REFERENCES customers(customer_id)
);

-- Insert sample data
-- Customer over 60 with a loan
INSERT INTO customers (customer_id, customer_name, date_of_birth, balance) VALUES (1, 'John Smith', TO_DATE('1960-05-15', 'YYYY-MM-DD'), 5000);
INSERT INTO loans (loan_id, customer_id, interest_rate, due_date) VALUES (101, 1, 5.00, SYSDATE + 100);

-- Customer under 60 with a high balance
INSERT INTO customers (customer_id, customer_name, date_of_birth, balance) VALUES (2, 'Jane Doe', TO_DATE('1992-08-20', 'YYYY-MM-DD'), 15000);
INSERT INTO loans (loan_id, customer_id, interest_rate, due_date) VALUES (102, 2, 4.50, SYSDATE + 200);

-- Customer with a loan due soon
INSERT INTO customers (customer_id, customer_name, date_of_birth, balance) VALUES (3, 'Peter Jones', TO_DATE('1985-11-30', 'YYYY-MM-DD'), 8000);
INSERT INTO loans (loan_id, customer_id, interest_rate, due_date) VALUES (103, 3, 6.25, SYSDATE + 15);

-- Customer with a high balance and loan due soon
INSERT INTO customers (customer_id, customer_name, date_of_birth, balance) VALUES (4, 'Mary Williams', TO_DATE('1975-01-10', 'YYYY-MM-DD'), 25000);
INSERT INTO loans (loan_id, customer_id, interest_rate, due_date) VALUES (104, 4, 3.75, SYSDATE + 25);

COMMIT;

-- =================================================================
--  Scenario 1: Apply Discount for Customers Over 60
-- =================================================================
-- Loops through all customers, checks their age, and if they are above 60,
-- applies a 1% discount to their current loan interest rates.

SET SERVEROUTPUT ON;

DECLARE
BEGIN
    FOR cust IN (SELECT customer_id, date_of_birth FROM customers) LOOP
        -- Check if age is greater than 60
        IF (TRUNC(MONTHS_BETWEEN(SYSDATE, cust.date_of_birth) / 12) > 60) THEN
            -- Apply a 1% discount (new rate = old rate * 0.99)
            UPDATE loans
            SET interest_rate = interest_rate * 0.99
            WHERE customer_id = cust.customer_id;
        END IF;
    END LOOP;
    DBMS_OUTPUT.PUT_LINE('Scenario 1: Interest rate discount check completed.');
END;
/

-- =================================================================
--  Scenario 2: Promote Customers to VIP Status
-- =================================================================
-- Iterates through all customers and sets a flag IsVIP to TRUE ('Y')
-- for those with a balance over $10,000.

DECLARE
BEGIN
    FOR cust IN (SELECT customer_id, balance FROM customers) LOOP
        IF cust.balance > 10000 THEN
            UPDATE customers
            SET is_vip = 'Y'
            WHERE customer_id = cust.customer_id;
        END IF;
    END LOOP;
    DBMS_OUTPUT.PUT_LINE('Scenario 2: VIP status update completed.');
END;
/


-- =================================================================
--  Scenario 3: Send Loan Reminders
-- =================================================================
-- Fetches all loans due in the next 30 days and prints a reminder
-- message for each customer.

DECLARE
BEGIN
    DBMS_OUTPUT.PUT_LINE('--- Loan Payment Reminders ---');
    FOR reminder IN (
        SELECT c.customer_name, l.due_date
        FROM customers c
        JOIN loans l ON c.customer_id = l.customer_id
        WHERE l.due_date BETWEEN SYSDATE AND SYSDATE + 30
    ) LOOP
        DBMS_OUTPUT.PUT_LINE(
            'Reminder for ' || reminder.customer_name ||
            ': Your loan payment is due on ' || TO_CHAR(reminder.due_date, 'YYYY-MM-DD') || '.'
        );
    END LOOP;
    DBMS_OUTPUT.PUT_LINE('----------------------------');
END;
/
