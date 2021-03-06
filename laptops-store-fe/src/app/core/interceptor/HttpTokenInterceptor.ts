import { TokenService } from "./../services/token-service.service";
import { Injectable } from "@angular/core";
import {
  HttpEvent,
  HttpInterceptor,
  HttpHandler,
  HttpRequest
} from "@angular/common/http";
import { Observable } from "rxjs";

@Injectable()
export class HttpTokenInterceptor implements HttpInterceptor {
  constructor(public tokenService: TokenService) {}

  intercept(
    request: HttpRequest<any>,
    next: HttpHandler
  ): Observable<HttpEvent<any>> {
    request = request.clone({
      setHeaders: {
        Authorization: `Basic ${this.tokenService.getToken()}`
      }
    });

    return next.handle(request);
  }
}
