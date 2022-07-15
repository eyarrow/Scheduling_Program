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




