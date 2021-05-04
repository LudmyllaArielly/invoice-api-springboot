export class NewInvoice {
    companyName: string;
    dueDate: Date;
    status: string[];
    value: number;
    userCpfDTO: {
        cpf: string;
    }
}

