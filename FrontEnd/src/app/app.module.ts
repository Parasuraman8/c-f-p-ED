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
import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';
import { LoginRequest } from './pojo/login-request';
import { AuthInterceptor } from './comman/intercept';
import { LoginResponse } from './pojo/login-response';
import { AdminManagerComponent } from './module/admin-manager/admin-manager.component';
import { AdminProfileComponent } from './admin-profile/admin-profile.component';
import { OfficerManagerComponent } from './officer-manager/officer-manager.component';
import { UserBankComponent } from './user-bank/user-bank.component';
import { UserPaymentComponent } from './user-payment/user-payment.component';
import { PaymentComponent } from './payment/payment.component';
import { OfficerPaymentComponent } from './module/officer-payment/officer-payment.component';
import { ComplaintsComponent } from './module/complaints/complaints.component';
import { UserPaymentSendComponent } from './module/user-payment-send/user-payment-send.component';
import { UserHistroyComponent } from './module/user-histroy/user-histroy.component';
import { UserComplaintsComponent } from './module/user-complaints/user-complaints.component';
import { ManageUserComponent } from './module/manage-user/manage-user.component';
import { ManageOfficerComponent } from './module/manage-officer/manage-officer.component';
import { ManageCredentialComponent } from './module/manage-credential/manage-credential.component';
import { ManagePaymentComponent } from './module/manage-payment/manage-payment.component';
import { ManageRoleComponent } from './module/manage-role/manage-role.component';
import { ManageAdminComponent } from './module/manage-admin/manage-admin.component';
import { UserInfoComponent } from './module/user-info/user-info.component';
import { OfficerInfoComponent } from './module/officer-info/officer-info.component';
import { AdminInfoComponent } from './module/admin-info/admin-info.component';
import { CredenInfoComponent } from './module/creden-info/creden-info.component';
import { PaymentInfoComponent } from './module/payment-info/payment-info.component';
import { RoleInfoComponent } from './module/role-info/role-info.component';
import { NewOfficerRegisterFormComponent } from './module/new-officer-register-form/new-officer-register-form.component';
import { NewAdminRegisterFormComponent } from './module/new-admin-register-form/new-admin-register-form.component';
import { NewRoleFormComponent } from './module/new-role-form/new-role-form.component';
import { PayRequest } from './pojo/pay-request';


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
    AdminHomeComponent,
    AdminManagerComponent,
    AdminProfileComponent,
    OfficerManagerComponent,
    UserBankComponent,
    UserPaymentComponent,
    PaymentComponent,
    OfficerPaymentComponent,
    ComplaintsComponent,
    UserPaymentSendComponent,
    UserHistroyComponent,
    UserComplaintsComponent,
    ManageUserComponent,
    ManageOfficerComponent,
    ManageCredentialComponent,
    ManagePaymentComponent,
    ManageRoleComponent,
    ManageAdminComponent,
    UserInfoComponent,
    OfficerInfoComponent,
    AdminInfoComponent,
    CredenInfoComponent,
    PaymentInfoComponent,
    RoleInfoComponent,
    NewOfficerRegisterFormComponent,
    NewAdminRegisterFormComponent,
    NewRoleFormComponent,
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    NgbModule,
    NgbCarouselModule,
    FormsModule,
  ],
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: AuthInterceptor,
      multi: true
    },
    LoginRequest,
    LoginResponse,
    PayRequest
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
