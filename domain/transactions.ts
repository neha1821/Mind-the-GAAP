import { Account } from "./account";

export class Transactions{
    transactionId: number = 0;
    date: string = "";
    type: string = "";
    fromAccount: Account = new Account();
    fromAccountId: number = 0;
    toAccount: Account = new Account();
    toAccountId: number = 0;
    transactionStatus: string =  "";
    amount: number = 0;
 }