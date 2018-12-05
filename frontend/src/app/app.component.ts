import {Component, OnInit} from '@angular/core';
import {AppService} from "./app.service";
import {AuthenticationService} from "./authentication/authentication.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

  constructor(private appService: AppService,
              private router: Router,
              public authenticationService: AuthenticationService) {
  }

  ngOnInit(): void {
    this.initLoggedUser();
  }

  private initLoggedUser(): void {
    this.authenticationService.getLoggedUser().subscribe(
      res => {
        console.log("loggedUser: ");
        console.log(res);
        if (res) {
          this.authenticationService.loggedUser = res;
        } else {
          this.router.navigate(['/login']);
        }
      }
    );
  }

}
