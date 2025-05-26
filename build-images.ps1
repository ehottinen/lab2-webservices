# build-images.ps1

# This script builds Docker images for each service in the project

Write-Host "Building Docker image for authservice..."
cd authservice
./mvnw --% spring-boot:build-image -Dspring-boot.build-image.imageName=authservice:0.0.1-SNAPSHOT
cd ..

Write-Host "Building Docker image for jokeservice..."
cd jokeservice
./mvnw --% spring-boot:build-image -Dspring-boot.build-image.imageName=jokeservice:0.0.1-SNAPSHOT
cd ..

Write-Host "Building Docker image for quoteservice..."
cd quoteservice
./mvnw --% spring-boot:build-image -Dspring-boot.build-image.imageName=quoteservice:0.0.1-SNAPSHOT
cd ..

Write-Host "Building Docker image for apigateway..."
cd apigateway
./mvnw --% spring-boot:build-image -Dspring-boot.build-image.imageName=apigateway:0.0.1-SNAPSHOT
cd ..

Write-Host "All Docker images built successfully!"
