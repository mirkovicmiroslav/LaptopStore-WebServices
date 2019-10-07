import { ProductService } from "./../../core/services/product.service";
import { Router, ActivatedRoute } from "@angular/router";
import { ToastrService } from "ngx-toastr";
import { UserService } from "./../../core/services/user.service";
import { NgForm } from "@angular/forms";
import { Payment } from "./../../core/models/payment.model";
import { Component, OnInit, ViewChild } from "@angular/core";

@Component({
  selector: "app-payment",
  templateUrl: "./payment.component.html",
  styleUrls: ["./payment.component.css"]
})
export class PaymentComponent implements OnInit {
  paymentData: Payment = new Payment();
  idProduct;
  item;

  @ViewChild("paymentForm")
  paymentForm: NgForm;

  constructor(
    private userService: UserService,
    private productService: ProductService,
    private router: Router,
    private route: ActivatedRoute,
    private toastr: ToastrService
  ) {}

  ngOnInit() {
    this.route.params.subscribe(params => {
      if (params["idProduct"]) {
        this.idProduct = params["idProduct"];
        this.getProduct(this.idProduct);
      }
    });
  }

  getProduct(idProduct) {
    this.productService.getProduct(idProduct).subscribe(
      response => {
        this.item = response.brand;
        this.paymentData.amount = response.price;
      },
      error => {
        this.toastr.error("Failed to get product");
      }
    );
  }

  onPayment() {
    console.log(this.paymentData.cardNumber);
    console.log(this.paymentData.expirationDate);
    console.log(this.paymentData.cvc2);
    this.userService.addPayment(this.paymentData, this.idProduct).subscribe(
      response => {
        if (response == true) {
          this.toastr.success("Successful buy!");
          this.router.navigate(["/"]);
        } else {
          this.toastr.error("Failed. Incorrect data..");
        }
      },
      error => {
        this.toastr.error("Failed! Connection problem..");
      }
    );
  }
}
