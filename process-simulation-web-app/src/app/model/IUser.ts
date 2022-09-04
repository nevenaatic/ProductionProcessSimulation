export interface IUser {
    id: number;
    name: string;
    surname: string;
    birthday: Date;
    email: string;
    profilePhoto: string;
    telephone: string;
    gender: string;
    type: string;
    address: { id: number, street: string,number: string, country: string, city: string }
}