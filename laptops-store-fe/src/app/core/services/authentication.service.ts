import { Login } from "./../models/login.model";
import { environment } from "./../../../environments/environment";
import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { User } from "../models/register.model";

@Injectable({
  providedIn: "root"
})
export class AuthenticationService {
  constructor(private http: HttpClient) {}

  public isAuthenticated(): boolean {
    if (localStorage.getItem("token")) {
      return true;
    }
    return false;
  }

  public isUser() {
    const decodedToken = atob(localStorage.getItem("token"));
    var token = decodedToken.split(":", 3);
    var role = token[2];
    if (decodedToken != null) {
      if (role === "USER") {
        return true;
      }
    }
    return false;
  }

  public isAdmin() {
    const decodedToken = atob(localStorage.getItem("token"));
    var token = decodedToken.split(":", 3);
    var role = token[2];

    if (decodedToken != null) {
      if (role == "ADMIN") {
        return true;
      }
    }
    return false;
  }

  public login(loginData: Login): Observable<any> {
    return this.http.post(environment.url + "login", loginData);
  }

  public register(userData: User): Observable<any> {
    return this.http.post(environment.url + "register", userData);
  }
  public getUserFirstName(): Observable<any> {
    return this.http.get(environment.url + "getUserFirstName");
  }
}
