import { AdminService } from "./../../core/services/admin.service";
import { Router } from "@angular/router";
import { NgForm } from "@angular/forms";
import { Component, OnInit, ViewChild } from "@angular/core";
import { Product } from "src/app/core/models/product.model";
import { ToastrService } from "ngx-toastr";

@Component({
  selector: "app-add-product",
  templateUrl: "./add-product.component.html",
  styleUrls: ["./add-product.component.css"]
})
export class AddProductComponent implements OnInit {
  productData: Product = new Product();
  productImage;
  imageUpload;
  changeProductImage: boolean = false;

  @ViewChild("addProductForm")
  addProductForm: NgForm;

  constructor(
    private router: Router,
    private toastr: ToastrService,
    private adminService: AdminService
  ) {}

  ngOnInit() {}

  onFileSelected(event) {
    this.imageUpload = event.target.files[0];
    let reader = new FileReader();
    this.changeProductImage = true;

    reader.onload = (e: any) => {
      this.productImage = e.target.result;
    };

    reader.readAsDataURL(this.imageUpload);
  }

  onAddProduct() {
    this.onUploadImage();
  }

  onUploadImage() {
    if (this.changeProductImage) {
      this.adminService.uploadImage(this.imageUpload).subscribe(
        response => {
          this.addProductHelper();
        },
        error => {
          this.toastr.error("Failed to upload image");
        }
      );
    }
  }

  addProductHelper() {
    this.adminService.addProduct(this.productData).subscribe(
      response => {
        this.toastr.success("Successfuly added new product");
        this.router.navigate(["/"]);
      },
      error => {
        this.toastr.error("Failed to add new product");
      }
    );
  }
}
