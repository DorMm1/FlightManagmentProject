# FlightManagmentProject
Backend only of flight marketplace website using Java -> Spring boot

Message for Hodi:
Answer for the question how will I use the facades and autenticate:
"I think the facades should be services with no argument (unlike what u asked for in part 1), instead of using LoginToken I implemented JWT,
after the authorization, user recieves 2 tokens in the body request: access token and refresh token. after each request to the API the system authenticate if the user has the approved role.
