import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { InvoiceService } from 'src/app/shared/invoice.service';
import { UpdateStatusInvoice } from 'src/app/shared/model/update-status-invoice.model';

@Component({
  selector: 'app-update-status',
  templateUrl: './update-status.component.html',
  styleUrls: ['./update-status.component.scss']
})
export class UpdateStatusComponent implements OnInit {

  invoice: UpdateStatusInvoice;

  id: string;

  constructor(private invoiceService: InvoiceService,
    private router: ActivatedRoute,
    private route: Router) { }

  ngOnInit(): void {
    this.id = this.router.snapshot.params['id'];
    this.getTheInvoiceData();
  }

  getTheInvoiceData() {
    this.invoiceService.getInvoiceFindById(this.id).subscribe(data => {
      this.invoice = data;
    });
  }

  editStatusInvoice() {
    this.invoiceService.updateStatus(this.invoice).subscribe(data => {
      console.log(data);
      this.gotToInvoiceList();
    }, error => console.log(error));
  }

  gotToInvoiceList() {
    this.route.navigate(['/list']);
  }

  onSubmit() {
    console.log(this.invoice);
    this.editStatusInvoice();
  }

}
