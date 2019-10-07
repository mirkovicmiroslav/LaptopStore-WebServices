import { IsUserGuard } from "./guards/isUser.guard";
import { TokenService } from "./services/token-service.service";
import { AuthenticationService } from "./services/authentication.service";
import { HttpTokenInterceptor } from "./interceptor/HttpTokenInterceptor";
import { HttpClientModule, HTTP_INTERCEPTORS } from "@angular/common/http";
import { NgModule } from "@angular/core";
import { CommonModule } from "@angular/common";
import { IsAdminGuard } from "./guards/isAdmin.guard";

@NgModule({
  declarations: [],
  providers: [
    { provide: HTTP_INTERCEPTORS, useClass: HttpTokenInterceptor, multi: true },
    AuthenticationService,
    TokenService,
    IsAdminGuard,
    IsUserGuard
  ],
  imports: [CommonModule],
  exports: [HttpClientModule]
})
export class CoreModule {}
