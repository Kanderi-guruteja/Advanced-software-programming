# 1.Project Description:

This project is a car purchase application designed to cater to different user roles, including manufacturers, sales staff, admin, and customers. Each role has specific functionalities tailored to their needs, such as managing cars, scheduling appointments, and making reservations. Our application aims to streamline the car purchasing experience for both buyers and sellers, providing a convenient platform for all parties involved in the transaction process.

**User Roles**:

*Manufacturer*: Manages car listings, schedules appointments, and reserves cars.

*Sales Staff*: Manages customer appointments and assists in the purchasing process.

*Admin*: Oversees system operations and resolves issues.

*Customer*: Browses available cars, makes reservations, and manages account details.


**How Requirements Were Fulfilled**:

*User Authentication and Authorization:* Implemented secure login mechanisms and role-based access control.

*Manufacturer Functionality:* Developed interfaces for managing car inventory and scheduling appointments.

*Sales Staff Functionality:* Implemented features for managing customer appointments and assisting in the purchasing process.

*Admin Functionality:* Designed administrative tools for managing user accounts and monitoring system activity.

*Customer Functionality:* Developed a user-friendly interface for browsing cars, making reservations, and managing account details.

*Security Measures:* Employed security measures such as password hashing and role-based access control to protect user data.

*Enhanced User Experience:* Focused on providing an intuitive interface optimized for various devices.


# 2. Design:

**Navigation Flow**:

Users start with the login page and are redirected to role-specific home pages upon authentication.
Within each role-specific section, users can navigate to different functionalities using intuitive menus or links.

Any User can reserve a car with any valid login credentials.

**ER DIAGRAM**:


