import { adres } from '../models/adres';
export class Todo {
    id: number;
  imie: string;
  nazwisko: string;
  pesel: string;
  address: adres;
  date: Date;
  constructor(imie: string, nazwisko: string, pesel: string, adress: adres, date: Date) {
    this.imie = imie;
   this.nazwisko = nazwisko;
this.pesel = pesel;
this.address = adress;
this.date = date;
}

  getId(): number {
    return this.id;
  }
  getName(): String {
    return this.imie;
  }
}
