import { HttpClient} from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { getAllInvoice } from './model/invoice.model';
import { NewInvoice } from './model/new-update-invoice.model';
import { UpdateStatusInvoice } from './model/update-status-invoice.model';


@Injectable({
  providedIn: 'root'
})
export class InvoiceService {

  private baseUrl = "http://localhost:8080/invoices";

  constructor(private http: HttpClient) { }

  getAllInvoice(): Observable<getAllInvoice[]> {
    return this.http.get<getAllInvoice[]>(this.baseUrl);
  }

  saveInvoice(invoice: NewInvoice): Observable<Object> {
    return this.http.post(this.baseUrl, invoice, { responseType: 'text' });
  }

  getInvoiceFindById(id: string): Observable<getAllInvoice> {
    return this.http.get<getAllInvoice>(this.baseUrl + '/' + id);
  }

  getInvoiceFindByIdWithUserCpf(id: number): Observable<NewInvoice> {
    return this.http.get<NewInvoice>(this.baseUrl + '/findInvoiceWithUserCpf/' + id);
  }

  updateStatus(invoice: UpdateStatusInvoice): Observable<Object> {
    return this.http.patch(this.baseUrl + '/status/', invoice, { responseType: 'text' });
  }

  updateInvoice(invoice: NewInvoice): Observable<Object> {
    return this.http.put(this.baseUrl + '/', invoice, { responseType: 'text' });
  }

  deleteInvoice(id: string): Observable<Object> {
    return this.http.delete(this.baseUrl + '/' + id, { responseType: 'text' });
  }

}
