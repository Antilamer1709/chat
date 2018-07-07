import { Component, OnInit } from '@angular/core';
import {ChatService} from "./chat.service";
import $ from 'jquery';

@Component({
  selector: 'app-chat',
  templateUrl: './chat.component.html',
  styleUrls: ['./chat.component.css']
})
export class ChatComponent implements OnInit {

  title = 'WebSockets chat';
  private stompClient;

  constructor(private chatService: ChatService) { }

  ngOnInit() {
    this.initializeWebSocketConnection();
  }

  private initializeWebSocketConnection(){
    this.stompClient = this.chatService.connect();

    this.stompClient.connect({}, frame => {
      this.stompClient.subscribe('/chat', message => {
        if(message.body) {
          $(".chat").append("<div class='message'>"+message.body+"</div>")
          console.log(message.body);
        }
      })
    });
  }

  sendMessage(message){
    this.stompClient.send("/app/send/message" , {}, message);
    $('#input').val('');
  }

}
