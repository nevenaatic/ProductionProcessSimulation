export class NewProcessStep{
    name: string="";
    description: string="";
    idStepKind: number=0;
    idStepNumber: number =0;

    constructor(name: string, description: string, idStepKind: number, idStepNumber: number){
        this.name = name;
        this.description = description;
        this.idStepKind = idStepKind;
        this.idStepNumber = idStepNumber;
    }
    
}
