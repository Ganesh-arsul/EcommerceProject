// src/app/module/common/home/home.component.ts
import { Component, OnInit } from '@angular/core';
import { Product } from 'src/app/model/product';
import { MainCategory } from 'src/app/model/maincategory';
import { MaincategoryService } from 'src/app/service/maincategory.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor(private mainCatService: MaincategoryService) { }

  mainCategories: MainCategory[] = [];
  products: Product[] = [
    {
      "prodName":"shirt1",
      "prodDesc":"This is half sleaves",
      "prodPrice":"5700",
      "status":"active",
      "catId":52
    },
    {
      "prodName":"shirt2",
      "prodDesc":"This is half sleaves",
      "prodPrice":"5700",
      "status":"active",
      "catId":52
    },
    {
      "prodName":"shirt3",
      "prodDesc":"This is half sleaves",
      "prodPrice":"5700",
      "status":"active",
      "catId":52
    },
    {
      "prodName":"shirt4",
      "prodDesc":"This is half sleaves",
      "prodPrice":"5700",
      "status":"active",
      "catId":52
    },
    {
      "prodName":"shirt5",
      "prodDesc":"This is half sleaves",
      "prodPrice":"5700",
      "status":"active",
      "catId":52
    },
    {
      "prodName":"shirt6",
      "prodDesc":"This is half sleaves",
      "prodPrice":"5700",
      "status":"active",
      "catId":52
    },
    {
      "prodName":"shirt7",
      "prodDesc":"This is half sleaves",
      "prodPrice":"5700",
      "status":"active",
      "catId":52
    }
  ];
  ngOnInit(): void {
    this.getMainCategory();
  }

  getMainCategory(): void {
    this.mainCatService.getMainCategory().subscribe((response: any) => {
      if (response.success === true) {
        this.mainCategories = response.data;
        console.log("Main Cat:" + JSON.stringify(this.mainCategories));
      }
    });
  }
}
