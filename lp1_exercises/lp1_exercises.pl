% A part of a family tree. Source: https://awoiaf.westeros.org/index.php/House_Lannister#Family_Tree
male(tytos).
male(tywin).
male(kevan).
male(tyrion).
male(robert).
male(jaime).
male(lancel).

female(jeyne).
female(joanna).
female(dorna).
female(sansa).
female(cersei).
female(janei).

married(tytos, jeyne).
married(jeyne, tytos).
married(tywin, joanna).
married(joanna, tywin).
married(kevan, dorna).
married(dorna, kevan).
married(tyrion, sansa).
married(sansa, tyrion).
married(robert, cersei).
married(cersei, robert).

father(tytos, tywin).
father(tytos, kevan).
father(tywin, jaime).
father(tywin, tyrion).
father(tywin, cersei).
father(kevan, lancel).
father(kevan, janei).

mother(jeyne, tywin).
mother(jeyne, kevan).
mother(joanna, jaime).
mother(joanna, tyrion).
mother(joanna, cersei).
mother(dorna, lancel).
mother(dorna, janei).

% Helper predicates for the other predicates
parent(Parent, Person) :- father(Parent, Person).
parent(Parent, Person) :- mother(Parent, Person).
sibling(Person, Sibling) :- parent(Parent, Person), parent(Parent, Sibling), Person\=Sibling.

% Exercise:
% Basierend auf dem oben gegebenen Stammbaum, sollen Sie ein Praedikat grandmother(X,Y) definieren,
% das wahr ist, wenn X die Grossmutter von Y ist.
% Based on the given family tree, define a predicate grandmother(X,Y), that evaluates to true if X
% is the grandmother of Y.
grandmother(Gmother, Gchild):- mother(Gmother, Parent), parent(Parent, Gchild).



% Exercise:
% Basierend auf dem oben gegebenen Stammbaum, sollen Sie ein Praedikat brother_in_law(X,Y)
% definieren, das wahr ist, wenn X der Schwager von Y ist.
% Based on the given family tree, define a predicate brother_in_law(X,Y), that is true if X is the
% brother in law of Y.

brother(Brother, Sibling):- male(Brother), sibling(Brother, Sibling).

is_brother_in_law(BrotherIL, Person):-
    brother(BrotherIL, Spouse),
    married(Spouse, Person).

brother_in_law(BrotherIL, Person):- is_brother_in_law(BrotherIL, Person).
brother_in_law(BrotherIL, Person):- is_brother_in_law(Person, BrotherIL).
% brother_in_law(BrotherIL, Person) :- ?



% Exercise:
% Basierend auf dem oben gegebenen Stammbaum, sollen Sie ein Praedikat cousin(X,Y) definieren, das
% wahr ist, wenn X die Cousine/der Cousin von Y ist.
% Based on the given family tree, define a predicate cousin(X,Y) definieren, that evaluates to true
% if X is the cousin of Y.
grandfather(Gfather, Person):- father(Gfather, Father), father(Father, Person).

cousin(Cousin, Person):- grandmother(Gmother, Cousin), grandmother(Gmother, Person), Cousin\=Person.
cousin(Cousin, Person):- grandfather(Gfather, Cousin), grandfather(Gfather, Person), Cousin\=Person.
% cousin(Cousin, Person) :-



% Exercise:
% Definieren Sie ein Praedikat ancestor(X,Y), das wahr ist, wenn X ein Vorfahre von Y ist.
% Define a predicate ancestor(X,Y) that evaluates to true if X is an ancestor of y.

ancestor(Anc, Person):- parent(Anc, Person).
ancestor(Anc, Person):- ancestor(Anc, X), parent(X, Person).



% Inductive definition of natural numbers
nat(0).
nat(s(X)) :- nat(X).

% Exercise:
% Unter Verwendung der induktiven Definition der natuerlichen Zahlen ueber den Funktor s, sollen Sie
% ein Praedikat lessEq(X,Y) definieren, welches wahr ist, wenn X kleiner als oder gleich Y ist.
% Using the inductive definition of natural numbers via the functor s, define a predicate
% lessEq(X,Y) that is true if X is less or equal to Y.

lessEq(X, _Y) :- X = 0.
lessEq(s(X), s(Y)) :- lessEq(X, Y).



% Exercise:
% Unter Verwendung der induktiven Definition der natuerlichen Zahlen ueber den Funktor s, sollen Sie
% ein Praedikat max(X,Y,Z) definieren, welches wahr ist, wenn Z das Maximum von X und Y ist.
% Using the inductive definition of natural numbers via the functor s, define a predicate max(X,Y,Z)
% which is true if Z is the maximum of X and Y.

% max(X, Y, Z) :- ?
max(0, X, X).
max(X, 0, X).
max(s(X), s(Y), s(X)):- max(X, Y, X).
max(s(X), s(Y), s(Y)):- max(X, Y, Y).



