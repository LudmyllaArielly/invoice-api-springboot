import { Component, OnInit } from '@angular/core';
import { InvoiceService } from 'src/app/shared/invoice.service';
import { getAllInvoice } from 'src/app/shared/model/invoice.model';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.scss']
})
export class ListComponent implements OnInit {
  constructor(private invoiceService: InvoiceService) { }

  getAllInvoices: getAllInvoice[];

  ngOnInit(): void {
    this.invoiceService.getAllInvoice()
      .subscribe((getAllInvoices: getAllInvoice[]) => {
        this.getAllInvoices = getAllInvoices;
      });
    console.log(this.getAllInvoices)
  }


}
