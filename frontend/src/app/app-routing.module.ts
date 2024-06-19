import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddproductComponent } from './components/addproduct/addproduct.component';
import { UpdateproductComponent } from './components/updateproduct/updateproduct.component';
import { ViewproductsComponent } from './components/viewproducts/viewproducts.component';
import { CartComponent } from './components/cart/cart.component';

const routes: Routes = [
  { path: 'products', component: ViewproductsComponent },
  { path: '', component: ViewproductsComponent },
  { path: 'add', component: AddproductComponent },
  { path: 'update/:id', component: UpdateproductComponent },
  { path: 'cart', component: CartComponent }, // 'cart' rotasını parametre almayacak şekilde düzenliyoruz.
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
