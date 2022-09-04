import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ProcessService {

  private readonly baseUrl = `${environment.apiUrl}/process`;
  
  constructor() { }
}
