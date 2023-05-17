% Exercise:
% Unter Verwendung der induktiven Definition der natuerlichen Zahlen ueber den Funktor s fuer den
% Parameter N, sollen Sie ein Praedikat len_nat(L,N) definieren, welches wahr ist, wenn N die
% Laenge der Liste L ist.
% Using the inductive definition of natural numbers via the functor s for the parameter N, define a
% predicate len_nat(L,N) that is true if N is the length of the list L.

len_nat(0, []).
len_nat(N, [_ | T]) :- N1 is N - 1, len_nat(N1, T).



% Exercise:
% Definieren Sie ein Praedikat sorted(L), welches wahr ist, wenn L eine sortierte Liste von Integers
% (des eingebaute Datentyps) ist.
% Define a predicate sorted(L) that is true if L is a sorted list of (built-in) integers.

sorted([]).
sorted([_]).
sorted([A | [B | T]]):-
    (A < B ; A = B),
    sorted([B | T]).
% sorted(L) :- ?



% Exercise:
% Definieren Sie ein Praedikat fill(N,E,L), welches wahr ist, wenn L eine Liste der Laenge N ist,
% die ausschließlich aus Elementen mit dem Wert E besteht.
% Define a predicate fill(N,E,L) which is true if L is a list of length N consisting of elements of
% the value E.

fill(0, _, []).
fill(N, E, [Lh | Lt]) :-
    N1 is N - 1,
    Lh is E,
    fill(N1, E, Lt).



% Exercise:
% Definieren Sie ein Praedikat fill_unary(N,E,L), welches wahr ist, wenn L eine Liste der Laenge N
% ist, die ausschließlich aus Elementen mit dem Wert E besteht, wobei N mit Hilfe der induktiven
% Definition der natuerlichen Zahlen codiert werden soll. Eine Anfrage wie fill_unary(N, 1, L)
% sollte moegliche Instantiierungen von N und L berechnen, wie: N = s(0) und L = [1].
% Define a predicate fill(N,E,L) which is true if L is a list of length N consisting of elements of
% the value E. Use the inductive definition of natural numbers to encode N. A query like
% fill_unary(N, 1, L) should compute instantiations for N and L, such as: N = s(0) and L = [1].

fill_unary(0, _, []).
fill_unary(s(Len), E, [E|Lt]):-
    fill_unary(Len, E, Lt).
% fill_unary(N, E, L) :- ?



% Exercise:
% Definieren Sie ein Praedikat multiply_list(M,L,R), das wahr ist, wenn R eine Liste ist, welche die
% selben Elemente wie die Liste L beinhaltet, aber M mal wiederholt. Eine Anfrage
% multiply_list(2, [1,2], [1,1,2,2]) soll demnach mit true beantwortet werden.
% Tipp: Verwenden Sie das Praedikat fill, um Wiederholungen von Elementen zu erzeugen.
% Define a predicate multiply_list(M,L,R) that evaluates to true if R is a list that consists of
% the same Elements as L, but every element should be repeated M times. For example, a query
% multiply_list(2, [1,2], [1,1,2,2]) should be answered with true.
% Hint: Use the predicate fill to create repeated elements.

multiply_list(_, [], []).
multiply_list(M, [Lh | Lt], Res) :-
    fill(M, Lh, MLh),
    multiply_list(M, Lt, R),
    append(MLh, R, Res).




% Exercise:
% Definieren Sie ein Praedikat multiply_list_unary(M,L,R), das wahr ist, wenn R eine Liste ist,
% welche die selben Elemente wie die Liste L beinhaltet, aber M mal wiederholt. M sei ueber die
% induktive Definition der natuerlichen Zahlen definiert. Eine Anfrage
% multiply_list_unary(s(s(0)), [1,2], [1,1,2,2]) soll mit true beantwortet werden und es soll
% moeglich sein, den Parameter M in multiply_list_unary(M, [1,2], R) offen zu lassen.
% Tipp: Verwenden Sie das Praedikat fill_unary, um Wiederholungen von Elementen zu erzeugen.
% Define a predicate multiply_list(M,L,R) which is true if R is a list that consists of the same
% Elements as L, but every element should be repeated M times, where M uses the inductive definition
% of natural numbers encoded with the functor s. A query multiply_list(s(s(0)), [1,2], [1,1,2,2])
% should be answered with true and it should be possible to leave the parameter M undefined in a
% query like multiply_list_unary(M, [1,2], R).
% Hint: Use the predicate fill_unary to create repeated elements.

