import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from 'src/app/services/authentication.service';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-toolbar',
  templateUrl: './toolbar.component.html',
  styleUrls: ['./toolbar.component.css']
})
export class ToolbarComponent implements OnInit {
  showMenu = false
  username: string =""
  constructor(private authService: AuthenticationService,private userService: UserService) { }

  ngOnInit(): void {
    this.getUsername()
  }

  public readonly signout = () => this.authService.signOut();

  public readonly getUsername = ()=> this.userService.getProfileInfo().subscribe( res => this.username = res.name)
}
