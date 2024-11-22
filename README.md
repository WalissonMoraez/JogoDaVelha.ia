# Jogo da Velha com IA
Este projeto é uma implementação do Jogo da Velha em Java, que permite que o jogador humano jogue contra o computador. O computador utiliza o algoritmo Minimax para tomar decisões estratégicas, garantindo uma jogabilidade desafiadora.

Sumário
Descrição
Como Funciona
Execução do Programa
Estrutura do Código
Melhorias Futuras
Descrição
O jogo apresenta um tabuleiro de 3x3 onde dois jogadores, o humano (X) e o computador (O), alternam turnos para preencher as casas. O objetivo é formar uma linha com três símbolos iguais (horizontal, vertical ou diagonal) antes do adversário.

O jogador humano insere suas jogadas escolhendo as coordenadas do tabuleiro.
O computador utiliza o algoritmo Minimax para calcular a melhor jogada possível, tornando-o quase invencível.
Como Funciona
Tabuleiro:

Representado como uma matriz 3x3 de caracteres (char[][]), inicializado com espaços em branco (' ').
Jogadas:

O jogador humano insere as coordenadas para sua jogada.
O computador escolhe a melhor jogada usando o algoritmo Minimax.
Condições de Vitória:

O jogo verifica, após cada jogada, se houve vitória (linha, coluna ou diagonal completa) ou empate (tabuleiro cheio sem vencedor).
Minimax:

É um algoritmo recursivo usado para maximizar as chances de vitória do computador e minimizar as do oponente.
Avalia todas as jogadas possíveis e retorna a melhor escolha com base em um valor de utilidade:
Vitória do computador: +1.
Vitória do jogador: -1.
Empate: 0.
Execução do Programa
Requisitos:
Java Development Kit (JDK) 8 ou superior instalado.
IDE como IntelliJ, Eclipse, ou editor de texto com suporte a Java (ex.: VSCode).
Como Rodar:
Clone este repositório:
bash
Copiar código
git clone https://github.com/seu-usuario/jogo-da-velha.git
Compile o código:
bash
Copiar código
javac jogo_da_velha/ia/Game_Hash.java
Execute o programa:
bash
Copiar código
java jogo_da_velha.ia.Game_Hash
Jogando:
Após executar o programa, você verá o tabuleiro vazio e será solicitado a inserir as coordenadas para sua jogada.
Insira os valores de linha e coluna (0 a 2) e pressione Enter.
O computador realizará sua jogada automaticamente após a sua.
Estrutura do Código
Principais Funções
1. Mostrar o Tabuleiro (showBoard)
Exibe o estado atual do tabuleiro no console.

2. Realizar Jogadas (make_Move)
O jogador humano insere suas jogadas manualmente.
O computador utiliza o algoritmo Minimax para determinar a melhor jogada.
3. Verificar Vitória (check_Win)
Avalia se algum jogador completou uma linha, coluna ou diagonal.
4. Verificar Empate (check_Draw)
Verifica se o tabuleiro está cheio e nenhuma vitória foi registrada.
5. Algoritmo Minimax
minimax: Explora todas as jogadas possíveis e retorna a melhor opção para o jogador atual.
minimaxHelper: Avalia o tabuleiro recursivamente para calcular o valor de utilidade.
Algoritmo Minimax - Fluxo Básico:
Avaliar se o estado atual do tabuleiro é terminal (vitória, derrota ou empate).
Para cada casa vazia, simular uma jogada do jogador atual.
Chamar recursivamente o Minimax para o próximo jogador.
Reverter a jogada simulada e calcular a pontuação para determinar a melhor jogada.
Melhorias Futuras
Interface Gráfica:

Substituir o console por uma interface gráfica para melhorar a experiência do usuário.
Níveis de Dificuldade:

Adicionar modos "Fácil", "Médio" e "Difícil", onde o computador joga de forma mais ou menos estratégica.
Suporte Multijogador:

Permitir que dois jogadores humanos joguem no mesmo dispositivo.
Jogos em Redes:

Habilitar partidas online via rede local ou internet.

Autor: Walisson Moraes

