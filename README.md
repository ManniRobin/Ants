<h1>
Ants
</h1>

<h2>
Ein Informatik-Projekt von Robin Wagner und Finn Westphal
</h2>

<p><img src="Screenshot_Greenfoot_SpaceRocket_Szenario.png" alt="Projekt"></p>

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
Java ist aus Blöcken aufgebaut, die im Snytax durch geschweifte Klammern gekennzeichnet werden. Der Inhalt dieser Blöcke kann Anweisungen und Befehle, aber auch weitere Blöcke enthalten. Auf diese Weise ist eine verschachtelte Blockstruktur mit mehreren Ebenen möglich. Der Vorteil einer Block-Programmierung ist, dass Snytax-Fehler leichter indentifiziert werden können, da nur einzelne Blöcke nicht ordnungsgemäß funktionieren und nicht der gesamte Code defekt ist.		
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
