import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { UpdateStatusComponent } from './update-status.component';

const routes: Routes = [{ path: 'update-status', component: UpdateStatusComponent }];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class UpdateStatusRoutingModule { }
