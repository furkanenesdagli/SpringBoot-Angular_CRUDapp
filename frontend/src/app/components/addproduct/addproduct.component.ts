import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ProductService } from 'src/app/product.service';
import { Product } from 'src/app/Product';
import { FormGroup, FormBuilder, Validators } from '@angular/forms'; // FormGroup ve FormBuilder eklendi

@Component({
  selector: 'app-addproduct',
  templateUrl: './addproduct.component.html',
  styleUrls: ['./addproduct.component.css']
})
export class AddproductComponent implements OnInit {

  form: FormGroup; // FormGroup tanımlandı

  constructor(private service: ProductService, private router: Router, private formBuilder: FormBuilder) { // FormBuilder eklendi
    this.form = this.formBuilder.group({ // FormGroup oluşturuldu
      name: ['', Validators.required],
      price: ['', Validators.required],
      stock: ['', Validators.required],
      description: ['', Validators.required]
    });
  }

  ngOnInit(): void {
  }

  submit(): void {
    if (this.form.valid) {
      this.service.addProduct(this.form.value).subscribe(() => {
        // Ürün ekleme işlemi başarılı olduğunda "/products" route'una yönlendirme yapılıyor
        this.router.navigate(['/products']);
      });
    } else {
      // Form geçersiz olduğunda hata mesajı gösterilebilir veya işlem yapılmayabilir
    }
  }
}
