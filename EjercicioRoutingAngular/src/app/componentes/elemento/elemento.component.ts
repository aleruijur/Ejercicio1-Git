import { Component, Input, OnInit } from '@angular/core';
import { Videojuego } from 'src/app/entidades/videojuegos';

@Component({
  selector: 'app-elemento',
  templateUrl: './elemento.component.html',
  styleUrls: ['./elemento.component.css']
})
export class ElementoComponent implements OnInit {

  @Input() videojuego : Videojuego;

  constructor() { }

  ngOnInit(): void {
  }

}
