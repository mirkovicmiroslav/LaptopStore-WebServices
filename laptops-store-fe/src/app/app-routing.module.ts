import { IsUserGuard } from "./core/guards/isUser.guard";
import { NgModule } from "@angular/core";
import { Routes, RouterModule } from "@angular/router";
import { IsAdminGuard } from "./core/guards/isAdmin.guard";

const routes: Routes = [
  {
    path: "",
    loadChildren: "./dashboard/dashboard.module#DashboardModule"
  },
  {
    path: "",
    loadChildren: "./authentication/authentication.module#AuthenticationModule"
  },
  {
    path: "product",
    loadChildren: "./products/products.module#ProductsModule"
  },
  {
    path: "admin",
    loadChildren:
      "./admin-management/admin-management.module#AdminManagementModule",
    canActivate: [IsAdminGuard]
  },
  {
    path: "user",
    loadChildren:
      "./user-management/user-management.module#UserManagementModule",
    canActivate: [IsUserGuard]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes, { useHash: true })],
  exports: [RouterModule]
})
export class AppRoutingModule {}