% Exercise:
% Ein gewichteter gerichteten azyklischen Graph sei durch eine Wissensbasis mit Fakten der Form
% edge(S, E, W) dargestellt, wobei S und E der Start- bzw. Endknoten einer Kante sind. Das Gewicht W
% sei mittels der in der Vorlesung besprochenen induktiven Repraesentation der natuerlichen Zahlen
% codiert.
% Schreiben Sie ein Praedikat cost(X,Y,C), welches wahr ist, wenn ein Pfad zwischen den Knoten X und
% Y existiert. Weiteres muss C der Summe der Kantengewichte entlang dieses Pfades entsprechen.
% Tipp: Verwenden Sie das Praedikat add(A,B,C) aus der Vorlesung.
% A weighted directed acyclic graph is formulated via a knowledge base of facts of the form
% edge(S,E,W). S and E represent the start and the end node of an edge in the graph. The weight W
% is represented via the inductive representation of natural numbers defined in the lecture.
% Write a predicate cost(X,Y,C), which is true if a path between the nodes X and Y exists and C is
% the sum of weights along this path.
% Hint: Use the add(A,B,C) predicate which was defined in the lecture.

% Example knowledge base:
edge(a, b, s(s(0))).
edge(b, c, s(0)).
edge(b, d, s(0)).
edge(b, e, s(s(0))).
edge(d, c, s(s(s(s(0))))).
edge(d, e, 0).
% add-predicate defined in lecture
add(A, 0, A).
add(A, s(B), s(C)) :- add(A, B, C).

cost(X, X, 0).
cost(X, Y, C):- edge(X, Z, Cstep), cost(Z, Y, Crest), add(Cstep, Crest, C).
% cost(X, Y, C) :- ?



% Exercise:
% Unter Verwendung des eingebauten Datentyps der Integer, sollen Sie ein Praedikat gcd(A,B,R)
% definieren, welches wahr ist, wenn R der groesste gemeinsame Teiler von A und B ist.
% Verwenden Sie den divisions-basierten euklidischen Algorithmus fuer die Berechnung.
% Using the built-in integers, define a predicate gcd(A,B,R) which is true if R is the greatest
% common divisor of A and B. Use the division-based Euclidean algorithm for the computation.

% gcd(A, B, R) :- ?



% Exercise:
% Unter Verwendung des eingebauten Datentyps der Integer, sollen Sie ein Praedikat
% sum_divisible(Div,From,To,Result) definieren, welches wahr ist, wenn Result die Summe der Zahlen
% zwischen From und To ist, die durch Div teilbar sind.
% Using the built-in integers, define a predicate sum_divisible(Div,From, To, Result) which is true
% if Result is the sum of the integers between From and To that are divisible by Div.

sum_divisible(_, From, From, 0).
sum_divisible(Div, From, To, Result):-
    Div =\= 0,
    From < To,
    From mod Div =:= 0,
    From1 is From + 1,
    Result1 is Result - From,
    sum_divisible(Div, From1, To, Result1).

sum_divisible(Div, From, To, Result):-
    Div =\= 0,
    From < To,
    From mod Div =\= 0,
    From1 is From + 1,
    sum_divisible(Div, From1, To, Result).
% sum_divisible(Div, From, To, Result) :- ?



% Exercise:
% Unter Verwendung des eingebauten Datentyps der Integer, ist ein Praedikat itob(N,P,B) zu
% definieren, welches wahr ist, wenn B die Binaerdarstellung als Dezimalzahl des Integers N fuer
% N >= 0 ist. P entspricht der minimalen Anzahl an Ziffern der Dezimalzahl B, die zur Darstellung
% benoetigt werden.
% Using the built-in integers, define a predicate itob(N,P,B) which is true if B is the binary
% representation as decimal number of the integer N for N >= 0. P is the minimal number of digits of
% the number B, which are needed for the binary representation.
% Beispiel / Example:
%% ?- itob(12,4,B).
%% B = 1100 ;
%% false.
%

% itob(N, P, B) :- ?



% Exercise:
% Unter Verwendung des eingebauten Datentyps der Integer, sollen Sie ein Praedikat fib(N,F)
% definieren, welches wahr ist, wenn F die Nte Fibonacci-Zahl ist.
% Using the built-in integers, define a predicate fib(N,F) which is true if F is the Nth Fibonacci
% number.

fib(N, F) :- N is 1, F is 0.
fib(N, F) :- N is 2, F is 1.
fib(N, F) :-
    N > 0,
    N1 is N - 1,
    N2 is N - 2,
    fib(N1, F1),
    fib(N2, F2),
    F is F1 + F2.



% Exercise:
% Unter Verwendung des eingebauten Datentyps der Integer, sollen Sie ein Praedikat fibL(N,F)
% definieren, welches mit Hilfe von Backtracking alle Fibonacci-Zahlen bis inklusive der Nten
% Fibonacci-Zahl (fuer N > 0) als separate Loesungen fuer F ausgibt.
% Tipp: Benutzen Sie das fib(N, F)-Praedikat des vorherigen Beispiels und definieren Sie ein Hilfs-
% praedikat das eine Fibonacci-Zahl liefert und ein weiters, welches die bereits gelieferten
% Ergebnisse mitzaehlt.
% Using the built-in integers, define a predicate fibL(N, F) which responds with all Fibonacci
% numbers up to the Nth Fibonacci number (for N > 0) as separate answers for F via backtracking.
% Hint: Use the fib(N, F)-predicate defined in the previous exercise and define an auxiliary
% predicate which answers with one Fibonacci number and another which counts the presented answers.
% Beispiel / Example:
%% ?- fibL(6,F).
%% F = 0 ; F = 1 ; F = 1 ; F = 2 ; F = 3 ; F = 5 ; F = 8 ; false.
%

