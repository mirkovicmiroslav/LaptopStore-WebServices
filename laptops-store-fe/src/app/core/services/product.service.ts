import { environment } from "./../../../environments/environment.prod";
import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";

@Injectable({
  providedIn: "root"
})
export class ProductService {
  constructor(private http: HttpClient) {}

  public getAllProducts(): Observable<any> {
    return this.http.get(environment.url + "product/getAllProducts");
  }

  public getProduct(idProduct: number): Observable<any> {
    return this.http.get(environment.url + "product/getProduct/" + idProduct);
  }
}
