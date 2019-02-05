import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { RouterModule, Routes } from '@angular/router';

import { AppComponent } from './app.component';
import { TodoListComponent } from './todo-list/todo-list.component';

import { TodoItemComponent } from './todo-item/todo-item.component';
import { TodoService } from './service/todo.service';
import { SpeakerService } from './service/speaker.service';
import { CourseService } from './service/course.service';
import { OpinionService } from './service/opinion.service';
import { AddTodoComponent } from './add-todo/add-todo.component';
import { SpeakerListComponent } from './speaker-list/speaker-list.component';
import { SpeakerItemComponent } from './speaker-item/speaker-item.component';
import { CourseListComponent } from './course-list/course-list.component';
import { CourseItemComponent } from './course-item/course-item.component';
import { OpinionListComponent } from './opinion-list/opinion-list.component';
import { OpinionItemComponent } from './opinion-item/opinion-item.component';
import { TodoEditComponent } from './todo-edit/todo-edit.component';


const ROUTES: Routes = [
  { path: '', redirectTo: 'todo-list', pathMatch: 'full' },
  { path: 'todo-list', component: TodoListComponent },
  { path: 'add-todo', component: AddTodoComponent },
  { path: 'speaker-list', component: SpeakerListComponent },
    { path: 'course-list', component: CourseListComponent },
{ path: 'opinion-list', component: OpinionListComponent },
{ path: 'edit/:id', component: TodoEditComponent  }

];

@NgModule({
  declarations: [AppComponent, TodoListComponent,TodoItemComponent, AddTodoComponent, SpeakerListComponent, SpeakerItemComponent, CourseListComponent, CourseItemComponent, OpinionListComponent, OpinionItemComponent, TodoEditComponent],
  imports: [BrowserModule, HttpClientModule, FormsModule, RouterModule.forRoot(ROUTES)],
  providers: [TodoService, SpeakerService, CourseService, OpinionService ],
  bootstrap: [AppComponent]
})
export class AppModule {}
