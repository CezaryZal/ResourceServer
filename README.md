# SERVER RESOURCE 

#### Description

The main task of the application is users authentication.
Similarly, as it is done by *Gmail* (google server) or *Facebook*.
>The project is an alpha version. The works has been suspended
>(more information in the **Condition of suspension**)

The application has two endpoints, 
- *create new account* `**/server-resource/api/new-account`
- *log in* `**/server-resource/api/login`

The application contains common security mechanisms, *basic authentication* 
for each client. After a successful login, the service is receiving a request 
with the object that contains a login name and password. Then service validates the input data.
The passwords in the database are encrypted by Bcrypt, which prevents it to be disclosed to others.
If the data are the same as those in the database, a new token is assigned to the client. 
The token can be used in order to authenticate all applications related to Server Resource.

The database contains entities `users_hc` and `users_app`, more information
about their structure can be found in *template_data_server.sql* file.
The first is used to store user data, based on which the token will be created.
The second is used to store user data, customers who have permission to use the application. 
Only the administrator has direct access to both entities.

The application is fully validating received objects and successfully handling with exceptions.


**Creation purpose**

The main purpose of creating the application was to consolidate knowledge 
of Spring Security - an application that works as *Gmail’s* or *Facebook’s* 
authentication servers. The next reason was to reduce the security responsibility 
of the main application **Health Calendar**. In addition, it was to be used to 
authenticate users for other future applications.

**Conditions of suspension**

The new account was to be confirmed by activation link shared via email. However, account
could be disabled from the main application (*Health Calendar*),
which forces frequent exchanges and updating of data between applications.
An additional application that takes over the authentication task does not
increase the security of the main application. This causes an additional 
overload on the network and server.

#### Usage
A swagger UI is implemented in the project that contains a basic API documentation.


## Applied technologies
Backend:
- Maven
- Spring (Boot, Data, Security)
- REST API
- Lombok 
- Swagger UI (/server-resource/swagger-ui.html)
