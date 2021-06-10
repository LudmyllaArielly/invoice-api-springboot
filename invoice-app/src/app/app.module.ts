import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { NoopAnimationsModule } from '@angular/platform-browser/animations';
import { ListComponent } from './pages/components/invoice/list/list.component';
import { AppRoutingModule } from './app-routing.module';
import { ListModule } from './pages/components/invoice/list/list.module';
import { HttpClientModule } from '@angular/common/http';
import { HeaderComponent } from './shared/components/header/header.component';
import { NewComponent } from './pages/components/invoice/new/new.component';
import { NewModule } from './pages/components/invoice/new/new.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { DetailsComponent } from './pages/components/invoice/details/details.component';
import { DetailsModule } from './pages/components/invoice/details/details.module';
import { FooterComponent } from './shared/components/footer/footer.component';
import { UpdateStatusComponent } from './pages/components/invoice/update-status/update-status.component';
import { UpdateStatusModule } from './pages/components/invoice/update-status/update-status.module';
import { NgxPaginationModule  } from 'ngx-pagination';
import { ListUserComponent } from './pages/components/user/list-user/list-user.component';
import { ListUserModule } from './pages/components/user/list-user/list-user.module';






@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    ListComponent,
    NewComponent,
    DetailsComponent,
    FooterComponent,
    UpdateStatusComponent,
    ListUserComponent,


  ],
  imports: [
    BrowserModule,
    NoopAnimationsModule,
    AppRoutingModule,
    HttpClientModule,
    ListModule,
    NewModule,
    UpdateStatusModule,
    DetailsModule,
    FormsModule,
    ReactiveFormsModule,
    NgxPaginationModule ,
    ListUserModule
 
  ],

  exports: [
    HeaderComponent,
    FooterComponent

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
