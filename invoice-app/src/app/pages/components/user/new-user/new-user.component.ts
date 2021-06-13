import { Component, OnInit } from '@angular/core';
import { NewUser } from 'src/app/shared/model/user/new-user.model';

@Component({
  selector: 'app-new-user',
  templateUrl: './new-user.component.html',
  styleUrls: ['./new-user.component.scss']
})
export class NewUserComponent implements OnInit {

  newUser: NewUser = {
    cpf: '', 
    dateOfBirth: null,
    firstName: '', 
    lastName: ''
  }

  constructor() { }

  ngOnInit(): void {
  }


  onSubmit() {
    console.log(this.newUser);
  }

}
