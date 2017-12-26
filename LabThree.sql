--Lab Three ------------------------------------------------

--2.1 SELECT
SELECT * FROM Employee;
SELECT * FROM Employee WHERE LASTNAME='King';
SELECT * FROM Employee WHERE FIRSTNAME='Andrew' AND REPORTSTO IS NULL;

--2.2 ORDER BY
SELECT * FROM Album ORDER BY title DESC;
SELECT Firstname FROM Customer ORDER BY city ASC;

--2.3 INSERT INTO
SELECT * FROM genre;
INSERT INTO Genre VALUES(26, 'Cave music');
INSERT INTO Genre VALUES(27, 'Russian Disco');

INSERT INTO Employee VALUES(9, 'Daniel', 'Robinson', 'Developer', NULL, '12-Jun-87', '03-Mar-2018', '1414 Deb road', 'Kent', 'OH', 'USA', 43312, '1(780)654-3158', '+1(777)123-5678', 'bill@yahoo.com');
INSERT INTO Employee VALUES(10, 'Dan', 'Robin', 'Dev', 2, '11-Jun-87', '03-Mar-2018', '1415 Deb road', 'Kent', 'OH', 'USA', 43312, '1(780)654-3159', '+1(777)123-5679', 'bil@yahoo.com');

INSERT INTO Customer VALUES(60, 'Gatha', 'Robinson', 'Revature', '6716 deb', 'Mobile', 'AL', 'USA', 36619, '+16548973216', NULL, 'Grobin45@yahoo.com', 3);
INSERT INTO Customer VALUES(61, 'Brittany', 'Robinson', 'Half-Shell', '6717 Deborah drive', 'Spanish Fort', 'AL', 'USA', 36619, '+16548973217', NULL, 'Britt95@yahoo.com', 4);

--2.4 UPDATE
UPDATE Customer SET FIRSTNAME='Robert',LASTNAME='Walter' WHERE FIRSTNAME='Aaron' AND LASTNAME='Mitchell';
UPDATE Artist SET NAME='CCR' WHERE NAME='Creedence Clearwater Revival';
SELECT * FROM Artist WHERE NAME='CCR';

--2.5 LIKE
SELECT * FROM INVOICE WHERE BILLINGADDRESS LIKE 'T%';

--2.6 BETWEEN
SELECT * FROM INVOICE WHERE TOTAL BETWEEN 15 AND 50;
SELECT * FROM EMPLOYEE WHERE HIREDATE BETWEEN '01-JUN-03' AND '01-MAR-04';

--2.7 DELETE
SELECT * FROM Customer WHERE FIRSTNAME='Robert';

DELETE FROM invoiceline WHERE invoiceid IN
(SELECT invoiceid FROM invoice WHERE customerid IN
(SELECT customerid FROM customer WHERE firstname='Robert' AND lastname='Walter'));

DELETE FROM invoice WHERE customerid IN (SELECT customerid FROM customer WHERE firstname='Robert' AND lastname='Walter');

DELETE FROM customer WHERE firstname='Robert' AND lastname='Walter';

SELECT * FROM customer;

--3.1 SYSTEM DEFINED FUNCTIONS       
--Create a function that returns the current time.      
CREATE OR REPLACE FUNCTION get_time
    return TIMESTAMP WITH TIME ZONE
IS
    is_time TIMESTAMP WITH TIME ZONE;
BEGIN
    SELECT SYSDATE INTO is_time FROM DUAL;
RETURN is_time;
END;
/

SELECT get_time FROM DUAL;

--create a function that returns the length of a mediatype from the mediatype table
CREATE OR REPLACE FUNCTION med_length(med_id NUMBER)
RETURN NUMBER
IS
leng NUMBER;
BEGIN
SELECT LENGTH(name) INTO leng FROM mediatype WHERE mediatypeid=med_id;
RETURN leng;
END;
/
SELECT med_length(2) FROM DUAL;
SELECT * FROM MEDIATYPE;

--3.2 SYSTEM DEFINED AGGREGATE FUNCTIONS
--Create a function that returns the average total of all invoices
CREATE OR REPLACE FUNCTION avg_invoice
RETURN NUMBER
IS
avg_in NUMBER;
BEGIN
SELECT AVG(total) INTO avg_in FROM invoice;
RETURN avg_in;
END;
/

SELECT avg_invoice FROM DUAL;

