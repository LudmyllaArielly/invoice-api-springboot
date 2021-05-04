import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { InvoiceService } from 'src/app/shared/invoice.service';
import { UpdateInvoice } from 'src/app/shared/model/update-invoice.model';


@Component({
  selector: 'app-edit',
  templateUrl: './edit.component.html',
  styleUrls: ['./edit.component.scss']
})
export class EditComponent implements OnInit {

  constructor(private invoiceService: InvoiceService, private route: ActivatedRoute,
    private router: Router) { }

  invoice: UpdateInvoice;

  id: string;

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.getTheInvoiceData();
  }

  getTheInvoiceData() {
    this.invoiceService.getInvoiceFindByIdWithUserCpf(this.id).subscribe(data => {
      this.invoice = data;
    }, error => console.log(error));
  }

  editInvoice() {
    this.invoiceService.updateInvoice(this.invoice).subscribe(data => {
      console.log(data);
      this.gotToInvoiceList();
    }, error => console.log(error));
  }

  gotToInvoiceList() {
    this.router.navigate(['/list']);
  }

  onSubmit() {
    console.log(this.invoice)
    this.editInvoice();
  }

}
