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
import { FormsModule } from '@angular/forms';
import { EditComponent } from './pages/components/invoice/edit/edit.component';
import { EditModule } from './pages/components/invoice/edit/edit.module';
import { DetailsComponent } from './pages/components/invoice/details/details.component';
import { DetailsModule } from './pages/components/invoice/details/details.module';
import { FooterComponent } from './shared/components/footer/footer.component';
import { UpdateStatusComponent } from './pages/components/update-status/update-status.component';




@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    ListComponent,
    NewComponent,
    EditComponent,
    DetailsComponent,
    FooterComponent,
    UpdateStatusComponent

  ],
  imports: [
    BrowserModule,
    NoopAnimationsModule,
    AppRoutingModule,
    HttpClientModule,
    ListModule,
    NewModule,
    EditModule,
    DetailsModule,
    FormsModule
  ],

  exports: [
    HeaderComponent,
    FooterComponent

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
