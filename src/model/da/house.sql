CREATE TABLE HOUSE (
    ID NUMBER PRIMARY KEY ,
    ADDRESS NVARCHAR2(100),
    MEASURE NUMBER ,
    ROOM NUMBER ,
    REGION NVARCHAR2 (40)
);
CREATE SEQUENCE HOUSE_SEQ START WITH 1 INCREMENT BY 1;