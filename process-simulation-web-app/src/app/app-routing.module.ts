import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FailuresComponent } from './components/failures/failures.component';
import { HomePageComponent } from './components/home-page/home-page.component';
import { LoginPageComponent } from './components/login-page/login-page.component';
import { ProcessComponent } from './components/process/process.component';
import { ProductsComponent } from './components/products/products.component';
import { ProfileComponent } from './components/profile/profile.component';
import { StatisticsComponent } from './components/statistics/statistics.component';
import { WorkersComponent } from './components/workers/workers.component';

const routes: Routes = [
  {
    path: 'homepage', component: HomePageComponent,
    children: [
      { path: 'my-profile', component: ProfileComponent },
      { path: 'process', component: ProcessComponent },
      { path: 'workers', component: WorkersComponent },
      { path: 'failures', component: FailuresComponent },
      { path: 'statistic', component: StatisticsComponent },
      { path: 'products', component: ProductsComponent }
    ]
  },
  { path: '', component: LoginPageComponent },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
