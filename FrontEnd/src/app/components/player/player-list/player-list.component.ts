import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { PlayerService } from 'src/app/player.service';

@Component({
  selector: 'app-player-list',
  templateUrl: './player-list.component.html',
  styleUrls: ['./player-list.component.css']
})
export class PlayerListComponent implements OnInit {

    player:any
  constructor(private playerService:PlayerService,private router:Router) {
    this.playerService.getAllPlayers().subscribe(players=>{
      console.log("players--",players)
      this.player=players
    })
   }

  ngOnInit(): void {
  }

  onAdd(){
      this.router.navigateByUrl("/AddPlayer")
  }


  onDelete(id:number) {
    this.playerService.deletePlayer(id).subscribe(result=>{
      this.router.navigateByUrl("/Player")
  })
}

}
