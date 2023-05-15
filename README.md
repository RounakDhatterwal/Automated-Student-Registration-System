# harsh-smell-899
<h2>Automated Student Registration System</h2>

This project is an automated student registration system implemented using Java and the STS. It allows students to register for courses and provides administrators a interface for managing course and batch offerings and student registrations.

#### Video Link - https://drive.google.com/drive/folders/1gwhX66pGzXSJ510V1SxzB8Ihh1EKjpcC?usp=share_link

#### To Setup project locally first we have to import the sql and then we have to import our project under genral project section  

<h3>The tables includes the following entities:</h3>

<h4>Student:</h4> This table represents the students in the system. Each student has a unique ID, a first name, a last name, an address, a mobile number, an email address, a password, and a flag indicating whether the student is deleted or not.

<h4>Course:</h4> This table represents the courses offered by the system. Each course has a unique ID, a name, a fee, a duration, a description, and a flag indicating whether the course is deleted or not.

<h4>Batch:</h4> This table represents the batches associated with a course. Each batch has a unique ID, a name, a start date, an end date, a capacity, a strength, a course ID (foreign key to the Courses table), and a flag indicating whether the batch is deleted or not.

<h4>Student_Batch:</h4> This table represents the many-to-many relationship between students and batches. Each student can be associated with multiple batches, and each batch can have multiple students. This table has foreign keys to the Student and Batch tables.


<h3>Roles for Administrator:</h3>
1. Login to the system with a fixed username and password (username: admin, password: admin) <br>
2.  Add new courses to the system<br>
3. Search for information about courses (by course name, duration range, and fee range)<br>
4. Update details of courses<br>
5. Create batches under a course<br>
6. Search for information about batches (by batch name, by start date range, by end date range, by start and end date, by course name of the      batch)<br>
7. Update details of batches<br>
8. View student details<br>
9. View the student list of a batch<br>
10. Consolidate the report batch-wise that contains the total students in every batch, and consolidate the report course-wise that contains the total batches and total -students in every course<br>
11. Logout of the system<br>

<h3>Roles for a Student:</h3>
1. Sign up for an account with their first name, last name, address, mobile number, email, and password<br>
2. Sign in to the system with their email and password<br>
3. Update personal details<br>
4. Change their password (old password must be entered)<br>
5. View the list of available courses<br>
6. View the list of upcoming batches for each course along with available seats<br>
7. Register themselves in a course and select a batch from the list of upcoming batches<br>
8. Logout of the system<br>
9. Delete their account<br>


<h3>ER Diagram :</h3>

![ER Diagram](https://user-images.githubusercontent.com/115460483/230307686-1180834a-2846-4aa9-96a4-2ef58d3b2f75.PNG)



