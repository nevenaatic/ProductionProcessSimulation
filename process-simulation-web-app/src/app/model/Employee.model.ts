import { Address } from "./Address.model";

export class Employee {
    id: number=0;
    name: string="";
    surname: string="";
    birthday: Date | undefined;
    email: string="";
    profilePhoto: string| undefined;
    telephone: string="";
    gender: string="";
    address: Address = new Address();
}