
**Project Description**: Use of Rest API to perform different tasks in GitHub account

**Technical Description:** <br />
It is a Java Maven Project <br />
Programming Language used - Java <br />
Version - Java 8 (jdk 1.8) <br />
Maven dependency Used: 
- org.apache.httpcomponents httpclient 4.5.2
- org.json json 20160810

**Instructions to Run:** <br />
 1. Clone this maven project to the local space <br />
 2. Import the maven project to any IDE like eclipse <br />
 3. Go to StartDemo.java <br />
 4. Right click on StartDemo.java and run as Java Application <br />
 5. One can use any alternative way to run StartDemo.java <br />
 
 **Application Flow:** <br />
 Enter User Token: <br />
 *Enter your personal token generated from github account* <br />
 Options will be displayed as follows <br/>
 <img width="203" alt="option" src="https://media.github.ncsu.edu/user/11919/files/12282000-1d66-11e9-8e73-f5b5bb4c6295"> <br/>
 
 Task 1 : List all branches of an existing repo : Option 1 <br/>
 *Note:Here the username means the username of repo owner* <br/>
 Sample Run <br/>
 <img width="277" alt="1" src="https://media.github.ncsu.edu/user/11919/files/118f8980-1d66-11e9-9c57-89b6db4699a5"> <br/>
 
 Task 2 : Create a new repo : Option 2 <br/>
 Sample Run <br/>
<img width="232" alt="2" src="https://media.github.ncsu.edu/user/11919/files/118f8980-1d66-11e9-936e-217c63218c80"> <br/>

 Task 3 : Create an issue for an existing repo : Option 3 <br/>
 *Note:Here the username means the username of repo owner* <br/>
 Sample Run <br/>
 <img width="309" alt="3" src="https://media.github.ncsu.edu/user/11919/files/12282000-1d66-11e9-9657-2ba739680960"> <br/>
 
  Task 4 : Add an assignee to an existing issue : Option 4 <br/>
  *Note:Here the username means the username of repo owner* <br/>
 Sample Run <br/>
 <img width="337" alt="4" src="https://media.github.ncsu.edu/user/11919/files/12282000-1d66-11e9-8d1a-06fc7bc1bdc8"> <br/>
 
  Task 5 : Edit a repo to enable projects : Option 5 <br/>
  *Note:Here the username means the username of repo owner* <br/>
 Sample Run <br/>
 <img width="321" alt="5" src="https://media.github.ncsu.edu/user/11919/files/12282000-1d66-11e9-8399-1b9eb63a3171"><br/>
 
  Task 6 : List reactions for an issue : Option 6 <br/>
  *Note:Here the username means the username of repo owner* <br/>
 Sample Run <br/>
<img width="349" alt="6" src="https://media.github.ncsu.edu/user/11919/files/12282000-1d66-11e9-91af-6b6c895e0891"><br/>

**Code Description** <br/>
###### StartDemo.java <br/>
This class contains the main method from which the application is triggered <br/>

###### Utility.java <br/>
This class contains generic utilty methods to make GET (makeGetCall), POST (makePostCall)and PATCH (makePatchCall) http requests <br/>

###### Tasks.java <br/>
This class contains actual methods to perform different tasks with GitHub Account <br/>
- **setToken():** Used to set security token provided by the user <br/>
- **listAllBranchesOfRepo():** Used to perform task 1.1 i.e List all branches of an existing repo <br/>
- **createNewRepo():** Used to perform task 1.2 i.e Create a new repo <br/>
- **createNewIssue():** Used to perform task 1.3 i.e Create an issue for an existing repo <br/>
- **addAssigneeToIssue():** Used to perform task 1.4 i.e Add an assignee to an existing issue <br/>
- **editRepo():** Used to perform task 1.5 i.e Edit a repo to enable projects <br/>
- **listReactionsToIssue():** Used to perform task 1.6 i.e List reactions for an issue <br/>



 
 
 
 
 
