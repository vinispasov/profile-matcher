# profile-matcher


The project is based on Java 17 with Spring boot framework. The build tool is Maven. Profile-matcher uses h2 database through JPA. The project is based on the Controller-Service-Repository pattern. 
Setup the project:

Before starting the project you have to build it with the command: "mvn clean install". Profile-matcher can be started from ProfileMatcherApplication.class. The database configurations are in application.properties. There are also some embedded SQL scripts in the data.sql file, which are executed on project startup.

Sample requests:

GET http://localhost:8080/profile-matcher/1  

Response (Based on the randomly chosen campaign): 
1. 200 OK
   
   {
    "playerId": 1,
    "credential": "apple_credential",
    "created": "2021-01-10T15:37:17",
    "modified": "2021-01-23T15:37:17",
    "lastSession": "2021-01-23T15:37:17",
    "totalSpent": 400.00,
    "totalRefund": 0.00,
    "totalTransactions": 5,
    "lastPurchase": "2021-01-22T15:37:17",
    "activeCampaigns": [
        "name_dbbdede4-6157-474b-b31e-ad2bde014c3a"
    ],
    "devices": [
        {
            "id": 1,
            "model": "apple iphone 11",
            "carrier": "vodafone",
            "firmware": "123"
        }
    ],
    "level": 3,
    "xp": 1000,
    "totalPlaytime": 144,
    "country": "CA",
    "language": "fr",
    "birthdate": "2000-01-10T15:37:17",
    "gender": "male",
    "inventory": {
        "item_1": 1
    },
    "clan": null,
    "itemId": 1,
    "deviceId": 1
}


2. 400 Bad request - Conditions not met!
