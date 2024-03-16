import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { APPURL, ENDPOINTS, SERVICES } from '../Constants/http';

@Injectable({
  providedIn: 'root'
})
export class HttpService {

  constructor(private http: HttpClient) { }

  headers = new HttpHeaders({
    'content-Type': 'application/json'
  });

  getMethod(service: string,endpoint: string): Observable<any>{
    return this.http.get(APPURL+service+endpoint,{headers: this.headers});
  }

  getMethodByRefId(service: string,endpoint: string, refId: number): Observable<any>{
    return this.http.get(APPURL+service+endpoint+refId,{headers: this.headers});
  }

  postMethod(service: string,endpoint: string,body:any):Observable<any>{
    return this.http.post(APPURL+service+endpoint,body,{headers: this.headers});

  }
}
