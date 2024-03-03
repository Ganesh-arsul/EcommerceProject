import { SubCategory } from "./subcategory";

export interface Category{
    catId: number,
    catName: string,
    catDesc: string,
    catImage: string,
    imageName: string,
    status: string,
    mainCatId: number,
    subCatList: SubCategory[]
    cssClass: String,
    isCollapse: boolean
}