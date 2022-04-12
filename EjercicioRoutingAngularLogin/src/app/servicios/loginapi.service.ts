import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';

@Injectable({
  providedIn: 'root'
})
export class LoginapiService {

  readonly endPoint = 'http://localhost:8080/EjercicioWebLogin/usuarios/login'

  constructor(private _httpClient : HttpClient) { 
    
  }

  public estaRegistrado(nombre : string, password : string) : Observable<any>{   
    return this._httpClient.get<any>(`${this.endPoint}?nombre=${nombre}&password=${password}`)
  }

}
