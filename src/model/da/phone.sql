CREATE TABLE PHONE
(
    ID            INT PRIMARY KEY,
    FIRST_NAME    NVARCHAR2(60),
    LAST_NAME    NVARCHAR2(60),
    BRAND         NVARCHAR2(80),
    PRICE         DECIMAL(10, 2),
    COLOR         NVARCHAR2(60),
    SERIAL_NUMBER NVARCHAR2(20)
);

CREATE SEQUENCE PHONE_SEQ START WITH 1 INCREMENT BY 1;

