import { Component, OnInit, inject } from '@angular/core';
import {
  FormBuilder,
  FormGroup,
  ReactiveFormsModule,
  Validators,
} from '@angular/forms';
import { BookService } from '../../services/book.service';
import { ActivatedRoute, Router } from '@angular/router';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-book-form',
  standalone: true,
  imports: [ReactiveFormsModule, CommonModule],
  templateUrl: './book-form.component.html',
  styleUrl: './book-form.component.css',
})
export class BookFormComponent implements OnInit {
  bookForm: FormGroup;
  isEdit = false;
  bookId: number | null = null;

  // Propiedades para las alertas
  showSuccessAlert = false;
  showErrorAlert = false;

  formBuilder = inject(FormBuilder);
  bookService = inject(BookService);
  router = inject(Router);
  route = inject(ActivatedRoute);

  constructor() {
    this.bookForm = this.formBuilder.group({
      title: ['', [Validators.required, Validators.minLength(3)]],
      author: ['', [Validators.required, Validators.minLength(3)]],
      isbn: ['', [Validators.required, Validators.pattern(/^\d{10,13}$/)]],
      quantity: [0, [Validators.required, Validators.min(1)]],
      available: [0, [Validators.required, Validators.min(0)]],
    });
  }

  ngOnInit() {
    this.route.paramMap.subscribe((params) => {
      const id = params.get('id');
      if (id) {
        this.isEdit = true;
        this.bookId = +id;
        this.bookService.getBook(this.bookId).subscribe((data) => {
          this.bookForm.patchValue(data);
        });
      }
    });
  }

  // Método para acceder a los controllers del form
  get f() {
    return this.bookForm.controls;
  }

  onSubmit() {
    if (this.bookForm.invalid) {
      this.bookForm.markAllAsTouched();
      return;
    }

    if (this.isEdit && this.bookId) {
      this.bookService
        .updateBook(this.bookId, this.bookForm.value)
        .subscribe({
          next: () => {
            this.showSuccessAlert = true;
            setTimeout(() => {
              this.router.navigate(['/']); 
            }, 1500);
          },
          error: () => {
            this.showErrorAlert = true; 
          },
        });
    } else {
      this.bookService.createBook(this.bookForm.value).subscribe({
        next: () => {
          this.showSuccessAlert = true; 
          setTimeout(() => {
            this.router.navigate(['/']); 
          }, 1500);
        },
        error: () => {
          this.showErrorAlert = true; 
        },
      });
    }
  }
}