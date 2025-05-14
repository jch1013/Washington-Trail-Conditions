<h1>
Washington Trail Conditions
</h1>

<strong>Purpose:</strong>
The purpose of this project is to provide easily accessible weather forecasts for hiking trails listed on the Washington Trails Association (WTA)
website. 

This project used a webscraping program, written in python using the Beautiful Soup library, to compile a list of all trails listed on the WTA
website. In addition to the trail names, coordinate data for each trail was scraped. Data retrieved by this program was stored in a CSV file.

Trail data was transferred from the CSV file to a MySQL database to allow users to easily search for the name of any trail within the WTA system.
Currently, this application can only search for a trail based on the trail name, although in the future the ability to search by trail feature
or trail region may be added.

The website for this application was created using the Spring Boot framework, and the backend is written entirely in Java. Thymeleaf templates are 
used to build the user interface on the front end. 

This website was deployed on the Heroku cloud application platform, but due to updates in the Heroku hosting policy the site is not currently live.



