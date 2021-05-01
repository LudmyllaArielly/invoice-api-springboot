import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { InvoiceService } from 'src/app/shared/invoice.service';
import { getAllInvoice } from 'src/app/shared/model/invoice.model';

@Component({
  selector: 'app-details',
  templateUrl: './details.component.html',
  styleUrls: ['./details.component.scss']
})
export class DetailsComponent implements OnInit {

  id: string;
  invoice: getAllInvoice;

  constructor(private invoiceService: InvoiceService, private router: ActivatedRoute) { }

  ngOnInit(): void {
    this.id = this.router.snapshot.params['id'];
    this.invoiceService.getInvoiceFindByid(this.id).subscribe(data => {
      this.invoice = data;
    });
  }

}
