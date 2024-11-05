import java.util.ArrayList;

public class Disciplina {
  private String nome;
  private int cargaHoraria;
  private int codigo;
  private ArrayList<Professor> professores;

  public Disciplina(String nome, int cargaHoraria, int codigo) {
    this.nome = nome;
    this.cargaHoraria = cargaHoraria;
    this.codigo = codigo;
    this.professores = new ArrayList<Professor>();
  }

  public String getNome() {
    return this.nome;
  }

  public void AdicionarProfessor(Professor professor) {
    this.professores.add(professor);
  }

  public String Relatorio() {
    StringBuilder relatorio = new StringBuilder();
    relatorio.append("Nome da Disciplina: ").append(this.nome)
      .append(" | Carga Horária: ").append(this.cargaHoraria)
      .append(" | Código: ").append(this.codigo)
      .append("\nProfessores:\n");

    for (Professor professor : this.professores) {
      relatorio.append(" - ").append(professor.getNome()).append("\n");
    }

    return relatorio.toString();
  }
}
