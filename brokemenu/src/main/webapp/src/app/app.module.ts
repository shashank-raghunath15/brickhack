import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule} from '@angular/forms';


// import { AngularFireModule } from 'angularfire2';
// import { AngularFireDatabaseModule } from 'angularfire2/database';
// import { AngularFireAuthModule } from 'angularfire2/auth';

// import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

import { AppComponent } from './app.component';


import { environment } from './../environments/environment';
import { AppNavbarComponent } from './app-navbar/app-navbar.component';

import { HttpClientModule } from '@angular/common/http';
import { LoginComponent } from './components/login/login.component';
import { SignUpComponent } from './components/sign-up/sign-up.component';
import { LoginService } from './services/login.service';
import { SignupService } from './services/signup.service';
import { RecipeComponent } from './components/recipe/recipe.component';
import { RecipeService } from './services/recipe.service';

@NgModule({
  declarations: [
    AppComponent,
    // UserComponent,
    AppNavbarComponent,
    LoginComponent,
    SignUpComponent,
    RecipeComponent
  ],
  imports: [
    BrowserModule,
    // AngularFireModule.initializeApp(environment.firebase),
    // AngularFireDatabaseModule,
    // AngularFireAuthModule,
    // NgbModule.forRoot(),
    HttpClientModule,
    FormsModule
  ],
  providers: [LoginService, SignupService, RecipeService],
  bootstrap: [AppComponent]
})
export class AppModule { }
