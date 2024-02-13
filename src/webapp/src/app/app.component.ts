import {Component, OnInit} from '@angular/core';
import {PrimeNGConfig} from "primeng/api";
import {UserService} from "./services/user.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
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

   this.userService.getUser().subscribe(data => {
     console.log(data);
   })
  }
}
