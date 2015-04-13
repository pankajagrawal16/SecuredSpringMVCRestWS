# README #

The project repersents a POC to connect to a remotely hosted restWebService which is secured using Spring Security. The security mechanism is role based and the credentials or the user details can be fetched from the DataBase against which the authentication needs to be performed. The POC shows both stateful and stateless session management for browser or form-based-login and restTemplate based respectively.

### What is this repository for? ###

* Secured Spring MVC based Rest API
* Ver0.1
* Stateful + Stateless

### How do I get set up? ###

* CheckOut the source code from repository
* Import as existing maven project
* Resolve the dependencies by allowing maven to download the same
* Update the config.properties
* Deploy on tomcat
* Try to run the RestClient in test packages

### Who do I talk to? ###
Please feel free to raise an issue or you can contact me at : sumit.gaur@optimumalgorithms.com

### Special Thanks ###
Special thanks to [Pankaj Agrawal](https://github.com/pankajagrawal16) for figuring out Authentication Filter issue
