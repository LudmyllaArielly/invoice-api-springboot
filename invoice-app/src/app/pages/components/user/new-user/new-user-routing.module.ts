import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { NewUserComponent } from './new-user.component';

const routes: Routes = [
{ path: 'newUser', component: NewUserComponent},
{ path: 'newUser/:id', component: NewUserComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class NewUserRoutingModule { }
