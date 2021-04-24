# 253_Nitu_Stefania-Elena_Cabinet_Medical
Clasele din aplicatie:

-Client:
  ClientMajor,
  ClientMinor

-Personal:
   Medic,
   Asistent

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

-Bonusable

-CostSpital

-DataVerifiable

-Deletable

-MaxMinAvCalculator

-Reducible

-Sumable

-Weekend

-Reportable - implementata in WarningAdd, WarningDelete

-IdentifiableCons - genereaza automat ID-ul consultatiilor


Interogarile din MENIU (atat cu posibilitatea citirii datelor de intrare din fisier, cat si cu posibilitatea scrierii rezultatului in fisiere CSV):

1.Ordonarea crescatoare a clientilor dupa numele de familie si verificarea corectitudinii CNP-ului, email-ului si numarului de telefon.

2.Suma medicamentelor pentru fiecare reteta dintr-o lista data de la tastatura

3.Salariul minim, maxim si mediu dintr-o lista de angajati data

4.Generare ID Consultatie

5.Sa se afiseze data nasterii pentru fiecare client dat (utilizand CNP-ul)

6.Adaugare client nou intr-un array de clienti dat

7.Stergere client dupa CNP-ul sau dintr-un array de clienti citit

8.Pentru medicii cu vechime mai mare de 10 ani se acorda sporuri de 25% la salariul actual. Sa se afiseze noul salariu dupa acordarea bonusului.

9.Pentru clientii cu varsta mai mare de 60 ani se acorda o reducere de 80% pentru fiecare medicament din reteta. Sa se afiseze noua suma a retetei dupa aplicarea reducerii pentru un vector de consultatii (consultatia face legatura intre client si reteta).

10.Se verifica daca data planificarii este in weekend. Daca este in weekend, se modifica data planificata pentru Luni (saptamana urmatoare).

11.Pentru pacientii care necesita spitalizare se afiseaza costul spitalizarii (100 lei/zi pentru client major, 80 lei/zi pentru client minor).



PARTEA A DOUA

-Adaugarea optiunii 12 (CITIRE MEDIC, ASISTENT, CLIENT MAJOR, CLIENT MINOR SI RETETA DIN FISIER CSV SI AFISAREA DATELOR CITITE IN ALT FISIER CSV)

-Adaugarea fisierelor .csv care retin datele intoarse de operatiunile 2-11 din meniu

-Adaugarea fisierului Rezultat.csv ce tine evidenta operatiilor efectuate (Denumirea operatiei + timestamp) folosind File Output Stream
