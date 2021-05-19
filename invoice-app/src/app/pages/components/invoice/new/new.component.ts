import { CompileMetadataResolver } from '@angular/compiler';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { InvoiceService } from 'src/app/shared/invoice.service';
import { NewInvoice } from 'src/app/shared/model/new-invoice.model';


@Component({
  selector: 'app-new',
  templateUrl: './new.component.html',
  styleUrls: ['./new.component.scss']
})
export class NewComponent implements OnInit {

  invoice: NewInvoice = {
    companyName: '',
    dueDate: new Date,
    status: [],
    value: 0,
    userCpfDTO: {
      cpf: '',
    }
  }

  constructor(private invoiceService: InvoiceService, private route: Router) { }

  ngOnInit(): void {

  }

  saveInvoice() {
    this.invoiceService.saveInvoice(this.invoice).subscribe(data => {
      console.log(data);
      this.goToInvoiceList();
    }, error => console.log(error));
  }

  goToInvoiceList() {
    this.route.navigate(['/list']);
  }

  onSubmit() {
    console.log(this.invoice);
    this.saveInvoice();
  }

}
