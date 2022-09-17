import { CUSTOM_ELEMENTS_SCHEMA, NgModule, NO_ERRORS_SCHEMA } from "@angular/core";
import { FormsModule, ReactiveFormsModule } from "@angular/forms";
import { MatButtonModule } from "@angular/material/button";
import { MatCardModule } from "@angular/material/card";
import { MatDialogModule } from "@angular/material/dialog";
import { MatFormFieldControl, MatFormFieldModule } from "@angular/material/form-field";
import { MatIconModule } from "@angular/material/icon";
import { MatInputModule, MAT_INPUT_VALUE_ACCESSOR } from "@angular/material/input";
import { MatPaginatorModule } from "@angular/material/paginator";
import { MatTableModule } from "@angular/material/table";
import { FailuresComponent } from "./failures.component";
import { FailuresTableComponent } from './failures-table/failures-table.component';
import { NewFailureDialogComponent } from './failures-table/new-failure-dialog/new-failure-dialog.component';
import { MatSelectModule } from "@angular/material/select";
import { MatOptionModule } from "@angular/material/core";
import { CommonModule } from "@angular/common";

@NgModule({
    declarations: [
        FailuresComponent,
        FailuresComponent,
        FailuresTableComponent,
        NewFailureDialogComponent
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
    ],
    exports: [FailuresComponent],
    providers: [],
    schemas: [
        CUSTOM_ELEMENTS_SCHEMA, NO_ERRORS_SCHEMA,
    ],
    entryComponents: []
})

export class FailuresModule { }