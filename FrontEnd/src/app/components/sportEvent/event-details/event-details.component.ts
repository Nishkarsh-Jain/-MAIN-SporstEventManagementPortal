import { Component, OnInit } from '@angular/core';
import { ActivatedRoute,Router } from '@angular/router';
import { SportsEventService } from 'src/app/sports-event.service';

@Component({
  selector: 'app-event-details',
  templateUrl: './event-details.component.html',
  styleUrls: ['./event-details.component.css']
})
export class EventDetailsComponent implements OnInit {

  event:any

  constructor(private activate_route:ActivatedRoute,private router:Router,private eventService:SportsEventService ) { 
    var id:string=this.activate_route.snapshot.params['pid']
    this.eventService.getEventByName(id).subscribe(eventdata=>{
      console.log("Printing Event Data:"+eventdata.sportsName);
       this.event=eventdata
    })
  }

  ngOnInit(): void {
    this.event=[]
  }

  

}
