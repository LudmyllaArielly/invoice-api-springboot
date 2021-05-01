import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { InvoiceService } from 'src/app/shared/invoice.service';
import { getAllInvoice } from 'src/app/shared/model/invoice.model';
import { updateInvoice } from 'src/app/shared/model/invoiceupdate.model';


@Component({
  selector: 'app-edit',
  templateUrl: './edit.component.html',
  styleUrls: ['./edit.component.scss']
})
export class EditComponent implements OnInit {

  constructor(private invoiceService: InvoiceService, private route: ActivatedRoute) { }

  invoice: updateInvoice;

  getInvoice: getAllInvoice;

  id: string;

  ngOnInit(): void {
    this.id = this.route.snapshot.paramMap.get('id');
    this.invoiceService.getInvoiceFindByid(this.id).subscribe(res => {
      this.getInvoice = {
        id: `${res.id}`,
        companyName: `${res.companyName}`,
        dueDate: new Date,
        status: `${res.status}`,
        value: 0,
        userCreateAndListAllDTO: {
          cpf: `${res.userCreateAndListAllDTO.cpf}`,
          dateOfBirth: new Date,
          fistName: '',
          lastName: '',
        }

      }
    });
  }

  edit() {
    this.invoiceService.updateInvoice(this.id, this.invoice).subscribe(res => {
      this.invoice = res;
      console.log(this.invoice = res)
    });
  }

}
