import { NewProcessStep } from "./NewProcessStep.model";

export class NewProcess {
    name: string = "";
    description: string = "";
    processSteps: NewProcessStep[] = [];
    productId: number = 0;
}