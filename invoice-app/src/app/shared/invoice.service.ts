import { HttpClient} from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { retry, catchError } from 'rxjs/operators';
import { getAllInvoice } from './model/invoice.model';
import { NewInvoice } from './model/new-update-invoice.model';
import { UpdateStatusInvoice } from './model/update-status-invoice.model';


@Injectable({
  providedIn: 'root'
})
export class InvoiceService {

  private baseUrl = "https://invoice-api-ludmylla.herokuapp.com/invoices";

  constructor(private http: HttpClient) { }

  getAllInvoice(): Observable<getAllInvoice[]> {
    return this.http.get<getAllInvoice[]>(this.baseUrl)
    .pipe (
      retry(1),
      catchError(this.handlerError)
    );
  }

  saveInvoice(invoice: NewInvoice): Observable<Object> {
    return this.http.post(this.baseUrl, invoice, { responseType: 'text' })
    .pipe (
      retry(1),
      catchError(this.handlerError)
    );
  }

  getInvoiceFindById(id: string): Observable<getAllInvoice> {
    return this.http.get<getAllInvoice>(this.baseUrl + '/' + id)
    .pipe (
      retry(1),
      catchError(this.handlerError)
    );
  }

  getInvoiceFindByIdWithUserCpf(id: number): Observable<NewInvoice> {
    return this.http.get<NewInvoice>(this.baseUrl + '/findInvoiceWithUserCpf/' + id)
    .pipe (
      retry(1),
      catchError(this.handlerError)
    );
  }

  updateStatus(invoice: UpdateStatusInvoice): Observable<Object> {
    return this.http.patch(this.baseUrl + '/status/', invoice, { responseType: 'text' }).pipe (
      retry(1),
      catchError(this.handlerError)
    );
  }

  updateInvoice(invoice: NewInvoice): Observable<Object> {
    return this.http.put(this.baseUrl + '/', invoice, { responseType: 'text' })
    .pipe (
      retry(1),
      catchError(this.handlerError)
    );
  }

  deleteInvoice(id: string): Observable<Object> {
    return this.http.delete(this.baseUrl + '/' + id, { responseType: 'text' })
    .pipe (
      retry(1),
      catchError(this.handlerError)
    );
  }

  // Error handling
  handlerError(error) {
    let errorMessage = '';
    if(error.error instanceof ErrorEvent){
      // Get client side error
      errorMessage = error.error.message;
    }else {
      errorMessage = `Error code: ${error.status}\nMessage: ${error.message}`;
    }
    // window.alert(errorMessage);
    return throwError(errorMessage);
  }
}


