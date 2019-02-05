export class adres {
    id: int;
  miasto: string;
  ulica: string;
  numer: string;

  constructor(id: int, miasto: string, ulica: string, numer:string) {
this.id = id;    
this.miasto = miasto;
 this.ulica = ulica;
this.numer = numer;
}
  constructor(miasto: string, ulica: string, numer:string) {
    this.miasto = miasto;
   this.ulica = ulica;
this.numer = numer;
}

  getId(): number {
    return this.id;
  }
  getName(): String {
    return this.ulica;
  }
}
