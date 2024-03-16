import { Pipe, PipeTransform } from '@angular/core';
import { Product } from '../model/product';

@Pipe({
  name: 'randomObj'
})
export class RandomObjPipe implements PipeTransform {

  transform(list: Array<any>): Product[] {
    const newList = [...list];
    newList.sort(() => Math.random() - 0.5);
    return newList;
  }

}
