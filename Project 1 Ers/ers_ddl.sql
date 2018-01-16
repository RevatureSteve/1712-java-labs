CREATE USER proj1 IDENTIFIED BY p4ssw0rd;
GRANT CONNECT, RESOURCE TO proj1;
GRANT DBA TO proj1 WITH ADMIN OPTION;

-------------------------------------

DROP TABLE ers_users;
DROP TABLE ers_user_roles;
DROP TABLE ers_reimbursements;
DROP TABLE ers_reimbursement_type;
DROP TABLE ers_reimbursement_status;

CREATE TABLE ers_users (
    u_id NUMBER(*, 0),
    u_username VARCHAR2(40) UNIQUE NOT NULL,
    u_password VARCHAR2(40) NOT NULL, 
    u_firstname VARCHAR2(30),
    u_lastname VARCHAR2(30),
    u_email VARCHAR2(100) UNIQUE,
    ur_id NUMBER(*, 0) NOT NULL,
    CONSTRAINT ers_users_pk PRIMARY KEY (u_id)
);

CREATE TABLE ers_user_roles (
    ur_id NUMBER(*, 0),
    ur_role VARCHAR2(40),
    CONSTRAINT ers_user_roles_pk PRIMARY KEY (ur_id)
);

CREATE TABLE ers_reimbursements (
    r_id NUMBER(*, 0),
    r_amount NUMBER(22, 2) NOT NULL,
    r_description VARCHAR2(100),
    r_receipt BLOB,
    r_submitted TIMESTAMP NOT NULL,
    r_resolved TIMESTAMP,
    u_id_author NUMBER(*, 0) NOT NULL,
    u_id_resolver NUMBER(*, 0),
    rt_type NUMBER(*, 0) NOT NULL,
    rt_status NUMBER(*, 0) NOT NULL,
    CONSTRAINT ers_reimbursements_pk PRIMARY KEY (r_id)
);

CREATE TABLE ers_reimbursement_status (
    rs_id NUMBER(*, 0),
    rs_status VARCHAR2(30) NOT NULL,
    CONSTRAINT ers_reimbursement_status_pk PRIMARY KEY (rs_id)
);

CREATE TABLE ers_reimbursement_type (
    rt_id NUMBER(*, 0),
    rt_type VARCHAR2(30) NOT NULL,
    CONSTRAINT ers_reimbursement_type_pk PRIMARY KEY (rt_id)
);

-----------------------------------
ALTER TABLE ers_users ADD CONSTRAINT fk_users_userroles
    FOREIGN KEY (ur_id) REFERENCES ers_user_roles (ur_id);
    
ALTER TABLE ers_reimbursements ADD CONSTRAINT fk_reimbursements_users_author
    FOREIGN KEY (u_id_author) REFERENCES ers_users (u_id);
    
ALTER TABLE ers_reimbursements ADD CONSTRAINT fk_reimbursements_resolver
    FOREIGN KEY (u_id_resolver) REFERENCES ers_users (u_id);

ALTER TABLE ers_reimbursements ADD CONSTRAINT fk_reimbursements_type
    FOREIGN KEY (rt_type) REFERENCES ers_reimbursement_type (rt_id);
    
ALTER TABLE ers_reimbursements ADD CONSTRAINT fk_reimbursements_status
    FOREIGN KEY (rt_status) REFERENCES ers_reimbursement_status (rs_id);
    
    