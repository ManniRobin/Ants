<h1>
Ants
</h1>

<h2>
Ein Informatik-Projekt von Robin Wagner und Finn Westphal
</h2>

<ul>
    <li><a href= "#Einleitung"> 1. Einleitung: Anforderungen und Elemente des Spiels</a></li>
        <ul>
        <li><a href= "#Das Spiel und die Dokumentation"> 1.1 Das Spiel und die Dokumentation</a></li>
        <li><a href= "#Snytax und Funktionsweise von Java"> 1.2 Snytax und Funktionsweise von Java</a></li>
        </ul>
    <li><a href= "#Umsetzung"> 2. Umsetzung</a></li>
        <ul>
    <li><a href= "#Das Szenario"> 2.1 Das Szenario</a></li>
        <ul>
        <li><a href= "#Erstellen einer Welt"> 2.1.1 Erstellen einer Welt</a></li>
        <li><a href= "#Objekte in der Welt"> 2.1.2 Objekte in der Welt</a></li>
        </ul>
    <li><a href= "#Die Creature-Klasse"> 2.2 Die Creature-Klasse</a></li>
        <ul>
        <li><a href= "#Code-Zusammenfassung Rakete"> 2.2.1 Code-Zusammenfassung</a></li>
    <li><a href= "#Die Ants-Klasse"> 2.3 Die Ants-Klasse</a></li>
        <ul>
        <li><a href= "#Code-Zusammenfassung Asteroiden"> 2.3.5 Code-Zusammenfassung</a></li>
        </ul>
    <li><a href= "#Die AntHill-Klasse"> 2.4 Die AntHill-Klasse</a></li>
    <li><a href= "#Die Pheromon-Klasse"> 2.5 Die Pheromon-Klasse</a></li>
    <li><a href= "#Die Food-Klasse"> 2.6 Die Food-Klasse</a></li>
    <li><a href= "#Die Counter-Klasse"> 2.6 Die Counter-Klasse</a></li>
    </ul>
<li><a href= "#Quellen"> 3. Quellen</a></li>
</ul>

<h2>
<a id="Einleitung">1. Einleitung</a>
</h2>

Ants ist ein biologisch faszinierendes Greenfoot-Projekt. Ameisen kommen aus Ameisenhügeln nach und nach heraus und suchen nach Futterhaufen. Wenn sie Futter gefunden haben, essen sie ein paar Krümel vom ganzen Futterhaufen und kehren zurück zu ihrem Zuhause, dem Ameisenhügel. Wenn die Ameisen Futter gefunden haben hinterlassen sie Spuren (Pheromone) auf ihrem Heimweg, die andere Ameisen erkennen und denen sie folgen. Ansonsten bewegen sich die Ameisen recht naturecht mit unterschiedlicher Geschwindigkeit und können oft ihre Ausrichtung ändern. 


<p>		
In den folgenden Ausführungen werden wir schrittweise beschreiben, wie wir bei der Programmierung des Spiels vorgegangen sind. Es macht Sinn, sich in der angegeben Reihenfolge mit dem Dokument zu beschäftigen, um unsere Gedankengänge nachzuvollziehen. Dies gilt vor allem für die verwendeten Programmiermethoden und Befehle, die wir nicht in jedem Kapitel neu erläutern, sondern nur beim ersten Auftreten detailliert beschreiben und als Wissensgrundlage für weitere Anwendungsfälle vorraussetzen.
</p>

<h3>
<a id="Snytax und Funktionsweise von Java"> 1.2 Snytax und Funktionsweise von Java</a>
</h3>

<p>
Die Programmierumgebung <i>Greenfoot</i> basiert auf der objektorientierten Blockprogrammiersprache <i>Java</i>. Ziel dieser Umgebung ist es, mit relativ einfachen Mitteln und ohne Vorkenntnisse objektorientierte Simulationskonzepte zu programmieren. Für das bessere Verständnis erklären wir kurz den generellen Aufbau und die Snytax von <i>Java</i>.		
</p>		
 		
<p>		
Java ist aus Blöcken aufgebaut, die im Snytax durch geschweifte Klammern gekennzeichnet werden. Der Inhalt dieser Blöcke kann Anweisungen und Befehle, aber auch weitere Blöcke enthalten. Auf diese Weise ist eine verschachtelte Blockstruktur mit mehreren Ebenen möglich. Der Vorteil einer Block-Programmierung ist, dass Snytax-Fehler leichter indentifiziert werden können, da nur einzelne Blöcke nicht ordnungsgemäßfnktionieren und nicht der gesamte Code defekt ist.		
</p>		
 		
```javascript
Anweisung
{
    Anweisung
    {
    	Anweisung
    }
}
```

Wir programmieren unser Projekt "SpaceRocket" in der Programmierumgebung "Greenfoot", die auf der objektorientierten Programmiersprache Java basiert. Zunächst haben wir festgelegt, welche Größe, welches Format und welche Auflösung unsere Welt haben soll. Unser Spiel soll über eine klassische Auflösung und ein klassisches Seitenverhälnis verfügen, damit es auf jedem Computer spielbar ist. Wir haben uns deswegen für das Seitenverhältis von 1/1 und eine Auflösung von 640 * 640 Pixeln entschieden. Diese Bildeigenschaften sind von den meisten aktuellen Displays umsetzbar.

2.1.1 Erstellen einer Welt

