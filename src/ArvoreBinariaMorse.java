import java.util.Scanner;

// Nó da árvore: armazena um caractere e referências aos filhos
class Nodo {
    public char valor;
    public Nodo esquerdo;
    public Nodo direito;

    public Nodo(char v) {
        this.valor = v;
        this.esquerdo = null; //esquerdo .
        this.direito = null; // direita -
    }
}

public class ArvoreBinariaMorse {
    private Nodo raiz;

    // cria raiz vazia
    public void inicializar() {
        this.raiz = new Nodo('\0');
    }

    // insere caractere seguindo o código ('.' = esquerda, '-' = direita)
    public void inserir(String codigo, char c) {
        if (codigo == null) return;
        Nodo atual = raiz;
        int i = 0;
        while (i < codigo.length()) {
            char s = codigo.charAt(i);
            if (s == '.') {
                if (atual.esquerdo == null) atual.esquerdo = new Nodo('\0');
                atual = atual.esquerdo;
            } else if (s == '-') {
                if (atual.direito == null) atual.direito = new Nodo('\0');
                atual = atual.direito;
            } else {
                return; // código inválido
            }
            i = i + 1;
        }
        atual.valor = c;
    }

    // busca caractere por código
    public char buscar(String codigo) {
        if (codigo == null) return '\0';
        Nodo atual = raiz;
        int i = 0;
        while (i < codigo.length()) {
            char s = codigo.charAt(i);
            if (s == '.') {
                if (atual.esquerdo == null)
                    return '\0';
                atual = atual.esquerdo;
            } else if (s == '-') {
                if (atual.direito == null)
                    return '\0';
                atual = atual.direito;
            } else {
                return '\0';
            }
            i = i + 1;
        }
        return atual.valor;
    }

    // decodifica mensagem com letras separadas por espaço e palavras por 2 espaços
    public String buscarMensagem(String mensagemMorse) {
        if (mensagemMorse == null) return "";
        String resultado = "";
        String token = "";
        int i = 0;
        while (i < mensagemMorse.length()) {
            char ch = mensagemMorse.charAt(i);
            if (ch == ' ') {
                if (token.length() > 0) {
                    char r = buscar(token);
                    if (r == '\0') resultado = resultado + '?';
                    else resultado = resultado + r;
                    token = "";
                } else {
                    int j = i + 1;
                    if (j < mensagemMorse.length() && mensagemMorse.charAt(j) == ' ') {
                        resultado = resultado + ' ';
                    }
                }
            } else {
                token = token + ch;
            }
            i = i + 1;
        }
        if (token.length() > 0) {
            char r = buscar(token);
            if (r == '\0') resultado = resultado + '?';
            else resultado = resultado + r;
        }
        return resultado;
    }

    //Remove o valor do nó correspondente ao código somente se existe
    public String remover(String codigo) {
        if (codigo == null) return "nao foi possivel remover pois nao existe";
        Nodo atual = raiz;
        int i = 0;
        while (i < codigo.length()) {
            char s = codigo.charAt(i);
            if (s == '.') {
                if (atual.esquerdo == null) return "nao foi possivel remover pois nao existe";
                atual = atual.esquerdo;
            } else if (s == '-') {
                if (atual.direito == null) return "nao foi possivel remover pois nao existe";
                atual = atual.direito;
            } else {
                return "nao foi possivel remover pois nao existe";
            }
            i = i + 1;
        }
        if (atual.valor != '\0') {
            atual.valor = '\0';
            return "Removido valor em " + codigo;
        } else {
            return "nao foi possivel remover pois nao existe";
        }
    }

    // busca o código de um caractere (retorna "" se não achar)
    public String buscarCodigoParaCaracter(char c) {
        return buscarCodigoParaCaracterRec(raiz, c, "");
    }
//recursao percorre a arvore acumulando  "." (esquerda) e "-" (direita)
    // se encontra retorna codigo morse se nao encontra nao retorna nada
    private String buscarCodigoParaCaracterRec(Nodo n, char c, String caminho) {
        if (n == null) return "";
        if (n.valor == c) return caminho;
        String res = buscarCodigoParaCaracterRec(n.esquerdo, c, caminho + ".");
        if (res.length() > 0) return res;
        res = buscarCodigoParaCaracterRec(n.direito, c, caminho + "-");
        return res;
    }

    // exibe árvore com indentação por nível
    public void exibirArvoreHierarquica() {
        System.out.println("Árvore Morse (hierárquica):");
        exibirArvoreHierarquicaRec(raiz, 0, "");
    }

