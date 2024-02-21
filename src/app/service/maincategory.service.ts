import { Injectable } from '@angular/core';
import { HttpService } from './http.service';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MaincategoryService {

  constructor(private httpService: HttpService) { }

  getMainCategory():Observable<any>{
  return this.httpService.getMainCategory();
  }
}
