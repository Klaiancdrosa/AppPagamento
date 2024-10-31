# **App Pagamento**
&gt; Desenvolvido para auxiliar o usuário no cálculo do salário.

## Descrição
O **App Pagamento** permite ao usuário cálcular o salário final adicionando ou não os diversos descontos disponíveis.

## Funcionalidades
- [x] Entrada de dados (nome do funcionario, salario bruto, sexo e número de filhos)
- [x] Interface simples e intuitiva

## Tecnologias Utilizadas
- [x] **Android Studio** (Koala | 2024.1.2)
- [x] **Java** para desenvolvimento
- [x] **RelativeLayout** para interface responsiva
- [x] **TextView**, **EditText**e **RadioButton** para entrada e exibição de dados
      
## Como Rodar o Projeto
Siga os passos abaixo para rodar o projeto localmente:

1. Clone este repositório:
```bash
git clone https://github.com/Klaiancdrosa/AppPagamento.git
```
2. Abra o projeto no Android Studio.
3. Compile e execute o projeto em um emulador ou dispositivo físico.
   
## Estrutura do Projeto
```bash
├── app
│ ├── src
│ │ ├── main
│ │ │ ├── java
| | | | |── br.ulbra.apppagamento
│ │ │ │ | ├── MainActivity.java # Atividade aonde o cálculo do salário final.
| │ │ │ ├── res
| | | | ├── drawable # imagens e icones utilizados na tela principal
│ │ │ │ ├── layout
│ │ │ │ │ ├── activity_main  .xml # Layout da tela principal
│ │ │ │ └── values
│ │ │ │ ├── strings.xml # Strings usadas no app
│ │ │ │ ├── colors.xml # Cores definidas no projeto
│ └── build.gradle # Configuração do Gradle
└── README.md # Este arquivo
```

## Design e Prototipage
A interface do app foi criada usando **RelativeLayout**;
O design é minimalista e fácil de usar, com foco na simplicidade e entendimento.

## Telas do App Pagamento
**Tela Principal**
Tela principal aonde o usuário pode realizar o cálculo final do salário com base nas informações fornecidas.

![image](https://github.com/user-attachments/assets/3723bac3-4431-4cc7-9adf-702570314612)

![image](https://github.com/user-attachments/assets/0e3b154f-f2d4-46b6-a306-b1031d0e3456)

## Desenvolvedores
**Klaian Conceição da Rosa** - Desenvolvedor - [GitHub](https://github.com/Klaiancdrosa)

## Licenças
Este projeto está licenciado sob os termos da licença MIT. Para mais detalhes, veja o arquivo
[LICENSE](LICENSE).
