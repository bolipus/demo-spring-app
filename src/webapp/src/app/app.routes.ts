import { Routes } from '@angular/router';
import {HomeComponent} from "./main/home/home.component";
import {CarComponent} from "./main/car/car.component";

let CarPartComponent;
export const routes: Routes = [
  { path: '', redirectTo: '/home', pathMatch: 'full' },
  { path: 'home', component: HomeComponent , data: { state: 'home' }},
  { path: 'cars', component: CarComponent, data: { state: 'cars' }},
];
