import { Component, inject } from '@angular/core';
import { Book } from '../../model/book.interface';
import { BookService } from '../../services/book.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-book-list',
  templateUrl: './book-list.component.html',
  styleUrl: './book-list.component.css'
})
export class BookListComponent {

  bookService = inject(BookService);
  router = inject(Router);
  books: Book[] = [];

  ngOnInit(): void {
    this.loadBooks();
  }

  loadBooks(): void {
    this.bookService.getBooks().subscribe((data) => {
      this.books = data;
    });
  }
  deleteBook(id: number): void {
    this.bookService.deleteBook(id).subscribe(() => {
      this.loadBooks();
    });
  }

  goToCreate() {
    this.router.navigate(['/create']);
  }
  goToEdit(id: number){
    this.router.navigate(['/edit', id]);
  }
}
