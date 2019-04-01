## Employee Portal

Employee Portal has a registration form which enables user to register by filling valid details and a view page where user can see the list of employees.

This project has two main components
1.  `EmployeePortal`: This contains Java code of the application.
2.  `employee-management`: This contains source code for the Angular 7 based frontend.


### Pre requisites
- Java 1.8
- Maven
- Angular 7

###  Installation
1. Clone the project by entering `git clone https://github.com/lavsingh89/EmployeePortal.git`

### Deployment

#### How to deploy frontend app?

Run `ng serve` for a dev server in the main project folder of employee-management . Navigate to `http://localhost:4200/`. The app will automatically reload if you change any of the source files.

##### Build 

Run `ng build` to build the project. The build artifacts will be stored in the `dist/` directory.

##### Running unit tests
Run `ng test` to execute the unit tests via KARMA

#### How to deploy backend app?

You can build the package as a single artifact by running the  `./mvn clean install`. Next, you can run the application by executing:

`$ java -jar EmployeePortal/target/EmployeePortal-0.0.1-SNAPSHOT`

The application will be accessible at  `http://localhost:8080`


### How it Works?
- Employee portal UI page can be accessed by the URL `http://localhost:4200/` after deploying the UI component as mentioned above.
- Home page will show the list of registered employees 
- A user can register by clicking on [**Add New Employee**](http://localhost:4200/addemployee)
- A user can view the employees by clicking [**View Employees**](http://localhost:4200/)
