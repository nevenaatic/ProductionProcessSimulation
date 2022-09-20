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
import { MatTableModule } from '@angular/material/table';
import { HttpClientModule } from '@angular/common/http';
import { ProductsModule } from './components/products/products.module';
import { FactoryComponent } from './components/factory/factory.component';
import { MatExpansionModule } from '@angular/material/expansion';
import { ProductRevisionComponent } from './components/product-revision/product-revision.component';
import { WorkersEngagementModule } from './components/workers-engagement/workers-engagement.module';
import {MatTabsModule} from '@angular/material/tabs';
import { ProductRevisionTableComponent } from './components/product-revision/product-revision-table/product-revision-table.component';
@NgModule({
  declarations: [
    AppComponent,
    LoginPageComponent,
    ChangePasswordComponent,
    FactoryComponent,
    ProductRevisionComponent,
    ProductRevisionTableComponent,
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
    MatTableModule, 
    HttpClientModule,
    ProductsModule,
    MatExpansionModule,
  WorkersEngagementModule,
  MatTabsModule
  

  ],
  providers: [{ provide: MAT_SNACK_BAR_DEFAULT_OPTIONS, useValue: { duration: 2000 } }],
  bootstrap: [AppComponent],
  schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class AppModule { }
