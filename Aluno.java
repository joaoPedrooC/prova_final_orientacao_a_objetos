import java.util.ArrayList;

public class Aluno extends Pessoa implements GerenciadorCadastroAluno {
  private int matricula;
  private int anoIngresso;
  private ArrayList<Nota> notas;

  public Aluno(String nome, String dataNascimento, Endereco endereco, String telefone, int matricula, int anoIngresso) {
    super(nome, dataNascimento, endereco, telefone);

    this.matricula = matricula;
    this.anoIngresso = anoIngresso;

    this.notas = new ArrayList<Nota>();
  }

  @Override
  public void CadastrarAluno() {
    // TODO Auto-generated method stub
  }

  @Override
  public String Relatorio() {
    // TODO Auto-generated method stub
    return "";
  }
}
