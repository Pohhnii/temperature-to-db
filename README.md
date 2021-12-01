# temperature-to-db

## Beschreibung

Dieses Projekt dient dazu, Temperaturen mit adafruit und DHT11 auszulesen.
Ausgelesene Daten werden in das Terminal ausgegeben und ebenso in eine Datenbank gespeichert.


## Installation
`sudo apt install mariadb-server`

Im `infrastructure/db`-Verzeichnis befinden sich die SQL-Skripte zur initialisierung der Datenbank.

`git clone https://github.com/Pohhnii/temperature-to-db.git`

`cd ./temperature-to-db/source`

`mvn clean install`

## Ausführung
`java -jar ./target/Temperature-To-Db-1.0-SNAPSHOT-jar-with-dependencies.jar`
