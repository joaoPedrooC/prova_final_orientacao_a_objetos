import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    // Declaração de variáveis
    Scanner scanner = new Scanner(System.in);

    ArrayList<Disciplina> disciplinas = new ArrayList<Disciplina>();
    ArrayList<Professor> professores = new ArrayList<Professor>();
    ArrayList<Turma> turmas = new ArrayList<Turma>();

    while (true) { // Looping responsável pelo menu principal - continua sendo executado até a opção 15 (Sair) ser selecionada.
      try {
        System.out.println("=========================================\n             MENU PRINCIPAL\n=========================================");
        System.out.println("1. Cadastrar Aluno\n2. Cadastrar Professor\n3. Cadastrar Disciplina\n4. Cadastrar Turma\n5. Inserir Nota\n6. Relatório Alunos");
        System.out.println("7. Relatório Professores\n8. Relatório Disciplinas\n9. Relatório Turmas\n10. Relatório de Alunos, notas e médias");
        System.out.println("11. Quantidade de Alunos Cadastrados\n12. Nome do aluno com maior nota\n13. Listar alunos de uma disciplina");
        System.out.println("14. Listar turmas de um professor\n15. Sair\n");
        int op = scanner.nextInt();
        scanner.nextLine();

        if (op == 3) { // Cadastro de disciplinas
          String nome;
          int cargaHoraria, codigo;

          System.out.println("Informe o nome da disciplina:");
          nome = scanner.nextLine();

          System.out.println("Informe a carga horaria da disciplina:");
          cargaHoraria = scanner.nextInt();

          codigo = disciplinas.size();

          Disciplina disciplina = new Disciplina(nome, cargaHoraria, codigo);
          disciplinas.add(disciplina);

          System.out.println("Disciplina cadastrada com sucesso!\n\n");
        } else if (op == 7) { // Relatório de professores
          for (Professor professor : professores) {
            System.out.println(professor.Relatorio() + '\n');
          }
        } else if (op == 9) { // Relatório de turmas
          for (Turma turma : turmas) {
            System.out.println(turma.toString() + '\n');
          }
        }
        
      } catch (InputMismatchException ex) { // Responsável por lidar com os erros de entrada.
        System.out.println("Tipo de dado inválido, valor do tipo [String] atribuído a variável do tipo numérico.");
        scanner.nextLine(); // "Limpa" o terminal para leitura das operações seguintes.
      }
    }

    scanner.close();
  }
}
