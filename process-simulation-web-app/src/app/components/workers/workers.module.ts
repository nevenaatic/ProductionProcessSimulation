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
import { WorkersComponent } from './workers.component';
import { WorkerPreviewComponent } from './worker-preview/worker-preview.component';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatInputModule } from '@angular/material/input';
@NgModule({
  declarations: [
    WorkersComponent,
    WorkerPreviewComponent
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
    MatInputModule
    
  ],
  providers: [],
  schemas:[
    CUSTOM_ELEMENTS_SCHEMA
  ],
  entryComponents: [ ],
  exports:[WorkersComponent]
})
export class WorkersModule { }
