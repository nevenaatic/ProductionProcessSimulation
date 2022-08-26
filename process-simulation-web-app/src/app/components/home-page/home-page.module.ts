import { CUSTOM_ELEMENTS_SCHEMA, NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatFormFieldModule, } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatCardModule } from '@angular/material/card';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { MatToolbarModule} from '@angular/material/toolbar';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatListModule } from '@angular/material/list';
import { AppRoutingModule } from 'src/app/app-routing.module';
import { RouterModule } from '@angular/router';
import { HomePageComponent } from './home-page.component';
import { ToolbarComponent } from 'src/app/shared-components/toolbar/toolbar.component';
import { SidenavComponent } from 'src/app/shared-components/sidenav/sidenav.component';
import { MatRadioModule} from '@angular/material/radio';
import { ProfileComponent } from '../profile/profile.component';
@NgModule({
  declarations: [
   HomePageComponent, 
   ToolbarComponent, SidenavComponent, ProfileComponent
  ],
  imports: [
    BrowserModule,
   MatToolbarModule,
    BrowserAnimationsModule,
    MatFormFieldModule,
    FormsModule,
    ReactiveFormsModule,
    MatInputModule,
    MatCardModule,
    MatButtonModule,
    MatIconModule,
    CommonModule, 
    MatSidenavModule, 
    MatListModule,
    AppRoutingModule,
    RouterModule,
    MatRadioModule,
   
    
    
  ],
  exports:[ HomePageComponent],
  providers: [],
  schemas:[
    CUSTOM_ELEMENTS_SCHEMA
  ]
})
export class HomePageModule { }
