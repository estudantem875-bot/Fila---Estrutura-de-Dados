package questao10;

public class Fa {
    private String nome;
    private int pulseiras;

    public Fa(String nome, int pulseiras) {
        this.nome = nome;
        this.pulseiras = pulseiras;
    }

    public String getNome() {
        return nome;
    }

    public int getPulseiras() {
        return pulseiras;
    }

    @Override
    public String toString() {
        return String.format("%s (%d pulseiras)", nome, pulseiras);
    }
}
