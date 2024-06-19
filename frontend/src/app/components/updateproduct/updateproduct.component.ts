import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { ProductService } from 'src/app/product.service';
import { Product } from 'src/app/Product';

@Component({
  selector: 'app-updateproduct',
  templateUrl: './updateproduct.component.html',
  styleUrls: ['./updateproduct.component.css']
})
export class UpdateproductComponent implements OnInit {

  product?: Product;
  data: any;

  constructor(private service: ProductService, private route: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    const id = this.route.snapshot.params['id'];
    if (id) {
      this.service.getProductById(id).subscribe(data => {
        this.product = data;
        console.log(this.product);
        this.form.setValue({
          name: this.product?.name,
          price: this.product?.price,
          stock: this.product?.stock,
          description: this.product?.description
        });
      });
    } else {
      console.error("No ID provided.");
    }
  }

  form = new FormGroup({
    name: new FormControl('', Validators.required),
    price: new FormControl('', Validators.required),
    stock: new FormControl('', Validators.required),
    description: new FormControl('', Validators.required)
  });

  submit(): void {
    if (this.form.valid) {
      if (this.product && this.product.id !== undefined) {
        let updatedProduct: Product = {
          id: this.product.id,
          name: this.form.value.name !== undefined && this.form.value.name !== null ? this.form.value.name : '',
          price: this.form.value.price !== undefined && this.form.value.price !== null ? this.form.value.price : '',
          stock: this.form.value.stock !== undefined && this.form.value.stock !== null ? this.form.value.stock : '',
          description: this.form.value.description !== undefined && this.form.value.description !== null ? this.form.value.description : ''

        };
        this.service.updateProduct(this.product.id, updatedProduct).subscribe(() => {
          this.router.navigate(['/products']);
        });
      } else {
        console.error("Product or product ID is undefined.");
      }
    } else {
      console.error("Form is invalid.");
    }
  }
}
