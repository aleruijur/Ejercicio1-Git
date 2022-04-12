import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Usuario } from 'src/app/entidades/usuario';
import { LoginapiService } from 'src/app/servicios/loginapi.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username: string = ""
  password: string = ""

  usernameVacioError = true
  passwordVacioError = true
  passwordIncorrectoError = true
  ususarioNoExisteError = true

  constructor(private router:Router, private _loginapiService : LoginapiService) { 
    this._loginapiService = _loginapiService
  }

  public login(){
    this.ocultarErrores();
    let newUser = new Usuario(this.username, this.password);

    let vacio = false
    if(this.username.trim().length==0){
      this.usernameVacioError = false 
      vacio = true
    }
    if(this.password.trim().length==0){
      this.passwordVacioError = false
      vacio = true
    }
    if (!vacio){
      let obs = this._loginapiService.estaRegistrado(this.username, this.password)
      
      obs.subscribe({
        next:  (respuesta) => {
          if(respuesta.validado) {
            this.router.navigate(['/listado'], {queryParams:{username: newUser.username}})
          }else {
            this.ususarioNoExisteError = false
          }
        },
        error: (e) => {
          console.log(`Error al acceder a la api de login`)
          alert(`Error al acceder a la api de login`)
        }
      });
    }
  }

  private ocultarErrores(){
    this.usernameVacioError = true
    this.passwordVacioError = true
    this.passwordIncorrectoError = true
    this.ususarioNoExisteError = true
  }

  ngOnInit(): void {
  }

}
