# Personagem.java

```java
// Classe abstrata que representa um personagem do jogo
public abstract class Personagem {

    // Atributos encapsulados
    private String nome;
    private String classe;
    private int nivel;
    private int pontosDeVida;
    private double poderBase;

    // Construtor
    public Personagem(String nome, String classe,
                      int nivel, int pontosDeVida,
                      double poderBase) {

        this.nome = nome;
        this.classe = classe;
        this.nivel = nivel;
        this.pontosDeVida = pontosDeVida;
        this.poderBase = poderBase;
    }

    // Getters
    public String getNome() {
        return nome;
    }

    public String getClasse() {
        return classe;
    }

    public int getNivel() {
        return nivel;
    }

    public int getPontosDeVida() {
        return pontosDeVida;
    }

    public double getPoderBase() {
        return poderBase;
    }

    // Método abstrato
    public abstract void usarHabilidade();

    // Exibe os dados do personagem
    public void exibirStatus() {

        System.out.println("===== STATUS DO PERSONAGEM =====");
        System.out.println("Nome: " + nome);
        System.out.println("Classe: " + classe);
        System.out.println("Nível: " + nivel);
        System.out.println("Pontos de Vida: " + pontosDeVida);
        System.out.println("Poder Base: " + poderBase);
    }
}
```

---

# Mago.java

```java
// Classe Mago herda de Personagem
public class Mago extends Personagem {

    // Atributo específico do mago
    private String elemento;

    // Construtor
    public Mago(String nome, int nivel,
                int pontosDeVida, double poderBase,
                String elemento) {

        super(nome, "Mago", nivel, pontosDeVida, poderBase);
        this.elemento = elemento;
    }

    // Getter
    public String getElemento() {
        return elemento;
    }

    // Implementação da habilidade do mago
    @Override
    public void usarHabilidade() {

        System.out.println(
                "Mago " + getNome()
                + " lança Bola de Fogo do elemento "
                + elemento + "!");
    }

    // Exibe também o elemento
    @Override
    public void exibirStatus() {

        super.exibirStatus();
        System.out.println("Elemento: " + elemento);
    }
}
```

---

# Guerreiro.java

```java
// Classe Guerreiro herda de Personagem
public class Guerreiro extends Personagem {

    // Atributo específico do guerreiro
    private String arma;

    // Construtor
    public Guerreiro(String nome, int nivel,
                     int pontosDeVida, double poderBase,
                     String arma) {

        super(nome, "Guerreiro", nivel, pontosDeVida, poderBase);
        this.arma = arma;
    }

    // Getter
    public String getArma() {
        return arma;
    }

    // Implementação da habilidade do guerreiro
    @Override
    public void usarHabilidade() {

        System.out.println(
                "Guerreiro " + getNome()
                + " ataca com sua "
                + arma + "!");
    }

    // Exibe também a arma
    @Override
    public void exibirStatus() {

        super.exibirStatus();
        System.out.println("Arma: " + arma);
    }
}
```

---

# Main.java

```java
import java.util.ArrayList;

// Classe principal do programa
public class Main {

    public static void main(String[] args) {

        // Lista de personagens usando polimorfismo
        ArrayList<Personagem> personagens = new ArrayList<>();

        // Adicionando magos
        personagens.add(new Mago(
                "Elenara", 12, 180, 95.0, "Fogo"));

        personagens.add(new Mago(
                "Merlin", 20, 150, 120.0, "Gelo"));

        // Adicionando guerreiros
        personagens.add(new Guerreiro(
                "Arthus", 10, 250, 75.5, "Espada Flamejante"));

        personagens.add(new Guerreiro(
                "Ragnar", 15, 320, 90.0, "Machado de Guerra"));

        // Percorre a lista e executa os métodos
        for (Personagem personagem : personagens) {

            personagem.exibirStatus();
            personagem.usarHabilidade();

            System.out.println(
                    "-------------------------------------");
        }
    }
}
