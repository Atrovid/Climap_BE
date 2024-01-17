CREATE SCHEMA "Sensor";

CREATE TABLE "Sensor"."Measurement" (
                                                "idMeasurement" SERIAL PRIMARY KEY,
                                                "SerialNumber" varchar NOT NULL,
                                                "Latitude" decimal NOT NULL,
                                                "Longitude" decimal NOT NULL,
                                                "DateDataCapture" timestamp NOT NULL
);

CREATE TABLE "Sensor"."Humidity" (
                                          "idHumidity" SERIAL PRIMARY KEY,
                                          "idMeasurement" int NOT NULL,
                                          "RelativeHumidityPercentage" decimal NOT NULL
);

CREATE TABLE "Sensor"."Sound" (
                                       "idSound" SERIAL PRIMARY KEY,
                                       "idMeasurement" int NOT NULL,
                                       "Decibel" decimal NOT NULL
);

CREATE TABLE "Sensor"."Heat" (
                                      "idHeat" SERIAL PRIMARY KEY,
                                      "idMeasurement" int NOT NULL,
                                      "CelsiusDegree" decimal NOT NULL

);

CREATE TABLE "Sensor"."Brightness" (
                                            "idBrightness" SERIAL PRIMARY KEY,
                                            "idMeasurement" int NOT NULL,
                                            "Lux" decimal NOT NULL
);

CREATE TABLE "Sensor"."Microparticles" (
    "idMicroparticles" SERIAL PRIMARY KEY,
    "idMeasurement" int NOT NULL,
    "ParticlesPerCubicCentimeter" decimal NOT NULL
);

ALTER TABLE "Sensor"."Humidity" ADD FOREIGN KEY ("idMeasurement") REFERENCES "Sensor"."Measurement"("idMeasurement");
ALTER TABLE "Sensor"."Sound" ADD FOREIGN KEY ("idMeasurement") REFERENCES "Sensor"."Measurement"("idMeasurement");
ALTER TABLE "Sensor"."Heat" ADD FOREIGN KEY ("idMeasurement") REFERENCES "Sensor"."Measurement"("idMeasurement");
ALTER TABLE "Sensor"."Brightness" ADD FOREIGN KEY ("idMeasurement") REFERENCES "Sensor"."Measurement"("idMeasurement");
ALTER TABLE "Sensor"."Microparticles" ADD FOREIGN KEY ("idMeasurement") REFERENCES "Sensor"."Measurement"("idMeasurement");
