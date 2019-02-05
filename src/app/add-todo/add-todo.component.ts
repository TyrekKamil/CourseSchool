import { Component, OnInit } from '@angular/core';
import { TodoService } from '../service/todo.service';
import { adres } from '../models/adres';
@Component({
  selector: 'app-add-todo',
  templateUrl: './add-todo.component.html',
  styleUrls: ['./add-todo.component.css']
})
export class AddTodoComponent implements OnInit {
  imie: string;
  nazwisko: string;
    pesel: string;
 miasto: string;
 ulica: string;
 numer: string;
 adress: adres;
 date: Date;



  constructor(private todoService: TodoService) {}

  ngOnInit() {
    this.imie = '';
this.nazwisko = '';
this.pesel = '';
this.miasto = '';
this.ulica = '';
this.numer = '';
this.adress = '';
this.date = '';

  }

  createNewTodo() {
    if (this.imie !== '' && this.nazwisko !=='' && this.pesel !=='' && this.miasto!=='' && this.date!=='') {
      this.todoService.createNewAdres(this.miasto,this.ulica,this.numer);
window.alert('Dodano adres');
      this.todoService.createNewTodo(this.imie, this.nazwisko, this.pesel,this.miasto,this.ulica,this.numer, this.adres, this.date);

      this.imie = '';
    this.nazwisko= '';
    this.pesel = '';
    this.miasto = '';
this.ulica = '';
this.numer = '';
this.date='';
window.alert('Dodano użytkownika');


    } else {
      window.alert('Conajmniej jedno z pól jest puste');
    }
  }
}
