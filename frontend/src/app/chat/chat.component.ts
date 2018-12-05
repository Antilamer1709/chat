import { Component, OnInit } from '@angular/core';
import {SocketService} from "../common/socket.service";
import {WsEndpoints} from "../common/ws.endpoints";

@Component({
  selector: 'app-chat',
  templateUrl: './chat.component.html',
  styleUrls: ['./chat.component.css']
})
export class ChatComponent implements OnInit {

  public messages: string[] = [];
  public messageContent: string;
  private stompClient;

  constructor(private socketService: SocketService) { }

  ngOnInit() {
    this.initializeWebSocketConnection();
  }

  private initializeWebSocketConnection(){
    this.stompClient = this.socketService.connect(WsEndpoints.SOCKET);

    this.stompClient.connect({}, frame => {
      this.stompClient.subscribe('/chat', message => {
        if(message.body) {
          this.messages.push(message.body);
          console.log(message.body);
        }
      })
      this.stompClient.subscribe('/userList', users => {
        console.log(users);
      })
    });
  }

  sendMessage(message){
    if (!message) {
      return;
    }

    this.stompClient.send("/app/send/message" , {}, message);
    this.messageContent = null;
  }

}
