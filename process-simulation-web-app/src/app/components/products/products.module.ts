import { CUSTOM_ELEMENTS_SCHEMA, NgModule, NO_ERRORS_SCHEMA } from "@angular/core";
import { FormsModule, ReactiveFormsModule } from "@angular/forms";
import { MatButtonModule } from "@angular/material/button";
import { MatDialogModule } from "@angular/material/dialog";
import { MatFormFieldModule } from "@angular/material/form-field";
import { MatIconModule } from "@angular/material/icon";
import { MatInputModule } from "@angular/material/input";
import { MatPaginatorModule } from "@angular/material/paginator";
import { MatTableModule } from "@angular/material/table";
import { MatSelectModule} from '@angular/material/select';
import { MatOptionModule } from "@angular/material/core";
import { CommonModule } from "@angular/common";
import { ProductsComponent } from "./products.component";
import { ProductsTableComponent } from "./products-table/products-table.component";
import { MatCardModule } from "@angular/material/card";

@NgModule({
    declarations: [
        ProductsComponent,
        ProductsTableComponent,
    ],
    imports: [
        MatFormFieldModule,
        FormsModule,
        MatIconModule,
        ReactiveFormsModule,
        MatInputModule,
        MatButtonModule,
        MatDialogModule,
        MatTableModule,
        MatPaginatorModule,
        MatSelectModule,
        MatOptionModule, 
        CommonModule, 
        MatCardModule
    ],
    exports: [ProductsComponent],
    providers: [],
    schemas: [
      CUSTOM_ELEMENTS_SCHEMA, NO_ERRORS_SCHEMA
    ],
    entryComponents: []
  })

export class ProductsModule { }