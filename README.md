Microservices Lab: API Gateway, JWT Authentication, and Protected Services

Översikt

Detta skolprojekt implementerar en mikrotjänst-arkitektur med JWT-autentisering och en central API Gateway för routing och säkerhet.
Systemets komponenter

    AuthService – autentiserar användare och genererar JWT-tokens

    ApiGateway – hanterar routing till andra tjänster och verifierar JWT-tokens

    JokeService – returnerar ett slumpmässigt programmeringsskämt (skyddad med JWT)

    QuoteService – returnerar ett slumpmässigt citat (skyddad med JWT)

Alla tjänster körs i Docker-containrar och hanteras via Docker Compose.

Hur man kör:

Starta hela systemet med Docker Compose
    Kontrollera att Docker och Docker Compose är installerat.
    Kör följande kommando i projektets rotmapp:

docker-compose up --build

Detta bygger och startar alla fyra tjänster i ett gemensamt nätverk.

Testning med Insomnia
1. Hämta en JWT-token
   Skapa en POST-förfrågan till:
http://localhost:8080/api/auth/login

Gå till fliken Body och välj JSON
Skriv in följande innehåll:

  ```json
  {
    "username": "user",
    "password": "password"
  }
  ```
Klicka på Send
Du får ett svar med en token:
  ```json
  {
    "token": "eyJhbGciOiJIUzUxMiJ9..."
  }
  ```

Använd token för att komma åt skyddade endpoints
    Skapa en GET-förfrågan till:
http://localhost:8080/api/jokes/random
or
http://localhost:8080/api/quotes/random

    Gå till fliken Auth
    Välj Bearer Token
    Klistra in tokenen från steg 1
    Klicka på Send – du bör få ett skämt eller citat i svaret

3. Testa utan token

   Ta bort eller stäng av token i Auth-fliken
   Skicka förfrågan igen
   Du bör få ett 401 Unauthorized-svar

Projektstruktur

Varje tjänst har en egen katalog och egen Dockerfile. Projektets rot innehåller docker-compose.yml som bygger och startar alla tjänster.

authservice/
apigateway/
jokeservice/
quoteservice/
docker-compose.yml

Säkerhet

    Alla tjänster använder samma JWT-secret, definierad i respektive application.properties.
    API Gateway filtrerar bort anrop utan giltig JWT-token.
    JokeService och QuoteService verifierar tokens lokalt genom spring-boot-starter-oauth2-resource-server.

Övrigt

    JWT-secret är hårdkodad i varje tjänst för enkelhetens skull.
    Tjänsterna är stateless och kommunicerar endast via HTTP.
    Denna lösning uppfyller kraven för den högre nivån på laborationen (till exempel VG), då varje tjänst ansvarar för egen säkerhet.