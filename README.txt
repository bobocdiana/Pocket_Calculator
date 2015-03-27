BOBOC DIANA-ANDREEA 322CA

Pentru rezolvarea temei m-am folosit de forma postfixata a expresiei date si de 
algoritmul de evaluare a unei expresii in forma postfixata.
Astfel, clasa ExpressionParser contine doua metode:
	-postfixat() ce returneaza forma postfixata a expresiei data ca parametru
	-eval() ce transforma expresia primita ca si parametru in forma ei 
	postfixata,apeland metoda postfixat(), si returneaza rezultatul expresiei 
	postfixate
Design pattern-ul Visitor este implementat prin doi vizitatori:
	-Postfixat_Visitor care intervine in momentul in care fiecare element al 
	expresiei este adaugat la noua expresie (retinuta in stiva numita postfixat)
	in functie de tipul acestuia (operand, operator, paranteza ) 

	-Evaluator_Visitor care intervine in momentul in care fiecare element al 
	expresiei postfixate este evaluat, in functie de tipul acestuia (adaugat in 
	stiva de operanzi daca elementul este numar sau calculat rezultatul operatiei 
	binare/unare daca este operator si adaugarea acestuia in stiva de operanzi)
Arborele sintactic este implementat in clasa AST, care de asemenea implementeaza 
interfata Visitable.AST contine:
	-stiva operations care contine operatorii din expresie, precum si paranteze
	-stiva operators care contine numerele din expresie si rezultatele
	partiale ale acesteia
	-stiva postfixat care contine forma postfixata a expresiei date 
	-String[] parser ce contine "nodurile" AST-ului, adica fiecare element al 
	expresiei incadrat de spatii
	-int current ce reprezinta indicele nodului care se evalueaza 
Algoritmul de transformare a unei expresii din forma infixata in forma postfixata:

1. cat timp exista elemente de parsat
	1.1 se ia un element
	1.2 daca elementul este un numar, adauga in stiva postfixat
	1.3 daca elementul este o paranteza stanga, se adauga in stiva operations
	1.4 daca elementul este o paranteza dreapta, extrage operatorii din
	stiva operations si adauga-i in stiva postfixat pana cand varful stivei 
	operations ajunge o paranteza stanga (care este extrasa, dar nu este 
	adaugata la forma postfixata).

	!! daca stiva s-a golit fara sa fie gasita o paranteza stanga, se arunca 
	eroare sintactica

	1.5 daca elementul este un operator (fie el O1)
		1.5.1 cat timp exista in varful stivei operations un alt operator 
		(fie el O2) si prioritatea lui O1 este mai mica sau egala cu cea a lui O2, 
		se scoate O2 din stiva operations si se adauga in stiva postfixat
		1.5.2 se adauga O1 in stiva operations

	2. cand nu mai exista elemente de parsat, extrage toate elementele ramase in 
	stiva operations si adauga-le la stiva postfixat (elementele trebuie sa fie 
	numai operatori; daca este extrasa o paranteza stanga se arunca eroare sintactica)

	Algoritmul de evaluare a formei postfixate este:
	1.cat timp exista elemente de parsat
		1.1 ia un element
		1.2 daca elementul este o valoare
			1.2.1 pune elementul in stiva operators
		altfel (elementul este un operator - vezi daca operatorul e binar/unar)
			1.2.2 extrage 2 operanzi din stiva operators
			1.2.3 daca nu exista 2 operaotri in stiva => eroare sintactica
			1.2.4 evalueaza rezultatul aplicarii operatorului asupra celor doi operanzi 
			1.2.5 pune rezultatul in stiva operators

	2.daca exista o singura valoare in stiva operators
		2.1 se returneaza valoarea din stiva
	altfel => eroare sintactica

