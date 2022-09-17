import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-sidenav',
  templateUrl: './sidenav.component.html',
  styleUrls: ['./sidenav.component.css']
})
export class SidenavComponent implements OnInit {

  processEngineer: boolean = false;
  qualityEngineer: boolean = false;
  productManager: boolean = false;
  employee: boolean = false;
  username: string='';

  constructor() { }

  ngOnInit(): void {
    this.whoAmI()
  }

  public readonly whoAmI = () => {
    if (localStorage.getItem('role') == 'ROLE_PROCESS_ENGINEER') {
      this.processEngineer = true;
    }
    if (localStorage.getItem('role') == 'ROLE_QUALITY_ENGINEER') {
      this.qualityEngineer = true;
    } if (localStorage.getItem('role') == 'ROLE_PRODUCTION_MANAGER') {
      this.productManager = true;
    } if (localStorage.getItem('role') == 'ROLE_EMPLOYEE') {
      this.employee = true;
    }
  }
}
