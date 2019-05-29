# Bank Kata notes
----
This is a Maven project, made using Java 8 and Spring Boot Framework.
The project is seperated into 3 main layers: entities, views and controllers
I did not made any unit tests, because the business logic is pretty simple

----
The project is initilized with 2 bank accounts:
Account 1: balance is zero, and the accountid is 1.

Account 2: balance is 10000, and the accountid is 2.

----
US 1: URL : (/deposit)

In order to save money
As a bank client
I want to make a deposit in my account

US 2: (/withdraw)

In order to retrieve some or all of my savings
As a bank client
I want to make a withdrawal from my account

US 3: (/history/{accountId})

In order to check my operations
As a bank client
I want to see the history (operation, date, amount, balance) of my operations

----
