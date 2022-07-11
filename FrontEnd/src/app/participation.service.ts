import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ParticipationService {

  url:string="http://localhost:9007/pm/"
  constructor(private http:HttpClient) {

  }

   getAllParticipants():Observable<any>{
    console.log("All Participants API called")
    return this.http.get<any>(this.url+"participations")
   }
   getApprovedParticpants():Observable<any>{
    console.log("All Participants API called")
    return this.http.get<any>(this.url+"participations")
   }
   getRejectedParticpants():Observable<any>{
    console.log("All Participants API called")
    return this.http.get<any>(this.url+"participations")
   }
   getPendingParticpants():Observable<any>{
    console.log("All Participants API called")
    return this.http.get<any>(this.url+"participations")
   }

     addParticipant(participants:any):Observable<any>{
       console.log("Participant: ",participants)
     return this.http.post<any>(this.url+"addParticipation",participants)
     }

    
    // deletePlayer(id:number):Observable<any>{
    //    return this.http.delete<any>(this.url+"deletePlayer/"+id)
    //  }
}
