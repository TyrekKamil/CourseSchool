import { Injectable } from '@angular/core';
import { Opinion } from '../models/opinion';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

const apiUrl: String = 'http://localhost:8080/spring-1.0-SNAPSHOT/';

@Injectable()
export class OpinionService {
  constructor(private http: HttpClient) {}

  getAllOpinions(): Observable<any> {
    return this.http.get(`${apiUrl}/api/Opinions`);
  }

  getHowManyPosen(): Observable<any>
  {
    return this.http.get('${apiUrl}/api/Address/howMany');
  }

  createNewOpinion(person: any): Observable<any> {
    let result: Observable<Object>;
    if (person['href']) {
      result = this.http.put(`${apiUrl}/api/Person`, person);
    } else {
      result = this.http.post(`${apiUrl}/api/Person`, person);
    }
    return result;
  }
  removeOpinion(id): Observable<Opinion> {
    return this.http.delete<Opinion>(`${apiUrl}/api/Opinion/${id}`);
  }

  updateOpinion(Opinion: Opinion) {
    return this.http.put(`${apiUrl}/api/Person/${Opinion.getId()}`, Opinion);
  }
}
