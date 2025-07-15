import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-dashboard',
  imports: [],
  templateUrl: './dashboard.html',
  styleUrl: './dashboard.scss',
})
export class Dashboard {
  constructor(private router: Router) {}

  logout() {
    sessionStorage.removeItem('token');
    this.router.navigate(['/']);
  }
}
