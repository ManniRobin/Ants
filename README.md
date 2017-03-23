<h1>
Ants
</h1>

<h2>
Ein Informatik-Projekt von Robin Wagner und Finn Westphal
</h2>

<p><img src="images/Screenshot (1).png" alt="Screenshot1"></p>

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
           <li><a href= "#Code-Zusammenfassung Die Creature-Klasse"> 2.2.1 Code-Zusammenfassung</a></li>
           </ul>
        <li><a href= "#Die Ants-Klasse"> 2.3 Die Ants-Klasse</a></li>
           <ul>
           <li><a href= "#Code-Zusammenfassung Die Ants-Klasse"> 2.3.1 Code-Zusammenfassung</a></li>
           </ul>
    <li><a href= "#Die AntHill-Klasse"> 2.4 Die AntHill-Klasse</a></li>
    <li><a href= "#Die Pheromon-Klasse"> 2.5 Die Pheromon-Klasse</a></li>
    <li><a href= "#Die Food-Klasse"> 2.6 Die Food-Klasse</a></li>
    </ul>
<li><a href= "#Quellen"> 3. Quellen</a></li>
</ul>

<h2>
<a id="Einleitung">1. Einleitung</a>
</h2>

Ants ist ein biologisch faszinierendes Greenfoot-Projekt. Ameisen kommen aus Ameisenhügeln nach und nach heraus und suchen nach Futterhaufen. Wenn sie Futter gefunden haben, essen sie ein paar Krümel vom ganzen Futterhaufen und kehren zurück zu ihrem Zuhause, dem Ameisenhügel. Wenn die Ameisen Futter gefunden haben hinterlassen sie Spuren (Pheromone) auf ihrem Heimweg, die andere Ameisen erkennen und denen sie folgen. Ansonsten bewegen sich die Ameisen recht naturecht mit unterschiedlicher Geschwindigkeit und können oft ihre Ausrichtung ändern. 

<p><img src="images/Screenshot (2).png" alt="Screenshot2"></p>


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

Wir programmieren unser Projekt "Ants" in der Programmierumgebung "Greenfoot", die auf der objektorientierten Programmiersprache Java basiert. Zunächst haben wir festgelegt, welche Größe, welches Format und welche Auflösung unsere Welt haben soll. Unser Spiel soll über eine klassische Auflösung und ein klassisches Seitenverhälnis verfügen, damit es auf jedem Computer spielbar ist. Wir haben uns deswegen für das Seitenverhältis von 1/1 und eine Auflösung von 640 * 640 Pixeln entschieden. Diese Bildeigenschaften sind von den meisten aktuellen Displays umsetzbar.

<h2>
<a id="Umsetzung"> 2. Umsetzung</a>
</h2>

<h3>
<a id= "Das Szenario"> 2.1 Das Szenario</a>
</h3>


2.1.1 Erstellen einer Welt

Mit dem Konstruktor public erstellen wir eine Welt-Klasse namens space_backround_1 und durch die Methode import greenfoot.*; geben wir an, dass diese Klasse in das Szenario implementiert werden soll. Fehlt diese Methode oder wird sie verändert, so würde diese Klasse beim Start des Programmes nicht geladen werden. Hinter jeder Klasse stehen mindestens eine geöffnete und eine geschlossene Klammer, die zusätzliche Parameter enthalten können. Zur Ausführung der Methoden, die wir verwenden, sind keine weiteren Parameter notwendig, weswegen bei uns nichts zwischen den Klammern steht. Die Referenz super sorgt dafür, dass alle Eigenschaften der Super- oder Hauptklasse auf alle anderen Klassen übertragen werden. In diesem Fall ist die Super-Klasse die generierte Welt. Diese Anweisung benötigt weitere Parameter für ihre Funktionalität und zwar die Auflösung der generierten Welt und das Verhältnis zwischen Pixeln und Zellen des Zellen-Koordinatensystems, das deckungsgleich zur generierten Welt erstellt wird. Wir wollen dieses Verhältnis auf 1:1 festlegen, sodass eine Zelle einem Pixel entspricht. Um diese Parameter dem Konstruktor zur Verfügung zu stellen, schreiben wir nach super in Klammern (640, 640, 1, true). Der erste Parameter definiert die Anzahl der Pixel entlang der x-Achse, der zweite nach dem Komma die Pixelanzahl in y-Richtung und der dritte Parameter "1" sagt aus, dass eine Zelle die Größe von einem Pixel in x- und y- Richtung besitzt. Das Größenverhältnis zwischen Zellen und Pixeln beträgt also 1:1. Wir haben aber nicht die Koordinaten 640 benutzt, sondern eine feste Größe der Welt (WORLDSIZE) auf 640 festgelegt, die wir später weiter verwendet haben. Durch den Parameter true erreichen wir, dass die Asteroiden und auch die Rakete zunächst nicht aus der Welt verschwinden können, da die Grenzen der Welt für sie eine Barriere darstellen. 
In dieser Zeile steht ein Semikolon, das verschiedene Methoden voneinander trennt. 
Ein Hintergrund der Welt war durch das Downloaden von Greenfoot Ants Project auf der Greenfoot Website schon vorgegeben und passt zum Ameisen-Szenario, sodass wir diesen nicht verändern mussten. Durch setPaintOrder können wir die Farbgebungsaufträge der Welt und der Ants Klasse aufnehmen. Außerdem erstellen wir mit scenario 1() ein neues Szenario für die Welt, in welchem die Objekte zu Beginn hinzugefügt werden.

