import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'searchUser'
})
export class SearchUserPipe implements PipeTransform {

  transform(users: any[], searchText: any, fieldName: string): unknown {

    if (!users) {
      return [];
    }

    if (!searchText) {
      return users;
    }

    console.log((typeof (searchText)));
    if (typeof (searchText) == 'string') {
      searchText = searchText.toLowerCase();
    }
    return users.filter(user => {
      if (user && user[fieldName]) {
        
        if(isNaN(searchText)) { 
          return user[fieldName].toLowerCase().includes(searchText);
        } else {
          return user[fieldName].includes(searchText);
        }
      }
    });
  }


}
