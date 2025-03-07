import { Component, inject } from '@angular/core';
import { Loan } from '../../model/loan.interface'
import { LoanService } from '../../services/loan.service';
import { Router } from '@angular/router';
import { DatePipe } from '@angular/common';

@Component({
  selector: 'app-loan-list',
  imports: [DatePipe],
  templateUrl: './loan-list.component.html',
  styleUrl: './loan-list.component.css',
  providers: [DatePipe]
})
export class LoanListComponent {
  loanService = inject(LoanService);
  router = inject(Router);
  loans : Loan[] = [];

  ngOnInit(): void {
    this.loadLoans();
  }

  loadLoans(): void {
    this.loanService.getLoans().subscribe((data) => {
      this.loans = data;
    })
  }

  deleteLoan(id: number): void {
    this.loanService.deleteLoan(id).subscribe(() => {
      this.loadLoans();
    });
  }

  goToCreate() {
    this.router.navigate(['loan/create']);
  }
  goToEdit(id: number){
    this.router.navigate(['loan/edit', id]);
  }
}
