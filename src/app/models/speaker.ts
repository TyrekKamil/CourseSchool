import { adres } from '../models/adres';
export class Speaker {
    id: number;
  imie: string;
  nazwisko: string;
  pesel: string;
  Adres: adres;

  constructor(obj?: any) {
    this.id = (obj && obj.name) || '';
    this.imie = (obj && obj.name) || '';
   this.nazwisko = (obj && obj.name) || '';
this.pesel = (obj && obj.name) || '';  
this.Adres = (obj && obj.name) || '';
}

  getId(): number {
    return this.id;
  }
  getName(): String {
    return this.imie;
  }
}
