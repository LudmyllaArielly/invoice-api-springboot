import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { getAllInvoice } from './model/invoice.model';
import { updateInvoice } from './model/invoiceupdate.model';
import { newInvoice } from './model/newInvoice.model';
import { retry, catchError } from 'rxjs/operators';


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

  saveInvoice(invoice: newInvoice): Observable<newInvoice> {
    return this.http.post<newInvoice>(this.baseUrl, invoice, this.httpOptions)
  }

  getInvoiceFindByid(id: string): Observable<getAllInvoice> {
    return this.http.get<getAllInvoice>(this.baseUrl + '/' + id);
  }

  getInvoiceFindByIdWithUserCpf(id: string): Observable<updateInvoice> {
    return this.http.get<updateInvoice>(this.baseUrl + '/findInvoiceWithUserCpf/' + id);
  }

  updateInvoice(invoice: updateInvoice): Observable<updateInvoice> {
    return this.http.put<updateInvoice>(this.baseUrl + '/', JSON.stringify(invoice), this.httpOptions);
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
