# Doctor_Answers
Android Application Project for HCI SS2016

## Readme - M3

* Gruppe:	Montag
* Team-Nr.: 8
* Projektthema: Kommunikation mit dem Arzt/der Ärztin

### Implementierung

Framework:	Android

API-Version:	Android Marshmallow 6.0.0, API 23

Geraet(e), auf dem(denen) getestet wurde:
Nexus 5X

Externe Libraries und Frameworks:
volley - als Hilfsmittel zur persistenten Datenspeicherung

Dauer der Entwicklung:
60 Stunden

Weitere Anmerkungen:
Die Authentifizierung wird über ein Datenbank-Verwaltungssystem verwirklicht (000webhost.com),
das es ermöglicht ein Datenbanksystem und drin auch Datenbanken zu erstellen und zu verwalten.
Unsere Datenbank - Doctor Answers, enthält 2 Tabellen: user und doctor. Diese ermöglichen den
User seine eigene Registrierung, das Login und das Hinzufügen eines Doctors in sein System.
Die Kommunikation der App mit der Datenbank wird über 4 .php Files, die in dem public_html Verzeichnis
des Hosts gespeichert wurden, und über das neue Android Package "Volley" realisiert.

Der gesamte Code ist auch auf GitHub committed (https://github.com/veryredheaded/Doctor_Answers, Stela Kucek)

Die .php Dateien sind außerhalb des Projekt-Verzeichnises einzusehen.