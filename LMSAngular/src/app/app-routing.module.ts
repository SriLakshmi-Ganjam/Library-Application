import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { AboutComponent } from './about/about.component';
import { ContactUsComponent } from './contact-us/contact-us.component';
import { RegisterComponent } from './register/register.component';
import { LoginComponent } from './login/login.component';
import { AddBookComponent } from './add-book/add-book.component';
import { ShowUsersComponent } from './show-users/show-users.component';
import { ShowBooksComponent } from './show-books/show-books.component';
import { RequestComponent } from './request/request.component';
import { ShowRequestsComponent } from './show-requests/show-requests.component';
import { IssueComponent } from './issue/issue.component';
import { UpdateComponent } from './update/update.component';
import { AuthGuard } from './auth.guard';
import { AdminAuthGuardGuard } from './admin-auth-guard.guard';
import { UserAuthGuardGuard } from './user-auth-guard.guard';
import { ReturnedBooksComponent } from './returned-books/returned-books.component';



const routes: Routes = [{ path: '', component: HomeComponent },
{ path: 'about', component: AboutComponent },
{ path: 'contact', component: ContactUsComponent },
{ path: 'register', component: RegisterComponent },
{ path: 'login', component: LoginComponent },
{ path: 'showBooks', component: ShowBooksComponent, canActivate: [AuthGuard] },
{ path: 'addBook', component: AddBookComponent, canActivate: [AdminAuthGuardGuard] },
{ path: 'showUsers', component: ShowUsersComponent, canActivate: [AdminAuthGuardGuard] },
{ path: 'issue', component: IssueComponent, canActivate: [AdminAuthGuardGuard] },
{ path: 'request', component: RequestComponent,canActivate:[UserAuthGuardGuard] },
{ path: 'showRequests', component: ShowRequestsComponent,canActivate:[AdminAuthGuardGuard] },
{ path: 'update', component: UpdateComponent, canActivate: [AdminAuthGuardGuard] },
{ path: 'returnedBooks', component:ReturnedBooksComponent,canActivate:[AdminAuthGuardGuard]}


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
