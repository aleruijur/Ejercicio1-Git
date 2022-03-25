import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Videojuego } from 'src/app/entidades/videojuegos';

@Component({
  selector: 'app-listado',
  templateUrl: './listado.component.html',
  styleUrls: ['./listado.component.css']
})
export class ListadoComponent implements OnInit {

  videojuegos: Videojuego[] = []

  static usuario = ""

  constructor(route:ActivatedRoute) { 
    let v = new Videojuego("Pokémon Leyendas Arceus", "Nintendo", "8.5", "https://i.blogs.es/5cea4c/leyendas-pokemon-arceus-portada/1024_2000.jpeg");
    this.videojuegos.push(v)
    v = new Videojuego("Doom Eternal", "Bethesda", "9", "https://as01.epimg.net/meristation/imagenes/2019/06/10/game_cover/822593211560152836.jpg");
    this.videojuegos.push(v)
    v = new Videojuego("Forza Horizon 5", "Xbox", "9.2", "https://pressakey.com/gfxgames/boxart/full/Forza-Horizon-5-7329-1629836165.jpg");
    this.videojuegos.push(v)

    let actualUser = route.snapshot.queryParams['username']
    if(this.usuarioReg.trim().length == 0 || this.usuarioReg!=actualUser && actualUser!=undefined){
      ListadoComponent.usuario = actualUser
    }
  }

  get usuarioReg(){
    return ListadoComponent.usuario
  }

  ngOnInit(): void {
  }

}
