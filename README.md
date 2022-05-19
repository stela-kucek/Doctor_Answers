# Doctor_Answers
Android Application Project for HCI SS2016

## Readme - M4

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

#### M4 UPDATES:
- Nun ist auch die Funktion des Hinzufügen eines Attachments - konkret: Foto - implementiert.
Diese ermöglicht dem User, ein Foto mit der integrierten Kamera des Geräts aufzunehmen und dieses an die Frage "anzuhängen".
Die Idee hinter der "Photo-Attachment" Funktion wird detailierter im .pdf Dokument beschrieben und erläutert.

Im Zusammenhang damit, kommen hier die zwei 'Dangerous Permissions' WRITE_EXTERNAL_STORAGE und READ_EXTERNAL_STORAGE zum Einsatz.
Ab Android 6.0 wird für diese Art von Permissions der User direkt während der Runtime aufgefordert, diese zuzulassen oder zu verbieten.
Nachdem der User einmal (und zwar beim ersten Auftreten des Bedarfs nach dieser Permission) akzeptiert/abgelehnt hat, wird diese Entscheidung
von der App "gemerkt" und danach wird nicht mehr gefragt (es sei denn, es werden die in der App lokal gespeicherten Infos mittels z.B. "wipe data"
gelöscht - in diesem Fall erscheint die Permission-Anfrage erneut im gegebenen Moment der Runtime).

- Es wurden Verbesserungen im Layout und Input einerseits wegen der neuen Funktion, andererseits wegen dem konstruktiven Feedback
der Testnutzer, durchgeführt. Details sind im .pdf beschrieben.

Dauer der Weiterentwicklung und Optimierung:
30 Stunden

Die .php Dateien sind außerhalb des Projekt-Verzeichnises einzusehen.
