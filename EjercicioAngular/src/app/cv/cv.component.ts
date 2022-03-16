import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-cv',
  templateUrl: './cv.component.html',
  styleUrls: ['./cv.component.css']
})
export class CvComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  nombre= "Alejandro Ruiz Jurado";
  email = "aleruizjurado@gmail.com";
  provincia = "Sevilla";

  java = "Java";
  python = "Python";

  titulo1 = "Grado de Ingeniería del Software";
  titulo2= "Bachiller Ciencias/Tecnológico";
  empresa = "Babel"

  ingles = "Inglés"
  nivelIngles = "B2"
}
