import { AdminService } from "./../../core/services/admin.service";
import { NgForm } from "@angular/forms";
import { DomSanitizer } from "@angular/platform-browser";
import { Product } from "./../../core/models/product.model";
import { AuthenticationService } from "./../../core/services/authentication.service";
import { ProductService } from "./../../core/services/product.service";
import { Router, ActivatedRoute } from "@angular/router";
import { Component, OnInit, ViewChild } from "@angular/core";
import { ToastrService } from "ngx-toastr";

@Component({
  selector: "app-product",
  templateUrl: "./product.component.html",
  styleUrls: ["./product.component.css"]
})
export class ProductComponent implements OnInit {
  productData: Product = new Product();
  idProduct;
  isUser: boolean;
  isAdmin;
  changeProductImage: boolean;
  productImage;
  imageUpload;
  image;

  @ViewChild("updateProductForm")
  updateProductForm: NgForm;

  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private toastr: ToastrService,
    private productService: ProductService,
    private authService: AuthenticationService,
    private adminService: AdminService,
    private sanitizer: DomSanitizer
  ) {}

  ngOnInit() {
    this.route.params.subscribe(params => {
      if (params["idProduct"]) {
        this.idProduct = params["idProduct"];
        this.getProduct(params["idProduct"]);
      }
    });
    this.isUser = this.authService.isUser();
    this.isAdmin = this.authService.isAdmin();
  }

  getProduct(idProduct) {
    this.productService.getProduct(idProduct).subscribe(
      response => {
        this.productData = response;
        this.productImage = this.sanitizer.bypassSecurityTrustResourceUrl(
          "data:image/png;base64," + response.image
        );
      },
      error => {
        this.toastr.error("Failed to get product");
      }
    );
  }

  onBuy() {
    if (this.isUser) {
      this.router.navigate(["user/payment/" + this.idProduct]);
    } else {
      this.toastr.error("Please sign in to continue");
    }
  }

  onFileSelected(event) {
    this.imageUpload = event.target.files[0];
    this.changeProductImage = true;
    let reader = new FileReader();

    reader.onload = (e: any) => {
      this.image = e.target.result;
    };

    reader.readAsDataURL(this.imageUpload);
  }

  onUpdateProduct() {
    this.onUploadImage();
  }

  onUploadImage() {
    if (this.changeProductImage) {
      this.adminService.uploadImage(this.imageUpload).subscribe(
        response => {
          this.uploadProductHelper();
        },
        error => {
          this.toastr.error("Failed to upload image");
        }
      );
    } else {
      this.uploadProductHelper();
    }
  }

  uploadProductHelper() {
    this.adminService.updateProduct(this.productData).subscribe(
      response => {
        this.toastr.success("Successfuly updated product");
        this.router.navigate(["/"]);
      },
      error => {
        this.toastr.error("Failed to update product");
      }
    );
  }
}
