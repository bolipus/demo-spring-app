import { Routes } from '@angular/router';
import {HomeComponent} from "./main/home/home.component";
import {CarComponent} from "./main/car/car.component";
import {CarPartsComponent} from "./main/car-parts/car-parts.component";

let CarPartComponent;
export const routes: Routes = [
  { path: '', redirectTo: '/home', pathMatch: 'full' },
  { path: 'home', component: HomeComponent },
  { path: 'cars', component: CarComponent},
  { path: 'cars/:id', component: CarPartsComponent},
  { path: 'cars/details/:id', component: CarPartsComponent}
];
