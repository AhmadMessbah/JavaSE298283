create table BORROW
(
    ID          NUMBER PRIMARY KEY,
    Person_id   number(20),
    Book_id     number(20),
    Borrow_date timestamp,
    Return_date timestamp
);

CREATE SEQUENCE BORROW_SEQ START WITH 1 INCREMENT BY 1;