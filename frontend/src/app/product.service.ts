import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Product } from './Product';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  private url = "http://localhost:8080/api/v1/products";

  constructor(private http: HttpClient) { }

  // Add Product - Create
  addProduct(product: Product): Observable<Product> {
    return this.http.post<Product>(`${this.url}`, product);
  }

  // Get Products - Read
  getProducts(): Observable<any[]> {
    return this.http.get<any[]>(`${this.url}`);
  }

  getProductById(id: number): Observable<Product> {
    return this.http.get<Product>(`${this.url}/${id}`);
  }

  updateProduct(id: number, product: Product): Observable<any> {
    return this.http.put<any>(`${this.url}/${id}`, product);
  }

  deleteProduct(id: number, options?: any): Observable<any> {
    return this.http.delete(`${this.url}/${id}`, options);
  }
}
