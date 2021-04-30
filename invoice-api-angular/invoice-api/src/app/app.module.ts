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



@NgModule({
  declarations: [
    AppComponent,
    ListComponent,
    HeaderComponent,
    NewComponent

  ],
  imports: [
    BrowserModule,
    NoopAnimationsModule,
    AppRoutingModule,
    ListModule,
    HttpClientModule,
    NewModule

  ],

  exports: [
    ListComponent,
    HeaderComponent

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
