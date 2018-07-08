import {Component, OnInit} from '@angular/core';
import {AppService} from "./app.service";
import {AuthenticationService} from "./authentication/authentication.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

  constructor(private appService: AppService,
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
        this.authenticationService.loggedUser = res;
      }
    );
  }

}
