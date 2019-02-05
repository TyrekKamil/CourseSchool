import { Injectable } from '@angular/core';
import { Todo } from '../models/todo';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { adres } from '../models/adres';

const apiUrl: String = 'http://localhost:8080/spring-1.0-SNAPSHOT/';

@Injectable()
export class TodoService {
  constructor(private http: HttpClient) {}

  getAllTodos(): Observable<any> {
    return this.http.get(`${apiUrl}api/Persons`);
  }


  get(id: string) {
    return this.http.get(`${apiUrl}/api/Person/${id}`);
  }
get(id: string) {
    return this.http.get(`${apiUrl}/api/Person/${id}`);
  }

  getHowManyPosen(): Observable<any>
{
return this.http.get('${apiUrl}/api/Address/howMany');
}

  createNewTodo(imie: string, nazwisko: string, pesel: string,miasto: string, ulica: string, numer: string, address: adres, dates: date) {
    const data = {
      imie: imie,
      nazwisko: nazwisko,
        pesel: pesel,
    miasto: miasto,
    ulica: ulica,
    numer: numer,
    dates: Date
    };
    
    const todo = new Todo(imie, nazwisko, pesel, address, dates);
    
    return this.http.post(`${apiUrl}api/Person`, todo).subscribe(res => {
      console.log(res);
    });
}

  createNewAdres(miasto: string, ulica: string, numer: string) {
   
    const adress = new adres(12,miasto,ulica,numer);
  
    return this.http.post(`${apiUrl}api/Address`, adress).subscribe(res => {
      console.log(res);
    });
}

    editAdres(miasto: string, ulica:string, numer:string, id:int)
    {
    const adress = new adres(id,miasto,ulica,numer);
         return this.http.put(`${apiUrl}api/Address`, adress).subscribe(res => {console.log(res);});
}

  removeTodo(id): Observable<Todo> {
     return this.http.delete<Todo>(`${apiUrl}api/Person/${id}`);
  }

  updateTodo(todo: Todo) {
    return this.http.put(`${apiUrl}/api/Person/${todo.getId()}`, todo);
  }
}
