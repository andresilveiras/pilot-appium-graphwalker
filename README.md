[PT-BR] - English bellow

Projeto piloto para o estudo de caso: uso de Teste Baseado em Modelo na automação de testes em aplicativos móveis

- Ferramenta de automação: Appium (v2.12.0)
- Ferramenta de TBM: GraphWalker (v4.3.3)
- Linguagem de programação utilizada: Java

Este projeto pode ser executado tanto em máquinas Windows quanto Linux e Mac, os dispositivos onde irá rodar o SUT (System Under Test) devem ser Android

Como executar o projeto?

Pré-Requisitos:

- Instale o GIT e a IDE de sua preferência (caso por algum estranho motivo você ainda não tenha feito rsrs)
- OBS: Caso utilize a IDE Visual Studio Code, instale a extensão "Extension Pack for Java", da Microsoft, possui todas as extensões necessárias para rodar este projeto 
- Instalar o Java na máquina e configurar as variáveis de ambiente necessárias (https://www.oracle.com/java/technologies/downloads/)
- Instalar o Maven na máquina e configurar as variáveis de ambiente necessárias - DEVE SER FEITO APÓS A INSTALAÇÃO E CONFIGURAÇÃO DO JAVA (https://maven.apache.org/install.html)
- Fazer a instalação do Android Studio e ferramentas ADB na máquina (https://developer.android.com/tools/adb)
- Fazer a instalação do Appium na máquina - requer Node.JS (https://appium.io/docs/en/2.2/quickstart/install/)
- Após instalar o appium, instale o driver uiautomator2 para os testes no android (https://github.com/appium/appium-uiautomator2-driver)
- Opcional: Instale tambem o Appium Inspector (https://github.com/appium/appium-inspector)
- Fazer a instalação do GraphWalker (https://graphwalker.github.io/)
- Fazer a instalação do apk disponível no src/main/resources no dispositivo utilizado no teste (necessário habilitar a instalação de app fora da Play Store no Android)

O teste pode ser feito tanto em dispositivo físico quanto emulado pelo Android Studio

No caso do dispositivo físico:

- Desbloquear o modo desenvolvedor no dispositivo (pesquisar como é feito no dispositivo que você tem, pode variar de modelo para modelo)
- Ativar o modo DEBUG nas opções de desenvolvedor
- Conectar o dispositivo à máquina via USB (ativar compartilhamento de mídia)
- Ativar a permissão do Appium ao modo debug do dispositivo

IMPORTANTE: Antes de rodar o código, é necessário editar as variáveis do dispositivo na classe appiumSetup() para o dispositivo que você irá utilizar, tanto para dispositivo físico quando emulado. Está em Main.java

Para executar o código:

OBS: Os comandos de terminal funcionam para todos os SO da máquina: Windows, Linux e Mac

- git clone ~ este projeto ~
- No terminal, entre na pasta onde está o POM e digite o comando mvn clean install (irá instalar as dependências e compilar as classes)
- Conecte o dispositivo à máquina (verifique pelo comando adb devices se o UDID é o mesmo que está setado nas capabilities na classe appiumSetup() na Main)
- Recomendado caso esteja testando em dispositivo físico: Espelhe a tela do disposivo pelo app Vysor (https://www.vysor.io/)
- Inicie o server appium abrindo um terminal à parte, digitando o comando appium
- Se estiver com o server do appium aberto e visualizando a tela do dispositivo, basta executar o Main.java pela IDE da sua preferência :)

Comando para rodar o graphwalker:  mvn org.graphwalker:graphwalker-maven-plugin:test

CRÉDITOS:

Repositório do SUT utilizado: https://github.com/farmerbb/Notepad

[ENG]

Pilot project for the case study: use of Model-Based Testing in test automation of mobile applications 

- Automation tool: Appium (v2.12.0)
- MBT tool: GraphWalker (v4.3.3)
- Programming language: Java

This project can run on Windows, Linux and Mac machines, the devices where the SUT (System Under Test) will run must be Android

How to run this project?

Prerequisites: 

- Install GIT and an IDE of your choice (if for some strange reason you haven't done it yet)
- NOTE: If you choose to use Visual Studio Code IDE, install the "Extension Pack for Java" extension from Microsoft, it has everything necessary to run this project
- Install Java on your machine and configure the environment variables (https://www.oracle.com/java/technologies/downloads/)
- Install Maven on your machine and configure the environment variables - NEEDS TO BE DONE AFTER JAVA INSTALLATION (https://maven.apache.org/install.html)
- Install Android Studio and ADB tools on your machine (https://developer.android.com/tools/adb)
- Install Appium on your machine - requires Node.JS (https://appium.io/docs/en/2.2/quickstart/install/)
- After installing Appium, install the uiautomator2 driver for testing on Android (https://github.com/appium/appium-uiautomator2-driver)
- Optional: Also install Appium Inspector (https://github.com/appium/appium-inspector)
- Install GraphWalker (https://graphwalker.github.io/)
- Install the apk available in src/main/resources on the device used in the test (it is necessary to enable the installation of applications outside the Play Store on Android)

The test can be done both on a physical device and one emulated by Android Studio 

In the case of using physical device: 

- Unlock developer mode on the device (research how to do it on the device you have, it may vary from model to model)
- Enable DEBUG mode in the developer options
- Connect the device to the machine via USB (enable media sharing)
- Enable Appium's permission to the device's debug mode

IMPORTANT: Before running the code, it is necessary to edit the device variables in the appiumSetup() class for the device you will use, for both the physical and emulated device. It is located in Main.java

To run the code: 

NOTE: The terminal commands work for all machine OS: Windows, Linux and Mac 

- git clone ~ this project ~
- In the terminal, enter the folder where the POM is located and type the command mvn clean install (it will install the dependencies and compile the classes)
- Connect the device to the machine (check with the command adb devices if the UDID is the same as the one defined in the capabilities in the appiumSetup() class in Main)
- Recommended if you are testing on a physical device: Mirror the device's screen using the Vysor app (https://www.vysor.io/)
- Start the appium server by opening a separate terminal, writing the command appium
- If you have the appium server open and is viewing the device's screen, just run Main.java via the IDE of your choice :)

CREDITS:

- Repository of the SUT used in this project: https://github.com/farmerbb/Notepad
