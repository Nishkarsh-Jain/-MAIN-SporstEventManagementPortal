import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { ParticipationService } from 'src/app/participation.service';

@Component({
  selector: 'app-add-participant',
  templateUrl: './add-participant.component.html',
  styleUrls: ['./add-participant.component.css']
})
export class AddParticipantComponent implements OnInit {

  participant:any
  

  constructor(private participationService:ParticipationService,private router:Router) {
    this.participationService.getAllParticipants().subscribe(participants=>{
      this.participant=participants
    })
  }

   
   ngOnInit(): void {
  }

  onSubmit(participants: NgForm) {
    console.log("player---",participants.value)
   
      this.participationService.addParticipant(participants.value).subscribe(result => {
       console.log("addd--",result)
      })
 
  }


  onCancel() {
    this.router.navigateByUrl("/Participant")
  }

}
