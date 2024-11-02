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
  
  @Override
  public void CadastrarProfessor() {
    // TODO Auto-generated method stub
  }

  @Override
  public String Relatorio() {
    return "Nome: " + this.getNome() + " | Data de Nascimento: " + this.getDataNascimento() + " | Endereco: " + this.getEndereco().toString() +
    " | Telefone: " + this.getTelefone() + "\nArea de formação: " + this.areaDeFormacao + " | Ano de Admissão: " + this.anoDeAdmissao + " | Email: "
    + this.email + " | Quantidade de turmas: " + this.turmas.size();
  }
}
