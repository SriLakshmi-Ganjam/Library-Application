import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'searchRequest'
})
export class SearchRequestPipe implements PipeTransform {

  transform(requests: any[], searchText: any, fieldName: string): unknown {

    if (!requests) {
      return [];
    }

    if (searchText>0) {
      return requests;
    }
    console.log((typeof (searchText)));
    if (typeof (searchText) == 'string') {
      searchText = searchText.toLowerCase();
    }
    return requests.filter(request => {
      if (request && request[fieldName]) {
        
        if(isNaN(searchText)) {
          return request[fieldName].toLowerCase().includes(searchText);
        } else {
          return request[fieldName].toString().includes(searchText);
        }
      }
    });
  }

}
