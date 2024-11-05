import java.util.ArrayList;

public class Turma {
  private int codigo;
  private int anoLetivo;
  private Professor professor;
  private Disciplina disciplina;
  private ArrayList<Aluno> alunos;

  public Turma(int codigo, int anoLetivo, Professor professor, Disciplina disciplina) {
    this.codigo = codigo;
    this.anoLetivo = anoLetivo;
    this.professor = professor;
    this.disciplina = disciplina;

    this.alunos = new ArrayList<Aluno>();
  }

  public Professor getProfessor() {
    return this.professor;
  }

  public Disciplina getDisciplina() {
    return this.disciplina;
  }

  public void AdicionarAlunos(Aluno aluno) {
    this.alunos.add(aluno);
  }

  public ArrayList<Aluno> getAlunos() {
    return this.alunos;
  }

  @Override
  public String toString() {
    return "Código da turma: " + this.codigo + " | Ano letivo: " + this.anoLetivo + " | Quantidade de alunos da turma " + this.codigo + ": " + this.alunos.size() + " | Professor responsável: " + this.professor.getNome();
  }
}
