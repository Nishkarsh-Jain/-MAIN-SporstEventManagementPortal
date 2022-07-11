import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { PlayerService } from 'src/app/player.service';
import { SportsEventService } from 'src/app/sports-event.service';

@Component({
  selector: 'app-add-player',
  templateUrl: './add-player.component.html',
  styleUrls: ['./add-player.component.css']
})
export class AddPlayerComponent implements OnInit {


  player:any
  sport:any

  constructor(private playerService:PlayerService,private sportsEvent:SportsEventService,private router:Router) {
    this.playerService.getAllPlayers().subscribe(players=>{
      this.player=players
    })
    this.sportsEvent.getAllSports().subscribe(result=>{
      this.sport=result;
    })

   }

  ngOnInit(): void {
  }

   onSubmit(players: NgForm) {
    console.log("player---", players.value)
   
      this.playerService.addPlayer(players.value).subscribe(result => {
       console.log("addd--",result)
      })
 
  }


  onCancel() {
    this.router.navigateByUrl("PLayer")
  }


}
