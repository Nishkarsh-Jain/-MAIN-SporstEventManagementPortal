import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { SportsEventService } from 'src/app/sports-event.service';

@Component({
  selector: 'app-sports-component',
  templateUrl: './sports-component.component.html',
  styleUrls: ['./sports-component.component.css']
})
export class SportsComponentComponent implements OnInit {

  sport:any

  constructor(private sportService:SportsEventService ,private router:Router) {
    this.sportService.getAllSports().subscribe(sports=>{
      console.log("Sports--",sports)
      this.sport=sports
    })
   }

  ngOnInit(): void {
  }

  
}
