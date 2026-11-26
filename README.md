# ComputerCenterShop — pràctica integradora RA2

> **Plantilla de l'equip.** Copieu aquest fitxer al vostre repositori de treball i completeu-lo a mesura que avanceu. No inclou solucions de codi: les decisions, proves i explicacions han de ser vostres.

## Fitxa de l'equip

- Integrants: Hugo Limoso Pascual, Yoselin Montserrat Necpas Sandoval i Nerea Diego Aldazabal
- Repositori compartit: https://github.com/HugoLimoPasc/ComputerCenterShop_v1_javafx_starter_HLNDYN
- Branca de treball habitual: 'main'
- Data d'inici: 2026-11-10
- Última actualització: 2026-11-26

## Propòsit del projecte

En aquesta pràctica desenvolupem una aplicació Java que accedeix a una base de dades relacional amb JDBC. Treballem sobre el projecte *starter* indicat pel professorat i fem servir el backlog RA2 per organitzar les tasques, els commits, les proves i les decisions tècniques.

El repositori ha de mostrar el procés de treball real de l'equip. No es tracta només d'arribar a una aplicació que s'executi: també cal poder explicar què s'ha canviat, com s'ha comprovat i per què la decisió correspon a cada *issue*.

## Punt de partida

- Repositori *starter* utilitzat: https://github.com/Bemen3-LLHB/ComputerCenterShop_v1_javafx_starter.git
- Gestor de base de dades relacional utilitzat: H2 2.2.224
- Connector utilitzat: JDBC de H2 (`org.h2.Driver`)
- Entorn de desenvolupament: Eclipse, Java 25, JavaFX 25.0.4 i Maven
- Comandament o acció que fem servir per comprovar l'execució: Eclipse → Run As → Maven build... → `clean javafx:run`

> No incorporeu ORM, Hibernate, ObjectDB, MongoDB, serveis externs ni persistència principal en fitxers. Aquests elements no formen part de RA2.

## Com treballem cada *issue*

1. Llegim l'objectiu i els criteris d'acceptació de l'*issue*.
2. Acordem què ha de canviar i qui inicia la feina.
3. Fem canvis petits i comprensibles, amb *commits* que expliquin la decisió.
4. Provem el comportament esperat i en guardem una evidència.
5. Actualitzem aquest README amb el resultat, la prova i l'enllaç al *commit* o a la *pull request*.
6. Tanquem l'*issue* només quan l'equip pot explicar individualment la solució aplicada.

## Progrés del backlog

Marqueu una tasca quan la prova i el rastre al repositori estiguin recollits. Els enllaços apunten a l'enunciat, no a una solució.

### M1 · Base JDBC operativa

- [x] [RA2-ISSUE-01 · Preparar el projecte JDBC](issues/RA2-ISSUE-01-preparar-projecte-jdbc.md)
- [x] [RA2-ISSUE-02 · Connector, URL i connexió](issues/RA2-ISSUE-02-revisar-connector-url-connexio.md)
- [x] [RA2-ISSUE-03 · Estructura relacional](issues/RA2-ISSUE-03-crear-estructura-relacional.md)

### M2 · Operacions relacionals principals

