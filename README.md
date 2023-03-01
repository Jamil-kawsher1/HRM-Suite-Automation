

#  HRM Suite Automation with TestNG

This is Simple automation of an HRM Management Suite.
I have used TestNg as a test framework and faker library
to generate random users. Here I have automated user
login and creation and an automated employee search,employee Information Update System.


## Author

- [@Jamil-kawsher1](https://www.github.com/Jamil-kawsher1)
## Automation Video

https://user-images.githubusercontent.com/42008531/222211145-8cab2e94-f815-4878-a780-f02b5205789c.mp4


## How to run this project

- Clone This project
- open build.gradle file in IntelliJ IDEA
- Then Hit the follwing command in terminal

```bash
  allure generate allure-results --clean -o allure-report
  allure serve allure-results
```
## Tools and Tech
- IntelliJ IDEA
- Selenium with TestNG
- Allure
- Gradle


## Test Case:
https://docs.google.com/spreadsheets/d/16Ok6JD1ylwbG48nBUL2UlweG0opYqSVI/edit?usp=sharing&ouid=105413695096846736430&rtpof=true&sd=true



# Allure report Screenshots

![AllureOverView](https://user-images.githubusercontent.com/42008531/222208439-b4208564-e134-4606-8411-cff345fe6b01.jpg)
![AllureBehavirous](https://user-images.githubusercontent.com/42008531/222208467-5f9c6dbc-566e-40dc-8e1a-07f2e54a4a77.jpg)

# Allure Full Live Report Link



## Scenerio

1. Login to orange hrm demo site
https://opensource-demo.orangehrmlive.com/

2. Create 2 new employees and save it to a JSON list
3. Now go to PIM dashboard and search by 1st user name. Assert that the user is found.
4. Now click on the user from the search table and update id by random userid
5. Now again search the user by new user id from the PIM dashboard menu and assert that the user is found
6. Now logout from admin and login with the 2nd user from your JSON list
7. Now click on My Info menu
8. Select Gender and Blood Type and save it
9. Click on contact details and input address and email
10. Logout the user


