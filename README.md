# The Transaction Refund Management System (TRMS)
## Project Description
The Transaction Refund Management System, TRMS, allows users to submit reimbursements for courses and training. The submitted reimbursement must be approved by that employee's supervisor, department head, and benefits coordinator. The benefits coordinator then reviews the grade received before finalizing the reimbursement.

## Technologies Used
* Java
* HTML
* CSS
* JDBC
* SQL
* JavaScript
* AJAX
* Azure
* Javalin

## Features
List of features ready and TODOs for future development
* Allows users to submit reimbursements for different events (courses, certification courses, certification examns, many more)
* The submitted reimbursement must be approved by that employee's director supervisor, The department Head, and a Benefits Coordinator in that order.
* The user can then add a grade to the reimbursement for final approval.
* Director supervisor can check reimbursement and leave a status.
* Department Head and Benifits Coordinator can place grades, also leave notes on the status of the reimbursement.
* Benefit Coordinator que change the rewarded amount on the reimbursement of the employee that submited.

To-do list:
* Implement JWTs for better session tracking and authurization.
* Complete 100% coverage Unit Tests. 
* Refine User Experience.

## Getting Started
- git clone https://github.com/arac29/alma_alva_p1.git
- Within the connectionUtil.java, set your URL, Username, and Password in order to connect to your database
- Run the included SQL files under the Scripts folder in your database to setup tables and dummy data(replace dummy data as needed)
    1. drop-create-add-insert_references.sql
    2. login-employees.sql
    3. dummy-data.sql
- Open in an ID and navigate to TransactionRefundMS/src/main/java/TransactionRefundMS/ServerDriver.java and change the port if needed. The default is 9094.
- Run the serverDriver.java and navigate to http://localhost:'port'/ to test connectivity.

## Usage
- Navigate to http://localhost:'port'/ to be redirected to the login page. Use the provided dummy data to log in though the different user levels. 
