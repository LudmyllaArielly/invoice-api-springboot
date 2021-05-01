import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { InvoiceService } from 'src/app/shared/invoice.service';
import { getAllInvoice } from 'src/app/shared/model/invoice.model';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.scss']
})
export class ListComponent implements OnInit {
  constructor(private invoiceService: InvoiceService, private route: Router) { }

  getAllInvoices: getAllInvoice[];

  ngOnInit(): void {
    this.getAllInvoice();
  }

  private getAllInvoice() {
    this.invoiceService.getAllInvoice().subscribe((getAllInvoices: getAllInvoice[]) => {
      this.getAllInvoices = getAllInvoices;
    });
  }

  editInvoice(id: string) {
    this.route.navigate(['edit', id]);
  }

  deleteInvoice(id: string) {
    this.route.navigate(['details', id]);
  }

}
