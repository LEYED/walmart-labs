# walmart-labs

# Usage guideline
  - Step 1: clone this git repository.
  - Step 2: navigate to the root of Ticket-Walamart and you'll find the build.gradle file. 
  - Step 3 (Optional): if you want to run the test use the command "gradle test"
  - Step 3: use the command "gradle run" to start the application.
  - Step 4: a console with instructions on how to use the application will show up.
  - Step 5: enjoy.

# Assumptions on requirements
  - The system will not take into account the contiguity of the seats to make the reservation it will use the better seats available for the reservation.
  - Since the application can be used for many events and stages with different distributions, every seat will have 2 attributes the seat name e.g. ("A1", "B23") and the seat value which is an integer that indicates how good a seat is (bigger numbers are better seats). 
  
# Technical assumptions
  - Im using plain java with no other frameworks besides Junit. 
  - If this application would be required to be deployed on a high scale a scope and life cycle for every entity will be assigned.
