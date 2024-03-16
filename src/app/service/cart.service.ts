import { Injectable } from '@angular/core';
import { HttpService } from './http.service';
import { Observable } from 'rxjs';
import { Cart } from '../model/cart';
import { ENDPOINTS, SERVICES } from '../Constants/http';

@Injectable({
  providedIn: 'root'
})
export class CartService {

  constructor(private httpService: HttpService) { }

  addCart(cart:Cart): Observable<any>{
    return this.httpService.postMethod(SERVICES.CART,ENDPOINTS.ADD,cart);
  }

  getCartByUserId(userId: string): Observable<any> {
    return this.httpService.getMethodByRefId(SERVICES.CART, ENDPOINTS.BY_REF_ID, Number.parseInt(userId));
}

}

