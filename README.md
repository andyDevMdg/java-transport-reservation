# java-transport-reservation

A java and Postgresql based program for transport reservation management

The project is using Spring layer Architecture which means the uses of _**model**_ - _**service**_ - _**controller**_ - _**repository**_ packages.

## To start the program
You need to have **Postgresql 14 or higher** version installed on your OS

#### - Connect to your Postgresql

#### - Create the database called "_**transport_booking**_"

Use the .sql file, located in the folder _**./psql-script**_ of this repository to create it with all necessary tables
- DB-transport-reservation.sql 

#### - Add mock data
After the creation of the database, use the SQL scripts located in _**./psql-script/mock**_ to insert mock data

##### !FOLLOW THIS ORDER!

- customer.sql
- employee.sql
- bus.sql
- bus_seat.sql
- driver.sql
- payment.sql
- booking.sql
- drive_assignment.sql

#### - Add those environment variables to your session or in intelliJ configurations according to your credentials

```
PSQL_USER = your postgres username
PSQL_PASSWORD = your postgres password
```

Those credentials can be seen in here:
```
src/main/java/org/transportreservation/connection/Credentials.java
```

#### - START THE PROGRAM
You can start the program directly into intelliJ or thru the jar file located here:
```
out/artifacts/java_transport_reservation_jar
```

