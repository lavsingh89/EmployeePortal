import { Component, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { HttpClientService, Employee } from '../service/http-client.service';
import { Router } from '@angular/router';


@Component({
  selector: 'app-add-employee',
  templateUrl: './add-employee.component.html',
  styleUrls: ['./add-employee.component.css'],
  styles: ['p { color: blue; text-align: left; }']
})
export class AddEmployeeComponent implements OnInit {

  user: Employee = new Employee("","","",new Date,"");

  constructor(private httpClientService: HttpClientService,private router: Router) { }

  ngOnInit() {
  }

  @ViewChild('myForm')
  private myForm: NgForm;

  register(myForm: NgForm) {
    if(myForm.invalid == true){
      alert("One or more of the required fields are not field or wrongly filled")
    }
    else if(myForm.value.gender=="---Select---" || myForm.value.department=="---Select---"){
      alert("One or more of the required fields are not field or wrongly filled")
    }
    else{
      this.createEmployee();
    }
    console.log('Registration successful.');
    console.log(myForm.invalid);
    console.log(myForm.value);
  }

  createEmployee(): void {
    this.httpClientService.createEmployee(this.user)
        .subscribe( data => {         
         this.btnClick();
        },error => {alert("Some Problems in submitting form.\n\n PLEASE TRY AGAIN")});

  };

  btnClick= function () {
    this.router.navigateByUrl('/');
  };

}
