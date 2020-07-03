import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import { SelectUserComponent } from './select-user/select-user.component';
import { LogInComponent } from './shared/log-in/log-in.component';

@NgModule({
  declarations: [
    AppComponent,
    SelectUserComponent,
    LogInComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
