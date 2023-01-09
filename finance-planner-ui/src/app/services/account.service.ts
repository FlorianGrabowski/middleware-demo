import {Injectable} from '@angular/core';
import {Observable} from "rxjs";
import {Account} from "../models/account";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {environment} from "../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class AccountService {

  private controllerUrl = environment.backendApiHost + '/account';
  private defaultHeaders = {
    headers: new HttpHeaders({'Content-Type': 'application/json'})
  };

  constructor(private httpClient: HttpClient) {
  }

  public addAccount(account: Account): Observable<Account> {
    const endpointUrl = this.controllerUrl;
    return this.httpClient.post <Account>(endpointUrl, account, this.defaultHeaders);
  }
}
