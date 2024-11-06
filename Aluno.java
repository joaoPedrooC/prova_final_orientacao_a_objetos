import java.io.FileWriter;
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

  public int getMatricula() {
    return this.matricula;
  }

  public void adicionarNota(Nota nota) {
    this.notas.add(nota);
  }

  public double calcularMedia() {
    if(notas.isEmpty()) return 0;

    double soma = 0;
    for (Nota nota : notas) {
      soma += nota.getNota();
    }
    return soma / notas.size();
  }

  public String relatorioNotas() {
    StringBuilder relatorio = new StringBuilder();
    relatorio.append("Nome: ").append(this.getNome()).append("\n");
    relatorio.append("Matrícula: ").append(this.matricula).append("\n");
    relatorio.append("Notas:\n");

    for (Nota nota : notas) {
      relatorio.append(" - Nota: ").append(nota.getNota()).append(" (Data: ").append(nota.getData()).append(")\n");
    }

    relatorio.append("Média: ").append(calcularMedia()).append("\n");
    return relatorio.toString();
  }

  public ArrayList<Nota> getNotas() {
    return this.notas;
  }

  public int getAnoIngresso() {
    return anoIngresso;
  }

  @Override
  public void CadastrarAluno(Aluno aluno) {
    try {
      FileWriter escrita = new FileWriter("Alunos.txt", true);
      Endereco endereco = aluno.getEndereco();
      
      escrita.append(aluno.getNome() + " - " + aluno.getTelefone() + " - " + aluno.getDataNascimento() + " - " + aluno.getMatricula()
      + " - " + getAnoIngresso() + " - " + endereco.getCidade() + " - " + endereco.getEstado() + " - " + endereco.getCep() + "\n");
      
      escrita.close();
    } catch (Exception e) {
      System.out.println("Falha na escrita do aluno!");
    }
  }

  @Override
  public String Relatorio() {
    StringBuilder relatorio = new StringBuilder();
    relatorio.append("Nome: ").append(this.getNome())
        .append(" | Matrícula: ").append(this.matricula)
        .append(" | Ano de Ingresso: ").append(this.anoIngresso)
        .append(" | Data de Nascimento: ").append(this.getDataNascimento())
        .append(" | Endereço: ").append(this.getEndereco().toString())
        .append(" | Telefone: ").append(this.getTelefone())
        .append("\nNotas:\n");

    for (Nota nota : this.notas) {
      relatorio.append(" - Nota: ").append(nota.getNota())
          .append(" | Data: ").append(nota.getData())
          .append("\n");
    }
    return relatorio.toString();
  }
}