import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-calculadora',
  templateUrl: './calculadora.component.html',
  styleUrls: ['./calculadora.component.css']
})
export class CalculadoraComponent implements OnInit {
  
  a: string
  b: string
  res: number | string

  constructor() {
    this.a = ""
    this.b = ""
    this.res = ""
  }

  private parse(): number[]{
    let ap = parseFloat(this.a)
    let bp = parseFloat(this.b)
    return [ap,bp]
  }

  public suma(): void{
    let p = this.parse()
    this.res = p[0] + p[1]
  }

  public resta(): void{
    let p = this.parse()
    this.res = p[0] - p[1]
  }

  public mult(): void{
    let p = this.parse()
    this.res = p[0] * p[1]
  }

  public div(): void{
    let p = this.parse()
    this.res = p[0] / p[1]
  }

  ngOnInit() {

  }

}
