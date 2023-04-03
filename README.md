# harsh-smell-899
Automated Student Registration System

This project is an automated student registration system implemented using Java and the STS. It allows students to register for courses and provides administrators a interface for managing course and batch offerings and student registrations.



The tables includes the following entities:

Student: This table represents the students in the system. Each student has a unique ID, a first name, a last name, an address, a mobile number, an email address, a password, and a flag indicating whether the student is deleted or not.

Course: This table represents the courses offered by the system. Each course has a unique ID, a name, a fee, a duration, a description, and a flag indicating whether the course is deleted or not.

Batch: This table represents the batches associated with a course. Each batch has a unique ID, a name, a start date, an end date, a capacity, a strength, a course ID (foreign key to the Courses table), and a flag indicating whether the batch is deleted or not.

Student_Batch: This table represents the many-to-many relationship between students and batches. Each student can be associated with multiple batches, and each batch can have multiple students. This table has foreign keys to the Student and Batch tables.


Roles for Administrator:

Login to the system with a fixed username and password (username: admin, password: admin)
Add new courses to the system
Search for information about courses (by course name, duration range, and fee range)
Update details of courses
Create batches under a course
Search for information about batches (by batch name, by start date range, by end date range, by start and end date, by course name of the batch)
Update details of batches
View student details
View the student list of a batch
Consolidate the report batch-wise that contains the total students in every batch, and consolidate the report course-wise that contains the total batches and total students in every course
Logout of the system

Roles for a Student:

Sign up for an account with their first name, last name, address, mobile number, email, and password
Sign in to the system with their email and password
Update personal details
Change their password (old password must be entered)
View the list of available courses
View the list of upcoming batches for each course along with available seats
Register themselves in a course and select a batch from the list of upcoming batches
Logout of the system
Delete their account



