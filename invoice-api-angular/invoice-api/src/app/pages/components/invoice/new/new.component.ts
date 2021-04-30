import { Component, OnInit } from '@angular/core';
import { InvoiceService } from 'src/app/shared/invoice.service';
import { newInvoice } from 'src/app/shared/model/newInvoice.model';


@Component({
  selector: 'app-new',
  templateUrl: './new.component.html',
  styleUrls: ['./new.component.scss']
})
export class NewComponent implements OnInit {

  invoice: newInvoice = {
    id: '',
    companyName: '',
    dueDate: new Date,
    status: [],
    value: 0,
    userCpfDTO: {
      cpf: '',
    }
  }

  constructor(private invoiceService: InvoiceService) { }

  ngOnInit(): void {

  }

  save() {
    if (this.invoice.id !== undefined) {
      this.invoiceService.updateInvoice(this.invoice).subscribe(res => {
        this.invoice = res;
        console.log(this.invoice = res)
      });
    } else {
      this.invoiceService.saveInvoice(this.invoice).subscribe(res => {
        this.invoice = res;
        console.log(this.invoice = res)
      });
    }
  }

  edit(invoice: newInvoice) {
    this.invoice = { ...invoice }
  }

}
