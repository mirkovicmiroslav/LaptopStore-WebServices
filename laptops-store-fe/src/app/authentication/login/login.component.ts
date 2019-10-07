import { TokenService } from "./../../core/services/token-service.service";
import { AuthenticationService } from "./../../core/services/authentication.service";
import { Login } from "./../../core/models/login.model";
import { Component, OnInit, ViewChild } from "@angular/core";
import { NgForm } from "@angular/forms";
import { ToastrService } from "ngx-toastr";
import { Router, ActivatedRoute } from "@angular/router";

@Component({
  selector: "app-login",
  templateUrl: "./login.component.html",
  styleUrls: ["./login.component.css"]
})
export class LoginComponent implements OnInit {
  loginData: Login = new Login();

  @ViewChild("loginForm")
  loginForm: NgForm;

  constructor(
    private authService: AuthenticationService,
    private tokenService: TokenService,
    private toastr: ToastrService,
    private router: Router
  ) {}
  ngOnInit() {}

  onLogin() {
    this.authService.login(this.loginData).subscribe(
      response => {
        this.tokenService.saveToken(response.accessToken);
        this.router.navigate(["/"]);
      },
      error => {
        this.toastr.error("Incorrect email or password", "Unable to login");
      }
    );
  }
}
