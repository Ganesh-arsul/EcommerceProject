import { Injectable } from '@angular/core';
import { HttpService } from './http.service';
import { Observable } from 'rxjs';
import { ENDPOINTS, SERVICES } from '../Constants/http';

@Injectable({
  providedIn: 'root'
})
export class CategoryService {
  getCartByUserId(userId: string | null) {
    throw new Error('Method not implemented.');
  }

  constructor(private httpService: HttpService) { }

  getCategoryByMainCatId(mainCatId: number): Observable<any>{
    return this.httpService.getMethodByRefId(SERVICES.CAT,ENDPOINTS.BY_REF_ID,mainCatId); 
   }
}
