import { Injectable } from '@angular/core';
import { HttpService } from './http.service';
import { Observable, catchError } from 'rxjs';
import { observableToBeFn } from 'rxjs/internal/testing/TestScheduler';
import { SERVICES, ENDPOINTS } from '../Constants/http';

@Injectable({
  providedIn: 'root'
})
export class MaincategoryService {

  constructor(private httpService: HttpService) { }

  getMainCategory(): Observable<any> {
    return this.httpService.getMethod(SERVICES.MAIN_CAT, ENDPOINTS.ALL)
      .pipe(
        catchError((error: any) => {
          console.error('An error occurred:', error);
          // You can rethrow the error or handle it in a way that makes sense for your application.
          throw error;
        })
      );
      }}
