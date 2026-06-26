

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Fila<String> filaEncadeada = new FilaEnc<>();
        FilaArray<String> fila = new FilaArray<>(1);

        System.out.println("================================");
        System.out.println("Primeira Questao");

        filaEncadeada.enfileirar("ana");
        filaEncadeada.enfileirar("bia");
        filaEncadeada.enfileirar("ciao");
        System.out.println(filaEncadeada.desenfilerar());
        System.out.println(filaEncadeada.frente());
        System.out.println(filaEncadeada.tamanho());
        filaEncadeada.limpar();

        System.out.println("================================");
        System.out.println("Segunda Questao");

        filaEncadeada.enfileirarComPrioridade("ana",1);
        filaEncadeada.enfileirarComPrioridade("bia",5);
        filaEncadeada.enfileirarComPrioridade("ciao",2);
        filaEncadeada.imprimirEnc();
        filaEncadeada.limpar();

        System.out.println("================================");
        System.out.println("Terceira Questao");

        fila.enfileirarComPrioridade("Ana", 8);
        fila.enfileirarComPrioridade("Bia", 1);
        fila.enfileirarComPrioridade("Caio", 5);
        fila.enfileirarComPrioridade("Davi", 10);
        fila.imprimir();
        fila.limpar();

        System.out.println("================================");
        System.out.println("Quarta Questao");

        fila = new  FilaArray<>(1);
        System.out.println("Capacidade inicial: " + fila.capacidade());
        System.out.println("tamanho: " + fila.tamanho());
        fila.enfileirarComPrioridade("q3", 2);
        fila.enfileirarComPrioridade("q4", 4);
        System.out.println("Capacidade antes de lotar: " + fila.capacidade());
        System.out.println("tamanho: " + fila.tamanho());
        fila.enfileirarComPrioridade("q5");
        fila.enfileirarComPrioridade("q6", 3);
        System.out.println("Capacidade após redimensionar: " + fila.capacidade());
        System.out.println("tamanho: " + fila.tamanho());
        fila.imprimir();

        System.out.println("================================");
        System.out.println("Quinta Questao");

        filaEncadeada.enfileirar("oi");
        filaEncadeada.enfileirar("oir");
        filaEncadeada.enfileirar("oid");
        filaEncadeada.imprimirEnc();
        filaEncadeada.acharValor("oi");
        filaEncadeada.limpar();

        System.out.println("================================");
        System.out.println("Sexta Questao");

        filaEncadeada.enfileirar("oi");
        filaEncadeada.enfileirar("oir");
        filaEncadeada.enfileirar("oid");
        filaEncadeada.imprimirEnc();
        filaEncadeada.acharValorCount("oi");
        filaEncadeada.limpar();

        System.out.println("================================");
        System.out.println("Setima Questao");

        filaEncadeada.enfileirar("oi");
        filaEncadeada.enfileirar("oir");
        filaEncadeada.enfileirar("oid");
        filaEncadeada.imprimirEnc();
        filaEncadeada.peekDaFila();
        filaEncadeada.limpar();

        System.out.println("================================");
        System.out.println("Oitava Questao");

        filaEncadeada.enfileirar("oi");
        filaEncadeada.enfileirar("oir");
        filaEncadeada.enfileirar("oid");
        filaEncadeada.enfileirar("o32id");
        filaEncadeada.imprimirEnc();
        filaEncadeada.reverse();
        filaEncadeada.limpar();


        System.out.println("================================");
        System.out.println("Nona Questao");

        filaEncadeada.enfileirar("oi");
        filaEncadeada.enfileirar("oir");
        filaEncadeada.enfileirar("oid");
        filaEncadeada.imprimirEnc();
        filaEncadeada.fILO();
        filaEncadeada.limpar();
    }


}
