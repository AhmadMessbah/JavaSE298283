CREATE TABLE PERSON(
                       ID NUMBER PRIMARY KEY,
                       NAME NVARCHAR2(20),
                       FAMILY NVARCHAR2(20),
                       NATIONAL_ID CHAR(10)
);

CREATE SEQUENCE PERSON_SEQ START WITH 1 INCREMENT BY 1;