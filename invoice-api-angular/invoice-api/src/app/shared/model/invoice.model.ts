export interface getAllInvoice {
    id: string;
    companyName: string;
    dueDate: Date;
    status: string
    value: number;
    userCreateAndListAllDTO: {
        cpf: string;
        dateOfBirth: Date;
        fistName: string;
        lastName: string;
    }
}