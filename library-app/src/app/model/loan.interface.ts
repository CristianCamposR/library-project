import { Book } from './book.interface';
import { Student } from './student.interface';

export interface Loan {
    id: number;
    book: Book
    student: Student;
    loanDate: string;
    returnDate: string;
}