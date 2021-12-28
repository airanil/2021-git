import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { DashboardService } from './dashboard.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss']
})
export class DashboardComponent implements OnInit {
  public requestForm:any;

  result:any;
  constructor(private ds:DashboardService,private fb:FormBuilder) { }

  ngOnInit(): void {
    this.requestForm=this.fb.group({
      flightId:['']
    });
  }

  getFlightList(){
    this.result=null;
    this.ds.getFlightList().subscribe(result=>{
      console.log(result);
      this.result=JSON.stringify(result)
    },error=>{
      this.result="server error";
      console.log("server error");
    });
  }

  addNewFlight(){
    this.result=null;
    this.ds.addNewFligh(this.requestForm?.get('flightId')?.value).subscribe(result=>{
      console.log(result);
      this.result=JSON.stringify(result);
    },error=>{
      this.result="server error";
      console.log("server error");
    });
  }


}
