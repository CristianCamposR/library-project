INSERT INTO books (id, title, author, isbn, quantity, available)
VALUES (book_seq.NEXTVAL, 'El Principito', 'Antoine de Saint-Exupéry', '978-0156012195', 10, 10);

INSERT INTO books (id, title, author, isbn, quantity, available)
VALUES (book_seq.NEXTVAL, 'Cien Años de Soledad', 'Gabriel García Márquez', '978-0307474728', 5, 5);

INSERT INTO students (id, name, email, phone, student_number)
VALUES (student_seq.NEXTVAL, 'Juan Pérez', 'juan.perez@example.com', '555-1234', 'S12345');

INSERT INTO students (id, name, email, phone, student_number)
VALUES (student_seq.NEXTVAL, 'María Gómez', 'maria.gomez@example.com', '555-5678', 'S67890');

INSERT INTO loans (id, book_id, student_id, loan_date, return_date)
VALUES (loan_seq.NEXTVAL, 1, 1, TO_DATE('2023-10-01', 'YYYY-MM-DD'), TO_DATE('2023-10-15', 'YYYY-MM-DD'));

INSERT INTO loans (id, book_id, student_id, loan_date, return_date)
VALUES (loan_seq.NEXTVAL, 2, 2, TO_DATE('2023-10-02', 'YYYY-MM-DD'), TO_DATE('2023-10-16', 'YYYY-MM-DD'));