# Algoritmusok és adatszerkezetek gyakorlat házi feladat
## Makszim Balázs Imre ENSGO3

Feladat eredeti leírása:
https://www.hackerrank.com/challenges/k-factorization/problem

## Feladat: Fordított Faktorizáció*

Egy órán Püthagorasz azt a feladatot adta tanítványainak, hogy oldjanak meg egy ilyen problémát: a **Fordított Faktorizációt**.
Adott egy egész számokat tartalmazó halmaz **A** és egy szám **N**. 
A cél, hogy **1**-ből **N**-t érjenek el úgy, hogy az aktuális értéket minden lépésben megszorozzák **A** egy elemével.

Hamar rájöttek azonban, hogy **N**-t többféleképpen is elérhetik.
Ezért úgy döntöttek, hogy keresnek egy megoldást, amelyben a lépések száma a lehető legkisebb.
Ekkor azonban újabb problémát fedeztek fel: még mindig több megoldás létezett.
Végül hosszú vita után abban állapodtak meg, hogy az olyan megoldást választják, amely a legkisebb lépésszámot tartalmazza, és ezen belül lexikografikus sorrendben is a legkisebb.

### Példa:
Ha \( N = 12 \) és \( A = \{2, 3, 4\} \), akkor az alábbi megoldások lehetségesek:

1. \( 1 -> 2 -> 4 -> 12 \)  
    \(&nbsp; *2 &nbsp;&nbsp;&nbsp; *2 &nbsp;&nbsp;&nbsp; *3 \)

2. \( 1 -> 4 -> 12 \)  
    \(&nbsp; *4 &nbsp;&nbsp;&nbsp; *3 \)

3. \( 1 -> 3 -> 12 \)  
    \(&nbsp; *3 &nbsp;&nbsp;&nbsp; *4 \)

Az (1) megoldás nem minimális, mivel 4 lépésből áll.
Az (2) és (3) megoldások 3 lépésből állnak, de a (3) megoldás lexikografikus sorrendben kisebb, így ez az eredmény.
Ebben az esetben az eredmény: `1 3 12`. Ha \( N \)-t nem lehet elérni, akkor az eredmény `-1`.

### Bemenet:

A bemenet két sort tartalmaz:
1. Az első sorban két egész szám található: \( N \) (a célérték) és \( K \) (az \( A \) halmaz mérete).
2. A második sor \( K \) darab egész számot tartalmaz, amelyek az \( A \) halmaz elemei.

## Megoldás

Az ***src/main*** könyvtár tartalmazza a megoldás forráskódját. Az ***src/test*** pedig a teszteseteket.

## Megoldó algoritmus

1. Bemenet feldolgozása:
    * N és K beolvaásása
    * A beolvaásása

2. **A** rendezése, hogy a lexikografikus sorrendben kisebb megoldást megtaláljuk

3. Rekurzív hívás
    * _current_ = 1-ről indítva minden lépésben megszorozva az A egy elemével.
    * Paraméterek:
        * aktuális érték
        * célérték
        * A elemei
        * aktuális út
    * Ha az aktuális érték egyenlő a céllal, ellenőrzés, hogy ez az út a legjobb-e.
    * Ha az aktuális érték meghaladja a célt, megállunk.

4. Kimenet
    * Ha létezik érvényes út, kiírjuk.
    * Ha nem, akkor -1-gyel térünk vissza.

_*A magyar fordításban nem mindig voltam biztos_