- [ ] [RA2-ISSUE-04 · Inserció de dades](issues/RA2-ISSUE-04-inserir-producte-preparedstatement.md)
- [ ] [RA2-ISSUE-05 · Actualització d'estoc](issues/RA2-ISSUE-05-actualitzar-estoc.md)
- [x] [RA2-ISSUE-06 · Eliminació controlada](issues/RA2-ISSUE-06-eliminar-producte-controlat.md)
- [ ] [RA2-ISSUE-07 · Consultes i resultats](issues/RA2-ISSUE-07-consultar-inventari-resultset.md)

### M3 · Robustesa JDBC

- [ ] [RA2-ISSUE-08 · Tancament de recursos](issues/RA2-ISSUE-08-tancar-recursos.md)
- [ ] [RA2-ISSUE-09 · Transaccions](issues/RA2-ISSUE-09-transaccio-commit-rollback.md)
- [ ] [RA2-ISSUE-10 · Procediment amb paràmetres](issues/RA2-ISSUE-10-procediment-parametres.md)
- [ ] [RA2-ISSUE-11 · Errors de connexió i operacions](issues/RA2-ISSUE-11-errors-connexio-recursos.md)

### M4 · Documentació i tancament

- [ ] [RA2-ISSUE-12 · Documentar l'execució i la configuració](issues/RA2-ISSUE-12-documentar-execucio-configuracio.md)
- [ ] [RA2-ISSUE-13 · Preparar el lliurament de la pràctica](issues/RA2-ISSUE-13-lliurament-practica-integradora.md)

## Registre de treball

Dupliqueu aquest bloc per a cada *issue* que completeu. Escriviu amb les vostres paraules i enllaceu només proves i *commits* del vostre repositori.

### RA2-ISSUE-01 · *Preparar projecte JDBC local*

- Estat: **comprovat**
- Persona que l'ha iniciat: **Nerea Diego**
- Problema inicial: **El projecte estava sense configurar ni executar.**
- Decisió aplicada: **Hem decidit revisar la configuració del pom.xml, i hem executat el projecte.**
- Canvis fets: **No hem fet ningun canvia.**
- Prova realitzada:**Hem executat el programa i em vist que si funciona, fent un maven build i hem posat clean javafx:run perque arrenqui.**
- Evidència:**Aquesta es la ruta ComputerCenterShop_v1_javafx_starter_HLNDYN\img\ISSUE-01**
- *Commit* o *pull request*: **7df597b**
- Explicació individual: **He revisat la configuració inicial del projecte, les dependències JDBC i l'execució de la demo per identificar el primer issue pendent.**
- Ús d'IA, si n'hi ha hagut: **.**

### RA2-ISSUE-02 · *Implementar connector, URL i connexio*

- Estat: **comprovat**
- Persona que l'ha iniciat: **Nerea**
- Problema inicial: **L'aplicació no podia connectar-se a la base de dades perquè el mètode connect() no estava implementat.**
- Decisió aplicada: **Hem implementat la connexió JDBC utilitzant, conn = DriverManager.getConnection(url, user, password);**
- Canvis fets: **Hem modificat el fitxer ProductDaoImplJDBC.java]**
- Prova realitzada: **Hem executat l'aplicació i la connexió ja no mostra l'error RA2-ISSUE-02**
- Evidència: **Aquesta es la ruta ComputerCenterShop_v1_javafx_starter_HLNDYN\img\ISSUE-02**
- *Commit* o *pull request*: **10335e4**
- Explicació individual: **He implementat el mètode connect() per crear la connexió JDBC amb H2 utilitzant DriverManager.**
- Ús d'IA, si n'hi ha hagut: **.**

### RA2-ISSUE-03 · Estructura relacional

- Estat: **comprovat**.
- Persona que l'ha iniciat: Hugo Limoso Pascual.
- Problema inicial: 'initSchema()' no estava implementat.
- Decisió aplicada: Crear l'esquema amb DDL, 'Statement' i 'try-with-resources'.
- Canvis fets: A 'src/dao/ProductDaoImplJDBC.java' es creen 'products', 'inventory_history' amb clau forana i l'àlies 'STOCK_ALERT_LIMIT'. El seed només s'insereix si 'products' és buida.
- Prova realitzada: Hem iniciat l'aplicació i comprovat amb H2 les dues taules, l'àlies amb 'SCRIPT NODATA' i els tres productes inicials sense duplicats després de reinicialitzar.
- Evidència: Missatge «Estructura relacional inicialitzada» i comprovacions a H2 descrites en aquest apartat. No hi ha captures enllaçades.
- *Commit* o *pull request*: [19a68f4](https://github.com/HugoLimoPasc/ComputerCenterShop_v1_javafx_starter_HLNDYN/commit/19a68f4).
- Explicació individual: Creació de taules, clau forana, àlies, seed i tancament automàtic de recursos.
- Ús d'IA: ChatGPT ha proposat codi i ajudat a resoldre errors. Hem comprovat el resultat amb Eclipse i H2. Cal confirmar amb el professorat si la proposta de codi és compatible amb IA-1.


### RA2-ISSUE-06 · [*Implementar eliminacio controlada*]

- Estat: **comprovat**
- Persona que l'ha iniciat: **Nerea Diego**
- Problema inicial: **El mètode `deleteProduct()` no estava implementat i no es podien eliminar productes de la base de dades.**
- Decisió aplicada: **Utilitzar un `PreparedStatement` amb una consulta SQL `DELETE` parametritzada.**
- Canvis fets: **He implementat el mètode `deleteProduct(String name)` per eliminar productes pel nom i retornar el nombre de files afectades.**
- Prova realitzada: **He eliminat el producte "SSD 1TB" i he verificat amb la consulta `SELECT * FROM PRODUCTS` que ja no apareix a la taula.**
- Evidència: **Aquesta es la ruta ComputerCenterShop_v1_javafx_starter_HLNDY\img\ISSUE-06**
- *Commit* o *pull request*: **.**
- Explicació individual: **He implementat l'eliminació controlada de productes mitjançant JDBC.**
- Ús d'IA, si n'hi ha hagut: **.**

## Proves que hem de poder repetir

| Cas que comprovem | Dades o condicions inicials | Resultat observat | Evidència |
| --- | --- | --- | --- |
| Arrencada del projecte | Eclipse i Maven | Esquema inicialitzat i inventari obert | Missatge d'inicialització |
| Operació de modificació | Pendent | Pendent | — |
| Consulta de dades | Consola H2 | Dues taules, àlies registrat i tres productes sense duplicats | Comprovació descrita a la ISSUE-03 |
| Cas d'error controlat | Pendent | Pendent | — |
| Operació agrupada o transacció | Pendent | Pendent | — |

## Decisions i dubtes de l'equip

| Data | *Issue* | Decisió o dubte | Com s'ha resolt | Referència |
| --- | --- | --- | --- | --- |
| 2026-11-23 | RA2-ISSUE-03 | Evitar duplicats | 'IF NOT EXISTS' i seed només amb la taula buida | [19a68f4](https://github.com/HugoLimoPasc/ComputerCenterShop_v1_javafx_starter_HLNDYN/commit/19a68f4) |
| 2026-11-23 | RA2-ISSUE-03 | Error de càrrega JavaFX | Eliminat 'columnResizePolicy' de 'ShopView.fxml' durant les proves | Arrencada correcta |
| 2026-11-24 | RA2-ISSUE-03 | H2 no troba la classe Java de l'àlies | Registre verificat amb 'SCRIPT NODATA'; execució de l'àlies no verificada | Comprovació descrita a la ISSUE-03 |

## Ús responsable d'IA

El nivell previst és **IA-1**: podeu usar eines d'IA com a suport per entendre conceptes, formular hipòtesis o revisar una explicació. No substitueixen les proves del projecte ni l'explicació individual.

Si n'heu fet ús, anoteu a l'*issue* corresponent què heu preguntat, què heu contrastat amb el projecte i quina decisió final heu pres. No enganxeu una resposta d'IA com si fos una prova de funcionament.

## Abans de donar la pràctica per preparada

- [ ] Els *issues* P0 tenen un resultat comprovat o una incidència explicada.
- [ ] El repositori conté *commits* que permeten seguir el treball de l'equip.
- [ ] Les proves de funcionament tenen evidències enllaçades.
- [ ] Les decisions sobre connector, consultes, recursos, transaccions i procediments estan explicades amb paraules pròpies.
- [ ] Tots els integrants poden defensar individualment les decisions tècniques del repositori.
- [ ] El README no inclou solucions copiades ni contingut fora de l'abast de RA2.

---

*Aquesta plantilla és un suport per documentar el treball. El que acredita el procés és el repositori de l'equip, amb els seus canvis, proves, decisions i explicacions.*
