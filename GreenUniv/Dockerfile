FROM amazoncorretto:17

COPY ["./build/libs/GreenUniv-*.jar", "/home/root/app.jar"]

CMD ["mkdir", "$HOME/greenuniv/logs"]
ENTRYPOINT [ "java", "-jar", "/home/root/app.jar"]
