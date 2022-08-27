import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { HomePageComponent } from './components/home-page/home-page.component';
import { LoginPageComponent } from './components/login-page/login-page.component';
import { ProcessComponent } from './components/process/process.component';
import { ProfileComponent } from './components/profile/profile.component';
import { WorkersComponent } from './components/workers/workers.component';

const routes: Routes = [
  { path: 'homepage', component: HomePageComponent, children: [ 
    { path: 'my-profile', component: ProfileComponent},
    { path: 'process', component: ProcessComponent},
    { path: 'workers', component: WorkersComponent}, ]},
  { path: '', component: LoginPageComponent},
 
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
