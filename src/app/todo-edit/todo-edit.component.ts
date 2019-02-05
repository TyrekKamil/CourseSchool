import { Component, OnDestroy, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { ActivatedRoute, Router } from '@angular/router';
import { NgForm } from '@angular/forms';
import {TodoService} from '../service/todo.service';
import {Todo} from '../models/todo';
import {adres} from '../models/adres';

@Component({
  selector: 'app-todo-edit',
  templateUrl: './todo-edit.component.html',
  styleUrls: ['./todo-edit.component.css']
})
export class TodoEditComponent implements OnInit, OnDestroy {
todo: Todo;
 sub: Subscription;
  constructor(private route: ActivatedRoute,
              private router: Router,
              private todoService: TodoService) { }

  ngOnInit() 
{this.miasto = '';
this.ulica = '';
this.numer = '';
    this.sub = this.route.params.subscribe(params => {
      const id = params['id'];
      if (id) {
        this.todoService.get(id).subscribe((todos: Todo) => {
          if (todos) {
            this.todo = todos;

          } else {
            console.log(`zle`);
          }
        });
      }
    });
  }

  editTodo(miastto: string, ullica: string, nr: string, idA: int) {
    if (miastto!=='' && ullica !=='' && nr !=='' && idA!=='') {
      this.todoService.editAdres(miastto, ullica, nr, idA);
      window.alert('Zapisano zmiany.');

    } else {
      window.alert('Conajmniej jedno z pól jest puste');
    }
  }

}
