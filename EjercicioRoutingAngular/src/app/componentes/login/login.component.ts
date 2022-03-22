import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Usuario } from 'src/app/entidades/usuario';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username: string = ""
  password: string = ""

  registrados: Usuario[] = []

  usernameVacioError = true
  passwordVacioError = true
  passwordIncorrectoError = true
  ususarioNoExisteError = true

  constructor(private router:Router) { 
    let user = new Usuario("aleruijur", "aleruijur");
    this.registrados.push(user)
    user = new Usuario("user", "password");
    this.registrados.push(user)
    user = new Usuario("babel", "camp");
    this.registrados.push(user)
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
      let user = this.registrados.find(u=>u.username==newUser.username)
      if(user!=undefined){
        if(user.password==newUser.password){
          this.router.navigate(['/listado'])
        }else{
          this.passwordIncorrectoError = false
        }
      }else {
        this.ususarioNoExisteError = false
      }
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
