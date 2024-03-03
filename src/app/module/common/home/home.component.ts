// src/app/module/common/home/home.component.ts
import { Component, OnInit } from '@angular/core';
import { Product } from 'src/app/model/product';
import { MainCategory } from 'src/app/model/maincategory';
import { MaincategoryService } from 'src/app/service/maincategory.service';
import { CategoryService } from 'src/app/service/category.service';
import { SubcategoryService } from 'src/app/service/subcategory.service';
import { Category } from 'src/app/model/category';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor(private mainCatService: MaincategoryService, private categoryService: CategoryService,private subCategoryService: SubcategoryService) { }

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
      this.mainCatService.getMainCategory().subscribe((response:any) => {
        if (response.success === true) {
          this.mainCategories = response.data;
          this.mainCategories.filter((mainCategory:MainCategory) =>{ 
            this.getCategoryByMainCatId(mainCategory);

            
          });
        }
      });
    }

    getCategoryByMainCatId(mainCategory: MainCategory){
      this.categoryService.getCategoryByMainCatId(mainCategory.mainCatId).subscribe((response:any) =>{
        if(response.success === true){
          mainCategory.categoryList = response.data;
          mainCategory.categoryList.filter((category:Category) => {
            category.cssClass='list-group collapse hide';
            this.getSubCategoryByCatId(category);
          });
        }
      });
    }
    
    getSubCategoryByCatId(category: Category){
      this.subCategoryService.getSubCategoriesByCatId(category.catId).subscribe((response:any) =>{
        if(response.success === true){
          category.subCatList = response.data;
        }
      })

    }

    changeArrow(mainCat: MainCategory){
       mainCat.isCollpase = !mainCat.isCollpase;
    }

    changeCatArrow(cat: Category){
      cat.isCollapse = !cat.isCollapse;
      cat.cssClass = cat.isCollapse?'list-group collapse show':'list-group collapse hide';
    }
}

