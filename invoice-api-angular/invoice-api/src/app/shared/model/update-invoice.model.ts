export class UpdateInvoice {
    id: string;
    companyName: string;
    dueDate: Date;
    status: string[];
    value: number;
    userCpfDTO: {
        cpf: string;
    }
}

