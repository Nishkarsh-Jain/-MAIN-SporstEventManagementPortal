import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class PlayerService {

  url:string="http://localhost:8083/pm/"
  constructor(private http:HttpClient) {

  }

   getAllPlayers():Observable<any>{
    console.log("All Players API called")
    return this.http.get<any>(this.url+"players")
   }

    addPlayer(players:any):Observable<any>{
      console.log("Player: ",players)
    return this.http.post<any>(this.url+"addPlayer",players)
    }

    
    deletePlayer(id:number):Observable<any>{
       return this.http.delete<any>(this.url+"deletePlayer/"+id)
     }
}
