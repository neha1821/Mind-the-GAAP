import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { LoginComponent } from './login/login.component';
import { AdminHeaderComponent } from './admin/admin-header/admin-header.component';
import { AdminFooterComponent } from './admin/admin-footer/admin-footer.component';
import { AdminHomeComponent } from './admin/admin-home/admin-home.component';
import { CustomerHeaderComponent } from './customer/customer-header/customer-header.component';
import { CustomerFooterComponent } from './customer/customer-footer/customer-footer.component';
import { CustomerHomeComponent } from './customer/customer-home/customer-home.component';
import { NewCustomerComponent } from './customer/new-customer/NewCustomerComponent';
import { AccountRequestComponent } from './admin/account-request/account-request.component';
import { AccountDetailsComponent } from './admin/account-request/account-details/account-details.component';
import { CustomerRequestComponent } from './admin/customer-request/customer-request.component';
import { CustomerDetailsComponent } from './admin/customer-request/customer-details/customer-details.component';
import { LoginPasswordComponent } from './admin/login-password/login-password.component';
import { LoginDetailsComponent } from './admin/login-password/login-details/login-details.component';
import { CustomerhomeDetailsComponent } from './customer/customerhome-details/customerhome-details.component';
import { CustomerAccountsComponent } from './customer/customer-accounts/customer-accounts.component';
import { NewAccountComponent } from './customer/new-account/new-account.component';
import { TransferComponent } from './customer/customer-accounts/transfer/transfer.component';
import { TransactionListComponent } from './customer/customer-accounts/transaction-list/transaction-list.component';
import { ChequeComponent } from './customer/customer-accounts/cheque/cheque.component';
import { ChequeRequestComponent } from './admin/cheque-request/cheque-request.component';
import { ChequeDetailsComponent } from './admin/cheque-request/cheque-details/cheque-details.component';
import { UpdatePasswordComponent } from './customer/customerhome-details/update-password/update-password.component';


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    AdminHeaderComponent,
    AdminFooterComponent,
    AdminHomeComponent,
    CustomerHeaderComponent,
    CustomerFooterComponent,
    CustomerHomeComponent,
    NewCustomerComponent,
    AccountRequestComponent,
    AccountDetailsComponent,
    CustomerRequestComponent,
    CustomerDetailsComponent,
    LoginPasswordComponent,
    LoginDetailsComponent,
    CustomerhomeDetailsComponent,
    CustomerAccountsComponent,
    NewAccountComponent,
    TransferComponent,
    TransactionListComponent,
    ChequeComponent,
    ChequeRequestComponent,
    ChequeDetailsComponent,
    UpdatePasswordComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
