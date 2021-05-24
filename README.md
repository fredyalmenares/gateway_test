# Gateway API
This project publishes an api that manages gateways and associated peripherals. 
It uses MySql database for the service and for unit testing.

### Running the service with maven

1. The first step is to create a copy of the .env.example file 
and rename it to .env (cp .env.example .env), then fill in the 
environment variables in the newly created file. The environment 
variables refer to ways of accessing the service and testing databases. 
   

2. It is required to have and active and reachable Mysql database for the service
to run. However, once the .env file is configured,
you can optionally use the command `docker-compose -f docker-compose-db.yml up -d`
to set up the two databases for you.
   

3. The next step is to run the following commands in a bash terminal:
    ```bash 
    source ./load_env.sh
    mvn clean install -Dmaven.test.skip
    java -jar ./target/*.jar
    ```
   Optionally, you may run `./run_with_maven.sh` instead. 


4. Once the service is running, the api documentation will be available at: 
http://localhost:<SERVER_PORT>/v1/api/swagger-ui/ (the final / is important)
   
5. For stopping the service press Ctrl + C.

### Running the tests with maven

1. Follow steps 1 and 2 in section "Running the service with maven"

2. Run the following commands in a bash terminal:
    ```bash 
    source ./load_env.sh
    mvn test
    ```
   Optionally, you may run `./test_with_maven.sh` instead. 
   
3. The test results will be displayed at the end of the run. 

### Running the service with docker-compose

1. Follow step 1 in section "Running the service with maven".

2. Modify the following env vars inside .env and set these values:
   ```
   MYSQL_HOST=mysqldb
   MYSQL_PORT=3306
   MYSQL_TEST_HOST=mysqldb-test
   MYSQL_TEST_PORT=3306
   ```

2. Run the following command in the root folder (alongside docker-compose.yml file): 
   `docker-compose up -d`. 

3. The docker-compose can take a while to finish its execution, 
   since it is a multistage build designed to make the final container 
   lighter. Once complete, the service can be found at 
   http://localhost:<SERVER_PORT>/v1/api/swagger-ui/
   
4. For stopping the service type docker-compose down -v in the root folder 
   (alongside docker-compose.yml file)

### Running the tests with docker-compose

1. Follow steps 1 and 2 in section "Running the service with docker-compose".

2. Run the following command: `docker-compose -f docker-compose-test.yml 
   up --abort-on-container-exit --exit-code-from api-test`

3. The test results will be displayed at the end of the run. 