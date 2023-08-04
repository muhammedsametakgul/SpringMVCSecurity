# SpringMVCSecurity

This repository includes a basic project. This project:
- This project shows everyone  main page( src - main - resources - templates - home.html) - (localhost:8080)
- This project shows only teachers teacher section( src - main - resources - templates - teacher.html) - (localhost:8080/teachers). Anyone who has TEACHER role can access this section. Before this section,
  spring helps us and check if the user authenticated and authorizated. If everything is correct, login is successfull.

- This project shows only admins admin section( src - main - resources - templates - admin.html) - (localhost:8080/admin). Anyone who has ADMIN role can access this section. Before this section,
  spring helps us and check if the user authenticated and authorizated. If everything is correct, login is successfull.

  I created my own custom log in page instead of using spring's custom log in page. In SecurityConfig.java class, I have specified to Spring that I have my own custom log in page. I will use it to log in operations

   ![image](https://github.com/muhammedsametakgul/SpringMVCSecurity/assets/93324656/93e371ef-06b5-4a23-8cca-504e1e06fca1)

  As above, ".loginPage" refers to our custom log in page address,which we defined in LoginController, and ".loginProcessingUrl" is actually created by Spring. We do not need create, and it makes operations behind for us ( Magic:)
  And with ".logout", we gave right user to log out .

  -----------------------------------
  In this demo, I have used:
  - Spring Security
  - Spring Web
  - Spring Devtools
  - Thymeleaf
  - Basic HTML/CSS Codes and bootstrap
