import { CUSTOM_ELEMENTS_SCHEMA, NgModule, NO_ERRORS_SCHEMA } from "@angular/core";
import { FormsModule, ReactiveFormsModule } from "@angular/forms";
import { MatButtonModule } from "@angular/material/button";
import { MatCardModule } from "@angular/material/card";
import { MatDialogModule } from "@angular/material/dialog";
import { MatFormFieldModule } from "@angular/material/form-field";
import { MatIconModule } from "@angular/material/icon";
import { MatInputModule } from "@angular/material/input";
import { MatPaginatorModule } from "@angular/material/paginator";
import { MatTableModule } from "@angular/material/table";
import { NewProcessDialogComponent } from "./new-process-dialog/new-process-dialog.component";
import { ProcessTableComponent } from "./process-table/process-table.component";
import { ProcessComponent } from "./process.component";
import {MatSelectModule} from '@angular/material/select';
import { MatOptionModule } from "@angular/material/core";
import { CommonModule } from "@angular/common";
import {MatExpansionModule} from '@angular/material/expansion';

@NgModule({
    declarations: [
        ProcessComponent,
        ProcessTableComponent,
        NewProcessDialogComponent,
    ],
    imports: [
        MatFormFieldModule,
        FormsModule,
        MatIconModule,
        ReactiveFormsModule,
        MatInputModule,
        MatButtonModule,
        MatCardModule,
        MatDialogModule,
        MatTableModule,
        MatPaginatorModule,
        MatSelectModule,
        MatOptionModule, 
        CommonModule,
        MatExpansionModule
    ],
    exports: [ProcessComponent],
    providers: [],
    schemas: [
      CUSTOM_ELEMENTS_SCHEMA, NO_ERRORS_SCHEMA
    ],
    entryComponents: []
  })

export class ProcessModule { }