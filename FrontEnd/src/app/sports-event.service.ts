import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class SportsEventService {


url:string="http://localhost:9006/sem/"
  constructor(private http:HttpClient) {

  }

   getAllSports():Observable<any>{
    console.log("APII")
    return this.http.get<any>(this.url+"sports")
   }

   getAllEvents():Observable<any>{
    console.log("APII")
    return this.http.get<any>(this.url+"events")
   }

    addEvent(events:any):Observable<any>{
      console.log("checj---",events)
    return this.http.post<any>(this.url+"addEvent",events)
    }

    getEventByName(id:string):Observable<any>{
     return this.http.get<any>(this.url+"events/"+id)
    }

    deleteEvent(id:number):Observable<any>{
       return this.http.delete<any>(this.url+"deleteEvent/"+id)
     }
}
