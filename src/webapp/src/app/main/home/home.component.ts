import {Component, OnInit} from '@angular/core';
import {UserService} from "../../services/user.service";
import {User} from "../../models/user.model";
import {JsonPipe} from "@angular/common";
import {RouterLink, RouterOutlet} from "@angular/router";
import {CalendarModule} from "primeng/calendar";
import {FormsModule} from "@angular/forms";

@Component({
  selector: 'app-home',
  standalone: true,
  templateUrl: './home.component.html',
  imports: [
    JsonPipe,
    RouterLink,
    RouterOutlet,
    CalendarModule,
    FormsModule
  ],
  styleUrl: './home.component.css'
})
export class HomeComponent implements OnInit{
  activeIndex :number  = 1;
  rounded : boolean = true;

  user!: User;
  date = new Date();


  constructor(private userService: UserService) {

  }

  ngOnInit(): void {

     /* this.userService.getUser().subscribe({
        next: user => {
          this.user = user;
          console.log("User:"+ this.user);
        },
        error: error => {
          console.log(error);
        }, complete: () => {
          console.log("User retrieved");
        }

      });-*/
  }
}
