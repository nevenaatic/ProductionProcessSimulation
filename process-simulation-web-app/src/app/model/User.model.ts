import { Address } from "./Address.model";

export class User {
    id: number=0;
    name: string="";
    surname: string="";
    birthday: Date | undefined;
    email: string="";
    profilePhoto: string="";
    telephone: string="";
    gender: string="";
    type: string="";
    address: Address = new Address();
}