--Create a function that returns the most expensive track
CREATE OR REPLACE FUNCTION max_track
RETURN NUMBER
IS
highest_price number;
BEGIN
SELECT DISTINCT MAX(unitprice)INTO highest_price FROM track;
RETURN
highest_price;
END;
/

SELECT max_track FROM DUAL;

--3.3 USER DEFINED SCALAR FUNCTION
--Create a function that returns the average price of invoiceline items in the invoiceline table

CREATE OR REPLACE FUNCTION avg_invoiceline
RETURN NUMBER
IS
avg_inv NUMBER;
BEGIN
SELECT AVG(unitprice) INTO avg_inv FROM invoiceline;
RETURN avg_inv;
END;
/

SELECT avg_invoiceline FROM DUAL;

--3.4 USER DEFINED TABLE VALUED FUNCTIONS
--Create a function that returns all employees who are born after 1968.
CREATE OR REPLACE FUNCTION youngins
RETURN SYS_REFCURSOR
IS
f_name SYS_REFCURSOR;
BEGIN
OPEN f_name FOR SELECT * FROM employee WHERE birthdate > '30-DEC-68';
RETURN
f_name;
END;
/

SELECT youngins FROM DUAL;

--4.1 -Created a stored procedure that selects the first and last names of all the employees
DESC employee;
SELECT * FROM employee;

CREATE OR REPLACE PROCEDURE sel_names(name_display OUT SYS_REFCURSOR)
IS
BEGIN
OPEN name_display for SELECT firstname, lastname FROM employee;
END;
/

DECLARE
name_display SYS_REFCURSOR;
firstname VARCHAR2(20);
lastname VARCHAR2(20);

BEGIN
sel_names(name_display);
    LOOP    
    FETCH name_display INTO firstname, lastname;
    EXIT WHEN name_display%notfound;
    DBMS_OUTPUT.PUT_LINE(firstname || ' ' || lastname);
    END LOOP;
END;
/

--4.2
--Create a stored procedure that updates the personal information of an employee.

CREATE OR REPLACE PROCEDURE updateEmployee(
e_id IN employee.employeeid%TYPE,
e_name IN employee.firstname%TYPE,
e_last IN employee.lastname%TYPE,
e_title IN employee.title%TYPE,
e_address IN employee.address%TYPE
)
IS
BEGIN

UPDATE employee SET firstname = e_name, lastname = e_last, title = e_title, address = e_address WHERE employeeid = e_id;
COMMIT;
END;
/

BEGIN
updateEmployee(1,'Andrewz', 'Adam', 'AssistentToTheGeneralManager', 'Shrute Farms');
END;
/

--Create a stored procedure that returns the managers of an employee.

SELECT * FROM employee;
CREATE OR REPLACE PROCEDURE reports_to(fname IN VARCHAR2, rep_to OUT employee.reportsto%TYPE)
IS
BEGIN
    SELECT reportsto INTO rep_to FROM employee WHERE firstname=fname;
    END;
    /
    
    DECLARE 
        rep_to NUMBER;
    BEGIN
    reports_to('Michael', rep_to);
        DBMS_OUTPUT.PUT_LINE (rep_to);
        END;
        /

--4.3
--Create a stored procedure that returns the name and company of a customer.

CREATE OR REPLACE PROCEDURE cmr_info(c_id IN NUMBER, f_name OUT customer.firstname%TYPE, compan OUT customer.company%TYPE)
IS
BEGIN
SELECT firstname, company INTO f_name, compan FROM customer WHERE customerid=c_id;
END;
/

DECLARE
    f_name VARCHAR2(40);
    compan VARCHAR2(80);
BEGIN
    cmr_info(1, f_name, compan);
    DBMS_OUTPUT.PUT_LINE (f_name || ' works at ' || compan);

END;
/
DESC customer;
SELECT * FROM customer;

--5.0
-- Create a transaction that given a invoiceId will delete that invoice

CREATE OR REPLACE PROCEDURE delete_invoice(inv_id IN invoice.invoiceid%TYPE)
IS
BEGIN

DELETE FROM invoiceline WHERE invoiceid IN 
(SELECT invoiceid from invoice WHERE invoiceid=inv_id);

DELETE FROM invoice WHERE invoiceid=inv_id;
COMMIT;
END;
/

DECLARE
inv_id NUMBER;
BEGIN
delete_invoice(215);
DBMS_OUTPUT.PUT_LINE('Item was deleted');
COMMIT;
END;
/

SELECT * FROM INVOICE;

