**Library Management System**

**Technologies Used**

- Apache NetBeans IDE
- MySQL Server 9.2.0
- MySQL Connector/J

**Setup Instructions**

- Open the Project
- Open NetBeans IDE.
- Click File > Open Project.
- Select the LibraryManagementSystem folder.
- Click Open Project.

**Configure the Database**

- Start your MySQL server.
- Open MySQL Workbench or Terminal and create the database:
- CREATE DATABASE LibraryDB;
USE LibraryDB;
-Import the database schema and initial data:
mysql -u root -p LibraryDB < librarydb_backup.sql
- Run the Project
- In NetBeans, right-click on the project and select Run.
- Follow the menu options to interact with the Library Management System.

**Features**

-View Available Books
- Add a New Book
- Borrow a Book
- Return a Book
- User Authentication System (Librarians & Members)

**Author**

Ellie EarwoodDate: March 2025
