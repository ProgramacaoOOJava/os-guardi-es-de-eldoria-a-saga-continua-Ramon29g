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