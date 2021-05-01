export interface updateInvoice {
    companyName: string;
    dueDate: Date;
    status: string[];
    value: number;
    userCpfDTO: {
        cpf: string;
    }
}