![ER_DIAGRAM_final_project](https://github.com/itmd4515/itmd4515-s24-fp-Kanderi-guruteja/assets/105558277/fbbcdb5e-b3d7-43bd-950c-3f821854ee5e)



*Extra Credit:*

Email Notifications: Attempted to implement email functionality for reservation confirmations and appointment reminders, but faced Gmail security issues.


## 3.Requirements:

Installation, Compile, Runtime, Database, etc

**Installation Steps**:
IDE Setup:
Download and install Apache NetBeans IDE version 20 from the official website.

**Database Setup**:
Install MySQL database server 8.0 on your machine for back end.Create a new database named itmd4515.
Configure port number 3306 , hostname and other details for ITMD4515.
provide full access to itmd4515 in users and privilages.


**Application Server Setup**:
Download and install Payara Server (Version 6.2023.12) from the official website.Set up Payara Server in your IDE by adding it as a server runtime environment.

**Build and Run Steps**:
Open Project in IDE:
Launch Apache NetBeans IDE.Create a new  project directory named gkanderi-fp.

**Dependencies/libraries and API’s WITH VERSIONS**:

Jakarta EE API: 10.0.0

MySQL Connector/J: 8.0.33

JUnit Jupiter API: 5.10.1

EclipseLink JPA: 4.0.1.payara-p2.v202310250827

Hibernate Validator: 8.0.1.Final

Expressly: 5.0.0

Jakarta Mail: 1.6.7

Maven will automatically download and resolve project dependencies based on the pom.xml file.

**Compile Project**:
Build the project by selecting the project in the IDE and choosing the "Build" option.

**Run Project**:
After successful compilation, deploy the project on the Payara Server by selecting the project in the IDE and choosing the "Run" option.Access the application using the appropriate URL provided by Payara Server.


## 4. Screen Captures:

**A.User Registration and Login:**

*Login page with SignUP Functionality:*
Login page with singup button:

Here , if you are an existing user you acn directly login with existing user details. Incase if you are an new user you can utilize the Signup functionality to create  a new user account and reserve a Car and look at the available Cars.


![image](https://github.com/itmd4515/itmd4515-s24-fp-Kanderi-guruteja/assets/105558277/854dfe93-48ff-4b2c-a1e7-21389f0a4fa9)


*Signup page to enter the required fields like username password full name and email:*

You will be asked to enter all the four input fields to register as User/Customer.


![image](https://github.com/itmd4515/itmd4515-s24-fp-Kanderi-guruteja/assets/105558277/ca342731-589f-4ccd-b5ad-e4ff4b2edd82)

*SignuP Confirmation Page:*

Upon successfull inputs you will be re-directed to registration successfull page. where you will have an option to login or return to home page.


![image](https://github.com/itmd4515/itmd4515-s24-fp-Kanderi-guruteja/assets/105558277/16ae1228-dbcb-486d-ab29-6b9c5a2bfe18)


*Logging In with newly signed up credentails:*

Now you can login with your credentilas to login to the Application.

![image](https://github.com/itmd4515/itmd4515-s24-fp-Kanderi-guruteja/assets/105558277/64b01daa-ff45-43ea-a11e-80a5e31d9936)


*User Creation in the database with the name "tej" with password hashing:*

![image](https://github.com/itmd4515/itmd4515-s24-fp-Kanderi-guruteja/assets/105558277/3ebb9a88-7b69-4a94-9f5f-f6b9c5d4c705)




**B. Customer Functions:**

*User Can Reserve a Car with the link provided:*

Deep dive into Customer functionality:

After successfull login, you will be able to see all the available car details and if you would like to reserve a car for you, You can utilize the reserve a car link to reserve a car.

![image](https://github.com/itmd4515/itmd4515-s24-fp-Kanderi-guruteja/assets/105558277/d743c750-aa46-4965-9821-64b2c1a71e4b)


*Reservation Confirmation Page:*

In this page , once you selected the car, date , time and car type you will re-directed to confirmation page with the details you entered while selecting.

![image](https://github.com/itmd4515/itmd4515-s24-fp-Kanderi-guruteja/assets/105558277/a2a86c0c-50cd-483b-8835-418c45d32ca0)


*Customer can access your upcoming reservations using a link My Reservations provided in the Home Screen:*

This functionality shows the reservations that has been created by the user. which gives clear information about at which date the reservations are reserved.

![image](https://github.com/itmd4515/itmd4515-s24-fp-Kanderi-guruteja/assets/105558277/bf48be95-c524-460b-a0d9-cc5d58a903fa)

**C. Manufacturer Functions:**

*Manufacturer Tab information:*

In the Manufacturer tab you will landed on the welcome page where you can also reserve a car, along with that Manufacturer will be provided additional functionality to manage tge Car invetory and scheduling the appointments, editing the cars availability and other functions.

![image](https://github.com/itmd4515/itmd4515-s24-fp-Kanderi-guruteja/assets/105558277/927a6878-cb6a-417a-a1dd-533f17a6e0a1)


*Creating a New Car as a Manufacturer using create a new car link:*


![image](https://github.com/itmd4515/itmd4515-s24-fp-Kanderi-guruteja/assets/105558277/47228a10-316c-41c8-8806-c3bd12e7e884)


*Manufacturer read-ONly mode about Car information:*

In this Read-Only mode user just able to see the details of the car.

![image](https://github.com/itmd4515/itmd4515-s24-fp-Kanderi-guruteja/assets/105558277/4b63893f-8933-407f-8c30-e54dc3c65483)

*Manufacturer editing the existing car:*

before editing:

Manufacturer can edit the cars inventory


![image](https://github.com/itmd4515/itmd4515-s24-fp-Kanderi-guruteja/assets/105558277/c197de21-6386-4767-875b-80e802e269f2)

*Edited the car name buick to buick_edited:*

![image](https://github.com/itmd4515/itmd4515-s24-fp-Kanderi-guruteja/assets/105558277/110c4d83-a295-4d05-9864-4826ed7b0aa7)


*Manufacturer Delete a car :*

At this monent you cannot delete a car because it has foreign keys connected to Appointments which deletes appointments if i try to delete a car.

![image](https://github.com/itmd4515/itmd4515-s24-fp-Kanderi-guruteja/assets/105558277/cf48c219-f21c-4764-88ee-70e9b262825c)


*Manufaturer scheduling an appointment:*

Manufacturer can scheduele and appointment for any selected car for servicing or any other potential operations.

![image](https://github.com/itmd4515/itmd4515-s24-fp-Kanderi-guruteja/assets/105558277/8669c158-f884-4bd2-8435-b25d2051e15c)

*Successfully created the appointments:*

In this page you can see the appointmenst that Manufacturer created in the past snapshots.

![image](https://github.com/itmd4515/itmd4515-s24-fp-Kanderi-guruteja/assets/105558277/787b8f80-11c9-435b-b894-a826b545f969)

**D. Sales Staff Functions:**

*When looged in as salessstaff1:*

Salesstaff also lands on the welcome page where salesstaff can be able to create the reservation for a particulat car and look after the existing reservations.
Along with that salesstaff can schedule an appointment for the car.

![image](https://github.com/itmd4515/itmd4515-s24-fp-Kanderi-guruteja/assets/105558277/db9cf021-1618-40cc-8011-9bc875867e8a)

*scheduling an appointment:*

![image](https://github.com/itmd4515/itmd4515-s24-fp-Kanderi-guruteja/assets/105558277/c5029ea0-7e12-4ba2-bb1f-bf0f503ceb1b)

*Retrived the scheduled appointment information in salesstaff page:*

![image](https://github.com/itmd4515/itmd4515-s24-fp-Kanderi-guruteja/assets/105558277/e465c8ff-bcb9-49d2-9ab1-e51f23d6a3fe)

*Viweing the scheduled appointment in Read-Only mode:*

![image](https://github.com/itmd4515/itmd4515-s24-fp-Kanderi-guruteja/assets/105558277/64807f58-72a0-4391-83cd-a1ed21fd8e6c)

**E. Admin Functions:**


*Admin home page:*

ADMIN can also reserve a car and look for existing reservations, along with that admin will ahve clear cut availability of cars in the admin welcome page.


![image](https://github.com/itmd4515/itmd4515-s24-fp-Kanderi-guruteja/assets/105558277/da628d92-62eb-49de-b20b-787d7cae4c89)




## 5. Expected Results/Known Issues:

To login to my application, you can register with any username, password using signup feature, use same to login as customer.

## Passwords
manufacturer1 - manufacturer1
salesstaff1 - salesstaff1
admin1 - admin1
Guest: can sign up their username and password and login with respect to their credentails.
   
## Extra Credit: Email Functionality:
 I attempted to implement the email functionality for the extra credit in the final project, but I encountered an issue related to Gmail security.

![image](https://github.com/itmd4515/itmd4515-s24-fp-Kanderi-guruteja/assets/105558277/db42aee8-e199-4010-bd1b-6f088cf81046)




## 6. Development Insights:

 Really enjoyed coding while working on this project. This project gave me enough idea how to build an enterprise application.

  would like to explore on application deployments, cloud related techniques too.
