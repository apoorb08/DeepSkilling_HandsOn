BEGIN
   EXECUTE IMMEDIATE 'DROP TABLE employees';
EXCEPTION
   WHEN OTHERS THEN
      IF SQLCODE != -942 THEN
         RAISE;
      END IF;
END;
/

CREATE TABLE employees (
    employee_id   NUMBER PRIMARY KEY,
    employee_name VARCHAR2(100),
    department_id NUMBER,
    salary        NUMBER(10, 2)
);

-- Insert sample employee data
INSERT INTO employees (employee_id, employee_name, department_id, salary) VALUES (101, 'Alice', 10, 50000);
INSERT INTO employees (employee_id, employee_name, department_id, salary) VALUES (102, 'Bob', 10, 55000);
INSERT INTO employees (employee_id, employee_name, department_id, salary) VALUES (103, 'Charlie', 20, 60000);

COMMIT;

-- =================================================================
--  Scenario 1: Process Monthly Interest for Savings Accounts
-- =================================================================
-- Procedure to calculate and update the balance of all accounts
-- by applying an interest rate of 1%.

CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest AS
BEGIN
    UPDATE customers
    SET balance = balance * 1.01;
    COMMIT;
END ProcessMonthlyInterest;
/

-- =================================================================
--  Scenario 2: Update Employee Bonus by Department
-- =================================================================
-- Procedure to update employee salaries in a specific department
-- by adding a bonus percentage.

CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus (
    p_department_id IN NUMBER,
    p_bonus_percent IN NUMBER
) AS
BEGIN
    UPDATE employees
    SET salary = salary * (1 + p_bonus_percent / 100)
    WHERE department_id = p_department_id;
    COMMIT;
END UpdateEmployeeBonus;
/

-- =================================================================
--  Scenario 3: Transfer Funds Between Customer Accounts
-- =================================================================
-- Procedure to transfer a specified amount from one account to another,
-- ensuring the source account has sufficient funds.

CREATE OR REPLACE PROCEDURE TransferFunds (
    p_from_customer_id IN NUMBER,
    p_to_customer_id   IN NUMBER,
    p_amount           IN NUMBER
) AS
    v_from_balance NUMBER;
BEGIN
    -- First, check the balance of the source account
    SELECT balance INTO v_from_balance
    FROM customers
    WHERE customer_id = p_from_customer_id;

    -- Check for sufficient funds
    IF v_from_balance >= p_amount THEN
        -- Subtract amount from the source account
        UPDATE customers
        SET balance = balance - p_amount
        WHERE customer_id = p_from_customer_id;

        -- Add amount to the destination account
        UPDATE customers
        SET balance = balance + p_amount
        WHERE customer_id = p_to_customer_id;

        COMMIT;
    ELSE
        -- If funds are insufficient, do nothing (or raise an error)
        NULL;
    END IF;
END TransferFunds;
/

-- =================================================================
--  Execution Examples (Optional)
-- =================================================================
-- You can run these blocks to test the stored procedures.

SET SERVEROUTPUT ON;

-- Example for Scenario 1
BEGIN
    DBMS_OUTPUT.PUT_LINE('Running ProcessMonthlyInterest...');
    ProcessMonthlyInterest;
    DBMS_OUTPUT.PUT_LINE('Monthly interest processed.');
END;
/

-- Example for Scenario 2
BEGIN
    DBMS_OUTPUT.PUT_LINE('Running UpdateEmployeeBonus for department 10 with a 5% bonus...');
    UpdateEmployeeBonus(p_department_id => 10, p_bonus_percent => 5);
    DBMS_OUTPUT.PUT_LINE('Employee bonuses updated.');
END;
/

-- Example for Scenario 3
BEGIN
    DBMS_OUTPUT.PUT_LINE('Running TransferFunds to move $500 from customer 2 to customer 1...');
    TransferFunds(p_from_customer_id => 2, p_to_customer_id => 1, p_amount => 500);
    DBMS_OUTPUT.PUT_LINE('Fund transfer attempted.');
END;
/
