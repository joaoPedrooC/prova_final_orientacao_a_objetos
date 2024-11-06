import java.io.FileWriter;
import java.util.ArrayList;

public class Professor extends Pessoa implements GerenciadorCadastroProfessor {
  private String areaDeFormacao;
  private int anoDeAdmissao;
  private String email;
  private ArrayList<Turma> turmas;

  public Professor(String nome, String dataNascimento, Endereco endereco, String telefone, String areaDeFormacao, int anoDeAdmissao, String email) {
    super(nome, dataNascimento, endereco, telefone);

    this.areaDeFormacao = areaDeFormacao;
    this.anoDeAdmissao = anoDeAdmissao;
    this.email = email;

    this.turmas = new ArrayList<Turma>();
  }

  public String getAreaDeFormacao() {
    return areaDeFormacao;
  }

  public int getAnoDeAdmissao() {
    return anoDeAdmissao;
  }

  public String getEmail() {
    return email;
  }
  
  @Override
  public void CadastrarProfessor(Professor professor) {
    try {
      FileWriter escrita = new FileWriter("Professores.txt", true);
      Endereco endereco = professor.getEndereco();
      
      escrita.append(professor.getNome() + " - " + professor.getTelefone() + " - " + professor.getDataNascimento() + " - " + professor.getEmail()
      + " - " + professor.getAnoDeAdmissao() +  " - " + professor.getAreaDeFormacao() + " - " + endereco.getCidade() + " - " + endereco.getEstado() + " - " + endereco.getCep() + "\n");
      
      escrita.close();
    } catch (Exception e) {
      System.out.println("Falha na escrita do professor!");
    }
  }

  public void AdicionarTurma(Turma turma) {
    this.turmas.add(turma);
  }

  @Override
  public String Relatorio() {
    return "Nome: " + this.getNome() + " | Data de Nascimento: " + this.getDataNascimento() + " | Endereco: " + this.getEndereco().toString() +
    " | Telefone: " + this.getTelefone() + "\nArea de formação: " + this.areaDeFormacao + " | Ano de Admissão: " + this.anoDeAdmissao + " | Email: "
    + this.email + " | Quantidade de turmas: " + this.turmas.size();
  }
}