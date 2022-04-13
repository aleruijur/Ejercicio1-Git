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

  public estaRegistradoGet(nombre : string, password : string) : Observable<any>{   
    return this._httpClient.get<any>(`${this.endPoint}?nombre=${nombre}&password=${password}`)
  }

  public estaRegistradoPost(nombre : string, password : string) : Observable<any>{   
    let headers = new HttpHeaders();
    headers = headers.set('Content-Type', 'application/x-www-form-urlencoded');
    return this._httpClient.post<any>(`${this.endPoint}`,`nombre=${nombre}&password=${password}`,{headers: headers})
  }

}
