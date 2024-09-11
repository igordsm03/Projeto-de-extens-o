import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ControleDeFaltas {

    private static class Aluno {
        String nome;
        int faltas;
        int presencas;

        Aluno(String nome) {
            this.nome = nome;
            this.faltas = 0;
            this.presencas = 0;
        }

        void registrarFalta() {
            faltas++;
        }

        void registrarPresenca() {
            presencas++;
        }

        @Override
        public String toString() {
            return String.format("Nome: %s | Presenças: %d | Faltas: %d", nome, presencas, faltas);
        }
    }

    private static final Map<String, Aluno> alunos = new HashMap<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n----- Menu Principal -----");
            System.out.println("1. Adicionar Aluno");
            System.out.println("2. Registrar Falta");
            System.out.println("3. Registrar Presença");
            System.out.println("4. Mostrar Status dos Alunos");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção (1-5): ");

            int escolha = scanner.nextInt();
            scanner.nextLine(); // Consumir o newline

            switch (escolha) {
                case 1:
                    adicionarAluno();
                    break;
                case 2:
                    registrarFalta();
                    break;
                case 3:
                    registrarPresenca();
                    break;
                case 4:
                    mostrarStatus();
                    break;
                case 5:
                    System.out.println("Saindo do programa...");
                    return;
                default:
                    System.out.println("Opção inválida. Por favor, escolha entre 1 e 5.");
            }
        }
    }

    private static void adicionarAluno() {
        System.out.print("Digite o nome do aluno para cadastro: ");
        String nome = scanner.nextLine();
        if (alunos.containsKey(nome)) {
            System.out.println("Aluno já cadastrado.");
        } else {
            alunos.put(nome, new Aluno(nome));
            System.out.println("Aluno cadastrado com sucesso!");
        }
    }

    private static void registrarFalta() {
        System.out.print("Digite o nome do aluno para registrar a falta: ");
        String nome = scanner.nextLine();
        Aluno aluno = alunos.get(nome);
        if (aluno != null) {
            aluno.registrarFalta();
            System.out.println("Falta registrada com sucesso!");
        } else {
            System.out.println("Aluno não encontrado. Verifique o nome e tente novamente.");
        }
    }

    private static void registrarPresenca() {
        System.out.print("Digite o nome do aluno para registrar a presença: ");
        String nome = scanner.nextLine();
        Aluno aluno = alunos.get(nome);
        if (aluno != null) {
            aluno.registrarPresenca();
            System.out.println("Presença registrada com sucesso!");
        } else {
            System.out.println("Aluno não encontrado. Verifique o nome e tente novamente.");
        }
    }

    private static void mostrarStatus() {
        if (alunos.isEmpty()) {
            System.out.println("Nenhum aluno cadastrado ainda.");
        } else {
            System.out.println("\n----- Status dos Alunos -----");
            for (Aluno aluno : alunos.values()) {
                System.out.println(aluno);
            }
        }
    }
}
