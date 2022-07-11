import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { EventListComponent } from './components/sportEvent/event-list/event-list.component';
import { SportsEventComponent } from './components/sportEvent/sports-event/sports-event.component';
// import { LoginComponent } from './components/auth/login/login.component';
import { EventDetailsComponent} from './components/sportEvent/event-details/event-details.component';
import { PlayerListComponent } from './components/player/player-list/player-list.component';
import { AddPlayerComponent } from './components/player/add-player/add-player.component';
import { HomeComponent} from './components/dashboard/home/home.component';
import { LoginPageComponent } from './components/auth/login-page/login-page.component';
import { AddParticipantComponent } from './components/participation/add-participant/add-participant.component';
import {SportsComponentComponent} from './components/sports/sports-component/sports-component.component';



const routes: Routes = [

  {path:"",component:LoginPageComponent},
  {path:"Event",component:EventListComponent},
  {path:"AddEvent",component:SportsEventComponent},
  {path:"EventDetails/:pid",component:EventDetailsComponent},
  {path:"Player",component:PlayerListComponent},
  {path:"AddPlayer",component:AddPlayerComponent},
  {path:"HomePage",component:HomeComponent},
  {path:"AddParticpant",component:AddParticipantComponent},
  {path:"allSports",component:SportsComponentComponent},

  // {path:"Login",component:LoginComponent}
 
  // {path:"AddPlayer",component:AddPlayerComponent},
  // {path:"UpdateProduct/:pid",component:UpdateProductComponent},
  // {path:"DeleteProduct/:pid",component:DeleteProductComponent},
  // {path:"DeletePlayer/:pid",component:DeletePlayerComponent},
  // {path:"ProductDetails/:pid",component:SeeDetailsComponent},


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
