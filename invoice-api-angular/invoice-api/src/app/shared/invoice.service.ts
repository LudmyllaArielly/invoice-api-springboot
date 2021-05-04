import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { getAllInvoice } from './model/invoice.model';
import { UpdateInvoice } from './model/update-invoice.model';
import { NewInvoice } from './model/new-invoice.model';


@Injectable({
  providedIn: 'root'
})
export class InvoiceService {

  private baseUrl = "http://localhost:8080/invoices";

  constructor(private http: HttpClient) { }

  // Headers
  httpOptions = {
    headers: new HttpHeaders(
      { 'Content-Type': 'application/json', 'responseType': 'json' }
    )
  }

  getAllInvoice(): Observable<getAllInvoice[]> {
    return this.http.get<getAllInvoice[]>(this.baseUrl)
  }

  saveInvoice(invoice: NewInvoice): Observable<Object> {
    return this.http.post(this.baseUrl, invoice, { responseType: 'text' });
  }

  getInvoiceFindByid(id: string): Observable<getAllInvoice> {
    return this.http.get<getAllInvoice>(this.baseUrl + '/' + id);
  }

  getInvoiceFindByIdWithUserCpf(id: string): Observable<UpdateInvoice> {
    return this.http.get<UpdateInvoice>(this.baseUrl + '/findInvoiceWithUserCpf/' + id);
  }

  updateInvoice(invoice: UpdateInvoice): Observable<Object> {
    return this.http.put(this.baseUrl + '/', invoice, { responseType: 'text' });
  }

  deleteInvoice(id: string): Observable<Object> {
    return this.http.delete(this.baseUrl + '/' + id, this.httpOptions);
  }


  // manipular erros
  handlerError(error: HttpErrorResponse) {
    let errorMessage = '';
    if (error.error instanceof ErrorEvent) {
      // Erro do lado do cliente
      errorMessage = error.error.message;
    } else {
      // Erro do lado do servidor
      errorMessage = `Code error: ${error.status},` + `message: ${error.message}`;
    }
    console.log('Message error' + errorMessage)
    return throwError(errorMessage);
  }


}
