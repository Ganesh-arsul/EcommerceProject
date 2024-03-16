import { Injectable } from '@angular/core';
import { HttpService } from './http.service';
import { ENDPOINTS, SERVICES } from '../Constants/http';
import { User } from '../model/user';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private httpService:HttpService) { }

  public signIn(user:User):Observable<any>{
    return this.httpService.postMethod(SERVICES.USER,ENDPOINTS.LOGIN,user);
  }
}
