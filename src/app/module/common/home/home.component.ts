// src/app/module/common/home/home.component.ts
import { Component, OnInit } from '@angular/core';
import { Product } from 'src/app/model/product';
import { MainCategory } from 'src/app/model/maincategory';
import { MaincategoryService } from 'src/app/service/maincategory.service';
import { CategoryService } from 'src/app/service/category.service';
import { SubcategoryService } from 'src/app/service/subcategory.service';
import { Category } from 'src/app/model/category';
import { ProductService } from 'src/app/service/product.service';
import { CartService } from 'src/app/service/cart.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  constructor(private mainCatService: MaincategoryService, private categoryService: CategoryService,
    private subCategoryService: SubcategoryService, private productService: ProductService,
    private cartService: CartService) { }
  
  mainCategories: MainCategory[] = [];
  cartCount = 0;
  products: Product[] = [];
  userId: string = "0";
    searchTxt: String = '';
    
    ngOnInit(): void {
    this.getMainCategory();
    this.getAllProducts();
  
    
  }
    
    setCartCount($event: any){
      this.cartCount = $event;
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
    getAllProducts(){
      this.productService.getAllProducts().subscribe((response: any) => {
        if(response.success===true){
          this.products = response.data;

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

