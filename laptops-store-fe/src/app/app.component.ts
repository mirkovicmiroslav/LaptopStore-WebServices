import { AuthenticationService } from "./core/services/authentication.service";
import { Router } from "@angular/router";
import { Component, OnInit } from "@angular/core";
import { TokenService } from "./core/services/token-service.service";

@Component({
  selector: "app-root",
  templateUrl: "./app.component.html",
  styleUrls: ["./app.component.css"]
})
export class AppComponent implements OnInit {
  title = "Laptops Store";
  isLoggedIn: boolean;
  isUser: boolean;
  isAdmin: boolean;
  userFirstName: string;

  constructor(
    private router: Router,
    private tokenService: TokenService,
    private authService: AuthenticationService
  ) {}

  ngOnInit() {
    this.isUserLoggedIn();
    if (this.isLoggedIn) {
      this.getUserFirstName();
    }
    this.isUser = this.authService.isUser();
    this.isAdmin = this.authService.isAdmin();
  }

  isUserLoggedIn() {
    this.isLoggedIn = this.authService.isAuthenticated();
  }

  onLogout() {
    this.tokenService.destroyToken();
    this.router.navigate(["/login"]);
    window.location.reload();
  }
  getUserFirstName() {
    this.authService.getUserFirstName().subscribe(response => {
      this.userFirstName = response.firstName;
    });
  }
}
