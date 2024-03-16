import { Pipe, PipeTransform } from '@angular/core';
import { Product } from '../model/product';

@Pipe({
  name: 'filter'
})
export class FilterPipe implements PipeTransform {

  transform(list: Array<any>,value: String): Array<any> {
    return list.filter((obj:Product) => obj.prodName.toLowerCase().includes(value.toLowerCase()) || obj.prodDesc.toLowerCase().includes(value.toLowerCase()));
  }

}
