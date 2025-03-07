import { Component, OnInit, inject } from '@angular/core';
import {
  FormBuilder,
  FormGroup,
  ReactiveFormsModule,
  Validators,
} from '@angular/forms';
import { BookService } from '../../services/book.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-book-form',
  imports: [ReactiveFormsModule],
  templateUrl: './book-form.component.html',
  styleUrl: './book-form.component.css',
})
export class BookFormComponent {
  bookForm: FormGroup;
  isEdit = false;
  bookId: number | null = null;

  formBuilder = inject(FormBuilder);
  bookService = inject(BookService);
  router = inject(Router);
  route = inject(ActivatedRoute);

  constructor() {
    this.bookForm = this.formBuilder.group({
      title: ['', Validators.required],
      author: ['', Validators.required],
      isbn: ['', Validators.required],
      quantity: [0, Validators.required],
      available: [0, Validators.required],
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

  onSubmit() {
    console.log("ENTRO", this.bookForm, this.bookForm.invalid)
    if (this.bookForm.invalid) return;

    if (this.isEdit && this.bookId) {
      this.bookService
        .updateBook(this.bookId, this.bookForm.value)
        .subscribe(() => {
          this.router.navigate(['/']);
        });
    } else {
    console.log("ENTRO ELSE", this.bookForm)
      this.bookService.createBook(this.bookForm.value).subscribe(() => {
        this.router.navigate(['/']);
      });
    }
  }
}
