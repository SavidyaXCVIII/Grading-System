import { Component, OnInit } from '@angular/core';
import {MatDialog} from '@angular/material/dialog';
import {LogInComponent} from '../shared/log-in/log-in.component';

@Component({
  selector: 'app-select-user',
  templateUrl: './select-user.component.html',
  styleUrls: ['./select-user.component.css']
})
export class SelectUserComponent implements OnInit {

  constructor(public dialog: MatDialog) {
  }

  ngOnInit(): void {
  }

  openLogIn(type: string): void {
    const dialogRef = this.dialog.open(LogInComponent, {
      width: '600px',
      data: type
    });
    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
    });
  }
}
