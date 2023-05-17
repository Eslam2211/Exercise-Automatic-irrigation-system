

Automatic irrigation system

## Iam Used
-   Java v17
-   maven
-   Spring boot 
-   Spring Data Jpa 
-   Spring Rest
-   MySql


## How to Run
- Run sql scripts  at DataBase  Folder.
run project : `mvn spring-boot:run`
	

## in database
insert data into two table plots and crops only 
the table irrigation  the data insert into automatic,But I did not create the function to add the data
##  After running
 we see the sensor request and the change of the Slots state in Treminal 


## Rest Endpoints
- to show the All plots 
`http://localhost:9095/plots/`

to add new plots
`http://localhost:9095/plots/add`

to update  plots
`http://localhost:9095/plots/update`

to delete  plots
`http://localhost:9095/plots/delete/{id}`

- Send a request to the sensor
`http://localhost:9095/sensors/SensorCall/{id}`


## I use vs code

