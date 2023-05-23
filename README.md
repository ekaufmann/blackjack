# Blackjack

## Description

This project is a Java application that simulates a Blackjack game on the console. Still a work in progress, so it's not possible to bid or play against another player or even the computer.

## Installation

1. Clone the repository: `git clone git@github.com:ekaufmann/blackjack.git` or `git clone https://github.com/ekaufmann/blackjack.git`
2. Navigate to the project directory: `cd ~/blackjack`

### Build with Gradle

To build the project using Gradle, follow these steps:

1. Make sure you have [Gradle](https://gradle.org/install/) installed.
2. Run the following command to build the project and generate the application JAR file:

   ```shell
   ./gradlew build
   ```

3. With the JAR just run the command below to execute the application (check the JAR path on your machine):

   ```shell
   java -jar build/libs/blackjack-1.0.0.jar
   ```

To build the project using Docker, follow these steps:

1. Make sure you have [Docker and Docker Compose](https://docs.docker.com/engine/install/) installed.
2. First, go to the devops folder from the root and build with `docker compose` or `docker-compose`:

   ```shell
   cd devops/
   docker compose build
   ```

3. After the build, check if the image was created and run it as an interactive container:

   ```shell
   docker images
   docker run -i -t blackjack
   ```

If both methods don't work, open the project with an IDE and run it using gradle.

### Dependencies

1. Mapstruct
2. Lombok
