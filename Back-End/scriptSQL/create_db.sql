CREATE SCHEMA "Sensor";

CREATE TABLE "Sensor"."Characteristic" (
                                                "idCharacteristic" SERIAL PRIMARY KEY,
                                                "Latitude" decimal NOT NULL,
                                                "Longitude" decimal NOT NULL,
                                                "DateDataCapture" timestamp NOT NULL
);

CREATE TABLE "Sensor"."Humidity" (
                                          "idHumidity" SERIAL PRIMARY KEY,
                                          "idCharacteristic" int NOT NULL,
                                          "ParticlesPerCubicCentimeter" decimal NOT NULL
);

CREATE TABLE "Sensor"."Sound" (
                                       "idSound" SERIAL PRIMARY KEY,
                                       "idCharacteristic" int NOT NULL,
                                       "Decibel" decimal NOT NULL
);

CREATE TABLE "Sensor"."Heat" (
                                      "idHeat" SERIAL PRIMARY KEY,
                                      "idCharacteristic" int NOT NULL,
                                      "CelsiusDegree" decimal NOT NULL

);

CREATE TABLE "Sensor"."Brightness" (
                                            "idBrightness" SERIAL PRIMARY KEY,
                                            "idCharacteristic" int NOT NULL,
                                            "Lux" decimal NOT NULL
);

CREATE TABLE "Sensor"."Microparticles" (
    "idMicroparticles" SERIAL PRIMARY KEY,
    "idCharacteristic" int NOT NULL,
    "ParticlesPerCubicCentimeter" decimal NOT NULL
);

ALTER TABLE "Sensor"."Humidity" ADD FOREIGN KEY ("idCharacteristic") REFERENCES "Sensor"."Characteristic"("idCharacteristic");
ALTER TABLE "Sensor"."Sound" ADD FOREIGN KEY ("idCharacteristic") REFERENCES "Sensor"."Characteristic"("idCharacteristic");
ALTER TABLE "Sensor"."Heat" ADD FOREIGN KEY ("idCharacteristic") REFERENCES "Sensor"."Characteristic"("idCharacteristic");
ALTER TABLE "Sensor"."Brightness" ADD FOREIGN KEY ("idCharacteristic") REFERENCES "Sensor"."Characteristic"("idCharacteristic");
ALTER TABLE "Sensor"."Microparticles" ADD FOREIGN KEY ("idCharacteristic") REFERENCES "Sensor"."Characteristic"("idCharacteristic");
