import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ParticipationService } from 'src/app/participation.service';
@Component({
  selector: 'app-participation-list',
  templateUrl: './participation-list.component.html',
  styleUrls: ['./participation-list.component.css']
})
export class ParticipationListComponent implements OnInit {

  participant:any



  constructor(private router:Router) {
   
   }

  ngOnInit(): void {
  }

  
 
}
