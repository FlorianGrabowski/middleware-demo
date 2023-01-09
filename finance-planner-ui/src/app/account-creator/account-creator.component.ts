import {Component} from '@angular/core';
import {AccountService} from "../services/account.service";

@Component({
  selector: 'app-account-creator',
  templateUrl: './account-creator.component.html',
  styleUrls: ['./account-creator.component.scss']
})

export class AccountCreatorComponent {

  name: string = "";
  isLoading: boolean = false;

  constructor(private accountService: AccountService) {
  }

  public addAccount(): void {
    this.isLoading = true;
    this.accountService.addAccount({name: this.name}).subscribe({
      next: (value) => console.log(value),
      error: (error) => {
        console.error(error);
      }
    }).add(() => this.isLoading = false);
  }
}
