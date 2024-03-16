import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/model/user';
import { UserService } from 'src/app/service/user.service';

@Component({
  selector: 'app-signin',
  templateUrl: './signin.component.html',
  styleUrls: ['./signin.component.css']
})
export class SignInComponent implements OnInit {

  constructor(private userService:UserService){}
  
  username!:string;
  password!:string;
  user:User = new User();
  
  ngOnInit():void {

  }
  signIn():void{
    this.userService.signIn(this.user).subscribe((response:any) =>{
      if(response.success===true){
        this.user = response.data;
        sessionStorage.setItem("userId",this.user.userId.toString());
        window.location.href='/';
      }
    });
  }
}
  