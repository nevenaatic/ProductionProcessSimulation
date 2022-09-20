import { CUSTOM_ELEMENTS_SCHEMA, NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatCardModule } from '@angular/material/card';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { AppRoutingModule } from 'src/app/app-routing.module';
import { RouterModule } from '@angular/router';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatInputModule } from '@angular/material/input';
import { WorkersEngagementComponent } from './workers-engagement.component';
import {MatSelectModule} from '@angular/material/select';
import { MatOptionModule } from "@angular/material/core";
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatNativeDateModule } from '@angular/material/core';
import { MatTableModule } from "@angular/material/table";

@NgModule({
  declarations: [
    WorkersEngagementComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    MatFormFieldModule,
    FormsModule,
    ReactiveFormsModule,
    MatCardModule,
    MatButtonModule,
    MatIconModule,
    CommonModule, 
    AppRoutingModule,
    RouterModule,
    MatPaginatorModule,
    MatInputModule,
    MatSelectModule,
    MatOptionModule, 
    MatDatepickerModule,
    MatNativeDateModule,
    MatTableModule,
    
  ],
  providers: [],
  schemas:[
    CUSTOM_ELEMENTS_SCHEMA
  ],
  entryComponents: [ ],
  exports:[WorkersEngagementComponent]
})
export class WorkersEngagementModule { }
