# Scheduling Desktop Application
A scheduler program built for a fictitious consulting company with multi-national offices. Completed in October of 2021. 

## Background
This application is for a fictional global consulting organization that conducts business in English and French, with main offices in Phoenix, Arizona; White Plains, New York; Montreal, Canada; and London, England.

Acme Consulting provides a MySQL database that the application must pull from; we cannot modify it. 

While this is a relatively straightforward assignment, the company has many specific business requirements that add complexity to the project. Using non-Java API libraries is not allowed except for JavaFX SDK and MySQL JDBC Driver. 

Concurrency would have been helpful for this use case, but using it was not allowed for this assignment. My solution utilizes a DAO (Data Access Object) and MVC (Master View Controller) design patterns. The application's front end is in Java and JavaFX, and the backend is Java and MySQL. 


### The business requirements are as follows:

#### Login Form
* Accepts a User ID and password and provides an appropriate error message if the combination is invalid. 
* Determines the user's location (i.e., their ZoneId) and displays it in a label on the login form.
* Displays the login form in English or French based on the user's computer language setting to translate all the text, labels, buttons, and errors on the form.
* Automatically translates error control messages into English or French based on the user's computer language setting.
* The application must save all logins to a log that includes the username and whether or not their login was successful. 


#### Customer Records
* Customer records and appointments can be added, updated, and deleted. When deleting a customer record, the program must first delete all of the customer's appointments due to foreign key constraints.
* When adding and updating a customer, text fields collect the following data: customer name, address, postal code, and phone number.
* Customer IDs are auto-generated, and first-level division (i.e., states, provinces) and country data are collected using separate combo boxes. 
* When a user updates a customer record, the customer data is auto-populated. 
* Country and first-level division data is prepopulated in separate combo boxes or lists in the user interface for the user to choose. The user's choices of first-level division should be limited to values valid for the selected country. In other words, if the country is Canada, only Canadian provinces should be listed.
* All of the original customer information is displayed on the update form.
* Customer_ID must be disabled.
* The user can update all of the fields except for Customer_ID.
* Customer data is displayed using a TableView, including first-level division data. The user may view a list of all customers and their information in a TableView. 
* A custom message should display in the user interface when deleting a customer record. 


### Scheduling Capabilities

* The user can add, update, and delete appointments. 
* A contact name is assigned to an appointment using a drop-down menu or combo box.
* A custom message is displayed in the user interface with the Appointment_ID and type of appointment canceled.
* The Appointment_ID is auto-generated and disabled throughout the application.
* When adding and updating an appointment, record the following data: Appointment_ID, title, description, location, contact, type, start date and time, end date and time, Customer_ID, and User_ID.
* All original appointment information is displayed on the update form in the local time zone.
* The user can update all appointment fields except the Appointment_ID, which must be disabled. 
* Write code that enables the user to view appointment schedules by month and week using a TableView and choose between these two options using tabs or radio buttons to filter appointments. Please include each of the following requirements as columns:
    * Appointment_ID
    * Title
    * Description
    * Location
    * Contact
    * Type
    * Start Date and Time
    * End Date and Time
    * Customer_ID 
* Write code that enables the user to adjust appointment times. While the appointment times should be stored in Coordinated Universal Time (UTC), they should be automatically and consistently updated according to the local time zone set on the user's computer wherever appointments are displayed in the application. 
* Write code to implement input validation and logical error checks to prevent each of the following changes when adding or updating information; display a custom message specific for each error check in the user interface:
    * scheduling an appointment outside of business hours defined as 8:00 a.m. to 10:00 p.m. EST, including weekends
    * overlapping scheduling appointments for customers
    * entering an incorrect username and password 
    * Write code to provide an alert when there is an appointment within 15 minutes of the user's login. A custom message should be displayed in the user interface and include the appointment ID, date, and time. If the user does not have any appointments within 15 minutes of logging in, display a custom message in the user interface indicating there are no upcoming appointments. 
    

## Implementation
### Application Information
--------------------------------------------------------------------------------------

TITLE : ACME Consulting Calendar System

PURPOSE: To provide a mechanism so that a fictitious consulting company can manage their customer records and their associated appointment scheduling using the application. 

AUTHOR: Elizabeth Yarrow

CONTACT: eyarrow@*.edu

APPLICATION VERSION: V1.5

DATE: October 18th, 2021


### Compilation Details [Built and Ran on University Virtual Machine]
--------------------------------------------------------------------------------------

IDE: IntelliJ IDEA 2021.1.1 (Community Edition)

JDK: Java JDK 11.0.11

JavaFX: JavaFX 11.0.2

MySQL Connector Driver: MySQL Connector 8.0.25


