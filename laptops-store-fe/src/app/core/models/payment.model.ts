export class Payment {
  cardNumber: String;
  expirationDate: String;
  cvc2: String;
  amount: number;
  cid: String;

  constructor() {
    this.cardNumber = "";
    this.expirationDate = "";
    this.cvc2 = "";
    this.amount;
    this.cid = "11";
  }
}
