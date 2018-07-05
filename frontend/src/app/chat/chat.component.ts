import { Component, OnInit } from '@angular/core';
import {ChatService} from "./chat.service";

@Component({
  selector: 'app-chat',
  templateUrl: './chat.component.html',
  styleUrls: ['./chat.component.css']
})
export class ChatComponent implements OnInit {

  public notifications = 0;

  constructor(private chatService: ChatService) { }

  ngOnInit() {
    let stompClient = this.chatService.connect();

    stompClient.connect({}, frame => {

      stompClient.subscribe('/topic/notification', notifications => {

        this.notifications = JSON.parse(notifications.body).count;

      })

    });
  }

}
