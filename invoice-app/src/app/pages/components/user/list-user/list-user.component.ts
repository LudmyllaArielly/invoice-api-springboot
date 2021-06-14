import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ListAllUser } from 'src/app/shared/model/user/list-user.model';
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

  constructor(private userService: UserService, private route: Router) { }

  ngOnInit(): void {
    this.getAllUsers();
  }

  private getAllUsers(){
   this.userService.getAllUsers().subscribe((listAllUser: ListAllUser[]) =>{
     this.listAllUser = listAllUser;
     console.log(this.getAllUsers);
   });
  }

  editUser(id: number){
    this.route.navigate(['newUser', id]);
  }

}
