import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { SportsEventService } from 'src/app/sports-event.service';



@Component({
  selector: 'app-sports-event',
  templateUrl: './sports-event.component.html',
  styleUrls: ['./sports-event.component.css']
})
export class SportsEventComponent implements OnInit {

  sport:any

  constructor(private sportService:SportsEventService,private router:Router) {
    this.sportService.getAllSports().subscribe(sports=>{
      //console.log("sports--",sports)
      this.sport=sports
    })
   }

  ngOnInit(): void {
  }
  onSubmit(events: NgForm) {
    console.log("event---", events.value)
   
      this.sportService.addEvent(events.value).subscribe(result => {
       console.log("addd--",result)
      })
 
  }


  onCancel() {
    this.router.navigateByUrl("Event")
  }


}
