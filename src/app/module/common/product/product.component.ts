import { HttpClient } from '@angular/common/http';
import { Component, EventEmitter, Input, Output } from '@angular/core';
import { Router } from '@angular/router';
import { subscribeOn } from 'rxjs';
import { Cart } from 'src/app/model/cart';
import { Product } from 'src/app/model/product';
import { User } from 'src/app/model/user';
import { CartService } from 'src/app/service/cart.service';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent {
  @Input()
  product!: Product;

  @Output() cartCount =new EventEmitter<string>();

  cart! : Cart;

  

  constructor(private cartService: CartService) { }

  ngOnInit(): void {
    this.getCartCount();

  }

  addTocart(prodId:string):void{
    var userId = sessionStorage.getItem("userId")
    if(userId && userId!=='0'){
      this.cart = new Cart();
      this.cart.productId = prodId;
      this.cart.userId = userId;
      this.cart.status = 'active';
      this.cartService.addCart(this.cart).subscribe((response:any) => {
        if(response.success = true){
          this.cart = response.data;
          alert("Product Added To Cart");

        }
      });
      this.getCartCount();

    }
    else{
      window.location.href='/signin';
    }
  }

  getCartCount(){
    var userId = JSON.parse(sessionStorage.getItem("userId") || '{}');
    this.cartService.getCartByUserId(userId).subscribe((response:any) => {
      if(response.success===true){
        var cartCount = response.data.length;
        this.cartCount.emit(cartCount);
      }
    });
  }

}
