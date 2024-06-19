import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders, HttpParams} from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CartService {

  private url = "http://localhost:8080/api/v1/carts";

  constructor(private http: HttpClient) { }

  // Add Product - Create
  addProduct(productId: number, quantity: number): Observable<any> {
    return this.http.post(`${this.url}?productId=${productId}&quantity=${quantity}`, null);
  }

  // Delete Product - Delete
  deleteProductFromCart(id: number): Observable<any> {
    return this.http.delete(`${this.url}/${id}`);

  }

  // Get Products - Read
  getProducts(): Observable<any[]> {
    return this.http.get<any[]>(`${this.url}`);
  }
}
