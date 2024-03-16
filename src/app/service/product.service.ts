import { Injectable } from '@angular/core';
import { HttpService } from './http.service';
import { Observable } from 'rxjs';
import { ENDPOINTS, SERVICES } from '../Constants/http';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  constructor(private httpService: HttpService) { }

  getAllProducts(): Observable<any>{
    return this.httpService.getMethod(SERVICES.PRODUCT,ENDPOINTS.ALL);

  }

  getAllProductsBySubCatId(subCatId: number){
    return this.httpService.getMethodByRefId(SERVICES.PRODUCT,ENDPOINTS.BY_REF_ID,subCatId);

  }
}
