import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { CategoryService } from '../category.service';
import { Category } from '../../models/category.model';

@Component({
  selector: 'app-category-form',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './category-form.component.html'
})
export class CategoryFormComponent implements OnInit {
  category: Category = { name: '', description: '' };
  isEdit = false;

  constructor(
    private service: CategoryService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit() {
    const id = this.route.snapshot.params['id'];
    if (id) {
      this.isEdit = true;
      this.service.get(id).subscribe(data => {
        this.category = data;
      });
    }
  }

  save() {
    if (this.isEdit) {
      this.service.update(this.category.id!, this.category).subscribe(() => {
        this.router.navigate(['/categories']);
      });
    } else {
      this.service.create(this.category).subscribe(() => {
        this.router.navigate(['/categories']);
      });
    }
  }
}
