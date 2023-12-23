import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginFormComponent } from './module/login-form/login-form.component';
import { HomePageComponent } from './module/home-page/home-page.component';
import { ServiceComponent } from './module/service/service.component';
import { ContactComponent } from './module/contact/contact.component';
import { NewRegisterFormComponent } from './module/new-register-form/new-register-form.component';
import { ForgotUserCredentialsComponent } from './module/forgot-user-credentials/forgot-user-credentials.component';
import { UserHomeComponent } from './module/user-home/user-home.component';
import { EdoHomeComponent } from './module/edo-home/edo-home.component';
import { AdminHomeComponent } from './module/admin-home/admin-home.component';

const routes: Routes = [

  { path : 'home', component : HomePageComponent},
  { path : 'home', children : [
                          
  { path : 'login',component : LoginFormComponent},
  { path : 'user-profile', component : UserHomeComponent},
  { path : 'edo-profile', component : EdoHomeComponent},
  { path : 'admin-profile', component : AdminHomeComponent},
  {path : 'login' , children : [

    { path : 'new-user-register-form', component : NewRegisterFormComponent},
    { path : 'forgot-user-credentials', component : ForgotUserCredentialsComponent},

  ]},
  { path : 'service', component : ServiceComponent},
  { path : 'contact', component : ContactComponent},
  
  ]},
  { path : '' , redirectTo : '/home' , pathMatch : 'full'}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
