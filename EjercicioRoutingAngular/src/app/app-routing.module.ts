import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ContactarComponent } from './componentes/contactar/contactar.component';
import { DetallesComponent } from './componentes/detalles/detalles.component';
import { ListadoComponent } from './componentes/listado/listado.component';
import { LoginComponent } from './componentes/login/login.component';
import { SobrenosotrosComponent } from './componentes/sobrenosotros/sobrenosotros.component';

const routes: Routes = [
  {
    path : '',
    component : LoginComponent
  },
  {
    path : 'login',
    component : LoginComponent
  },
  {
    path : 'listado',
    component : ListadoComponent
  },
  {
    path : 'detalles/:titulo',
    component : DetallesComponent
  },
  {
    path : 'contactar',
    component : ContactarComponent
  },
  {
    path : 'sobrenosotros',
    component : SobrenosotrosComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
