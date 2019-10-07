import { AdminManagementRoutingModule } from "./admin-management-routing.module";
import { FormsModule } from "@angular/forms";
import { NgModule } from "@angular/core";
import { CommonModule } from "@angular/common";
import { AddProductComponent } from "./add-product/add-product.component";

@NgModule({
  declarations: [AddProductComponent],
  imports: [CommonModule, FormsModule, AdminManagementRoutingModule]
})
export class AdminManagementModule {}
