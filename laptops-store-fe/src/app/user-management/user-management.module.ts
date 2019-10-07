import { FormsModule } from "@angular/forms";
import { UserManagementRoutingModule } from "./user-management-routing.module";
import { NgModule } from "@angular/core";
import { CommonModule } from "@angular/common";
import { PaymentComponent } from "./payment/payment.component";

@NgModule({
  declarations: [PaymentComponent],
  imports: [CommonModule, FormsModule, UserManagementRoutingModule]
})
export class UserManagementModule {}
