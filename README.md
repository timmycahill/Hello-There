# Hello There

## Project Description

Hello There is a social media platform where users can write posts and share their ideas with the world.

## Technologies Used

* Angular - 11.0.2
* Node - 14.15.1
* Bootstrap - 3.3.7
* JQuery - 3.1.1
* Java - 1.8
* JUnit - 4.11
* Log4J - 2.13.3
* JDBC
* Maven - 4.0.0
* Tomcat - 8.5.60
* AWS RDS
* PostgreSQL - 42.2.18
* Java Servlet - 3.1.0
* Jackson - 2.11.3

## Features

Features:
* Users can submit requests.
* Users can view their pending/resolved requests.
* Users can view their personal information.
* Admins can view all pending/resolved requests.
* Admins can approve/deny requests.
* Admins can create new users.
* Admins can view all employees.

To-do list:
* Users can edit their personal information.
* Users can reset their passwords.
* Admins can view requests by user.

## Getting Started

Before you get started, make sure you have the following installed:
   1. Apache Tomcat 8 (https://tomcat.apache.org/)
   2. Java 1.8 (https://www.oracle.com/java/technologies/javase-jre8-downloads.html)
   3. Git (https://git-scm.com/)
   
In order to set up Tomcat, download the zip file from the website provided and extract it to your C: drive's base directory. (C:\) 
   
Once you have Tomcat set up, you can clone the current repo to your device using the following git command:
* `git clone https://github.com/timmycahill/Expense-Reimbursements.git`

Once you have cloned the repository, you are ready to start up your Tomcat server. To do this, navigate to `C:\apache-tomcat-8.5.60\bin` and run the `startup.bat` file.
With Tomcat running, navigate to the `Expense-Reimbursements/Project1/target/` folder, copy the `Project1.war` file, and paste it in the `C:\apache-tomcat-8.5.60\webapps` folder. After a few seconds, you should see a folder named Project1 appear in the `C:\apache-tomcat-8.5.60\webapps` folder. Your application is now on the server and ready to be accessed.

To access the application, open up your browser and type `localhost:8080` into the address bar.

## Usage

> Users can log in and submit remibursement requests to be reviewed by their managers. Managers can log in and approve/deny requests submitted by their employees.
