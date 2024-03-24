import {Component, OnInit} from '@angular/core';
import {ProductService} from "../../services/product.service";
import {Product} from "../../models/product.model";
import {TableModule} from "primeng/table";

@Component({
  selector: 'app-car',
  standalone: true,
  imports: [
    TableModule
  ],
  templateUrl: './car.component.html',
  styleUrl: './car.component.css'
})
export class CarComponent implements OnInit {

  products!: Product[];

  constructor(private productService: ProductService) {
  }

  ngOnInit(): void {
    this.products = this.productService.getProductsData();
  }
}
