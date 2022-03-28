import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Videojuego } from 'src/app/entidades/videojuegos';

@Component({
  selector: 'app-listado',
  templateUrl: './listado.component.html',
  styleUrls: ['./listado.component.css']
})
export class ListadoComponent implements OnInit {

  private static videojuegos: Map<string,Videojuego> = new Map();

  static usuario = ""

  constructor(route:ActivatedRoute) { 
    let v = new Videojuego("Pokémon Leyendas Arceus", "Nintendo", "8.5", "https://i.blogs.es/5cea4c/leyendas-pokemon-arceus-portada/1024_2000.jpeg");
    if(!ListadoComponent.videojuegos.has(v.titulo)){
      ListadoComponent.videojuegos.set(v.titulo,v)
    }
    v = new Videojuego("Doom Eternal", "Bethesda", "9", "https://as01.epimg.net/meristation/imagenes/2019/06/10/game_cover/822593211560152836.jpg");
    if(!ListadoComponent.videojuegos.has(v.titulo)){
      ListadoComponent.videojuegos.set(v.titulo,v)
    }
    v = new Videojuego("Forza Horizon 5", "Xbox", "9.2", "https://pressakey.com/gfxgames/boxart/full/Forza-Horizon-5-7329-1629836165.jpg");
    if(!ListadoComponent.videojuegos.has(v.titulo)){
      ListadoComponent.videojuegos.set(v.titulo,v)
    }

    let actualUser = route.snapshot.queryParams['username']
    if(actualUser!=undefined && (this.usuarioReg.trim().length == 0 || this.usuarioReg!=actualUser)){
      ListadoComponent.usuario = actualUser
    }
  }

  get usuarioReg(){
    return ListadoComponent.usuario
  }

  //Necesario para acceder a la lista de videojuegos en DetallesComponent
  static get listaVideojuegos(){
    return ListadoComponent.videojuegos
  }

  //Necesario para acceder a la lista de videojuegos en la template debido a que es estática
  get listaVideojuegos(){
    return Array.from(ListadoComponent.videojuegos.values())
  }

  ngOnInit(): void {
  }

}
