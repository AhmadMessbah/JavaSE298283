CREATE TABLE LICENSE(
                        ID            NUMBER PRIMARY KEY ,
                        LICENSE_TYPE  NVARCHAR2(30),
                        FILE_NAME     NVARCHAR2(50),
                        FILE_SIZE     NUMBER,
                        DESCRIPTION   NVARCHAR2(20)
);

CREATE SEQUENCE LICENSE_SEQ START WITH 1 INCREMENT BY 1;