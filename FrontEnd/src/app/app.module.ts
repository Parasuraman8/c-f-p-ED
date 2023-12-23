import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { NgbCarouselModule } from '@ng-bootstrap/ng-bootstrap';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomePageComponent } from './module/home-page/home-page.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { LoginFormComponent } from './module/login-form/login-form.component';
import { ServiceComponent } from './module/service/service.component';
import { ContactComponent } from './module/contact/contact.component';
import { NewRegisterFormComponent } from './module/new-register-form/new-register-form.component';
import { ForgotUserCredentialsComponent } from './module/forgot-user-credentials/forgot-user-credentials.component';
import { EdoHomeComponent } from './module/edo-home/edo-home.component';
import { UserHomeComponent } from './module/user-home/user-home.component';
import { AdminHomeComponent } from './module/admin-home/admin-home.component';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    HomePageComponent,
    LoginFormComponent,
    ServiceComponent,
    ContactComponent,
    NewRegisterFormComponent,
    ForgotUserCredentialsComponent,
    UserHomeComponent,
    EdoHomeComponent,
    AdminHomeComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule,
    NgbCarouselModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
