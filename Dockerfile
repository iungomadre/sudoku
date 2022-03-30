FROM gradle:jdk17 AS build
WORKDIR /home/app
COPY . .
CMD ./gradlew build --no-daemon

FROM openjdk:18-alpine
WORKDIR home/app
COPY --from=build /home/app/build/libs/*.jar .
ENTRYPOINT ["java", "-jar"]
CMD ["sudoku.jar"]