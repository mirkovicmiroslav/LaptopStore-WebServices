import { Observable } from "rxjs";
import { environment } from "./../../../environments/environment";
import { Payment } from "./../models/payment.model";
import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";

@Injectable({
  providedIn: "root"
})
export class UserService {
  constructor(private http: HttpClient) {}

  public addPayment(paymentData: Payment, idProduct): Observable<any> {
    return this.http.post(
      environment.url + "user/payment/" + idProduct,
      paymentData
    );
  }
}
