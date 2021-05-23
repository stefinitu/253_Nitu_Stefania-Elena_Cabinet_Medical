# 253_Nitu_Stefania-Elena_Cabinet_Medical
Clasele din aplicatie:

-Client:
  ClientMajor,
  ClientMinor

-Personal:
   Medic,
   Asistent

-InfoAngajare - retine datele ce tin de angajare

-Programare - retine datele despre o programare efectuata inaintea unui consult

-Consultatie - retine datele despre programarea efectuata, datele medicului care a efectuat consultatia si datele retetei

-Reteta - retine informatiile despre medicamentele prescrise de catre medic in timpul consultatiei

Clase cu metode:

-CostSpitalizare - calculeaza costul spitalizarii

-SumaMedicamente - calculeaza costul total al medicamentelor dintr-o reteta

-VerificareDate - verifica corectitudinea datelor clientilor

-AddClient - adauga un client la un array memorat

-BonusMedic - adauga la salariul medicului un bonus de vechime (minim 10 ani)

-DeleteClient - sterge un client dupa CNP dintr-un array de clienti

-MaxMinAverage - calculeaza maximul, minimul si media salariilor dintr-un array de angajati

-Reducere - se aplica reducere la costul medicamentelor dintr-o reteta persoanelor de peste 60 de ani

-VerificarePlanifWeekend - verifica daca planificarea cade in weekend

-WarningAdd, WarningDelete - afiseaza mesaje la adaugarea/stergerea unui client dintr-un array dat

Interfete:

-Addable

-CostSpital

-DataVerifiable

-MaxMinAvCalculator

-Reducible

-Sumable

-Weekend

-Reportable - implementata in WarningAdd, WarningDelete

-IdentifiableCons - genereaza automat ID-ul consultatiilor


Interogarile din MENIU (atat cu posibilitatea citirii datelor de intrare din fisier, cat si cu posibilitatea scrierii rezultatului in fisiere CSV):

1.Ordonarea crescatoare a clientilor dupa numele de familie de la tastatura

2.Suma medicamentelor pentru fiecare reteta dintr-o lista data de la tastatura - CSV inclus

3.Salariul minim, maxim si mediu dintr-o lista de angajati data

4.Generare ID Consultatie - CSV inclus

5.Sa se afiseze data nasterii pentru fiecare client dat (utilizand CNP-ul) - CSV inclus

6.Adaugare client nou intr-un array de clienti dat - CSV inclus

7.Stergere client dupa CNP-ul sau dintr-un array de clienti citit - CSV inclus

8.Pentru medicii cu vechime mai mare de 10 ani se acorda sporuri de 25% la salariul actual. Sa se afiseze noul salariu dupa acordarea bonusului. - CSV inclus

9.Pentru clientii cu varsta mai mare de 60 ani se acorda o reducere de 80% pentru fiecare medicament din reteta. Sa se afiseze noua suma a retetei dupa aplicarea reducerii pentru un vector de consultatii (consultatia face legatura intre client si reteta). - CSV inclus

10.Se verifica daca data planificarii este in weekend. Daca este in weekend, se modifica data planificata pentru Luni (saptamana urmatoare). - CSV inclus

11.Pentru pacientii care necesita spitalizare se afiseaza costul spitalizarii (100 lei/zi pentru client major, 80 lei/zi pentru client minor). - CSV inclus



PARTEA A DOUA

-Adaugarea optiunii 12 (CITIRE MEDIC, ASISTENT, CLIENT MAJOR, CLIENT MINOR SI RETETA DIN FISIER CSV SI AFISAREA DATELOR CITITE IN ALT FISIER CSV)

-Adaugarea fisierelor .csv care retin datele intoarse de operatiunile 2-11 (cu exceptia 3) din meniu:

AsistentResult

ClientMajResult

ClientMinResult

CosturiPacienti

DataNasterii

GenIDCons

MedicResult

PlanificariNoi

Reduceri

RetetaResult


-Adaugarea fisierului Rezultat.csv ce tine evidenta operatiilor efectuate (Denumirea operatiei + timestamp) folosind File Output Stream

---------------------PARTEA A TREIA - SQL---------------------------------

-AM STERS OPTIUNILE DIN MENIU REALIZATE IN PARTILE 1 SI 2

-AM CREAT IN BAZA DE DATE SQL (SCHEMA: CABINETMEDICAL) TABELELE: CLIENTMINOR, CLIENTMAJOR, MEDIC, ASISTENT, PROGRAMARE_CLIENTMINOR, PROGRAMARE_CLIENTMAJOR (IN BAZA DE DATE AM IMPARTIT CLASA PROGRAMARE IN DOUA SUBCLASE, ADICA DOUA TABELE PENTRU A PUTEA FOLOSI USOR FOREIGN KEY-URILE CNP DIN TABELELE CLIENTMINOR, RESPECTIV CLIENTMAJOR))

-AM ADAUGAT IN PROIECT CLASELE SingletonBD, BDClientMinor, BDClientMajor, BDMedic, BDAsistent, BDProgramareMajor, BDProgramareMinor care contin comenzile SQL pentru fiecare tabel in parte

-AM ADAUGAT DE ASEMENEA SI OPTIUNEA DE INSERARE IN BAZA DE DATE SQL A INFORMATIILOR DIN FISIERELE CSV REALIZATE IN PARTEA A DOUA PENTRU CLIENT MINOR, CLIENT MAJOR, MEDIC SI ASISTENT

-AM ADAUGAT OPTIUNEA DE A UTILIZA O INTERFATA GRAFICA. UTILIZATORUL POATE ALEGE DINTRE MANIPULAREA DATELOR DIN CONSOLA SAU DINTR-O INTERFATA.

-AM ADAUGAT 28 DE CLASE CE CONTIN INSTRUCTIUNILE PENTRU FIECARE OPTIUNE DIN INTERFATA IN PARTE (AM CREAT NOI CLASE DEOARECE AM INTRODUS CLASELE/COMENZILE SPECIFICE INTERFETEI)

-AM ADAUGAT CONNECTOR-UL PE CARE L-AM UTILIZAT PENTRU CONECTAREA LA BAZA DE DATE SQL

-AM ADAUGAT FISIERUL SQL AL SCHEMEI CREATE