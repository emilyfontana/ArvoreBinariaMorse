# Árvore Binária para Código Morse

- Aluna: Emily Pontes Fontana
- Turma: 4U noite

## Descrição
Projeto em Java que implementa uma árvore binária para representar o Código Morse.  
Cada nó corresponde a um símbolo: filho esquerdo = ponto ('.') e filho direito = traço ('-').  
A árvore contém as letras A–Z e os números 0–9, permitindo inserção, busca, exibição hierárquica, decodificação de mensagens e remoção.

## Arquivo principal
- `ArvoreBinariaMorse.java` — contém as classes `Nodo` e `ArvoreBinariaMorse` e o método `main` com menu.

## Funcionalidades implementadas
- Inicialização da árvore (raiz vazia).
- Inserção de caracteres conforme código Morse ('.' = esquerda, '-' = direita).
- Inserção automática padrão (A–Z, 0–9).
- Busca(decodificação).
- Busca.
- Decodificação de mensagens completas.
- Remoção.
- Exibição hierárquica da árvore.


## Como compilar e executar

1. Compile:
   ```bash
   javac src/ArvoreBinariaMorse.java
   ```
2. Execute:
   ```bash
   java -cp src ArvoreBinariaMorse
   ```

## Menu do programa 
Ao executar, o programa mostra um menu com as opções:

1. Codificar letra (caractere -> código)  
2. Decodificar código Morse (uma letra)  
3. Decodificar mensagem Morse (letras por espaço; palavras por 2 espaços)  
4. Inserir novo caractere (forneça código e caractere)  
5. Remover caractere (só remove se existia; caso contrário retorna a mensagem "nao foi possivel remover pois nao existe")  
6. Mostrar árvore hierárquica  
0. Sair


## Exemplos de uso e saída esperada (Teste que eu realizei como base)

- Decodificar letra:
  - Entrada (menu): `2`  
  - Código: `...`  
  - Saída: `Letra: S`

- Codificar letra:
  - Entrada (menu): `1`  
  - Letra: `O`  
  - Saída: `Código Morse: ---`

- Decodificar mensagem (SOS):
  - Entrada (menu): `3`  
  - Mensagem: `... --- ...`  
  - Saída: `Mensagem decodificada: SOS`

- Decodificar mensagem com palavra:
  - Mensagem: `... --- ...  .-`  
  - Saída: `Mensagem decodificada: SOS A`  
  (Note o uso de dois espaços entre palavras.)

- Inserir e remover:
  - Inserir: opção `4` → código `..--` caractere `@` → Saída: `Inserido @ em ..--`  
  - Buscar: opção `2` → `..--` → Saída: `Letra: @`  
  - Remover: opção `5` → `..--` → Saída: `Removido valor em ..--`  
  - Remover novamente: opção `5` → `..--` → Saída: `nao foi possivel remover pois nao existe`

- Mensagem com código inválido:
  - Entrada: `... -.-x ...` → Saída: `S?S` (letra inválida marcada com `?`)


