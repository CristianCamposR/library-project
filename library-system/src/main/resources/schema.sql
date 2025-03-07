CREATE TABLE books
(
    id        NUMBER PRIMARY KEY,
    title     VARCHAR2(100),
    author    VARCHAR2(100),
    isbn      VARCHAR2(20),
    quantity  NUMBER,
    available NUMBER
);
CREATE TABLE students
(
    id             NUMBER PRIMARY KEY,
    name           VARCHAR2(100),
    email          VARCHAR2(100),
    phone          VARCHAR2(20),
    student_number VARCHAR2(20)
);

CREATE TABLE loans
(
    id          NUMBER PRIMARY KEY,
    book_id     NUMBER REFERENCES books (id),
    student_id  NUMBER REFERENCES students (id),
    loan_date   DATE,
    return_date DATE
);

CREATE SEQUENCE book_seq
    START WITH 1
    INCREMENT BY 1
    NOCACHE;

CREATE SEQUENCE student_seq
    START WITH 1
    INCREMENT BY 1
    NOCACHE;

CREATE SEQUENCE loan_seq
    START WITH 1
    INCREMENT BY 1
    NOCACHE;