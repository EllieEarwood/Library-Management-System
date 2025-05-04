Library Management System

Technologies Used

Apache NetBeans IDE
MySQL Server 9.2.0
MySQL Connector/J
Setup Instructions

Configure the Database

Start your MySQL Server.

Open MySQL Workbench or Command Line.

Create the database:

CREATE DATABASE LibraryDB; USE LibraryDB;

Import the database schema and initial data:

mysql -u root -p LibraryDB < librarydb_backup.sql

Ensure librarydb_backup.sql is in the same folder as MySQL or specify the full path
Open the Project in NetBeans

Open NetBeans IDE.

Click File > Open Project.
Select the LibraryManagementSystem folder.
Click Open Project.
Run the Project

In NetBeans, right-click on the project and select Run.
Follow the menu options to interact with the Library Management System.
Features

View Available Books
Add a New Book
Borrow a Book
Return a Book
Author: Ellie Earwood Date: May 2025