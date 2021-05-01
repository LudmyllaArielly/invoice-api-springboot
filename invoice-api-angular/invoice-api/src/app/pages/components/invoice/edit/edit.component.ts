import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { InvoiceService } from 'src/app/shared/invoice.service';
import { updateInvoice } from 'src/app/shared/model/invoiceupdate.model';


@Component({
  selector: 'app-edit',
  templateUrl: './edit.component.html',
  styleUrls: ['./edit.component.scss']
})
export class EditComponent implements OnInit {

  constructor(private invoiceService: InvoiceService, private route: ActivatedRoute,
    private router: Router) { }

  invoice: updateInvoice;

  id: string;

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];

    this.invoiceService.getInvoiceFindByIdWithUserCpf(this.id).subscribe(data => {
      this.invoice = data;
    }, error => console.log(error)
    );
  }

  edit() {
    this.invoiceService.updateInvoice(this.invoice).subscribe(res => {
      return this.gotToInvoiceList();
    }, error => console.log(error));
  }

  gotToInvoiceList() {
    this.router.navigate(['/list']);
  }

}
