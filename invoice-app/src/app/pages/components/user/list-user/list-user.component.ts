import { Component, OnInit } from '@angular/core';
import { ListAllUser } from 'src/app/shared/model/list-user.model';
import { UserService } from 'src/app/shared/user.service';

@Component({
  selector: 'app-list-user',
  templateUrl: './list-user.component.html',
  styleUrls: ['./list-user.component.scss']
})
export class ListUserComponent implements OnInit {

  listAllUser: ListAllUser[];

  page: number = 1;
  count: number = 5;

  constructor(private userService: UserService) { }

  ngOnInit(): void {
    this.getAllUsers();
  }

  private getAllUsers(){
   this.userService.getAllUsers().subscribe((listAllUser: ListAllUser[]) =>{
     this.listAllUser = listAllUser;
     console.log(this.getAllUsers);
   });
  }

}
