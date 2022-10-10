import { CUSTOM_ELEMENTS_SCHEMA, NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatCardModule } from '@angular/material/card';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { StatisticsComponent } from './statistics.component';
import { AppRoutingModule } from 'src/app/app-routing.module';
import { RouterModule } from '@angular/router';
import { MatSelectModule } from '@angular/material/select';
import { MatOptionModule } from '@angular/material/core';
@NgModule({
  declarations: [
    StatisticsComponent,
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    FormsModule,
    ReactiveFormsModule,
    MatCardModule,
    MatButtonModule,
    MatIconModule,
    CommonModule, 
    FormsModule,
    AppRoutingModule,
    RouterModule,
    MatSelectModule,
    MatOptionModule
    
  ],
  providers: [],
  schemas:[
    CUSTOM_ELEMENTS_SCHEMA
  ],
  entryComponents: [ ],
  exports:[StatisticsComponent]
})
export class StatisticsModule { }
