import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {AppRoutingModule} from './app-routing.module';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import { MatSliderModule } from '@angular/material/slider';
import {MatIconModule} from "@angular/material/icon";

import {AppComponent} from './app.component';
import {HomepaginaComponent} from './components/homepagina/homepagina.component';
import { FooterComponent } from './components/footer/footer.component';
import {NavbarComponent} from "./components/navbar/navbar.component";
import { KindCardComponent } from './components/kind-card/kind-card.component';
import { OverzichtKinderenComponent } from './components/overzicht-kinderen/overzicht-kinderen.component';
import { ToastrModule } from 'ngx-toastr';
import { ErrorInterceptor } from './services/error.interceptor'
import {ProfielKindComponent} from "./components/profiel-kind/profiel-kind.component";
import {TrajectOverzichtComponent} from "./components/traject-overzicht/traject-overzicht.component";
import { SitueringpaginaComponent } from './components/situeringpagina/situeringpagina.component';
import { TrajectVoortgangIndicatieComponent } from './components/traject-voortgang-indicatie/traject-voortgang-indicatie.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import { TerugNaarKindProfielComponent } from './components/terug-naar-kind-profiel/terug-naar-kind-profiel.component';
import { GroeipuntenpaginaComponent } from './components/groeipuntenpagina/groeipuntenpagina.component';
import { DomeinIndicatieComponent } from './components/domein-indicatie/domein-indicatie.component';
import { HoofdfunctieIndicatieComponent } from './components/hoofdfunctie-indicatie/hoofdfunctie-indicatie.component';
import { HoofdfunctieComponent } from './components/hoofdfunctie/hoofdfunctie.component';
import { MentaleFunctiesComponent } from './components/hoofdfuncties/mentale-functies/mentale-functies.component';
import { SensorischeFunctiesComponent } from './components/hoofdfuncties/sensorische-functies/sensorische-functies.component';
import { BewegingFunctiesComponent } from './components/hoofdfuncties/beweging-functies/beweging-functies.component';
import {MatCheckboxModule} from "@angular/material/checkbox";
import { PrioriteitenAanduidenComponent } from './components/prioriteiten-aanduiden/prioriteiten-aanduiden.component';
import { PrioriteitSelectieComponent } from './components/prioriteit-selectie/prioriteit-selectie.component';
import { AfgemaaktTrajectComponent } from './components/afgemaakt-traject/afgemaakt-traject.component';
import { AfgemaaktTrajectCardComponent } from './components/afgemaakt-traject-card/afgemaakt-traject-card.component';
import { MatCardModule } from '@angular/material/card';
import { AfgemaaktTrajectVergelijkenComponent } from './components/afgemaakt-traject-vergelijken/afgemaakt-traject-vergelijken.component';
import { AfgemaaktTrajectSelectieCardComponent } from './components/afgemaakt-traject-selectie-card/afgemaakt-traject-selectie-card.component';
import {MatTooltipModule} from "@angular/material/tooltip";
import { ContactComponent } from './components/contact/contact.component';
import { DialogComponent } from './components/dialog/dialog.component';
import { MaterialModule } from './material.module';
import { LoginpaginaComponent } from './components/loginpagina/loginpagina.component';
import { AuthGuardGuard } from './auth-guard.guard';

@NgModule({
  declarations: [
    AppComponent,
    HomepaginaComponent,
    FooterComponent,
    NavbarComponent,
    KindCardComponent,
    OverzichtKinderenComponent,
    ProfielKindComponent,
    TrajectOverzichtComponent,
    SitueringpaginaComponent,
    TrajectVoortgangIndicatieComponent,
    TerugNaarKindProfielComponent,
    GroeipuntenpaginaComponent,
    DomeinIndicatieComponent,
    HoofdfunctieIndicatieComponent,
    HoofdfunctieComponent,
    MentaleFunctiesComponent,
    SensorischeFunctiesComponent,
    BewegingFunctiesComponent,
    PrioriteitenAanduidenComponent,
    PrioriteitSelectieComponent,
    AfgemaaktTrajectComponent,
    AfgemaaktTrajectCardComponent,
    AfgemaaktTrajectVergelijkenComponent,
    AfgemaaktTrajectSelectieCardComponent,
    ContactComponent,
    DialogComponent,
    LoginpaginaComponent
  ],
    imports: [
        BrowserModule,
        HttpClientModule,
        AppRoutingModule,
        BrowserAnimationsModule,
        MatSliderModule,
        MatIconModule,
        BrowserAnimationsModule,
        ToastrModule.forRoot(),
        FormsModule,
        MatCheckboxModule,
        ReactiveFormsModule,
        MatCardModule,
        MatTooltipModule,
    MaterialModule
    ],
  providers: [
    { provide: HTTP_INTERCEPTORS, useClass: ErrorInterceptor, multi: true},
    AuthGuardGuard
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
