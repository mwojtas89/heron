##Analiza zadania:

###1. Struktura
Po przeanalizowaniu przykładu postanowiłem przebudować strukturę programu.

W obecnej wersji mamy dwa interfejsy:
* Brick
* Structure

Brick interfejs obsługuje wiele różnych rodzajów "cegieł", natomiast CompositeBlock uznałem za implementacje "cegieł"
doszedłem do wniosku, że tworzenie dodatkowego interfejsu który dostarcza tylko get List jest zbędne.

W zamian za interfejs CompositeBlock zaproponowałem klasę implementującą interfejs Brick,
gdyż CompositeBlock uznałem za implementację Brick.

Może być wiele różnych rodzajów cegieł i ich implementacji jedną z nich jest CompositeBlock.

Interfejs Structure pozostał bez zmian.

Klasa Wall implementuje wszystkie niezbędne metody.

###2. Klasa Wall

* metoda findBlockByColor(String color): Trzeba pamiętać o obsłudze wyjątków związanych z Optional.

* metoda int count() : uznałem, że najlepszym sposobem wykonania zadania będzie użycie stream().count()
  jednak rozwiązanie to wymagało by cast z long na int. Zastosowałem więc inne podejście z reduce aby uzyskać int jako
  typ wynikowy, jedyny minus ograniczenie wynikające z rozmiaru typu int