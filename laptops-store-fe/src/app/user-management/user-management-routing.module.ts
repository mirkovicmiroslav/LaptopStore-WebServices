import { NgModule } from "@angular/core";
import { Routes, RouterModule } from "@angular/router";
import { PaymentComponent } from "./payment/payment.component";

const routes: Routes = [
  { path: "payment/:idProduct", component: PaymentComponent }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class UserManagementRoutingModule {}
