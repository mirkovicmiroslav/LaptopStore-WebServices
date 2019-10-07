import { AuthenticationService } from "./../services/authentication.service";
import { Injectable } from "@angular/core";
import { Router, CanActivate, ActivatedRouteSnapshot } from "@angular/router";

@Injectable()
export class IsUserGuard implements CanActivate {
  constructor(
    private authService: AuthenticationService,
    private router: Router
  ) {}

  canActivate(route: ActivatedRouteSnapshot): boolean {
    if (this.authService.isUser()) {
      return true;
    }
    this.router.navigate(["/"]);
    return false;
  }
}
