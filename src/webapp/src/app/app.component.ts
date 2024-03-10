import {Component, OnInit} from '@angular/core';
import {PrimeNGConfig} from "primeng/api";
import {UserService} from "./services/user.service";
import {HeaderComponent} from "./main/header/header.component";
import {HomeComponent} from "./main/home/home.component";

@Component({
  selector: 'app-root',
  standalone: true,
  templateUrl: './app.component.html',
  imports: [
    HeaderComponent,
    HomeComponent
  ],
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  title = 'Bogdan';

  constructor(private primengConfig: PrimeNGConfig,
              private userService: UserService) {
    this.primengConfig.ripple = true;
  }


  ngOnInit(): void {
    this.primengConfig.ripple = true;
    this.primengConfig.zIndex = {
      modal: 1100,    // dialog, sidebar
      overlay: 1000,  // dropdown, overlaypanel
      menu: 1000,     // overlay menus
      tooltip: 1100   // tooltip
    };


    this.userService.getUser().subscribe({
      next: user => {
       console.log("User:"+user);
      },
      error: error => {
        console.log(error);
      }, complete: () => {
        console.log("User retrieved");
      }

    });
  }
}
