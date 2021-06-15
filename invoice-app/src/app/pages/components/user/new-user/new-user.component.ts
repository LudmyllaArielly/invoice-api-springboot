import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { NewUser } from 'src/app/shared/model/user/new-user.model';
import { UserService } from 'src/app/shared/user.service';

@Component({
  selector: 'app-new-user',
  templateUrl: './new-user.component.html',
  styleUrls: ['./new-user.component.scss']
})
export class NewUserComponent implements OnInit {

  newUser: NewUser = {
    id: null,
    cpf: '', 
    dateOfBirth: null,
    firstName: '', 
    lastName: ''
  }

  constructor(private userService: UserService, private route: Router, private router: ActivatedRoute) { }

  ngOnInit(): void {
    this.newUser.id = this.router.snapshot.params['id'];
    this.getUserFindById();
  }

  getUserFindById(){
    this.userService.getUserFindById(this.newUser.id ).subscribe(data => {
      this.newUser = data;
    }, error => console.log(error));
  }

  saveUser(){
    if(this.newUser.id != null){
      this.userService.updateUser(this.newUser).subscribe(data => {
        console.log(data);
        this.goToUserList();
      }, error => console.log(error));
    }else {
        this.userService.newUser(this.newUser).subscribe(data => {
          console.log(data);
          this.goToUserList();
        }, error => console.log(error));
    }
  }

  goToUserList(){
    this.route.navigate(['/listUser']);
  }

  onSubmit() {
    console.log(this.newUser);
    this.saveUser();
  }

}
