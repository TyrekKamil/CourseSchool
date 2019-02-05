import { Injectable } from '@angular/core';
import { Speaker } from '../models/speaker';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

const apiUrl: String = 'http://localhost:8080/spring-1.0-SNAPSHOT/';

@Injectable()
export class SpeakerService {
  constructor(private http: HttpClient) {}

  getAllSpeakers(): Observable<any> {
    return this.http.get(`${apiUrl}/api/Speakers`);
  }

  getHowManyPosen(): Observable<any>
{
return this.http.get('${apiUrl}/api/Address/howMany');
}

  createNewSpeaker(person: any): Observable<any> {
   let result: Observable<Object>;
    if (person['href']) {
      result = this.http.put(`${apiUrl}/api/Person`, person);
    } else {
      result = this.http.post(`${apiUrl}/api/Person`, person);
    }
    return result;
  }
  removeSpeaker(id): Observable<Speaker> {
    return this.http.delete<Speaker>(`${apiUrl}api/Speaker/${id}`);
  }

  updateSpeaker(speaker: Speaker) {
    return this.http.put(`${apiUrl}/api/Person/${speaker.getId()}`, speaker);
  }
}
