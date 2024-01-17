# Getting Started

### Routes for post

- localhost:8080/sensor : list of all sensor with its different sensor declination
- localhost:8080/sensor/date : list of parsed date captured by year, month, day
- localhost:8080/brightness : list of all brightness data in different arrays
- localhost:8080/brightness/lux : list of all brightness data in one single array
- localhost:8080/heat : list of all heat data in different arrays
- localhost:8080/heat/celsius : list of heat data in one single array
- localhost:8080/humidity : list of all humidity data in different arrays
- localhost:8080/humidity/relativeHumidityPercentage : list of humidity data in one single array
- localhost:8080/sound : list of all sound data in different array
- localhost:8080/sound/decibel : list of all sound data in one single array

### Docker Compose support
This project contains a Docker Compose file named `compose.yaml`.
In this file, the following services have been defined:

* postgres: [`postgres:latest`](https://hub.docker.com/_/postgres)

Please review the tags of the used images and set them to the same as you're running in production.
