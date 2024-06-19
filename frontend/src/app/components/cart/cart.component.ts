import { Component, OnInit } from '@angular/core';
import { CartService } from 'src/app/cart.service';
import { Cart } from 'src/app/Cart';
import { Router } from '@angular/router';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {

  cartItems: Cart[] = [];

  constructor(private cartService: CartService, private router: Router) { }

  ngOnInit(): void {
    this.getCartItems();
  }

  getCartItems(): void {
    this.cartService.getProducts().subscribe(items => {
      this.cartItems = items;
    });
  }

  addToCart(id: number): void {
    this.cartService.addProduct(id, 1).subscribe(item => {
      if (item && typeof item === 'object' && Object.keys(item).length > 0) {
        this.cartItems.push(item);
        this.router.navigate(['/cart']); // Navigate to cart page
      }
    }, error => {
      if (error.status === 404) {
        alert("Product not found.");
      } else {
        alert("An error occurred.");
      }
    });
  }

  getTotal() {
    return this.cartItems.reduce((acc, item) => acc + item.product.price * item.quantity, 0);
  }

  deleteItem(id: number) {
    this.cartService.deleteProductFromCart(id).subscribe(() => {
      this.cartItems = this.cartItems.filter(item => item.id !== id);
    });
  }
}
