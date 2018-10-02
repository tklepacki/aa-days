
# Drogi Uczestniku,

Cieszę się, że wybrałeś właśnie mój warsztat :) 

W celu weryfikacji środowiska na którym będziemy pracować w takcie warsztatów poproszę Cię o wykonanie kilku czynności. Najpierw upewnij się, że spełniasz określone wymagania dotyczące wiedzy oraz narzędzi (*Wymagania*), a następnie przejdź do kroków w paragrafie *Weryfikacja*.

## Wymagania

### Wiedza

Oczekuję od Ciebie:

- Znajomości podstaw języka Java oraz projektów typu Maven;

- Podstaw poruszania się w systemie Unix;

- Mile widziana znajomość podstaw GIT;

- Wskazana podstawowa znajomość biblioteki Selenium WebDriver.

Niestety z uwagi na ograniczony czas warsztatów nie będzie czasu na tłumaczenie tych zagadnień od zera.

### Narzędzia

Proszę o przyniesienie ze sobą komputera z systemem Linux albo w ostateczności Windows (rekomendowany system Windows 10). Proszę o instalację:

- Wybranego IDE - najlepiej IntelliJ IDEA https://www.jetbrains.com/idea/ 
  lub Eclipse: https://www.eclipse.org/downloads/
  W przypadku Eclipse'a prośba dodatkowo o instalację TestNG for Eclipse: 
  https://marketplace.eclipse.org/content/testng-eclipse

- Java 8
  http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html

- GIT
  Windows: https://git-scm.com/download/win
  **UWAGA: W trakcie instalacji w oknie "Adjusting your PATH environment" zaznaczcie opcje: "Use Git and optional Unix tools from the Windows Command Prompt (ostatni radio button)"**
  
  Linux: https://git-scm.com/download/linux
  Mac: https://git-scm.com/download/mac

- Docker
  https://docs.docker.com/install/linux/docker-ce/ubuntu/
  https://docs.docker.com/docker-for-windows/install/
  https://docs.docker.com/docker-for-mac/install/

- Docker Compose - instalacja wymagana tylko dla komputerów z systemem Linux:
  https://docs.docker.com/compose/install/

- System do zarządzania wersjami - GIT
  https://git-scm.com/downloads

- VNC Viewer
  https://www.realvnc.com/en/connect/download/viewer/

- Przeglądarki Chrome oraz FireFox w najnowszych wersjach.

- Jeśli nie posiadasz jeszcze konta na GitHub prośba o utworzenie:
  https://github.com/join?source=header-home. Po utworzeniu konta wejdź na https://goo.gl/forms/2tPHSId8UHwB85YF3, podaj nazwę   
  użytkownika i wyślij formularz.

## Weryfikacja środowiska

### Java

- Wpisz w konsoli: `java -version`. Upewnij się, że została podana informacja o wersji zainstalowanej JAVY:
  *java version "1.8.0_181*
  *Java(TM) SE Runtime Environment (build 1.8.0_181-b13)*
  *Java HotSpot(TM) 64-Bit Server VM (build 25.181-b13, mixed mode)* 

- Wpisz w konsoli: `javac -version`. Upewnij się, że została podana informacja o wersji zainstalowanego kompilatora JAVA:
  *javac 1.8.0_181*

### Git:

- Sklonuj repozytorium `git clone https://github.com/tklepacki/aa-days.git`
- Wejdź do folderu z repozytorium i upewnij się, że projekt został pobrany
- Tylko dla systemów Windows - wejdź to terminal (CMD) i wpisz komendę:
`ls -al`  
Upewnij się, że zostały wylistowane pliki/foldery danej lokalizacji i komenda została rozpoznana.

### IDE

- Zaimportuj projekt Maven w swoim IDE. Następnie uruchom zestaw testowy znajdujący się w lokalizacji
  *src/test/resources/testsuite.xml*
- Powinny uruchomić się 4 testy logowania użytkownika - dwa dla sklepu e-commerce Reserved (przeglądarka FF) oraz dwa dla sklepu 
  e-commerce Mohito (przeglądarka Chrome).
- Upewnij się, że testy zostały zakończone sukcesem.

### Docker

- Wpisz w konsoli: `docker -v`
- Upewnij się, iż została podana informacja o wersji zainstalowanego Dockera:
  *Docker version 18.06.0-ce, build 0ffa825*
- Pobierz dockerowe obrazy następującymi komendami:  
`docker pull jenkins/jenkins:lts`  
`docker pull selenium/hub`  
`docker pull selenium/node-firefox`  
`docker pull selenium/node-firefox-debug`  
`docker pull selenium/node-chrome`  
`docker pull selenium/node-chrome-debug`  
`docker pull elgalu/selenium`  
`docker pull dosel/zalenium`  
- Tylko dla systemów Linux - wpisz następujące komendy:  
`sudo groupadd docker`  
`sudo usermod -aG docker $USER`  
Uruchom ponownie swoją maszynę

### Docker Compose

- Wpisz w konsoli: `docker-compose -v`
- Upewnij się, iż została podana informacja o wersji zainstalowanego Dockera Compose:
  *docker-compose version 1.22.0, build f46880fe*

### Maven

- Wejdź do repozytorium.
- Uruchom polecenie `mvnw clean install` jeśli używasz Windows lub `./mvnw clean install` jeśli używasz Linux/MacOS.
- Powinny uruchomić się 4 testy logowania użytkownika - dwa dla sklepu e-commerce Reserved (przeglądarka FF) oraz dwa dla sklepu 
  e-commerce Mohito (przeglądarka Chrome).
- Upewnij się, że testy zostały wykonane poprawnie i zakończyły się komunikatem *BUILD SUCCESS*.

## W razie problemów
Pisz na mój adres email: *t.klepacki@wp.pl*
