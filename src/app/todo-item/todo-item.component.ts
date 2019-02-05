import { Component, OnInit, Input, EventEmitter, Output } from '@angular/core';
import { Todo } from '../models/todo';
import { TodoService } from '../service/todo.service';
import {Router} from "@angular/router";
@Component({
  selector: 'app-todo-item',
  templateUrl: './todo-item.component.html', 
  styleUrls: ['./todo-item.component.css']
})
export class TodoItemComponent implements OnInit {
  @Input() todo: Todo;  
  @Output() removeItem: EventEmitter<Todo> = new EventEmitter();
  constructor(private todoService: TodoService, private router: Router) {}
 
  ngOnInit() {}

  remove(id) {
    this.todoService.removeTodo(id).subscribe((data) => (console.log ("usunieto") );
    window.location.reload();
 
  }
editUser(id){
    this.router.navigate(['/edit',id]);
  };

}
