# SpringBoob Java application for upload files to AWS S3 bucket.

This repository provides a simple implementation of upload files in a Java and Spring Boot application to Aws S3 bucket.
The project is built using Maven and demonstrates the integration of the AWs S2 and Java library.

For run the application you should use Java 17 (it should run on 8080) in Postman.
Hit the following API: http://localhost:8080/api/upload, method POST. Remember to include the required  body.

Before you run app, you should fill some parameters in file application.yaml, you should have S3 bucket or create
new one, also you should have accessKey and secretAccessKey of your AWS IAM User or create new one, and all this
data you need to use in application.yaml.

Example Request:
You should use "form-data", fill "key" name like "file", "value" you can upload file which you wanna upload to S3 
and send request

Example Response:

status 200 ok

Open your S3 bucket and you will see your file.