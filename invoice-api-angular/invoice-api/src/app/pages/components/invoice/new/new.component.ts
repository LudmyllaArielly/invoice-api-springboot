import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
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

  constructor(private invoiceService: InvoiceService, private route: Router) { }

  ngOnInit(): void {

  }

  save() {
    this.invoiceService.saveInvoice(this.invoice).subscribe(res => {
      this.route.navigate(['/list']);
    }, error => console.log(error)
    );
  }

}
