import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomepaginaComponent } from './components/homepagina/homepagina.component';
import { OverzichtKinderenComponent } from './components/overzicht-kinderen/overzicht-kinderen.component';
import { TrajectOverzichtComponent } from './components/traject-overzicht/traject-overzicht.component';
import { ProfielKindComponent } from "./components/profiel-kind/profiel-kind.component";
import { OverOnsComponent } from "./components/over-ons/over-ons.component";
import { SitueringpaginaComponent } from "./components/situeringpagina/situeringpagina.component";
import { GroeipuntenpaginaComponent } from "./components/groeipuntenpagina/groeipuntenpagina.component";
import { PrioriteitenAanduidenComponent } from './components/prioriteiten-aanduiden/prioriteiten-aanduiden.component';
import { AfgemaaktTrajectComponent } from "./components/afgemaakt-traject/afgemaakt-traject.component";
import { ContactComponent } from './components/contact/contact.component';
import { LoginpaginaComponent } from './components/loginpagina/loginpagina.component';
import { AuthGuardGuard } from './auth-guard.guard';

const routes: Routes = [
    { path: 'home', component: HomepaginaComponent },
    { path: 'contact', component: ContactComponent },
    { path: 'overzichtkinderen', component: OverzichtKinderenComponent , canActivate: [AuthGuardGuard]},
    { path: 'overzichttraject/:userId/kind/:kindId', component: TrajectOverzichtComponent , canActivate: [AuthGuardGuard]},
    { path: 'profielkind/:kindId', component: ProfielKindComponent , canActivate: [AuthGuardGuard]},
    { path: 'over-ons', component: OverOnsComponent },
    { path: 'login', component: LoginpaginaComponent},
    { path: 'situering', component: SitueringpaginaComponent , canActivate: [AuthGuardGuard]},
    { path: 'groeipunten', component: GroeipuntenpaginaComponent , canActivate: [AuthGuardGuard]},
    { path: 'prioriteiten', component: PrioriteitenAanduidenComponent , canActivate: [AuthGuardGuard]},
    { path: 'afgemaakttraject', component: AfgemaaktTrajectComponent , canActivate: [AuthGuardGuard]},
    { path: '', redirectTo: 'home', pathMatch: 'full' },
    { path: '**', redirectTo: 'home', pathMatch: 'full' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
