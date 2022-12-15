import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { catchError, of } from 'rxjs';
import { Login } from 'src/app/models/login';
import { LoginService } from 'src/app/services/login.service';
import { TokenService } from 'src/app/services/token.service';

@Component({
  selector: 'app-loginpagina',
  templateUrl: './loginpagina.component.html',
  styleUrls: ['./loginpagina.component.css']
})
export class LoginpaginaComponent implements OnInit {
  loginForm: FormGroup;
  loginService: LoginService;
  loginRequest: Login;
  accessToken: any;

  constructor(private formBuilder: FormBuilder, loginService: LoginService, private router: Router, private tokenService: TokenService, private toastrService: ToastrService) { 
    this.loginForm = this.formBuilder.group({
      email: ['', Validators.required],
      wachtwoord: ['', Validators.required]
    });
    this.loginService = loginService;
    this.loginRequest = new Login("", "");
    this.accessToken = "";
  }

  ngOnInit(): void {
    
  }

  onSubmit(): void{
    this.loginRequest.email = this.loginForm.value['email'];
    this.loginRequest.wachtwoord = this.loginForm.value['wachtwoord'];
    console.log(this.loginRequest);
    this.loginService.login(this.loginRequest)
    .pipe(catchError(error => of(`Foute inloggegevens: ${error}`)))
    .subscribe(
      data => {
        if (data == "invalid_grant"){
          this.toastrService.error("Onjuiste gebruikersnaam of wachtwoord");
          throw new Error("Foute inloggegevens");
        }else{
          this.accessToken = data;
          this.tokenService.setAccessToken(this.accessToken);
          this.router.navigate(['/overzichtkinderen']);
        }
      })
  }
}
