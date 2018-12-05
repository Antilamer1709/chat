import { Injectable } from '@angular/core';

import { Stomp} from 'stompjs/lib/stomp.js';
import SockJS from 'sockjs-client';

@Injectable({
  providedIn: 'root'
})
export class SocketService {

  constructor() { }

  connect() {
    let socket = new SockJS('http://localhost:8080/socket');

    let stompClient = Stomp.over(socket);

    return stompClient;
  }

}
