import { Component, OnDestroy, inject } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Store } from '@ngrx/store';
import { selectCart } from '../../store/selectors/book.selectors';
import { Router } from '@angular/router';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-navbar',
  standalone: true,
  imports: [CommonModule],
  template: `
    <nav>
      <span>BookStore</span>
      <span class="cart" (click)="goToCart()">
        🛒 <span>{{ cartCount }}</span>
      </span>
    </nav>
  `,
  styles: [`
    nav { display: flex; justify-content: space-between; align-items: center; padding: 1rem; background: #f8f8f8; }
    .cart { cursor: pointer; }
  `]
})
export class NavbarComponent implements OnDestroy {
  cartCount = 0;
  private subscription: Subscription;
  private store = inject(Store);
  private router = inject(Router);

  constructor() {
    this.subscription = this.store.select(selectCart).subscribe(cart => {
      // Add null/undefined check before Object.values()
      this.cartCount = cart 
        ? Object.values(cart).reduce((a: number, b: number) => a + b, 0)
        : 0;
    });
  }

  goToCart() {
    this.router.navigate(['/cart']);
  }

  ngOnDestroy() {
    this.subscription.unsubscribe();
  }
}
