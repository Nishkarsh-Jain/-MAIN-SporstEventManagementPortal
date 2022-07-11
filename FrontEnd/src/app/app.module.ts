import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import {HttpClientModule} from "@angular/common/http";

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SportsEventComponent } from './components/sportEvent/sports-event/sports-event.component';
import { EventListComponent } from './components/sportEvent/event-list/event-list.component';
import { EventDetailsComponent } from './components/sportEvent/event-details/event-details.component';
import { PlayerListComponent } from './components/player/player-list/player-list.component';
import { AddPlayerComponent } from './components/player/add-player/add-player.component';
import { HomeComponent } from './components/dashboard/home/home.component';
import { LoginPageComponent } from './components/auth/login-page/login-page.component';
import { AddParticipantComponent } from './components/participation/add-participant/add-participant.component';
import { SportsComponentComponent } from './components/sports/sports-component/sports-component.component';



@NgModule({
  declarations: [
    AppComponent,
    SportsEventComponent,
    EventListComponent,
    EventDetailsComponent,
    PlayerListComponent,
    AddPlayerComponent,
    HomeComponent,
    LoginPageComponent,
    AddParticipantComponent,
    SportsComponentComponent,
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
