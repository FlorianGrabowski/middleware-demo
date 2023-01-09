import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {DashboardComponent} from "./dashboard/dashboard.component";
import {AccountCreatorComponent} from "./account-creator/account-creator.component";

export const APP_ROUTES = {
  DASHBOARD: {
    route: 'dashboard',
    path: '/dashboard',
  },
  ACCOUNT_CREATOR: {
    route: 'new/account',
    path: '/new/account'
  }
}

const routes: Routes = [
  {path: '', redirectTo: APP_ROUTES.DASHBOARD.route, pathMatch: 'full'},
  {path: APP_ROUTES.DASHBOARD.route, component: DashboardComponent},
  {path: APP_ROUTES.ACCOUNT_CREATOR.route, component: AccountCreatorComponent}
]

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
