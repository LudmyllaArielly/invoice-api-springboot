import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { getAllInvoice } from './model/invoice.model';
import { updateInvoice } from './model/invoiceupdate.model';
import { newInvoice } from './model/newInvoice.model';



@Injectable({
  providedIn: 'root'
})
export class InvoiceService {

  private baseUrl = "http://localhost:8080/invoices";

  constructor(private http: HttpClient) { }

  // Headers
  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  }

  getAllInvoice(): Observable<getAllInvoice[]> {
    return this.http.get<getAllInvoice[]>(this.baseUrl);
  }

  saveInvoice(invoice: newInvoice): Observable<newInvoice> {
    return this.http.post<newInvoice>(this.baseUrl, JSON.stringify(invoice), this.httpOptions);
  }

  getInvoiceFindByid(id: number): Observable<getAllInvoice> {
    return this.http.get<getAllInvoice>(this.baseUrl + '/' + id);
  }

  updateInvoice(id: string, invoice: updateInvoice): Observable<updateInvoice> {
    return this.http.put<updateInvoice>(this.baseUrl + '/' + id, JSON.stringify(invoice), this.httpOptions);
  }

  deleteInvoice(invoice: newInvoice) {
    return this.http.delete<newInvoice>(this.baseUrl + '/' + invoice.id, this.httpOptions);
  }



}
