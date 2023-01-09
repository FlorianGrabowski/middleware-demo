import {Component} from '@angular/core';
import {Router} from '@angular/router';
import {APP_ROUTES} from "../app-routing.module";

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss']
})
export class DashboardComponent {

  constructor(private router: Router) {
  }

  public changeToAccountCreator(): void {
    this.router.navigate([APP_ROUTES.ACCOUNT_CREATOR.path]);
  }
}
