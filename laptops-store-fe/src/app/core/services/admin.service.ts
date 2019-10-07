import { Observable } from "rxjs";
import { environment } from "./../../../environments/environment.prod";
import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Product } from "../models/product.model";

@Injectable({
  providedIn: "root"
})
export class AdminService {
  constructor(private http: HttpClient) {}

  public updateProduct(productData: Product): Observable<any> {
    return this.http.put(environment.url + "admin/updateProduct", productData);
  }
  public addProduct(productData: Product): Observable<any> {
    return this.http.post(environment.url + "admin/addProduct", productData);
  }

  public uploadImage(image: File) {
    const formData: FormData = new FormData();
    formData.append("image", image, image.name);
    console.log(image.name);
    return this.http.post(environment.url + "admin/uploadImage", formData);
  }
}
