import {
  Component,
  ViewChild,
  ViewContainerRef,
  
} from '@angular/core';
import { MessageComponent } from './message/message.component';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html'
})
export class AppComponent {
  title = 'app';
  @ViewChild('messagecontainer', { read: ViewContainerRef }) vcr: ViewContainerRef={} as ViewContainerRef;
    

    createComponent(message:string) {
      this.vcr.clear();
     
      const componentRef = this.vcr.createComponent(MessageComponent);
      componentRef.instance.message = message;
  }
}
