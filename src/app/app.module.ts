import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import{ HttpClientModule} from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ViewStudentsComponent } from './view-students/view-students.component';
import { AddStudentComponent } from './add-student/add-student.component';
import { ReactiveFormsModule } from '@angular/forms';
import { UpdateStudentComponent } from './update-student/update-student.component';
import { AdminNevbarComponent } from './admin-nevbar/admin-nevbar.component';
import { LoginComponent } from './login/login.component';
import { UserDashboardComponent } from './user-dashboard/user-dashboard.component';
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';
import { ViewUserComponent } from './view-user/view-user.component';
import { RegisterUserComponent } from './register-user/register-user.component';
import { UserNevbarComponent } from './user-nevbar/user-nevbar.component';
import { PagenotfoundComponent } from './pagenotfound/pagenotfound.component';
import { ViewMedComponent } from './view-med/view-med.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { HomeComponent } from './home/home.component';
import { OrderComponent } from './order/order.component';
import { AddOrderComponent } from './add-order/add-order.component';
import { UserProfileComponent } from './user-profile/user-profile.component';
import { ViewOrderAdminComponent } from './view-order-admin/view-order-admin.component';

@NgModule({
  declarations: [
    AppComponent,
    ViewStudentsComponent,
    AddStudentComponent,
    UpdateStudentComponent,
    AdminNevbarComponent,
    LoginComponent,
    UserDashboardComponent,
    AdminDashboardComponent,
    ViewUserComponent,
    RegisterUserComponent,
    UserNevbarComponent,
    PagenotfoundComponent,
    ViewMedComponent,
    HeaderComponent,
    FooterComponent,
    HomeComponent,
    OrderComponent,
    AddOrderComponent,
    UserProfileComponent,
    ViewOrderAdminComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
