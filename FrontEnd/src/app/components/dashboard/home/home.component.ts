import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor(private router:Router) { }

  ngOnInit(): void {
  }

  onEvents(){
    this.router.navigateByUrl("/Event")
}
onSports(){
  this.router.navigateByUrl("/allSports")
}
onPlayers(){
  this.router.navigateByUrl("/Player")
}
onParticipations(){
  this.router.navigateByUrl("/AddParticipant")
}

}
