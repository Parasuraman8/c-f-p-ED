import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class DataService {
  private sharedStringSource = new BehaviorSubject<string>('');
  sharedString$ = this.sharedStringSource.asObservable();

  updateSharedString(newString: string) {
    this.sharedStringSource.next(newString);
  }
}