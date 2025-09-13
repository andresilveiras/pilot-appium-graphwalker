# Projeto Piloto: Automação de Testes Móveis com Model-Based Testing

[🇧🇷 Português](#português) | [🇺🇸 English](#english)

## Português

### Visão Geral
Este projeto demonstra a implementação de testes automatizados para aplicações móveis utilizando a abordagem de Model-Based Testing (MBT). O projeto serve como um estudo de caso prático para avaliar a eficácia desta metodologia na automação de testes mobile.

### Stack Tecnológica
- **Framework de Automação**: Appium v2.12.0
- **Ferramenta MBT**: GraphWalker v4.3.3
- **Linguagem**: Java (JDK 21.0.5)
- **Compatibilidade**: Windows, Linux e macOS
- **Plataforma de Teste**: Android

### Pré-requisitos

#### Ferramentas de Desenvolvimento
1. Git
2. IDE de sua preferência
   - Para Visual Studio Code: Instalar "Extension Pack for Java" da Microsoft
3. Java JDK 21.0.5
   - [Download e instruções de instalação](https://www.oracle.com/java/technologies/downloads/)
   - **Importante**: Versão 21 recomendada devido a problemas de compatibilidade com versões posteriores
4. Maven
   - [Guia de instalação](https://maven.apache.org/install.html)
   - Configurar após a instalação do Java

#### Ambiente Android
1. Android Studio e ADB
   - [Download e configuração do ADB](https://developer.android.com/tools/adb)
2. Appium
   - Requer Node.js
   - [Guia de instalação](https://appium.io/docs/en/2.2/quickstart/install/)
3. Driver UIAutomator2
   - [Instruções de instalação](https://appium.io/docs/en/2.2/quickstart/uiauto2-driver/)
4. Appium Inspector (opcional)
   - [Download](https://github.com/appium/appium-inspector)
5. GraphWalker
   - [Instalação e documentação](https://graphwalker.github.io/)

### Configuração do Dispositivo

#### Para Dispositivo Físico
1. Ativar modo desenvolvedor
2. Habilitar depuração USB
3. Conectar via USB com compartilhamento de mídia
4. Configurar permissões do Appium
5. Instalar APK do aplicativo (disponível em `src/main/resources`)
   - Necessário habilitar instalação de fontes desconhecidas

#### Para Emulador
- Configurar dispositivo virtual via Android Studio

### Configuração do Projeto

1. Clonar o repositório:
   ```bash
   git clone [URL do repositório]
   ```

2. Verificar dados do dispositivo (físico ou emulado):
   ```bash
   adb devices

3. Configurar variáveis do dispositivo em `DriverRunner.java`:
   - `appPath`: Diretório do repositório clonado
   - `deviceName`: Nome do dispositivo
   - `deviceUdid`: UDID do dispositivo
   - `deviceOSVersion`: Versão do Android

### Execução dos Testes

1. Instalar dependências:
   ```bash
   mvn clean install
   ```

2. Iniciar servidor Appium:
   ```bash
   appium
   ```

3. Para dispositivos físicos:
   - Recomendado: Usar [Vysor](https://www.vysor.io/) para espelhamento

4. Executar testes:
   ```bash
   mvn org.graphwalker:graphwalker-maven-plugin:test
   ```

### Modelo de Testes
![Modelo de Testes](https://github.com/user-attachments/assets/f86c5e8c-0099-4e1a-bd53-bf70605206f4)

O modelo completo está disponível em `src/main/resources/NotepadTestModel_v1.json`

### Créditos
- Sistema sob teste (SUT): [Notepad by farmerBB](https://github.com/farmerbb/Notepad)

## English

### Overview
This project demonstrates the implementation of automated testing for mobile applications using the Model-Based Testing (MBT) approach. It serves as a practical case study to evaluate the effectiveness of this methodology in mobile test automation.

### Technology Stack
- **Automation Framework**: Appium v2.12.0
- **MBT Tool**: GraphWalker v4.3.3
- **Language**: Java (JDK 21.0.5)
- **Compatibility**: Windows, Linux, and macOS
- **Testing Platform**: Android

### Prerequisites

#### Development Tools
1. Git
2. IDE of your choice
   - For Visual Studio Code: Install Microsoft's "Extension Pack for Java"
3. Java JDK 21.0.5
   - [Download and installation instructions](https://www.oracle.com/java/technologies/downloads/)
   - **Important**: Version 21 recommended due to compatibility issues with newer versions
4. Maven
   - [Installation guide](https://maven.apache.org/install.html)
   - Configure after Java installation

#### Android Environment
1. Android Studio and ADB
   - [ADB download and setup](https://developer.android.com/tools/adb)
2. Appium
   - Requires Node.js
   - [Installation guide](https://appium.io/docs/en/2.2/quickstart/install/)
3. UIAutomator2 Driver
   - [Installation instructions](https://appium.io/docs/en/2.2/quickstart/uiauto2-driver/)
4. Appium Inspector (optional)
   - [Download](https://github.com/appium/appium-inspector)
5. GraphWalker
   - [Installation and documentation](https://graphwalker.github.io/)

### Device Setup

#### For Physical Device
1. Enable developer mode
2. Enable USB debugging
3. Connect via USB with media sharing enabled
4. Configure Appium permissions
5. Install app APK (available in `src/main/resources`)
   - Must enable installation from unknown sources

#### For Emulator
- Set up virtual device via Android Studio

### Project Setup

1. Clone the repository:
   ```bash
   git clone [repository URL]
   ```

2. Verify device data:
   ```bash
   adb devices

3. Configure device variables in `DriverRunner.java`:
   - `appPath`: Cloned repository directory
   - `deviceName`: Device name
   - `deviceUdid`: Device UDID
   - `deviceOSVersion`: Android version

### Running Tests

1. Install dependencies:
   ```bash
   mvn clean install
   ```

2. Start Appium server:
   ```bash
   appium
   ```

3. For physical devices:
   - Recommended: Use [Vysor](https://www.vysor.io/) for screen mirroring

4. Execute tests:
   ```bash
   mvn org.graphwalker:graphwalker-maven-plugin:test
   ```

### Test Model
The complete model is available at `src/main/resources/NotepadTestModel_v1.json`

### Credits
- System Under Test (SUT): [Notepad by farmerBB](https://github.com/farmerbb/Notepad)
