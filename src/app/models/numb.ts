
export class numb {
   num: number;

  constructor(obj?: any) {
    this.num = (obj && obj.name) || '';

}


  getName(): Number {
    return this.num;
  }
}
