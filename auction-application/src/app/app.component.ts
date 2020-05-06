import { Component } from '@angular/core';
import { ApiService } from '../app/api.service';
@Component({
    selector: 'app-root',
    templateUrl: './app.component.html',
    styleUrls: ['./app.component.css']
})
export class AppComponent {
    num: string = '';
    size: number = 0;
    title = 'auction application';
    collection: any = [];
    saveForm: any = {
        reservePrice: 0,
        item: {
            itemId: null,
            description: null
        }
    }

    bid: any = {
        auctionItemId: 0,
        maxAutoBidAmount:0,
        bidderName:null
    }
    constructor(private apiService: ApiService) { }
    ngOnInit() {
        this.getalldata();
    }



    search() {
        /*this.apiService.getPhoneNumbers(this.num).subscribe((data)=>{
            console.log(data);
            this.collection = data;
          });*/
        this.collection = [];
        this.apiService
            .getPhoneNumbers<any[]>(this.num)
            .subscribe((data: any[]) => this.collection = data,
                error => () => {

                },
                () => {
                    this.size = this.collection.length;
                });
    }
    submitForm() {
        this.apiService
            .getSave('auctionItems', this.saveForm).subscribe((data: any[]) => {
                console.log(data);
                this.collection = data;
            });
    }
    getalldata() {
        this.apiService
            .getItems('auctionItems').subscribe((data: any[]) => {
                console.log(data);
                this.collection = data;
            });
    }
    // error => () => {
    //     () => {
    //         this.size = this.collection.length;
    //     });
    // }
}