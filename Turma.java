import java.util.ArrayList;

public class Turma {
  private int codigo;
  private int anoLetivo;
  private ArrayList<Aluno> alunos;

  public Turma(int codigo, int anoLetivo) {
    this.codigo = codigo;
    this.anoLetivo = anoLetivo;

    this.alunos = new ArrayList<Aluno>();
  }

  @Override
  public String toString() {
    return "Código da turma: " + this.codigo + " | Ano letivo: " + this.anoLetivo + " | Quantidade de alunos da turma " + this.codigo + ": " + this.alunos.size();
  }
}
