export class getAllInvoice {
    id: string;
    companyName: string;
    dueDate: Date;
    status: string
    value: number;
    userCreateAndListAllDTO: {
        cpf: string;
        dateOfBirth: Date;
        firstName: string;
        lastName: string;
    }

    constructor(values: Object = {}) {
        Object.assign(this, values);
    }
}
