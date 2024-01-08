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
import { AuthGard } from './comman/auth-gard';
import { AdminManagerComponent } from './module/admin-manager/admin-manager.component';
import { UserBankComponent } from './user-bank/user-bank.component';
import { UserPaymentComponent } from './user-payment/user-payment.component';
import { OfficerManagerComponent } from './officer-manager/officer-manager.component';
import { OfficerPaymentComponent } from './module/officer-payment/officer-payment.component';
import { ComplaintsComponent } from './module/complaints/complaints.component';
import { UserPaymentSendComponent } from './module/user-payment-send/user-payment-send.component';
import { UserHistroyComponent } from './module/user-histroy/user-histroy.component';
import { UserComplaintsComponent } from './module/user-complaints/user-complaints.component';
import { ManageUserComponent } from './module/manage-user/manage-user.component';
import { ManageRoleComponent } from './module/manage-role/manage-role.component';
import { ManageCredentialComponent } from './module/manage-credential/manage-credential.component';
import { ManageOfficerComponent } from './module/manage-officer/manage-officer.component';
import { ManagePaymentComponent } from './module/manage-payment/manage-payment.component';
import { ManageAdminComponent } from './module/manage-admin/manage-admin.component';
import { UserInfoComponent } from './module/user-info/user-info.component';
import { AdminInfoComponent } from './module/admin-info/admin-info.component';
import { PaymentInfoComponent } from './module/payment-info/payment-info.component';
import { OfficerInfoComponent } from './module/officer-info/officer-info.component';
import { CredenInfoComponent } from './module/creden-info/creden-info.component';
import { RoleInfoComponent } from './module/role-info/role-info.component';
import { NewAdminRegisterFormComponent } from './module/new-admin-register-form/new-admin-register-form.component';
import { NewOfficerRegisterFormComponent } from './module/new-officer-register-form/new-officer-register-form.component';
import { NewRoleFormComponent } from './module/new-role-form/new-role-form.component';

const routes: Routes = [

  { path : 'home', component : HomePageComponent},
  { path : 'home',children : [
                          
  { path : 'login', component : LoginFormComponent},
  { path : 'Edu-page',component : UserHomeComponent/*,canActivate:[AuthGard]*/},
  { path : 'Edu-page',children : [
    { path : 'Bank-info', component : UserBankComponent},
    { path : 'User-Payment', component : UserPaymentComponent},
    { path : 'User-Payment', children : [
      { path : 'Pay', component : UserPaymentSendComponent},
      { path : 'history', component : UserHistroyComponent},
      { path : 'complaints', component : UserComplaintsComponent}
    ]},
  ]}, //,canActivate:[AuthGard]
  { path : 'Edo-page', component : EdoHomeComponent}, //,canActivate:[AuthGard]
   { path: 'Edo-page', children :[
    { path : 'officer-manager', component : OfficerManagerComponent},
    { path : 'officer-manager', children : [
      { path : 'Manage-User', component : ManageUserComponent},
      { path : 'Manage-User' , children:[
        { path: 'User-info', component : UserInfoComponent},
        { path : 'New-User', component : NewRegisterFormComponent}
      ]},
      { path : 'Manage-Creden', component : ManageCredentialComponent},
      { path : 'Manage-Creden' , children:[
        { path: 'Creden-info', component : CredenInfoComponent}
      ]},
      { path : 'Manage-Officer', component : ManageOfficerComponent},
      { path : 'Manage-Officer' , children:[
        { path: 'Officer-info', component : OfficerInfoComponent},
        { path : 'New-Officer', component : NewOfficerRegisterFormComponent}
      ]},
      { path : 'Manage-Payment', component : ManagePaymentComponent},
      { path : 'Manage-Payment' , children:[
        { path: 'Payment-info', component : PaymentInfoComponent}
      ]},

    ]},//,canActivate:[AuthGard]
    { path : 'officer-payments', component : OfficerPaymentComponent},
    { path : 'Complaints', component : ComplaintsComponent },
   ]}, //,canActivate:[AuthGard]
  { path : 'Eda-page', component : AdminHomeComponent}, //canActivate:[AuthGard]
  { path : 'Eda-page',children : [
    { path : 'Manager', component : AdminManagerComponent },
    { path : 'Manager',children : [
      { path : 'Manage-User', component : ManageUserComponent},
      { path : 'Manage-User', children:[
        {path : 'User-info', component : UserInfoComponent},
        { path : 'New-User', component : NewRegisterFormComponent}
      ]},
      { path : 'Manage-Role', component : ManageRoleComponent},
      { path : 'Manage-Role', children:[
        {path : 'Role-info', component : RoleInfoComponent},
        { path : 'New-Role', component : NewRoleFormComponent }
      ]},
      { path : 'Manage-Creden', component : ManageCredentialComponent},
      { path : 'Manage-Creden', children:[
        {path : 'Creden-info', component : CredenInfoComponent}
      ]},
      { path : 'Manage-Officer', component : ManageOfficerComponent},
      { path : 'Manage-Officer', children:[
        {path : 'Officer-info', component : OfficerInfoComponent},
        { path : 'New-Officer', component : NewOfficerRegisterFormComponent}
      ]},
      { path : 'Manage-Payment', component : ManagePaymentComponent},
      { path : 'Manage-Payment', children:[
        {path : 'Payment-info', component : PaymentInfoComponent}
      ]},
      { path : 'Manage-Admin', component : ManageAdminComponent},
      { path : 'Manage-Admin', children:[
        {path : 'Admin-info', component : AdminInfoComponent},
        { path : 'New-Admin', component : NewAdminRegisterFormComponent}
      ]},

    ]}
  ]},//,canActivate:[AuthGard]
  {path : 'login' , children : [

    { path : 'new-user-register-form',component : NewRegisterFormComponent},
    { path : 'forgot-user-credentials',component : ForgotUserCredentialsComponent},

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
