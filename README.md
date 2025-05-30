Microservices Lab: API Gateway, JWT Authentication, and Protected Services

Innehållande tjänster:

    AuthService – autentiserar användare och genererar JWT-token.

    ApiGateway – hanterar routing och verifierar JWT innan trafik når andra tjänster.

    JokeService – returnerar ett slumpmässigt programmeringsskämt. Skyddad av JWT.

    QuoteService – returnerar ett slumpmässigt citat. Skyddad av JWT.

Alla tjänster är containeriserade med Docker och körs via Docker Compose.

Hur man kör systemet:

Dependencies: 

    Docker

    Docker Compose


`docker-compose up --build
`

Kommandot bygger och startar alla fyra tjänster automatiskt.

Om du vill bygga Docker-images manuellt innan du startar kan du köra Powershell-scriptet:

`./build-images.ps1
`

Scriptet bygger images för varje mikrotjänst med hjälp av Maven och Spring Boot Buildpacks.

Hur man testar med Insomnia:
1. Logga in för att få token

   Method: POST

   URL: http://localhost:8080/api/auth/login

Body (JSON):

`{
"username": "user",     
"password": "password"
}`

Svar:

`{
"token": "blabla..."
}
`
2. Anropa skyddade endpoints

   Method: GET

   URL:

        http://localhost:8080/api/jokes/random

        http://localhost:8080/api/quotes/random

   Gå till Auth-fliken och välj Bearer Token

   Klistra in token från föregående steg

Svar: Du får ett skämt eller citat som svar.
3. Testa obehörig åtkomst

   Ta bort token och skicka begäran igen

   Du bör få ett 401 Unauthorized-svar