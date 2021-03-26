# ParvinHajili
Web and Mobile II - Assignment 3 - RESTFull API for Library CRUD application


Please create Backend Application using Spring Boot technology which will consist of Registration, Authentication, Library & Book Pick-up/Drop-off functionality by integration with PostgreSQL and JPA (Java Persistance API)
1. Registration/Authentication
1.1. User can register with it's own email and password
1.2. User should go through authentication with his email and password and then receive the token
2. Library & Book Pick-up/Drop-off
2.1. Library should contain information about categories of the books (Sci-Fi, Economy, STEM and etc.)
2.2. Library should provide information about the list of the books with metadata information (Author, Published Date and etc) and  Availability in Library (if not available information about who picked-up the book)
2.3. Search the book by: name, category and/or author name
2.4. Ability to pick-up or drop-off the book from/to library
2.5. Get the list of the currently pick-up books from library (by logged in user)
2.6. Get the history of pick-up/drop-off from library for whole period (by logged in user)
2.7. User should be able to see list of courses which he could be enrolled to (list of the courses should be stored in database, fetched from database and rendered in page)
Note: All your solutions SHOULD be pushed to remote Git repository 
Total possible points for this assignment is 15.
Assessment criteria is the following:
1.1. Usage of the technologies and techniques covered in Lecture materials and explained by Instructor - 50%
1.3. Implementation of the whole scope of business requirements - 20%
1.2. Clean Code - 10% (project structure, code structure, patterns usage, logging and etc)
1.3. Storage of password in encrypted way - 10%
1.4. Containerization of the application via Docker - 10%
