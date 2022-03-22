import { Component, OnInit } from '@angular/core';
import { Videojuego } from '../entidades/videojuegos';

@Component({
  selector: 'app-formulario',
  templateUrl: './formulario.component.html',
  styleUrls: ['./formulario.component.css']
})
export class FormularioComponent implements OnInit {

  listaVideojuegos: Videojuego[] = []

  id : number = 0
  titulo : string = ""
  compania : string = ""
  valoracion : string = ""

  tituloObligatorioOculto = true
  companiaObligatorioOculto = true
  valoracionObligatorioOculto = true
  valoracionRangoOculto = true
  
  constructor() { 
    let pokemon = new Videojuego("Pokemon Diamante", "Nintendo", "8.7")
    this.listaVideojuegos.push(pokemon)
    let forza = new Videojuego("Forza Horizon 5", "Xbox", "9.2")
    this.listaVideojuegos.push(forza)
    let doom = new Videojuego("Doom Eternal", "Bethesda", "9")
    this.listaVideojuegos.push(doom)
  }

  public insertar(){
    if(!this.hayErroresEnFormulario()){
      let v = new Videojuego(this.titulo, this.compania, this.valoracion)
      this.listaVideojuegos.push(v)
      this.vaciar()
    }   
  }

  public hayErroresEnFormulario():boolean{
    let error : boolean = false
    this.ocultarMensajesError()

    if(this.titulo.trim().length==0){
      this.tituloObligatorioOculto = false
      error = true
    }
    if(this.compania.trim().length==0){
      this.companiaObligatorioOculto = false
      error = true
    }
    if(isNaN(parseFloat(this.valoracion)) && this.valoracion.trim().length==0){
      this.valoracionObligatorioOculto = false
      error = true
    }else if(parseFloat(this.valoracion)>10 || parseFloat(this.valoracion)<0){
      this.valoracionRangoOculto = false
      error = true
    }
    
    return error
  }

  public vaciar(){
    this.id = 0
    this.titulo = ""
    this.compania = ""
    this.valoracion = ""

    this.ocultarMensajesError()
  }

  public ocultarMensajesError(){
    this.tituloObligatorioOculto = true
    this.companiaObligatorioOculto = true
    this.valoracionObligatorioOculto = true
    this.valoracionRangoOculto = true
  } 

  ngOnInit(): void {
  }

}