*** springboot Dictionary web appliication ****

> Required Java Version 1.8
> Required maven 3.0.5



> Used Amazon dynamo DB for storing the unique records into the DB

> follow below steps to know how the application works

	Step 1: unzip the file / clone the repo
	Step 2: Run cmd : mvn clean install
	Step 3: Run cmd : mvn spring-boot:run
	Step 4: once the server is up hit localhost:8080/   and wait until the page loads where you can upload your txt file
	step 5: Hit Url http://localhost:8080/searchWord to search for a word in the Dictionary (Database)
