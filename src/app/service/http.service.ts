import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class HttpService {

  constructor(private http: HttpClient) { }

  header = new HttpHeaders({
    'content-Type': 'application/json'
  });

  getMainCategory(): Observable<any>{
    return this.http.get('http://localhost:8083/main-category/all',{headers:this.header});
  }
}
