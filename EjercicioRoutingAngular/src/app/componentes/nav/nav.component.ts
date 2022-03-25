import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ListadoComponent } from '../listado/listado.component';

@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.css']
})
export class NavComponent implements OnInit {

  constructor() { 
  
  }

  ngOnInit(): void {
  }

}
