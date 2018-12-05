import { Injectable } from '@angular/core';

import { Stomp} from 'stompjs/lib/stomp.js';
import SockJS from 'sockjs-client';
import {WsEndpoints} from "./ws.endpoints";

@Injectable({
  providedIn: 'root'
})
export class SocketService {

  private serverPrefix: string = 'http://localhost:8080/';

  constructor() { }

  connect(endpoint: WsEndpoints) {
    let socket = new SockJS(this.serverPrefix + endpoint);

    return Stomp.over(socket);
  }

}
