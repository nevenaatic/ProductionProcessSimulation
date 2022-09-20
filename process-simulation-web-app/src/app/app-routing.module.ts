import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FactoryComponent } from './components/factory/factory.component';
import { FailuresComponent } from './components/failures/failures.component';
import { HomePageComponent } from './components/home-page/home-page.component';
import { LoginPageComponent } from './components/login-page/login-page.component';
import { ProcessComponent } from './components/process/process.component';
import { ProductRevisionComponent } from './components/product-revision/product-revision.component';
import { ProductsComponent } from './components/products/products.component';
import { ProfileComponent } from './components/profile/profile.component';
import { StatisticsComponent } from './components/statistics/statistics.component';
import { WorkersComponent } from './components/workers/workers.component';
import { WorkersEngagementComponent } from './components/workers-engagement/workers-engagement.component';

const routes: Routes = [
  {
    path: 'homepage', component: HomePageComponent,
    children: [
      { path: 'my-profile', component: ProfileComponent },
      { path: 'process', component: ProcessComponent },
      { path: 'workers', component: WorkersComponent },
      { path: 'failures', component: FailuresComponent },
      { path: 'statistic', component: StatisticsComponent },
      { path: 'products', component: ProductsComponent },
      { path: 'factory', component: FactoryComponent },
      {path: 'product-revision', component: ProductRevisionComponent},
      {path: 'engagements', component: WorkersEngagementComponent}
    ]
  },
  { path: '', component: LoginPageComponent },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
