import { CompileMetadataResolver } from '@angular/compiler';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { InvoiceService } from 'src/app/shared/invoice.service';
import { NewInvoice } from 'src/app/shared/model/new-update-invoice.model';


@Component({
  selector: 'app-new',
  templateUrl: './new.component.html',
  styleUrls: ['./new.component.scss']
})
export class NewComponent implements OnInit {

  invoice: NewInvoice = {
    id: null,
    companyName: '',
    dueDate: null,
    status: [],
    value: null,
    userCpfDTO: {
      cpf: '',
    }
  }

  constructor(private invoiceService: InvoiceService, private route: Router, private router: ActivatedRoute) { }

  ngOnInit(): void {
    this.invoice.id = this.router.snapshot.params['id'];
    this.getTheInvoiceData();
  }

  getTheInvoiceData() {
    this.invoiceService.getInvoiceFindByIdWithUserCpf(this.invoice.id).subscribe(data => {
      this.invoice = data;
    }, error => console.log(error));
  }

  saveInvoice() {
    if(this.invoice.id != null){
        this.invoiceService.updateInvoice(this.invoice).subscribe(data => {
          console.log(data);
          this.goToInvoiceList();
        }, error => console.log(error));
    }else {
      this.invoiceService.saveInvoice(this.invoice).subscribe(data => {
      console.log(data);
      this.goToInvoiceList();
     }, error => console.log(error));
   }
}
 
  goToInvoiceList() {
    this.route.navigate(['/list']);
  }

  onSubmit() {
    console.log(this.invoice);
    this.saveInvoice();
  }

}
