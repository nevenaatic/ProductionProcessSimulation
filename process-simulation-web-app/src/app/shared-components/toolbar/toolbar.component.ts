import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from 'src/app/services/authentication.service';

@Component({
  selector: 'app-toolbar',
  templateUrl: './toolbar.component.html',
  styleUrls: ['./toolbar.component.css']
})
export class ToolbarComponent implements OnInit {
  showMenu = false
  constructor(private authService: AuthenticationService) { }

  ngOnInit(): void {
  }

  public readonly signout = () => this.authService.signOut();
}
