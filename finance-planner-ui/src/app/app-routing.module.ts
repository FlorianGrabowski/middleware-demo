import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {DashboardComponent} from "./dashboard/dashboard.component";

export const APP_ROUTES = {
  DASHBOARD: {
    route: 'dashboard',
    path: '/dashboard'
  }
}

const routes: Routes = [
  {path: '', redirectTo: APP_ROUTES.DASHBOARD.route, pathMatch: 'full'},
  {path: APP_ROUTES.DASHBOARD.route, component: DashboardComponent},
]

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
