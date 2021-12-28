import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class DashboardService {
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  }

  constructor(private http: HttpClient) { }

  getFlightList():Observable<any>{
    return this.http.get<any>(environment.apiURL + environment.domainUrl.getFlight, this.httpOptions);
  }
  addNewFligh(value:number):Observable<any>{
    return this.http.get<any>(environment.apiURL + environment.domainUrl.addFlight+ '/'+value, this.httpOptions);
  }

}
