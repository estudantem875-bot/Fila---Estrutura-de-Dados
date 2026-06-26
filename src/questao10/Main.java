package questao10;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("==================================================");
        System.out.println("      SIMULADOR DE FILA - TAYLOR SWIFT (Q10)      ");
        System.out.println("==================================================");
        System.out.println("Digite os parâmetros para iniciar a simulação:\n");

        int tempoTotal = obterInteiroValido(scanner, "Tempo total da simulação em minutos (ex: 10): ", 1, 1000);
        int numGuiches = obterInteiroValido(scanner, "Quantidade de guichês de atendimento (ex: 3): ", 1, 50);
        int tempoMaxAtendimento = obterInteiroValido(scanner, "Tempo máximo de atendimento por fã em minutos (ex: 4): ", 1, 60);
        int maxFansPorMinuto = obterInteiroValido(scanner, "Número máximo de novos fãs que chegam por minuto (ex: 3): ", 0, 100);

        System.out.println("\nConfigurações salvas. Iniciando simulação...");
        
        SimulacaoFila simulacao = new SimulacaoFila(tempoTotal, numGuiches, tempoMaxAtendimento, maxFansPorMinuto);
        simulacao.executar();

        scanner.close();
    }

    private static int obterInteiroValido(Scanner scanner, String prompt, int min, int max) {
        int valor = -1;
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            try {
                valor = Integer.parseInt(input);
                if (valor >= min && valor <= max) {
                    break;
                } else {
                    System.out.printf("Por favor, digite um valor entre %d e %d.\n", min, max);
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Digite um número inteiro válido.");
            }
        }
        return valor;
    }
}
