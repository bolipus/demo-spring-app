import {Component, OnInit} from '@angular/core';
import {UserService} from "../../services/user.service";
import {User} from "../../models/user.model";

@Component({
  selector: 'app-home',
  standalone: false,
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent implements OnInit{
  activeIndex :number  = 1;
  rounded : boolean = true;

  user!: User;


  constructor(private userService: UserService) {

  }

  ngOnInit(): void {

      this.userService.getUser().subscribe(user => this.user = user);
  }
}
