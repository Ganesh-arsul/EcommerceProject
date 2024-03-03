import { Category } from "./category";

export interface MainCategory{
    mainCatId: number,
    catName: string,
    catDesc: string,
    status: string,
    categoryList: Category[]
    isCollpase: boolean
}
