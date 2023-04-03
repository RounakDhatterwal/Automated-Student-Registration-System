# harsh-smell-899
Automated Student Registration System

This project is an automated student registration system implemented using Java and the STS. It allows students to register for courses and provides administrators a interface for managing course and batch offerings and student registrations.



The tables includes the following entities:

Student: This table represents the students in the system. Each student has a unique ID, a first name, a last name, an address, a mobile number, an email address, a password, and a flag indicating whether the student is deleted or not.

Course: This table represents the courses offered by the system. Each course has a unique ID, a name, a fee, a duration, a description, and a flag indicating whether the course is deleted or not.

Batch: This table represents the batches associated with a course. Each batch has a unique ID, a name, a start date, an end date, a capacity, a strength, a course ID (foreign key to the Courses table), and a flag indicating whether the batch is deleted or not.

Student_Batch: This table represents the many-to-many relationship between students and batches. Each student can be associated with multiple batches, and each batch can have multiple students. This table has foreign keys to the Student and Batch tables.

