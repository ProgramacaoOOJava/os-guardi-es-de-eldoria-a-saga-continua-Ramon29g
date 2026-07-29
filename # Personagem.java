// Classe abstrata que representa um personagem do jogo.
public abstract class Personagem {

    // Atributos encapsulados.
    private String nome;
    private String classe;
    private int nivel;
    private int pontosDeVida;
    private double poderBase;

    // Construtor.
    public Personagem(String nome, String classe, int nivel,
                      int pontosDeVida, double poderBase) {
        this.nome = nome;
        this.classe = classe;
        this.nivel = nivel;
        this.pontosDeVida = pontosDeVida;
        this.poderBase = poderBase;
    }

    // Getters.
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

    // Método abstrato.
    public abstract void usarHabilidade();

    // Exibe as informações do personagem.
    public void exibirStatus() {
        System.out.println("================================");
        System.out.println("Nome: " + nome);
        System.out.println("Classe: " + classe);
        System.out.println("Nível: " + nivel);
        System.out.println("Pontos de Vida: " + pontosDeVida);
        System.out.println("Poder Base: " + poderBase);
        System.out.println("================================");
    }

    // Método protegido para aumentar o poder base.
    protected void atribuirBencao(double valor) {
        poderBase += valor;
    }
}
import java.util.ArrayList;

// Classe Mago herda de Personagem e implementa Auditavel.
public class Mago extends Personagem implements Auditavel {

    private ArrayList<String> historicoAcoes;

    public Mago(String nome, int nivel,
                int pontosDeVida, double poderBase) {

        super(nome, "Mago", nivel, pontosDeVida, poderBase);

        historicoAcoes = new ArrayList<>();
    }

    @Override
    public void usarHabilidade() {
        System.out.println("Mago " + getNome()
                + " lança uma poderosa Bola de Fogo!");
    }

    @Override
    public void registrarAcao(String acao) {
        historicoAcoes.add(acao);
    }

    @Override
    public void auditarAcoes() {

        System.out.println("Ações registradas por "
                + getNome() + ":");

        for (String acao : historicoAcoes) {
            System.out.println("- " + acao);
        }
    }
}
// Classe Guerreiro herda de Personagem.
public class Guerreiro extends Personagem {

    public Guerreiro(String nome, int nivel,
                     int pontosDeVida, double poderBase) {

        super(nome, "Guerreiro", nivel,
              pontosDeVida, poderBase);
    }

    @Override
    public void usarHabilidade() {
        System.out.println("Guerreiro " + getNome()
                + " utiliza Golpe Devastador!");
    }
}
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        // Lista de personagens.
        ArrayList<Personagem> personagens = new ArrayList<>();

        // Adicionando magos.
        personagens.add(
                new Mago("Eldoran", 7, 120, 45.0));

        personagens.add(
                new Mago("Merlin", 10, 150, 60.0));

        // Adicionando guerreiros.
        personagens.add(
                new Guerreiro("Arthus", 8, 220, 50.0));

        personagens.add(
                new Guerreiro("Ragnar", 12, 280, 70.0));

        // Percorre a lista.
        for (Personagem personagem : personagens) {

            personagem.exibirStatus();

            personagem.usarHabilidade();

            // Verifica se é um Mago.
            if (personagem instanceof Mago) {

                Mago mago = (Mago) personagem;

                mago.registrarAcao(
                        "Conjurou uma magia especial.");

                Auditavel auditavel = (Auditavel) mago;

                auditavel.auditarAcoes();
            }

            // Casting explícito para Personagem.
            Personagem referencia = (Personagem) personagem;

            referencia.atribuirBencao(10.0);

            System.out.println(
                    "\nApós receber uma bênção:");

            referencia.exibirStatus();

            System.out.println();
        }
    }
}