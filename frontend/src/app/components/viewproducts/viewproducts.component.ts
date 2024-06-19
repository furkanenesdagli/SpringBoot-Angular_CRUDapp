import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ProductService } from 'src/app/product.service';
import { CartService } from 'src/app/cart.service'; // CartService'ı import ediyoruz.
import { Product } from 'src/app/Product';

@Component({
  selector: 'app-viewproducts',
  templateUrl: './viewproducts.component.html',
  styleUrls: ['./viewproducts.component.css']
})
export class ViewproductsComponent implements OnInit {

  products: Product[] | undefined;
  cartItems: any[] = []; // cartItems dizisini tanımlıyoruz.

  constructor(private service: ProductService, private router: Router, private cartService: CartService) { } // cartService'ı CartService olarak enjekte ediyoruz.


  ngOnInit(): void {
    this.service.getProducts().subscribe(data => {
      this.products = data;
    });
  }
  deleteProduct(id: number): void {

    this.service.deleteProduct(id).subscribe(() => {
      this.products = this.products?.filter(product => product.id !== id);});
  }
  updateProduct(id: number): void {
    this.router.navigate(['update/', id]);
  }
  addToCart = (id: number) => {
    this.cartService.addProduct(id, 1).subscribe((response: any) => {
      if (response && typeof response === 'object' && Object.keys(response).length > 0) {
        this.cartItems.push(response);
        alert("Product added to cart."); // Display an alert
        this.router.navigate(['/cart']).then(() => {
          window.location.reload();
        });
      }
    }, error => {
      if (error.status === 404) {
        console.error("Product not found.");
      } else {
        console.error("An error occurred.");
        console.error(error);
      }
    });
  }



  getTotal() {
    return this.cartItems.reduce((acc, item) => acc + item.product.price * item.quantity, 0);
  }

}
