import {Routes} from "@angular/router";
import {ChatComponent} from "./chat/chat.component";
import {AuthenticationRoutes} from "./authentication/authentication.routes";

export const routes: Routes = [

  ...AuthenticationRoutes,
  {
    path: '', component: ChatComponent
  },
  { path: '**',
    redirectTo: '/'
  }

];
