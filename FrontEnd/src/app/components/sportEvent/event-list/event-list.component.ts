import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { SportsEventService } from 'src/app/sports-event.service';

@Component({
  selector: 'app-event-list',
  templateUrl: './event-list.component.html',
  styleUrls: ['./event-list.component.css']
})
export class EventListComponent implements OnInit {
  event:any



  constructor(private eventService:SportsEventService,private router:Router) {
    this.eventService.getAllEvents().subscribe(events=>{
      console.log("events--",events)
      this.event=events
    })
   }

  ngOnInit(): void {
  }
  onDetails(evname:any) {
    this.router.navigateByUrl("EventDetails/"+evname)
  }
  onAdd(){
      this.router.navigateByUrl("/AddEvent")
  }


  onDelete(id:number) {
    this.eventService.deleteEvent(id).subscribe(result=>{
      this.router.navigateByUrl("/Event")
  })
}



}
