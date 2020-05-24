# -Localization

In filele Messages.properties si Messages_ro.properties sunt stocate
o serie de perechi de valori cheie , valori care vor fi preluate de
metodele java.

DisplayLocales afiseaza localizarile disponibile (perechi de limbi si tari).
SetLocale seteaza o localizare la o anumita limba(romana,engleza,franceza,italiana)
Info afiseaza informatile localizarii dorite. Continentul si capitala sunt
asigutate cu ajutorul DataFlex.

In LocaleExplolre cream un obiect Locale care preia default o localizare in engleza.
Apoi intr-un loop declaram un ResourceBundle care prelueaza date din filele properties.
Acum putem apela metodele DisplayLocales, SetLocale, Info prin comenzi cheie(Display,
Set,Info), eventual iesim din loop tastand "Exit".

