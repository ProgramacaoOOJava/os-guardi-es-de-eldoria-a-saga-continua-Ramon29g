import java.util.Objects;

// Classe base Personagem
public class Personagem {

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
        setNivel(nivel);
        setPontosDeVida(pontosDeVida);
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

    // Setters com validação
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public void setNivel(int nivel) {
        if (nivel >= 0) {
            this.nivel = nivel;
        }
    }

    public void setPontosDeVida(int pontosDeVida) {
        if (pontosDeVida >= 0) {
            this.pontosDeVida = pontosDeVida;
        }
    }

    public void setPoderBase(double poderBase) {
        this.poderBase = poderBase;
    }

    // Método que será sobrescrito nas subclasses
    public void usarHabilidade() {
        System.out.println(nome + " usa uma habilidade genérica.");
    }

    // Exibe os dados do personagem
    @Override
    public String toString() {

        return "Nome: " + nome
                + "\nClasse: " + classe
                + "\nNível: " + nivel
                + "\nPontos de Vida: " + pontosDeVida
                + "\nPoder Base: " + poderBase;
    }

    // Dois personagens são iguais se nome e classe forem iguais
    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Personagem)) {
            return false;
        }

        Personagem outro = (Personagem) obj;

        return Objects.equals(nome, outro.nome)
                && Objects.equals(classe, outro.classe);
    }

    // Consistente com equals
    @Override
    public int hashCode() {
        return Objects.hash(nome, classe);
    }
}
Mago.java
// Classe Mago herda de Personagem
public class Mago extends Personagem {

    private String elemento;

    public Mago(String nome, int nivel,
                int pontosDeVida, double poderBase,
                String elemento) {

        super(nome, "Mago", nivel, pontosDeVida, poderBase);
        this.elemento = elemento;
    }

    public String getElemento() {
        return elemento;
    }

    public void setElemento(String elemento) {
        this.elemento = elemento;
    }

    // Sobrescrita da habilidade
    @Override
    public void usarHabilidade() {

        System.out.println(
                getNome()
                + " lança Bola de Fogo do elemento "
                + elemento + "!");
    }

    // Inclui o elemento no toString
    @Override
    public String toString() {

        return super.toString()
                + "\nElemento: " + elemento;
    }
}
Guerreiro.java
// Classe Guerreiro herda de Personagem
public class Guerreiro extends Personagem {

    private String arma;

    public Guerreiro(String nome, int nivel,
                     int pontosDeVida, double poderBase,
                     String arma) {

        super(nome, "Guerreiro", nivel, pontosDeVida, poderBase);
        this.arma = arma;
    }

    public String getArma() {
        return arma;
    }

    public void setArma(String arma) {
        this.arma = arma;
    }

    // Sobrescrita da habilidade
    @Override
    public void usarHabilidade() {

        System.out.println(
                getNome()
                + " ataca com sua "
                + arma + "!");
    }

    // Inclui a arma no toString
    @Override
    public String toString() {

        return super.toString()
                + "\nArma: " + arma;
    }
}
Main.java
import java.util.ArrayList;

// Classe principal
public class Main {

    public static void main(String[] args) {

        // Lista de personagens usando polimorfismo
        ArrayList<Personagem> personagens = new ArrayList<>();

        // Adicionando magos
        personagens.add(new Mago(
                "Eldoran", 7, 150, 80.0, "Fogo"));

        personagens.add(new Mago(
                "Merlin", 12, 180, 95.0, "Gelo"));

        // Adicionando guerreiros
        personagens.add(new Guerreiro(
                "Arthus", 10, 250, 75.5, "Espada Flamejante"));

        personagens.add(new Guerreiro(
                "Ragnar", 15, 320, 90.0, "Machado de Guerra"));

        // Percorre a lista e executa os métodos
        for (Personagem personagem : personagens) {

            // Exibe status completo
            System.out.println(
                    "===== STATUS DO PERSONAGEM =====");

            System.out.println(personagem);

            // Executa habilidade
            personagem.usarHabilidade();

            // Verifica o tipo real do objeto
            if (personagem instanceof Mago) {

                System.out.println(
                        "O personagem "
                        + personagem.getNome()
                        + " é um Mago de nível "
                        + personagem.getNivel() + ".");

            } else if (personagem instanceof Guerreiro) {

                System.out.println(
                        "O personagem "
                        + personagem.getNome()
                        + " é um Guerreiro de nível "
                        + personagem.getNivel() + ".");
            }

            System.out.println(
                    "------------------------------------");
        }

        // Comparação de personagens
        Personagem p1 = new Mago(
                "Eldoran", 7, 150, 80.0, "Fogo");

        Personagem p2 = new Mago(
                "Eldoran", 20, 300, 150.0, "Gelo");

        // Verifica igualdade
        if (p1.equals(p2)) {

            System.out.println(
                    "Os personagens p1 e p2 são iguais.");

        } else {

            System.out.println(
                    "Os personagens p1 e p2 são diferentes.");
        }
    }
}