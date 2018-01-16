--Populate roles, types, status tables, should not insert/delete/update these tables after this
INSERT INTO ers_user_roles VALUES (0, 'employee');
INSERT INTO ers_user_roles VALUES (1, 'manager');
SELECT * FROM ers_user_roles;

INSERT INTO ers_reimbursement_status VALUES (0, 'pending');
INSERT INTO ers_reimbursement_status VALUES (1, 'approved');
INSERT INTO ers_reimbursement_status VALUES (2, 'denied');
SELECT * FROM ers_reimbursement_status;

INSERT INTO ers_reimbursement_type VALUES (0, 'other');
INSERT INTO ers_reimbursement_type VALUES (1, 'personal injury');
INSERT INTO ers_reimbursement_type VALUES (2, 'science accident');
INSERT INTO ers_reimbursement_type VALUES (3, 'psychological damage');
INSERT INTO ers_reimbursement_type VALUES (4, 'travel');
SELECT * FROM ers_reimbursement_type;

COMMIT;

INSERT INTO ers_users VALUES (null, 'cave.johnson', '1234', 'Cave', 'Johnson', 'cave.johnson@aperture.science', 1);
INSERT INTO ers_users VALUES (null, 'GLaDOS', '1234', 'Caroline', '', 'caroline@aperture.sciencne', 1);
INSERT INTO ers_users VALUES (null, 'chell', '1234', 'Chell', '', 'chell@aperture.science', 0);
INSERT INTO ers_users VALUES (null, 'ratman', '1234', 'Doug', 'Rattman', 'doug.rattman@aperture.science', 0);
INSERT INTO ers_users VALUES (null, 'turret1138', '1234', 'Bill', 'the Turret', 'turret1138@aperture.science', 0);
INSERT INTO ers_users VALUES (null, 'wheatley', '1234', 'Wheatley', '', 'wheatley@aperture.science', 1);
INSERT INTO ers_users VALUES (null, 'ts137', '1234', 'Test Subject', '137', 'ts137@aperture.science', 0);
UPDATE ers_users SET ur_id = 0 WHERE u_username = 'GLaDOS';
DELETE FROM ers_reimbursements;
COMMIT;


--------------------------------------------------------------------------------

--Insert rows into users, reimbursements for JUnit tests, do not change these entries!

INSERT INTO ers_users VALUES (null, 'test', '1234', 'Testy', 'McTesterston', 'testtest@test.test', 0);
INSERT INTO ers_users VALUES (null, 'test2', '1234', 'Tester', 'Testeroni', 'test@testtest.test', 0);
INSERT INTO ers_users VALUES (null, 'test3', '1234', 'Testus', 'Test', 'test@test.test', 1);
UPDATE ers_users SET u_id=2 WHERE u_id=21;
SELECT * FROM ers_users;

BEGIN
    DELETE FROM ers_reimbursements WHERE u_id_author=63;
    insert_reimbursement(1, 'pending request 1', null, 63, 0, 0);
    insert_reimbursement(2, 'pending request 2', null, 63, 0, 0);
    insert_reimbursement(3, 'approved request 1', null, 63, 0, 0);
    insert_reimbursement(4, 'approved request 2', null, 63, 0, 0);
    insert_reimbursement(5, 'denied request 1', null, 63, 0, 0);
    insert_reimbursement(6, 'denied request 2', null, 63, 0, 0);
    COMMIT;
END;
/


--------------------------------------------------------------------------------

--Create sequences
CREATE SEQUENCE ers_users_seq
    START WITH 1
    INCREMENT BY 1;
    
CREATE SEQUENCE ers_reimbursements_seq
    START WITH 1
    INCREMENT BY 1;
    
--Create triggers

CREATE OR REPLACE TRIGGER insert_ers_usersb
BEFORE INSERT ON ers_users                    
FOR EACH ROW                                
BEGIN
    IF :new.u_id IS NULL then
        SELECT ers_users_seq.NEXTVAL INTO :new.u_id FROM dual;
    END IF;
END;
/

CREATE OR REPLACE TRIGGER insert_ers_reimbursementsb
BEFORE INSERT ON ers_reimbursements                 
FOR EACH ROW                                
BEGIN
    IF :new.r_id IS NULL then
        SELECT ers_reimbursements_seq.NEXTVAL INTO :new.r_id FROM dual;
    END IF;
    IF :new.r_submitted IS NULL then
        SELECT CURRENT_TIMESTAMP INTO :new.r_submitted FROM dual;
    END IF;
END;
/

--Create stored procedures for insertion

CREATE OR REPLACE PROCEDURE insert_reimbursement(amount IN NUMBER, descript IN VARCHAR2, receipt IN BLOB, author_id IN NUMBER, type_id IN NUMBER, status_id IN NUMBER)
IS
    cur_time TIMESTAMP;
BEGIN
    SELECT CURRENT_TIMESTAMP INTO cur_time FROM dual;
    INSERT INTO ers_reimbursements VALUES (null, amount, descript, receipt, cur_time, null, author_id, null, type_id, status_id);
    COMMIT;
END;
/

CREATE OR REPLACE PROCEDURE update_reimbursement_status(re_id IN NUMBER, resolver_id IN NUMBER, status_id IN NUMBER)
IS
    cur_time TIMESTAMP;
BEGIN
    SELECT CURRENT_TIMESTAMP INTO cur_time FROM dual;
    UPDATE ers_reimbursements SET r_resolved=cur_time, u_id_resolver=resolver_id, rt_status=status_id WHERE r_id = re_id;
    COMMIT;
END;
/