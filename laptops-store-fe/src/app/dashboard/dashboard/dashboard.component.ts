import { AuthenticationService } from "./../../core/services/authentication.service";
import { ToastrService } from "ngx-toastr";
import { AllProducts } from "./../../core/models/allProducts..model";
import { ProductService } from "./../../core/services/product.service";
import { Router } from "@angular/router";
import { Component, OnInit } from "@angular/core";
import { DomSanitizer } from "@angular/platform-browser";

@Component({
  selector: "app-dashboard",
  templateUrl: "./dashboard.component.html",
  styleUrls: ["./dashboard.component.css"]
})
export class DashboardComponent implements OnInit {
  productData: AllProducts = new AllProducts();
  isUser: boolean;
  isAdmin: boolean;
  productImage = [];

  constructor(
    private router: Router,
    private toastr: ToastrService,
    private productService: ProductService,
    private authService: AuthenticationService,
    private sanitizer: DomSanitizer
  ) {}

  ngOnInit() {
    this.getAllProducts();
    this.isUser = this.authService.isUser();
    this.isAdmin = this.authService.isAdmin();
  }

  getAllProducts() {
    this.productService.getAllProducts().subscribe(
      response => {
        this.productData = response;
        for (var i = 0; i < this.productData.products.length; i++) {
          this.productImage[
            i + 1
          ] = this.sanitizer.bypassSecurityTrustResourceUrl(
            "data:image/png;base64," + response.products[i].image
          );
        }
      },
      error => {
        this.toastr.error("Failed to get products");
      }
    );
  }

  onBuy(idProduct) {
    if (this.isUser) {
      this.router.navigate(["user/payment/" + idProduct]);
    } else {
      this.toastr.error("Please sign in to continue");
    }
  }
}