```javascript

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
```

<p><img src="images/sand.jpg" alt="sand world"></p>

2.1.2 Objekte in der Welt

Bisher enthält unsere Welt noch keine Objekte, die agieren können und für unser Spiel relevant sind. Wir benötigen in jedem Fall zunächst eine Creature, Ants, AntHill, Pheromon und Food-Klasse. Da die Ameisen immer aus ihrem Ameisenhügel spawnen sollen, legen wir die Koordinaten der Ameisenhügel mithilfe des Befehls addObject fest. Die Methode addObject benötigt bestimmte Parameter für ihre Funktionalität. Zu diesen zählt zum Einen die Bezeichnung des zu generierenden Objektes einer Klasse und seine Position in der Welt. Hierzu wird nach addObject in Klammern die jeweilige Klasse mit dem Aufdruck new davor genannt, welcher als Referenz festlegt, dass ein Objekt dieser Klasse hinzugefügt werden soll. Schließlich geben zwei Parameter, durch Kommata getrennt, die Koordinaten des jeweiligen Objekts an. Diese Koordinaten haben wir so gewählt, dass die Ameisenhügel jeweils ein bisschen auseinander liegen. Außerdem sollen zu Beginn Futterhaufen für die Ameisen vorhanden sein. Diese haben wir so gewählt, dass sie etwas auseinander und auf der ganzen Karte verteilt liegen. Es sollten außerdem nicht zu wenige Futterhaufen sein, da die Ameisen diese sonst zu schnell leeren.

```javascript

import greenfoot.*;
public void scenario1()
    {
        addObject(new AntHill(), WORLDSIZE / 2, WORLDSIZE / 2);
        addObject(new AntHill(), WORLDSIZE / 4, WORLDSIZE / 4);
        addObject(new Food(), 200, 200);
        addObject(new Food(), 50, 50);
        addObject(new Food(), 300, 50);
        addObject(new Food(), 500, 200);
        addObject(new Food(), 300, 275);
        addObject(new Food(), 300, 350);
        addObject(new Food(), 350, 400);
        addObject(new Food(), 150, 400);
        addObject(new Food(), 400, 550);
        addObject(new Food(), 550, 500);
    }
```

<p>
Zusammengefasst ergibt sich für die World-Klasse:
</p>


```javascript
import greenfoot.*;

public static final int WORLDSIZE = 640;
public AntWorld()
    {
        super(WORLDSIZE, WORLDSIZE, 1,false);
        setPaintOrder(AntWorld.class, Ant.class);
        scenario1();
    }
    public void scenario1()
    {
        addObject(new AntHill(), WORLDSIZE / 2, WORLDSIZE / 2);
        addObject(new AntHill(), WORLDSIZE / 4, WORLDSIZE / 4);
        addObject(new Food(), 200, 200);
        addObject(new Food(), 50, 50);
        addObject(new Food(), 300, 50);
        addObject(new Food(), 500, 200);
        addObject(new Food(), 300, 275);
        addObject(new Food(), 300, 350);
        addObject(new Food(), 350, 400);
        addObject(new Food(), 150, 400);
        addObject(new Food(), 400, 550);
        addObject(new Food(), 550, 500);
        }
       
```
 
 <h3>
<a id= "Die Creature-Klasse"> 2.2 Die Creature-Klasse</a>
</h3>

<h4>
<a id="Code-Zusammenfassung Die Creature-Klasse"> 2.2.1 Code-Zusammenfassung</a>
</h4>

<h3>
<a id= "Die Ants-Klasse"> 2.3 Die Ants-Klasse</a>
</h3>

<p><img src="images/ant.gif" alt="ant"></p>

<p><img src="images/ant-with-food.gif" alt="Ant with food"></p>

<h4>
<a id="Code-Zusammenfassung Die Ants-Klasse"> 2.3.1 Code-Zusammenfassung</a>
</h4>

<h3>
<a id= "Die AntHill-Klasse"> 2.4 Die AntHill-Klasse</a>
</h3>

<p><img src="images/anthill.png" alt="anthill"></p>

<h3>
<a id= "Die Pheromon-Klasse"> 2.5 Die Pheromon-Klasse</a>
</h3>

<p><img src="images/Pheromone.png" alt="Pheromone"></p>

<h3>
<a id= "Die Food-Klasse"> 2.6 Die Food-Klasse</a>
</h3>

<p><img src="images/Food.png" alt="food"></p>

<h3>
<a id= "Quellen"> 3. Quellen</a>
</h3>

- Michael Kölling: *Einführung in Java mit Greenfoot*. Pearson Education Deutschland GmbH, 2010
- Download: Greenfoot AntsProject
