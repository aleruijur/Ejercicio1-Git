import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Videojuego } from 'src/app/entidades/videojuegos';
import { ListadoComponent } from '../listado/listado.component';

@Component({
  selector: 'app-detalles',
  templateUrl: './detalles.component.html',
  styleUrls: ['./detalles.component.css']
})
export class DetallesComponent implements OnInit {

  videojuego: Videojuego;

  constructor(private route: ActivatedRoute) {
    let videojuegos = ListadoComponent.listaVideojuegos
    let titulo = route.snapshot.params["titulo"]

    let posibleVideojuego = videojuegos.get(titulo)
    if(posibleVideojuego!=undefined){
      this.videojuego = posibleVideojuego
    }
  }

  ngOnInit(): void {
  }

}