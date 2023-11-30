import { Account } from "./account";
export class Cheque {
    chequeId: number = 0;
    chequeDate: string = "";
    amount: number = 0;
    fromAccount: Account = new Account();
    fromAccountId: number = 0;
    toAccount: Account = new Account();
    toAccountId: number = 0;
    clearanceChequeDate: string = "";
    chequeStatus: string = "";

}