export class User {
  firstName: string;
  lastName: string;
  email: string;
  password: string;
  deliveryAddress;

  constructor() {
    this.firstName = "";
    this.lastName = "";
    this.email = "";
    this.password = "";
    this.deliveryAddress = "";
  }
}
