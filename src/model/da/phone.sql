CREATE TABLE PHONE
(
    ID            INT PRIMARY KEY,
    first_name    NVARCHAR2(60),
    last_name     NVARCHAR2(60),
    brand         NVARCHAR2(80),
    price         DECIMAL(10, 2),
    color         NVARCHAR2(60),
    serial_number NVARCHAR2(20)
);

CREATE SEQUENCE PHONE_SEQ START WITH 1 INCREMENT BY 1;

commit;