    private void exibirArvoreHierarquicaRec(Nodo n, int nivel, String caminho) {
        if (n == null) return;
        int k = 0;
        while (k < nivel) {
            System.out.print("  ");
            k = k + 1;
        }
        if (n.valor != '\0') System.out.println(caminho + " : " + n.valor);
        else System.out.println(caminho + " : " + "-");
        exibirArvoreHierarquicaRec(n.esquerdo, nivel + 1, caminho + ".");
        exibirArvoreHierarquicaRec(n.direito, nivel + 1, caminho + "-");
    }

    // inicializa com A-Z e 0-9 (inserção automática pedida no enunciado)
    public void inicializarPadrao() {
        inicializar();
        inserir(".-", 'A');
        inserir("-...", 'B');
        inserir("-.-.", 'C');
        inserir("-..", 'D');
        inserir(".", 'E');
        inserir("..-.", 'F');
        inserir("--.", 'G');
        inserir("....", 'H');
        inserir("..", 'I');
        inserir(".---", 'J');
        inserir("-.-", 'K');
        inserir(".-..", 'L');
        inserir("--", 'M');
        inserir("-.", 'N');
        inserir("---", 'O');
        inserir(".--.", 'P');
        inserir("--.-", 'Q');
        inserir(".-.", 'R');
        inserir("...", 'S');
        inserir("-", 'T');
        inserir("..-", 'U');
        inserir("...-", 'V');
        inserir(".--", 'W');
        inserir("-..-", 'X');
        inserir("-.--", 'Y');
        inserir("--..", 'Z');
        inserir(".----", '1');
        inserir("..---", '2');
        inserir("...--", '3');
        inserir("....-", '4');
        inserir(".....", '5');
        inserir("-....", '6');
        inserir("--...", '7');
        inserir("---..", '8');
        inserir("----.", '9');
        inserir("-----", '0');
    }

    // menu com funções principais
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArvoreBinariaMorse morse = new ArvoreBinariaMorse();
        morse.inicializarPadrao();

        while (true) {
            System.out.println("\nÁrvore Morse");
            System.out.println("1 - Codificar letra");
            System.out.println("2 - Decodificar código Morse");
            System.out.println("3 - Decodificar mensagem Morse");
            System.out.println("4 - Inserir");
            System.out.println("5 - Remover");
            System.out.println("6 - Mostrar árvore hierárquica");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");

            String opcao = sc.nextLine();
            if (opcao.length() == 0) continue;
            char escolha = opcao.charAt(0);

            if (escolha == '0') break;
    //escolhas do usuário
            else if (escolha == '1') {
                System.out.print("Digite letra (A-Z ou 0-9): ");
                String entrada = sc.nextLine();
                if (entrada.length() > 0) {
                    char letra = entrada.toUpperCase().charAt(0);
                    String codigo = morse.buscarCodigoParaCaracter(letra);
                    if (codigo.length() == 0) System.out.println("Letra não encontrada!");
                    else System.out.println("Código Morse: " + codigo);
                }
            }

            else if (escolha == '2') {
                System.out.print("Digite código Morse (. e -): ");
                String codigo = sc.nextLine();
                char letra = morse.buscar(codigo);
                if (letra == '\0') System.out.println("Código inválido!");
                else System.out.println("Letra: " + letra);
            }

            else if (escolha == '3') {
                System.out.print("Digite mensagem Morse: ");
                String mensagem = sc.nextLine();
                String decodificada = morse.buscarMensagem(mensagem);
                System.out.println("Mensagem decodificada: " + decodificada);
            }

            else if (escolha == '4') {
                System.out.print("Digite código Morse (ex: ...): ");
                String cod = sc.nextLine();
                System.out.print("Digite caractere a inserir: ");
                String ch = sc.nextLine();
                if (ch.length() > 0) {
                    char letra = ch.toUpperCase().charAt(0);
                    morse.inserir(cod, letra);
                    System.out.println("Inserido " + letra + " em " + cod);
                }
            }

            else if (escolha == '5') {
                System.out.print("Digite código Morse a remover: ");
                String cod = sc.nextLine();
                String res = morse.remover(cod);
                System.out.println(res);
            }

            else if (escolha == '6') {
                morse.exibirArvoreHierarquica();
            }

            else {
                System.out.println("Opção inválida.");
            }
        }

        sc.close();
        System.out.println("Programa encerrado.");
    }
}