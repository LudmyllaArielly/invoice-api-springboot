export class NewInvoice {
    id: number;
    companyName: string;
    dueDate: Date;
    status: string[];
    value: number;
    userCpfDTO: {
        cpf: string;
    }
}

