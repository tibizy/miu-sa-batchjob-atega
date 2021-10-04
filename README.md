# miu-sa-batchjob-atega
MIU-SA Mini Project 1 October 2021

### Project Members
* **AJIBADE**, Eden Adetunji
* **Sule Odu** Ismail Oluwatobiloba 
* **Asrat** Girmay Kibreab

### Prerequisites
*docker

### Configuration
* Dockerfile
* docker-compose.yml

### Start-up Commands
* **package jar**: mvn clean package -DskipTests
* **start**: docker-compose up
* **stop**: docker-compose down

### Endpoints
 * Open POSTMAN
   * Click on "import" tab on the upper left side.
   * Select the Raw Text option and paste your cURL command.
   * Hit import, and you will have the command in your Postman builder!
   * Click Send to post the command.
* **login**
  * curl --location --request POST 'http://localhost:8080/api/auth/login' \
    --header 'Content-Type: application/json' \
    --data-raw '{
    "username": "admin",
    "password": "admin"
    }'
  
  * curl --location --request POST 'http://localhost:8080/api/auth/login' \
    --header 'Content-Type: application/json' \
    --data-raw '{
    "username": "user",
    "password": "user"
    }'
* **run batch job**
  * curl --location --request GET 'http://localhost:8080/api/admin/jobs' \
    --header 'Authorization: Bearer ey...'