multiply_list_unary(0, _, []).
multiply_list_unary(_, [], []).
multiply_list_unary(M, [Lh | Lt], R):-
    fill_unary(M, Lh, Rh),
    multiply_list_unary(M, Lt, Rt),
    append(Rh, Rt, R).
% multiply_list_unary(M, L, R) :- ?



% Exercise:
% Definieren Sie ein Praedikat removeDup(L,R), welches wahr ist, wenn die Liste R die Elemente der
% Liste L ohne aufeinanderfolgende Duplikate enthaelt. Die Reihenfolge der individuellen Elemente
% soll gleich sein.
% Define a predicate removeDup(L,R) which is true if the list R contains all Elements of the list L
% without consecutive duplicates. The order of the individual elements has to be the same.

removeDup([], []).
removeDup([X], [X]).
removeDup([H | [Lth | Lt]], [H | Rt]):-
    H =\= Lth,
    removeDup([Lth | Lt], Rt).

removeDup([H | [Lth | Lt]], [H | Rt]):-
    H =:= Lth,
    removeDup([Lth | Lt], [H | Rt]).
% removeDup(L, R) :- ?



% Exercise:
% Definieren Sie ein Praedikat min(L,M), welches wahr ist, wenn M das kleinste Element aus der
% Integerliste L ist. min([], none) ist wahr, wenn L leer ist.
% Define a predicate min(L,M) which is true if M is the smallest element occurring in the integer
% Liste L. In the case that L is empty, min(none,[]) is true.

% min(L, M) :- ?



% Exercise:
% Definieren Sie ein Praedikat tails(L,T), welches wahr ist, wenn T eine Liste der echten Suffixe
% (tails) der Liste L ist, wobei die leere Liste keine Suffixe hat.
% Define a predicate tails(L,T) which is true if T is a list containing proper suffixes (tails) of
% the list L. An empty list does not have any suffixes.
% Beispiel/Example:
% ?- tails([1,2,3],[[2,3],[3],[]]).
% true.
%

% tails(L, T) :- ?



% Exercise:
% Definieren Sie ein zip(L,R,Res) Praedikat, welches wahr ist, wenn Res ein Liste von Paaren ist,
% die aus den Elementen der Eingabelisten L und R bestehen. Res soll so lang sein, wie die kuerzere
% der beiden Listen.
% Define a zip(L,R,Res) predicate that is true if Res is a list of pairs consisting of elements of
% the input lists L and R. Res should be as long as the shortest of the two lists.
% Beispiel/Example:
% ?- zip([1,2],[3,4,5], [(1,3),(2,4)]).
% true.
%

% zip(L, R, Res) :- ?



% Exercise:
% Definieren Sie ein Praedikat to_binary(N,L), das wahr ist, wenn L eine Liste aus Werten 0 und 1
% ist, welche die binaere Repraesentation der natuerlichen Zahl N darstellen (unter Verwendung des
% eingebauten Datentyps der Integers). Fuer den Fall, dass N = 0, soll gelten, dass to_binary(0,[]).
% Define a predicate to_binary(N,L) that is true if L is a list over 0 and 1 containing the binary
% representation of the natural number N (using the built-in integers). In the case that N = 0, it
% should hold that to_binary(0,[]).

% to_binary(N, L) :- ?



% Exercise:
% Definieren Sie ein Praedikat count(L,E,N), das wahr ist, wenn die Liste L den Wert E N-mal
% beinhaltet. Verwenden Sie die induktiv definierten natuerlich Zahlen mit dem Funktor s, um N
% darzustellen.
% Define a Praedikat count(L,E,N) that is true if the list L contains the value E N-times. Use the
% inductively defined natural numbers via the functor s to encode N.

count([], _, 0).
count([E | T], E, s(N)):- count(T, E, N).
count([H | T], E, N):-
    H \= E,
    count(T, E, N).
% count(L, E, N) :- ?



% Exercise:
% Definieren Sie ein Praedikat recIndex(L, N, R), das wahr ist, wenn L eine in absteigender
% Reihenfolge sortiere Integerliste und N ein Integer ist. Des Weiteren soll gelten, dass die
% Elemente der Integerliste R die groeßten moeglichen Zahlen aus L sind, die in Summe die Zahl N
% ergeben.
% Define a predicate recIndex(L, N, R) which is true if L is an integer list, sorted in decending
% order, and N an integer. In addition, the integer list R should consist of the greates possible
% numbers of L, which sum up to the number N.
% Beispiel/Example:
% ?- recIndex([10,9,8,7,6,5,4,3,2,1], 38, R).
% R = [10, 10, 10, 8] ;
% false.
%

% recIndex(L, N, R) :- ?