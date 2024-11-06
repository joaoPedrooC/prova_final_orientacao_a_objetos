import java.io.File;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.naming.NameNotFoundException;
import javax.naming.NoPermissionException;

public class Main {
  public static void main(String[] args) {
    // Declaração de variáveis
    Scanner scanner = new Scanner(System.in);
    
    File arquivoAlunos = new File("Alunos.txt");
    File arquivoProfessores = new File("Professores.txt");
    File arquivoDisciplinas = new File("Disciplinas.txt");
    File arquivoTurma = new File("Turmas.txt");
    File arquivoNotas = new File("Notas.txt");

    ArrayList<Disciplina> disciplinas = new ArrayList<Disciplina>();
    ArrayList<Professor> professores = new ArrayList<Professor>();
    ArrayList<Turma> turmas = new ArrayList<Turma>();
    ArrayList<Aluno> alunos = new ArrayList<Aluno>();

    try {
      if (arquivoAlunos.exists()) {
        Scanner leitorArquivoAlunos = new Scanner(arquivoAlunos);

        while (leitorArquivoAlunos.hasNextLine()) {
          String []dadosAluno = leitorArquivoAlunos.nextLine().split(" - ");
          
          String nome = dadosAluno[0];
          String telefone = dadosAluno[1];
          String nascimento = dadosAluno[2];
          int matricula = Integer.parseInt(dadosAluno[3]);
          int anoIngresso = Integer.parseInt(dadosAluno[4]);
          String cidade = dadosAluno[5];
          String estado = dadosAluno[6];
          String cep = dadosAluno[7];
  
          Endereco endereco = new Endereco(cidade, estado, cep);
          Aluno aluno = new Aluno(nome, nascimento, endereco, telefone, matricula, anoIngresso);
  
          alunos.add(aluno);
        }
        leitorArquivoAlunos.close();
      }

      if(arquivoProfessores.exists()) {
        Scanner leitorArquivoProfessores = new Scanner(arquivoProfessores);
        while (leitorArquivoProfessores.hasNextLine()) {
          String []dadosAluno = leitorArquivoProfessores.nextLine().split(" - ");
          
          String nome = dadosAluno[0];
          String telefone = dadosAluno[1];
          String nascimento = dadosAluno[2];
          String email = dadosAluno[3];
          int anoAdmissao = Integer.parseInt(dadosAluno[4]);
          String areaDeFormacao = dadosAluno[5];
          String cidade = dadosAluno[6];
          String estado = dadosAluno[7];
          String cep = dadosAluno[8];
  
          Endereco endereco = new Endereco(cidade, estado, cep);
          Professor professor = new Professor(nome, nascimento, endereco, telefone, areaDeFormacao, anoAdmissao, email);
  
          professores.add(professor);
        }

        leitorArquivoProfessores.close();
      }

      if(arquivoDisciplinas.exists()) {
        Scanner leitorArquivoDisciplinas = new Scanner(arquivoDisciplinas);
        while (leitorArquivoDisciplinas.hasNextLine()) {
          String []dadosDisciplina = leitorArquivoDisciplinas.nextLine().split(" - ");
  
          String nome = dadosDisciplina[0];
          int cargaHoraria = Integer.parseInt(dadosDisciplina[1]);
          int codigo = Integer.parseInt(dadosDisciplina[2]);
  
          Disciplina disciplina = new Disciplina(nome, cargaHoraria, codigo);
  
          String []nomesProfessores = leitorArquivoDisciplinas.nextLine().split(" - ");
          for (String nomeProfessor : nomesProfessores) {
            for (Professor professor : professores) {
              if (professor.getNome().equalsIgnoreCase(nomeProfessor)) {
                disciplina.AdicionarProfessor(professor);
                break;
              }
            }
          }
  
          disciplinas.add(disciplina);
        }

        leitorArquivoDisciplinas.close();
      }

      if(arquivoTurma.exists()) {
        Scanner leitorArquivoTurma = new Scanner(arquivoTurma);
        while (leitorArquivoTurma.hasNextLine()) {
          String []dadosTurmas = leitorArquivoTurma.nextLine().split(" - ");
  
          int codigo = Integer.parseInt(dadosTurmas[0]);
          int anoLetivo = Integer.parseInt(dadosTurmas[1]);
          String nomeProfessor = dadosTurmas[2];
          String nomeDisciplina = dadosTurmas[3];
  
          Professor professor = null;
  
          for (Professor iProfessor : professores) {
            if (iProfessor.getNome().equalsIgnoreCase(nomeProfessor)) {
              professor = iProfessor;
              break;
            }
          }
  
          Disciplina disciplina = null;
          for (Disciplina iDisciplina : disciplinas) {
            if (iDisciplina.getNome().equalsIgnoreCase(nomeDisciplina)) {
              disciplina = iDisciplina;
              break;
            }
          }
  
          Turma turma = new Turma(codigo, anoLetivo, professor, disciplina);
          
          String []dadosAlunos = leitorArquivoTurma.nextLine().split(" - ");
          for (String nomeAluno : dadosAlunos) {
            for (Aluno aluno : alunos) {
              if (aluno.getNome().equalsIgnoreCase(nomeAluno)) {
                turma.AdicionarAlunos(aluno);
                break;
              }
            }
          }

          turmas.add(turma);
        }
        leitorArquivoTurma.close();
      }

      if (arquivoNotas.exists()) {
        Scanner leitorArquivoNotas = new Scanner(arquivoNotas);
        while (leitorArquivoNotas.hasNextLine()) {
          String []dadosNotas = leitorArquivoNotas.nextLine().split(" - ");
  
          double nota = Double.parseDouble(dadosNotas[0]);
          String data = dadosNotas[1];
          String nomeAluno = dadosNotas[2];
          String nomeDisciplina = dadosNotas[3];
  
          Aluno aluno = null;
          Disciplina disciplina = null;
  
          for (Aluno iAluno : alunos) {
            if (iAluno.getNome().equalsIgnoreCase(nomeAluno)) {
              aluno = iAluno;
              break;
            }
          }
  
          for (Disciplina iDisciplina : disciplinas) {
            if (iDisciplina.getNome().equalsIgnoreCase(nomeDisciplina)) {
              disciplina = iDisciplina;
              break;
            }
          }
  
          Nota iNota = new Nota(nota, data, disciplina);
          aluno.adicionarNota(iNota);
        }
        leitorArquivoNotas.close();
      }
    } catch (Exception e) {
      System.out.println(e);
    }

    while (true) { // Looping responsável pelo menu principal - continua sendo executado até a opção 15 (Sair) ser selecionada.
      try {
        System.out.println("=========================================\n             MENU PRINCIPAL\n=========================================");
        System.out.println("1. Cadastrar Aluno\n2. Cadastrar Professor\n3. Cadastrar Disciplina\n4. Cadastrar Turma\n5. Inserir Nota\n6. Relatório Alunos");
        System.out.println("7. Relatório Professores\n8. Relatório Disciplinas\n9. Relatório Turmas\n10. Relatório de Alunos, notas e médias");
        System.out.println("11. Quantidade de Alunos Cadastrados\n12. Nome do aluno com maior nota\n13. Listar alunos de uma disciplina");
        System.out.println("14. Listar turmas de um professor\n15. Sair\n");
        int op = scanner.nextInt();
        scanner.nextLine();

        if (op == 1) { // Cadastrar Aluno
          System.out.println("Informe o nome do aluno:");
          String nome = scanner.nextLine();

          System.out.println("Informe a data de nascimento:");
          String dataNascimento = scanner.nextLine();

          System.out.println("Informe o telefone:");
          String telefone = scanner.nextLine();

          System.out.println("Informe a cidade:");
          String cidade = scanner.nextLine();

          System.out.println("Informe o estado:");
          String estado = scanner.nextLine();

          System.out.println("Informe o CEP:");
          String cep = scanner.nextLine();

          System.out.println("Informe o ano de ingresso:");
          int anoIngresso = scanner.nextInt();
          
          System.out.println("Informe a matricula:");
          int matricula = scanner.nextInt();
          scanner.nextLine();
      
          Endereco endereco = new Endereco(cidade, estado, cep);
          Aluno aluno = new Aluno(nome, dataNascimento, endereco, telefone, matricula, anoIngresso);
          
          alunos.add(aluno);
          aluno.CadastrarAluno(aluno);
      
          System.out.println("Aluno cadastrado com sucesso!\n\n");
        } else if (op == 2) { // Cadastrar Professor
          System.out.println("Informe o nome do professor:");
          String nome = scanner.nextLine();

          System.out.println("Informe a data de nascimento:");
          String dataNascimento = scanner.nextLine();

          System.out.println("Informe o telefone:");
          String telefone = scanner.nextLine();

          System.out.println("Informe o email:");
          String email = scanner.nextLine();

          System.out.println("Informe a área de formação:");
          String areaDeFormacao = scanner.nextLine();

          System.out.println("Informe o ano de admissão:");
          int anoDeAdmissao = scanner.nextInt();
          scanner.nextLine();

          System.out.println("Informe a cidade:");
          String cidade = scanner.nextLine();

          System.out.println("Informe o estado:");
          String estado = scanner.nextLine();

          System.out.println("Informe o CEP:");
          String cep = scanner.nextLine();

          Endereco endereco = new Endereco(cidade, estado, cep); 
          Professor professor = new Professor(nome, dataNascimento, endereco, telefone, areaDeFormacao, anoDeAdmissao, email);
          
          professores.add(professor);
          professor.CadastrarProfessor(professor);

          System.out.println("Professor cadastrado com sucesso!\n\n");
        } else if (op == 3) { // Cadastro de disciplinas
          String nome;
          int cargaHoraria, codigo;

          System.out.println("Informe o nome da disciplina:");
          nome = scanner.nextLine();

          System.out.println("Informe a carga horaria da disciplina:");
          cargaHoraria = scanner.nextInt();

          codigo = disciplinas.size();

          System.out.println("Informe a quantidade de professores da disciplina:");
          int quantidadeProfessores = scanner.nextInt();
          scanner.nextLine();

          Disciplina disciplina = new Disciplina(nome, cargaHoraria, codigo);

          while (quantidadeProfessores > 0) {
            System.out.println("Informe o nome do professor:");
            String nomeProfessor = scanner.nextLine();

            boolean encontrado = false;

            for (Professor professor : professores) {
              if (professor.getNome().equalsIgnoreCase(nomeProfessor)) {
                encontrado = true;
                disciplina.AdicionarProfessor(professor);

                break;
              }
            }

            if (!encontrado) {
              System.out.println("Professor " + nomeProfessor + " não encontrado!");
            } else quantidadeProfessores--;
          }

          disciplinas.add(disciplina);
          disciplina.CadastrarDisciplina(disciplina);

          System.out.println("Disciplina cadastrada com sucesso!\n\n");
        } else if (op == 4) { // Cadastrar Turma
          if (disciplinas.isEmpty() || professores.isEmpty()) {
            throw new NoPermissionException("Para cadastrar uma turma, é necessário ter pelo menos uma disciplina e um professor cadastrados.");
          }

          System.out.println("Informe o ano letivo da turma:");
          int anoLetivo = scanner.nextInt();
          scanner.nextLine();
          
          System.out.println("Selecione a disciplina para a turma:");
          for (int i = 0; i < disciplinas.size(); i++) {
            System.out.println(i + ". " + disciplinas.get(i).getNome());
          }

          int indiceDisciplina = scanner.nextInt();
          scanner.nextLine();

          Disciplina disciplinaSelecionada = disciplinas.get(indiceDisciplina);

          System.out.println("Selecione o professor responsável pela turma:");
          for (int i = 0; i < professores.size(); i++) {
            System.out.println(i + ". " + professores.get(i).getNome());
          }

          int indiceProfessor = scanner.nextInt();
          scanner.nextLine();

          Professor professorSelecionado = professores.get(indiceProfessor);

          int codigoTurma = turmas.size() + 1;
          Turma turma = new Turma(codigoTurma, anoLetivo, professorSelecionado, disciplinaSelecionada);

          System.out.println("Informe a quantidade de alunos da turma:");
          int quantidadeAlunos = scanner.nextInt();
          scanner.nextLine();

          while (quantidadeAlunos > 0) {
            System.out.println("Informe o nome do aluno:");
            String nomeAluno = scanner.nextLine();

            boolean encontrado = false;
            for (Aluno aluno : alunos) {
              if(aluno.getNome().equalsIgnoreCase(nomeAluno)) {
                encontrado = true;
                turma.AdicionarAlunos(aluno);

                break;
              }
            }

            if (!encontrado) {
              System.out.println("Aluno " + nomeAluno + " não encontrado!");
            } else quantidadeAlunos--;
          }

          professorSelecionado.AdicionarTurma(turma);
          turmas.add(turma);
          turma.CadastrarTurma(turma);

          System.out.println("Turma cadastrada com sucesso!\n\n");
        } else if (op == 5) { // Inserir Nota
          System.out.println("Informe o nome do aluno:");
          String nomeAluno = scanner.nextLine();

          System.out.println("Informe o nome da disciplina:");
          String nomeDisciplina = scanner.nextLine();

          boolean alunoEncontrado = false;
          boolean disciplinaEncontrada = false;
      
          Aluno alunoSelecionado = null;
          Disciplina disciplinaSelecionada = null;
      
          // Verificar se o aluno está cadastrado
          for (Aluno aluno : alunos) { // Supondo que você tenha uma lista de alunos
            if (aluno.getNome().equalsIgnoreCase(nomeAluno)) {
              alunoSelecionado = aluno;
              alunoEncontrado = true;
              break;
            }
          }
      
          // Verificar se a disciplina está cadastrada
          for (Disciplina disciplina : disciplinas) {
              if (disciplina.getNome().equalsIgnoreCase(nomeDisciplina)) {
                  disciplinaSelecionada = disciplina;
                  disciplinaEncontrada = true;
                  break;
              }
          }
      
          // Se aluno e disciplina foram encontrados, insere a nota
          if (alunoEncontrado && disciplinaEncontrada) {
            System.out.println("Informe a nota:");
            double valorNota = scanner.nextDouble();
            scanner.nextLine(); // Limpa o buffer do scanner

            System.out.println("Informe a data da nota (dd/mm/aaaa):");
            String dataNota = scanner.nextLine();
    
            Nota novaNota = new Nota(valorNota, dataNota, disciplinaSelecionada);
            alunoSelecionado.adicionarNota(novaNota); // Adiciona a nota ao aluno

            novaNota.CadastrarNota(novaNota, nomeAluno);
    
            System.out.println("Nota cadastrada com sucesso para o aluno " + alunoSelecionado.getNome() + " na disciplina " + disciplinaSelecionada.getNome());
          } else {
              if (!alunoEncontrado) {
                throw new NameNotFoundException("Aluno " + nomeAluno + " não encontrado.");
              }
              if (!disciplinaEncontrada) {
                throw new NameNotFoundException("Disciplina " + nomeDisciplina + " não encontrada.");
              }
          }
        } else if (op == 6) { // Relatório de Alunos
          System.out.println("=== Relatório de Alunos ===");
          for (Aluno aluno : alunos) {
            System.out.println(aluno.Relatorio());
          }
        }else if (op == 7) { // Relatório de professores
          for (Professor professor : professores) {
            System.out.println(professor.Relatorio());
          }
        } else if (op == 8) { // Relatório de Disciplinas
          System.out.println("=== Relatório de Disciplinas ===");
          for (Disciplina disciplina : disciplinas) {
            System.out.println(disciplina.Relatorio());
          }
        }else if (op == 9) { // Relatório de turmas
          for (Turma turma : turmas) {
            System.out.println(turma.toString());
          }
        } else if (op == 10) { // Relatório de Alunos, notas e médias
          for (Aluno aluno : alunos) { 
              System.out.println(aluno.relatorioNotas());
          }
        } else if (op == 11) { // Quantidade de Alunos Cadastrados
          System.out.println("Total de alunos cadastrados: " + alunos.size());
        } else if (op == 12) { // Nome do aluno com maior nota
          Aluno alunoComMaiorNota = null;
          double maiorNota = -1;
      
          for (Aluno aluno : alunos) { // Supondo que você tenha uma lista de alunos
            for (Nota nota : aluno.getNotas()) { // Assumindo que há um método getNotas() na classe Aluno
              double notaAtual = nota.getNota();

              if (notaAtual > maiorNota) {
                maiorNota = notaAtual;
                alunoComMaiorNota = aluno;
              }
            }
          }
      
          if (alunoComMaiorNota != null) {
            System.out.println("Aluno com a maior nota: " + alunoComMaiorNota.getNome() + " | Nota: " + maiorNota);
          } else {
            System.out.println("Nenhuma nota cadastrada no sistema.");
          }
        }else if(op == 13) { // Listar alunos de uma disciplina
          System.out.println("Informe a disciplina que deseja visualizar:");
          String disciplina = scanner.nextLine();
          boolean encontrado = false;

          for (Turma turma : turmas) {
            if (turma.getDisciplina().getNome().equalsIgnoreCase(disciplina)) {
              encontrado = true;
              
              for (Aluno aluno : turma.getAlunos()) {
                System.out.println("Nome: " + aluno.getNome() + " | Matricula: " + aluno.getMatricula());
              }

              break;
            }
          }

          if (!encontrado) {
            throw new NameNotFoundException("Disciplina " + disciplina + " não está cadastrada!");
          }
        } else if(op == 14) { // Listar turmas de um professor
          System.out.println("Informe o nome do professor que deseja buscar:");
          String professor = scanner.nextLine();
          boolean encontrado = false;

          for (Turma turma : turmas) {
            if (turma.getProfessor().getNome().equalsIgnoreCase(professor)) {
              encontrado = true;
              
              System.out.println(turma.toString());
            }
          }

          if (!encontrado) {
            throw new NameNotFoundException("Professor " + professor + " não está cadastrado(a)!");
          }
        } else if (op == 15) { // Sair
          System.out.println("Saindo do sistema.");
          break;
        }
        
      } catch (InputMismatchException ex) { // Responsável por lidar com os erros de entrada.
        System.out.println("Tipo de dado inválido, valor do tipo [String] atribuído a variável do tipo numérico.");
        scanner.nextLine();
      } catch (NameNotFoundException ex) { // Responsável por lidar com os erros de instância não encontrada / não existente
        System.out.println(ex.getMessage());
      } catch (NoPermissionException ex) { // Responsável por lidar com erros de permissão
        System.out.println(ex.getMessage());
      } catch (IndexOutOfBoundsException ex) { // Responsável por lidar com erros de accesso (índice inexistente) em arrays
        System.out.println("Índice inválido!");
      } catch (Error ex){
        System.out.println("Falha na criação de arquivo");
      }
    }

    scanner.close();
  }
}