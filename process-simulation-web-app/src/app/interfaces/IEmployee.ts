export interface IEmpolyee {
    id: number;
    name: string;
    surname: string;
    birthday: Date | undefined;
    email: string;
    profilePhoto: string| undefined;
    telephone: string;
    gender: string;
    address: [];
}