import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { getAllInvoice } from './model/invoice.model';

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

}