Mit dem Konstruktor public erstellen wir eine Welt-Klasse namens space_backround_1 und durch die Methode import greenfoot.*; geben wir an, dass diese Klasse in das Szenario implementiert werden soll. Fehlt diese Methode oder wird sie verändert, so würde diese Klasse beim Start des Programmes nicht geladen werden. Hinter jeder Klasse stehen mindestens eine geöffnete und eine geschlossene Klammer, die zusätzliche Parameter enthalten können. Zur Ausführung der Methoden, die wir verwenden, sind keine weiteren Parameter notwendig, weswegen bei uns nichts zwischen den Klammern steht. Die Referenz super sorgt dafür, dass alle Eigenschaften der Super- oder Hauptklasse auf alle anderen Klassen übertragen werden. In diesem Fall ist die Super-Klasse die generierte Welt. Diese Anweisung benötigt weitere Parameter für ihre Funktionalität und zwar die Auflösung der generierten Welt und das Verhältnis zwischen Pixeln und Zellen des Zellen-Koordinatensystems, das deckungsgleich zur generierten Welt erstellt wird. Wir wollen dieses Verhältnis auf 1:1 festlegen, sodass eine Zelle einem Pixel entspricht. Um diese Parameter dem Konstruktor zur Verfügung zu stellen, schreiben wir nach super in Klammern (640, 640, 1, true). Der erste Parameter definiert die Anzahl der Pixel entlang der x-Achse, der zweite nach dem Komma die Pixelanzahl in y-Richtung und der dritte Parameter "1" sagt aus, dass eine Zelle die Größe von einem Pixel in x- und y- Richtung besitzt. Das Größenverhältnis zwischen Zellen und Pixeln beträgt also 1:1. Durch den Parameter true erreichen wir, dass die Asteroiden und auch die Rakete zunächst nicht aus der Welt verschwinden können, da die Grenzen der Welt für sie eine Barriere darstellen. 

eser Zeile steht ein Semikolon, das verschiedene Methoden voneinander trennt. Ein Hintergrund der Welt war durch das Downloaden von Ants1 schon vorgegeben und passt zum Ameisen-Szenario. 


Code-Script 1.1

import greenfoot.*;

public static final int WORLDSIZE = 640;
    {
     public AntWorld()
    {
        super(WORLDSIZE, WORLDSIZE, 1,false);
        setPaintOrder(AntWorld.class, Ant.class);
        scenario1();
    }
    }
2.1.2 Objekte in der Welt

Bisher enthält unsere Welt noch keine Objekte, die agieren können und für unser Spiel relevant sind. Wir benötigen in jedem Fall zunächst eine Raketen- und eine Asteroiden-Klasse. Zunächst wollen wir, dass jeweils vor Spielbeginn eine Rakete an einem festen Ort startet. Ebenfalls sollen verschiedene Asteroiden an immer anderen Punkten der Welt, allerdings nur an den Rändern der rechten Welthälfte, spawnen. Dazu haben wir, wie in dem folgenden Befehl zu sehen (siehe Code-Script 1.2), mithilfe der Methode addObject eine Rakete hinzugefügt, die jedes Mal, wenn man das Spiel startet, an der Position x = 150 und y = 270, startet. Die Methode addObject benötigt bestimmte Parameter für ihre Funktionalität. Zu diesen zählt zum Einen die Bezeichnung des zu generierenden Objektes einer Klasse und seine Position in der Welt. Hierzu wird nach addObject in Klammern die jeweilige Klasse mit dem Aufdruck new davor genannt, welcher als Referenz festlegt, dass ein Objekt dieser Klasse hinzugefügt werden soll. Schließlich geben zwei Parameter, durch Kommata getrennt, die Koordinaten des jeweiligen Objektes an. Diese Koordinaten haben wir so gewählt, dass die Rakete ziemlich weit links, aber nicht am Rand startet und genau die Hälfte der Höhe besitzt.

Code-Script 1.2

import greenfoot.*;
public space_backround_1()
{
    super(960, 540, 1, true);
    addObject(new rocket(), 150, 270);
}
Weiterhin lassen wir Asteroiden spawnen, die sich an immer anderen Positionen befinden können. Der erste Asteroid hat die x-Koordinate 960 und befindet sich genau am rechten Rand der Welt mit einer y-Koordinate, die von 0 bis 540, also von ganz unten bis ganz oben entlang der y-Achse variieren kann. Dies erreichen wir durch die Methode Greenfoot.getRandomNumber, die eine zufällige, natürliche Zahl zwischen 0 und dem jeweiligen in Klammern stehenden Grenzwert generiert. Der Grenzwert (hier: 541) ist dabei ausgeschlossen. Der 2. Asteroid kann zwischen den x-Koordinaten 480 und 480 + 480, also maximal 960 entstehen. Das bedeutet, dass er immer zufällig zwischen der Hälfte der Welt und dem rechten Rand spawnt. Die y-Koordinate beträgt 0, weshalb der Asteroid nur am oberen Rand der Welt spawnen kann. Dem 3. Asteroid sind die gleichen x-Koordinaten zugewiesen, er spawnt aber durch die festgelegte y-Koordinate von 540 immer am unteren Rand. Seine x-Koordinate ist ebenfalls variabel, sodass er entlang der y-Achse zufällig erscheinen kann.

Code-Script 1.3

addObject(new rocket(), 150, 270);
addObject(new counter(), 30, 510);
addObject(new Asteroid(), 960, Greenfoot.getRandomNumber(541);
addObject(new Asteroid(), Greenfoot.getRandomNumber(480) + 480, 0);
addObject(new Asteroid(), Greenfoot.getRandomNumber(480) + 48
