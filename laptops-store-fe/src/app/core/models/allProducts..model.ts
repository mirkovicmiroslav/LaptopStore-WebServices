export class AllProducts {
  products: ProductInfo[];

  constructor() {
    this.products = [];
  }
}

interface ProductInfo {
  idProduct: number;
  image: any;
  brand: String;
  price: number;
  processor: String;
  ram: String;
  graphicCard: String;
  hardDrive: String;
}