### Usage Instructions
--------------------------------------------------------------------------------------
#### LOGIN SCREEN:
![image](https://user-images.githubusercontent.com/12164300/179374181-6bff9dbc-2482-4f33-b377-fe36239cbc89.png)

To login to the application, enter "test" for the user name, and "test" for the password. Click on Sign in. On logging in a dialogue will display that will let you know if there are any appointments scheduled to start in the next 15 minutes. Click "Ok" to proceed, and the Overview page will load. 

The overview page provides a basic report and landing page for the program. The report data will be explained further in the "Custom Report" section of the README. The navigation menu appears to the left of the page, under the "ACME Consulting" logo image. Clicking on text of any of the menu items will direct you to the corresponding section of the program. 

Each screen of the program has instructions on how to use the page on in the top header, under the page title. 

This is how each section is organized: 

#### OVERVIEW :
![image](https://user-images.githubusercontent.com/12164300/179374188-bab53146-f160-4bb3-b88a-12d2fd2059b7.png)

This page shows dynamically updated numbers on upcoming appointments. Adding additional appointments will immediately update the aggregated numbers. 

#### CUSTOMERS: 
![image](https://user-images.githubusercontent.com/12164300/179374203-9a4d77cb-a5df-492b-8b95-ecd08107638d.png)

Clicking on CUSTOMERS in the main menu,  leads to a "Customers Overview" page. From there, you can click on "Add new customer" which will open the "Add Customer" screen, or you can review all of the existing customers by looking through the list of customers that loads to the right of the navigation menu. To view further details about the customer, delete the record, or modify it, first click on the customer on the list, and then click on the OPEN CUSTOMER RECORD button on the top of the page. This will load the "Modify Customer" page. 

#### CUSTOMERS > ADD CUSTOMER: 
![image](https://user-images.githubusercontent.com/12164300/179374212-27ac332f-3cf2-454e-9cf0-88513babe66a.png)

Use this screen to add a new customer to the application. All fields must be filled in to pass validation. Click OK to save the new customer record, or click CANCEL to return to the Customer Overview Page. This screen can be accessed both from the Customers Overview and Customer Modify pages. 

#### CUSTOMERS > DETAIL: 
![image](https://user-images.githubusercontent.com/12164300/179374221-f49a4601-358a-4784-8472-f5b77985312b.png)

The customer detail page can be accessed from the "Customer Overview" page, by clicking a customer on the list, and then clicking on OPEN CUSTOMER RECORD. The full customer record is printed out to the screen in an extended view. There are also buttons on this page to manipulate the displayed record. DELETE will remove the record from the program. MODIFY will allow you to change any of the fields of the customer record (except for the Customer ID). Click on RETURN TO LIST VIEW to return to the Customer Overview Page. 

#### CUSTOMERS > MODIFY: 
![image](https://user-images.githubusercontent.com/12164300/179374232-5f6cfb2d-5245-4037-9c55-afe9bae8502a.png)

Get to the modification screen by clicking on a customer record on the Customer Overview page, and then click on OPEN CUSTOMER RECORD. When the "Customer Detail" screen loads, click on MODIFY to get to the modification screen. All fields must be populated to submit the modification, and Customer ID cannot be altered. 

#### APPOINTMENTS: 
![image](https://user-images.githubusercontent.com/12164300/179374239-4e9ee997-54e4-4d19-ba81-492876b41e10.png)

Clicking on APPOINTMENTS in the main menu leads to the Appointment Overview screen. To the right of the menu bar, a list of all upcoming appointments load. Click on the WEEKLY radio button will change the list of upcoming appointments to only display the records that start in the next 7 days. Click on the MONTHLY radio button to change the view to the appointments starting in the next 30 days. Click on ADD APPOINTMENT on the top right hand corner to add a new appointment. To view the detail page for an appointment, click on the appointment record, and then the OPEN APPOINTMENT DETAIL screen to open the detail page. 

#### APPOINTMENTS > DETAIL: 
![image](https://user-images.githubusercontent.com/12164300/179374250-cc30858a-6bb4-4042-96c7-5d476835f57d.png)

Accessed from the Appointment Overview page. Lists the details of the appointment, and also offers options to either Modify the appointment by clicking on MODIFY or deleting the record by clicking on DELETE. Click on RETURN TO LIST VIEW to return to the Appointments Overview screen. 

#### APPOINTMENTS > ADD: 
![image](https://user-images.githubusercontent.com/12164300/179374255-7f72c312-0fd0-48a5-a685-02a24ac54a44.png)

Use this screen to add a new appointments record. All fields must be filled in, and the appointment times must fall within business hours. Click SAVE to add the record, and click CANCEL to return to the Appointments Overview screen. 

#### APPOINTMENTS > MODIFY: 
![image](https://user-images.githubusercontent.com/12164300/179374263-df8a1531-8270-4fcd-9a89-2169f4e1128e.png)

Modify an existing Appointment record. Click SAVE to make the update, and CLICK cancel to exit. 

#### REPORTS: 
![image](https://user-images.githubusercontent.com/12164300/179374276-9a6e9cb1-3157-4649-83c3-78829345bfb6.png)

Clicking on the REPORTS button on the main menu will lead to the primary reports page, where two reporting options are available. Use the drop down box on the upper right hand corner to choose the report of your choice. "Appointment Number by Type / Month" provides the aggregated numbers of appointments sorted by type and month of the year respectively. The "Appointments by Contact" report provides a list of appointments sorted by Contact. Use the drop down box at the top of the page (under the header) to choose the specific contact you want to view records for. 

LOG OUT:  Click on Log out to exit the application. It will return to the log in screen where you can either log in as another user, or close the application by clicking on "Exit the Application".


Additional Report
--------------------------------------------------------------------------------------
The additional required report can be accessed by clicking the OVERVIEW button on the main menu. This screens provides aggregate information about the appointments coming up soon. This is a breakdown of what it displays:

Today: These are appointments that have start times that occur between Now and the end of the business day (10 PM EST). Once an appointment's start time has passed, it is excluding from this calculation. 

Tomorrow: The number of appointments that occur on the next business day, between the hours of 8AM and 10PM EST. 

This week: The number of appointments that occur in the next 7 days. 








