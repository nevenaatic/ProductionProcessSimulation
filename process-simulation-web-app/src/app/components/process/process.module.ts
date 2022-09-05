import { CUSTOM_ELEMENTS_SCHEMA, NgModule } from "@angular/core";
import { FormsModule, ReactiveFormsModule } from "@angular/forms";
import { MatButtonModule } from "@angular/material/button";
import { MatCardModule } from "@angular/material/card";
import { MatDialogModule } from "@angular/material/dialog";
import { MatFormFieldModule } from "@angular/material/form-field";
import { MatIconModule } from "@angular/material/icon";
import { MatInputModule } from "@angular/material/input";
import { MatPaginatorModule } from "@angular/material/paginator";
import { MatTableModule } from "@angular/material/table";
import { NewProcessDialogComponent } from "./process-table/new-process-dialog/new-process-dialog.component";
import { ProcessTableComponent } from "./process-table/process-table.component";
import { ProcessComponent } from "./process.component";

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
    ],
    exports: [ProcessComponent],
    providers: [],
    schemas: [
      CUSTOM_ELEMENTS_SCHEMA
    ],
    entryComponents: []
  })

export class ProcessModule { }