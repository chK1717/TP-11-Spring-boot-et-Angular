import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { CategoryService } from '../category.service';
import { Category } from '../../models/category.model';

@Component({
  selector: 'app-category-list',
  standalone: true,
  imports: [CommonModule, RouterModule],
  templateUrl: './category-list.component.html'
})
export class CategoryListComponent implements OnInit {
  categories: Category[] = [];

  constructor(private service: CategoryService) {}

  ngOnInit() {
    this.loadCategories();
  }

  loadCategories() {
    this.service.list().subscribe(data => {
      this.categories = data;
    });
  }

  delete(id: number) {
    if (confirm('Êtes-vous sûr de vouloir supprimer cette catégorie ?')) {
      this.service.delete(id).subscribe(() => {
        this.loadCategories();
      });
    }
  }
}
