import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddOrderComponent } from './add-order/add-order.component';
import { AddStudentComponent } from './add-student/add-student.component';
import { AdminAuthGuardGuard } from './admin-auth-guard.guard';
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';
import { HeaderComponent } from './header/header.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { OrderComponent } from './order/order.component';
import { PagenotfoundComponent } from './pagenotfound/pagenotfound.component';
import { RegisterUserComponent } from './register-user/register-user.component';
import { UpdateStudentComponent } from './update-student/update-student.component';
import { UserDashboardComponent } from './user-dashboard/user-dashboard.component';
import { UserProfileComponent } from './user-profile/user-profile.component';
import { UserGuard } from './user.guard';
import { ViewMedComponent } from './view-med/view-med.component';
import { ViewOrderAdminComponent } from './view-order-admin/view-order-admin.component';
import { ViewStudentsComponent } from './view-students/view-students.component';
import { ViewUserComponent } from './view-user/view-user.component';

const routes: Routes = [

{path:'',component:HomeComponent},
{path:'login',component:LoginComponent},
{ path:'re-user',component:RegisterUserComponent},
{ path:'home-home',component:HomeComponent},
{path:'add-order',component:AddOrderComponent},
{path:'view-profile',component:UserProfileComponent},

{ path:'admin',component:AdminDashboardComponent,canActivate:[AdminAuthGuardGuard],


    children:
    [
      {path:'update-student/:studentIdl',component:UpdateStudentComponent},
      { path:'addstudent',component:AddStudentComponent},
      { path:'view-user',component:ViewUserComponent},
      {path:'student-list',component:ViewStudentsComponent},
      {path:'view-order',component:ViewOrderAdminComponent},

        ]

      },

 { path:'user-dashboard',component:UserDashboardComponent,canActivate:[UserGuard],


 children:
    [

     {path:'view-med',component:ViewMedComponent},
     {path:'view-orders',component:OrderComponent},
     
    
    ]

   },


      {path:'**',component:PagenotfoundComponent}


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
