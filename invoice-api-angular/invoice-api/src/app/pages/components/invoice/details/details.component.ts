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
    this.invoiceService.getInvoiceFindByid(this.id).subscribe(data => {
      this.invoice = data;
    });
  }

  delete(id: string) {
    this.invoiceService.deleteInvoice(this.id).subscribe(data => {
      this.route.navigate(['/list']);
      console.log(data);
    }, error => console.log(error)
    );
  }
}
