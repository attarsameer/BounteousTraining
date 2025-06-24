import { Component, OnDestroy, inject } from '@angular/core';
import { Store } from '@ngrx/store';
import { selectBooks, selectCart } from '../../store/selectors/book.selectors';
import { CommonModule } from '@angular/common';
import { BookCardComponent } from '../book-card/book-card.component';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-store-page',
  standalone: true,
  imports: [CommonModule, BookCardComponent],
  template: `
    <div class="store">
      <app-book-card
        *ngFor="let book of books"
        [book]="book"
        [inCart]="cart[book.id] || 0"
      ></app-book-card>
    </div>
  `,
  styles: [`
    .store { display: flex; flex-wrap: wrap; }
  `]
})
export class StorePageComponent implements OnDestroy {
  books: any[] = [];
  cart: { [key: string]: number } = {};

  private store = inject(Store);
  private subscriptions = new Subscription();

  constructor() {
    this.subscriptions.add(
      this.store.select(selectBooks).subscribe(books => this.books = books)
    );
    this.subscriptions.add(
      this.store.select(selectCart).subscribe(cart => this.cart = cart)
    );
  }

  ngOnDestroy() {
    this.subscriptions.unsubscribe();
  }
}
