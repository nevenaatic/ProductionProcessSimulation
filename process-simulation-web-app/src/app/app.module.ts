import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatFormFieldModule, } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatCardModule } from '@angular/material/card';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { LoginPageComponent } from './components/login-page/login-page.component';
import { HomePageModule } from './components/home-page/home-page.module';
import { MatSnackBarModule, MAT_SNACK_BAR_DEFAULT_OPTIONS } from '@angular/material/snack-bar';
import { ChangePasswordComponent } from './components/profile/change-password/change-password.component';
import { FailuresComponent } from './components/failures/failures.component';
import { MatTableModule } from '@angular/material/table';
import { NewProcessDialogComponent } from './components/process/process-table/new-process-dialog/new-process-dialog.component';
import { WorkerPreviewComponent } from './components/workers/worker-preview/worker-preview.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginPageComponent,
    ChangePasswordComponent,
    FailuresComponent,
    NewProcessDialogComponent,

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatFormFieldModule,
    FormsModule,
    ReactiveFormsModule,
    MatInputModule,
    MatCardModule,
    MatButtonModule,
    MatIconModule,
    HomePageModule,
    MatSnackBarModule,
    MatTableModule
  ],
  providers: [{ provide: MAT_SNACK_BAR_DEFAULT_OPTIONS, useValue: { duration: 2000 } }],
  bootstrap: [AppComponent],
  schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class AppModule { }
