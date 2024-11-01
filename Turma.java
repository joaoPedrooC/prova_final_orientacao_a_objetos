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
}
