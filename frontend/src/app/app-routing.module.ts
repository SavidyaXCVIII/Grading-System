import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {SelectUserComponent} from './select-user/select-user.component';
import {LogInComponent} from './shared/log-in/log-in.component';


const routes: Routes = [
  {
    path: '',
    component: SelectUserComponent
  },
  {
    path: 'log-in',
    component: LogInComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
