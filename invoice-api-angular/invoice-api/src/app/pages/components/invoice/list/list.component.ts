import { DatePipe } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { InvoiceService } from 'src/app/shared/invoice.service';
import { getAllInvoice } from 'src/app/shared/model/invoice.model';



@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.scss'],
  providers: [DatePipe]
})
export class ListComponent implements OnInit {
  dateOfBirth: Date;

  constructor(private invoiceService: InvoiceService, private datePipe: DatePipe) { }

  getAllInvoices: getAllInvoice[];

  getAllInvoiceDate: {
    dateOfBirth: ''
  }

  ngOnInit(): void {
    this.invoiceService.getAllInvoice()
      .subscribe((getAllInvoices: getAllInvoice[]) => {
        this.getAllInvoices = getAllInvoices;
      });
    console.log(this.getAllInvoices)
  }

  formatDate() {
    this.datePipe.transform(this.dateOfBirth, 'dd/MM/yyyy');
  }

}
