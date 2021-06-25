## About The Project
This is a demo spring boot application project with 2 services. 
URL: {HOST_URL}/swagger-ui.html

## Dependency
* Java 8
* Docker desktop
* Git
* Java IDE (Optional)

## How to run in local
1. Using code
    * Pull code in local
    * Open in IDE and run as maven projet
2. From image 
    ```sh
   docker login  // Ask developer for credentials 
   ```
   ```sh
   docker pull sayan21/product-service:latest
   ```
   ```sh
   docker images   // Collect the image id
   ```
   
   ```sh
     docker run -p 8081:8080 {IMAGE_ID}  // left port for local
   ```
## Developer Contact
Sayan Das - dassayan.it@gmail.com
