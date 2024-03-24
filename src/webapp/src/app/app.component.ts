import {Component, OnInit} from '@angular/core';
import {MenuItem, PrimeNGConfig} from "primeng/api";
import {UserService} from "./services/user.service";
import {HeaderComponent} from "./main/header/header.component";
import {HomeComponent} from "./main/home/home.component";
import {ChildrenOutletContexts, RouterOutlet} from "@angular/router";
import {TabMenuModule} from "primeng/tabmenu";
import { AnimationEvent } from '@angular/animations';
import {routerTransition} from "./utils/router-transition";

@Component({
  selector: 'app-root',
  standalone: true,
  templateUrl: './app.component.html',
  imports: [
    HeaderComponent,
    HomeComponent,
    RouterOutlet,
    TabMenuModule,
  ],
  styleUrls: ['./app.component.css'],
  animations: [
    routerTransition
  ]
})
export class AppComponent implements OnInit{

  items: MenuItem[] | undefined;

  activeItem: MenuItem | undefined;

  title = 'Bogdan';

  constructor(private primengConfig: PrimeNGConfig,
              private userService: UserService,
              private contexts: ChildrenOutletContexts) {
    this.primengConfig.ripple = true;
  }

  onAnimationStart(event: AnimationEvent) {
    if (event.phaseName === 'start') {
      console.log('Route change animation started');
    }
  }

  onAnimationDone(event: AnimationEvent) {
    if (event.phaseName === 'done') {
      console.log('Route change animation stopped');
    }
  }


  ngOnInit(): void {
    this.items = [
      { label: 'Home', icon: 'pi pi-fw pi-home' , routerLink: './home'},
      { label: 'Cars', icon: 'pi pi-fw pi-calendar' , routerLink: './cars'},
    ];

    this.activeItem = this.items[0];


    this.primengConfig.ripple = true;
    this.primengConfig.zIndex = {
      modal: 1100,    // dialog, sidebar
      overlay: 1000,  // dropdown, overlaypanel
      menu: 1000,     // overlay menus
      tooltip: 1100   // tooltip
    };


   /* this.userService.getUser().subscribe({
      next: user => {
       console.log("User:"+user);
      },
      error: error => {
        console.log(error);
      }, complete: () => {
        console.log("User retrieved");
      }

    });*/
  }


  getState(outlet:any) {
    // Changing the activatedRouteData.state triggers the animation
    return outlet.activatedRouteData.state;
  }
}
