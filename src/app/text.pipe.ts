import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'convert'
})
export class TextPipe implements PipeTransform {

  transform(text: string, format:string=''): string {
    if(format=='U')
       return text.toUpperCase()
    if(format=='L')
      return text.toLowerCase()   
    return text
  }

}

