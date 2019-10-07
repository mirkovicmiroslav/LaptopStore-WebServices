import { Router } from "@angular/router";
import { AuthenticationService } from "./../../core/services/authentication.service";
import { NgForm } from "@angular/forms";
import { Component, OnInit, ViewChild } from "@angular/core";
import { User } from "src/app/core/models/register.model";
import { ToastrService } from "ngx-toastr";

@Component({
  selector: "app-register",
  templateUrl: "./register.component.html",
  styleUrls: ["./register.component.css"]
})
export class RegisterComponent implements OnInit {
  userData: User = new User();
  rPassword: String = "";

  @ViewChild("signUpForm")
  signUpForm: NgForm;

  constructor(
    private authService: AuthenticationService,
    private router: Router,
    private toastr: ToastrService
  ) {}
  ngOnInit() {}

  onRegister() {
    if (this.rPassword !== this.userData.password) {
      this.toastr.error("Passwords do not match!", "Unable to register");
    } else {
      this.authService.register(this.userData).subscribe(
        response => {
          this.toastr.success("Successfully registration");
          this.router.navigate(["/login"]);
        },
        error => {
          this.toastr.error(
            "Email address already exist",
            "Unable to register"
          );
        }
      );
    }
  }
}
