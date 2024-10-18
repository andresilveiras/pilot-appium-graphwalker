[PT-BR] - English bellow

Projeto piloto para o estudo de caso: uso de Teste Baseado em Modelo na automação de testes em aplicativos móveis

Ferramenta de automação: Appium (v2.12.0)
Ferramenta de TBM: GraphWalker (v4.3.3)
Linguagem de programação utilizada: Java

Como executar o projeto?

Pré-Requisitos:

- Fazer a instalação do Android Studio e ferramentas ADB na máquina
- Fazer a instalação do Appium na máquina (requer Node.JS)
- Após instalar o appium, instale o driver uiautomator2 para os testes no android (https://github.com/appium/appium-uiautomator2-driver)
- Fazer a instalação do GraphWalker (https://graphwalker.github.io/)
- Fazer a instalação do apk disponível no src/main/resources no dispositivo utilizado no teste (necessário habilitar a instalação de app fora da Play Store no Android)

O teste pode ser feito tanto em dispositivo físico quanto emulado pelo Android Studio

No caso do dispositivo físico:

- Desbloquear o modo desenvolvedor no dispositivo (pesquisar como é feito no dispositivo que você tem, pode variar de modelo para modelo)
- Ativar o modo DEBUG nas opções de desenvolvedor
- Conectar o dispositivo à máquina via USB (ativar compartilhamento de mídia)
- Ativar a permissão do Appium ao modo debug do dispositivo

IMPORTANTE: Antes de rodar o código, é necessário editar as variáveis do dispositivo na classe appiumSetup() para o dispositivo que você irá utilizar, tanto para dispositivo físico quando emulado

Para executar o código:

OBS: Os comandos de terminal funcionam para todos os SO da máquina: Windows, Linux e Mac

- git clone ~ este projeto ~
- No terminal, entre na pasta onde está o POM e digite o comando mvn install (irá instalar as dependências e compilar as classes)
- Conecte o dispositivo à máquina (verifique pelo comando adb devices se o UDID é o mesmo que está setado nas capabilities na classe appiumSetup() )
- Recomendado caso esteja testando em dispositivo físico: Espelhe a tela do disposivo pelo app Vysor (https://www.vysor.io/)
- Inicie o server appium abrindo um terminal à parte, digitando o comando appium
- Se estiver com o server do appium aberto e visualizando a tela do dispositivo, basta executar o Main pela IDE da sua preferência (eu utilizei o VS Code) :)
