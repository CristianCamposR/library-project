import { Routes } from '@angular/router';
import { BookListComponent } from './components/book-list/book-list.component';
import { BookFormComponent } from './components/book-form/book-form.component';
import { LoanListComponent } from './components/loan-list/loan-list.component';

export const routes: Routes = [
  { path: '', component: BookListComponent },
  { path: 'book', component: BookListComponent },
  { path: 'book/create', component: BookFormComponent },
  { path: 'book/edit/:id', component: BookFormComponent },
  { path: 'loan', component: LoanListComponent },
];
