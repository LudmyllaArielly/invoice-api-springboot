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

  constructor(private invoiceService: InvoiceService, private router: ActivatedRoute, private route: Router) { }

  ngOnInit(): void {
    this.id = this.router.snapshot.params['id'];
    this.getTheInvoiceData();
  }

  getTheInvoiceData() {
    this.invoiceService.getInvoiceFindById(this.id).subscribe(data => {
      this.invoice = data;
    });
  }

  deleteInvoice(id: string) {
    this.invoiceService.deleteInvoice(this.id).subscribe(data => {
      console.log(data);
      this.onGoToInvoiceList();
    }, error => console.log(error));
  }

  onGoToInvoiceList() {
    this.route.navigate(['/list']);
  }
}
