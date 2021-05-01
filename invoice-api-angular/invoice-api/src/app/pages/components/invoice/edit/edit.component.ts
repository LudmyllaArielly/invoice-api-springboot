import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { InvoiceService } from 'src/app/shared/invoice.service';
import { newInvoice } from 'src/app/shared/model/newInvoice.model';

@Component({
  selector: 'app-edit',
  templateUrl: './edit.component.html',
  styleUrls: ['./edit.component.scss']
})
export class EditComponent implements OnInit {

  constructor(private invoiceService: InvoiceService, private route: Router) { }

  invoice: newInvoice;

  id: string;

  ngOnInit(): void {
    const navigation = this.route.getCurrentNavigation();
    this.invoice = navigation?.extras?.state?.value;
  }

  edit() {

  }

}