-- Create a transaction nested within a stored procedure that inserts a new record in the Customer table
CREATE OR REPLACE PROCEDURE cmr_new_record(c_id IN NUMBER, f_name OUT customer.firstname%TYPE)
IS
BEGIN
SELECT firstname INTO f_name FROM customer WHERE customerid=c_id;
END;
/

DECLARE
    f_name VARCHAR2(40);    
BEGIN
    cmr_new_record(60, f_name);
    IF f_name = 'Gatha' THEN
    DBMS_OUTPUT.PUT_LINE('Gatha is new here, we need to input his information');
    INSERT INTO customer VALUES(63, 'Gatha Jr.', 'Trosclaire', 'Retired', '8717 Lucinda drive', 'Mobile', 'AL', 'USA', 38649, '+16548973217', NULL, 'Jeff75@yahoo.com', 4);
    ELSE
    DBMS_OUTPUT.PUT_LINE (f_name);
    END IF;
COMMIT;
END;
/

DESC customer;
SELECT * FROM customer;

--6.1
-- Create an after insert trigger on the employee table fired after a new record is inserted into the table.

CREATE OR REPLACE TRIGGER employee_inserta
AFTER INSERT ON employee
FOR EACH ROW
BEGIN
    IF:new.employeeid > 1 THEN
     DBMS_OUTPUT.PUT_LINE ('You have successfully created new employee data!');
    END IF;
END;
/

SELECT * FROM employee;
INSERT INTO employee VALUES (12, 'D', 'R', 'D', 2, '11-Jun-87', '03-Mar-2018', '1415 Deb road', 'Kent', 'OH', 'USA', 43312, '1(780)654-3159', '+1(777)123-5679', 'bil@yahoo.com');

-- Create an after update trigger on the album table that fires after a row is inserted in the table

CREATE OR REPLACE TRIGGER album_inserta
BEFORE INSERT ON album
FOR EACH ROW
BEGIN
    IF:new.albumid > 1 THEN
    DBMS_OUTPUT.PUT_LINE ('Thank you for adding an album to our data collection!');
    END IF;
END;
/

SELECT * FROM album;
INSERT INTO album VALUES(348, 'Awaken, My Love', 275);

-- Create an after delete trigger on the customer table that fires after a row is deleted from the table.

CREATE OR REPLACE TRIGGER customer_delete_a
AFTER INSERT ON customer
FOR EACH ROW
BEGIN
    IF:new.customerid > 1 THEN
    DBMS_OUTPUT.PUT_LINE ('New customer deleted');
    END IF;
END;
/

INSERT INTO customer VALUES(62, 'Gatha Sr.', 'Robinson', 'Retired', '6757 Deborah drive', 'Mobile', 'AL', 'USA', 36639, '+16548973217', NULL, 'N/A', 4);
SELECT * FROM customer;

--7.1 INNER JOIN

SELECT FIRSTNAME, LASTNAME, INVOICEID FROM customer C INNER JOIN invoice I on C.CUSTOMERID = I.INVOICEID;

--7.2 OUTER JOIN

SELECT C.CUSTOMERID, FIRSTNAME, LASTNAME, INVOICEID, TOTAL FROM customer C FULL OUTER JOIN invoice I on C.CUSTOMERID = I.INVOICEID;

--7.3 RIGHT JOIN

SELECT NAME, TITLE FROM artist A RIGHT OUTER JOIN ALBUM L on A.ARTISTID = L.ALBUMID;

--7.4 CROSS JOIN

SELECT * FROM ALBUM A CROSS JOIN ARTIST A ORDER BY A.NAME ASC;

--7.5 SELF JOIN

SELECT * FROM employee A, employee B WHERE A.EmployeeID=B.Reportsto;

--LAB 3.2 JOIN ALL TABLES IN CHINOOK

SELECT * FROM ALBUM A INNER JOIN ARTIST B on B.ARTISTID = A.ALBUMID;
SELECT * FROM CUSTOMER C INNER JOIN EMPLOYEE E on C.CUSTOMERID = E.EMPLOYEEID;
SELECT * FROM INVOICE I INNER JOIN INVOICELINE L ON I.INVOICEID = L.INVOICELINEID;
SELECT * FROM TRACK T INNER JOIN GENRE G ON T.TRACKID = G.GENREID;
SELECT * FROM TRACK T INNER JOIN MEDIATYPE M ON T.TRACKID = M.MEDIATYPEID;
SELECT * FROM PLAYLIST P INNER JOIN PLAYLISTTRACK T ON P.PLAYLISTID = T.PLAYLISTID;





