import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { ProductService } from '../product.service';
import { CategoryService } from '../../categories/category.service';
import { Product } from '../../models/product.model';
import { Category } from '../../models/category.model';

@Component({
  selector: 'app-product-form',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './product-form.component.html'
})
export class ProductFormComponent implements OnInit {
  product: any = { name: '', price: 0, stock: 0, category: { id: 0 } };
  categories: Category[] = [];
  isEdit = false;

  constructor(
    private service: ProductService,
    private categoryService: CategoryService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit() {
    this.categoryService.list().subscribe(data => {
      this.categories = data;
    });

    const id = this.route.snapshot.params['id'];
    if (id) {
      this.isEdit = true;
      this.service.get(id).subscribe(data => {
        this.product = data;
      });
    }
  }

  save() {
    if (this.isEdit) {
      this.service.update(this.product.id, this.product).subscribe(() => {
        this.router.navigate(['/products']);
      });
    } else {
      this.service.create(this.product).subscribe(() => {
        this.router.navigate(['/products']);
      });
    }
  }
}
