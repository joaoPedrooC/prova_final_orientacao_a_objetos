import java.util.ArrayList;

public class Disciplina {
  private String nome;
  private int cargaHoraria;
  private int codigo;
  private ArrayList<Professor> professores;
  private ArrayList<Nota> notas;

  public Disciplina(String nome, int cargaHoraria, int codigo) {
      this.nome = nome;
      this.cargaHoraria = cargaHoraria;
      this.codigo = codigo;
      this.professores = new ArrayList<Professor>();
      this.notas = new ArrayList<Nota>();
  }

  public String getNome() {
      return this.nome;
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

      relatorio.append("Notas:\n");
      for (Nota nota : this.notas) {
          relatorio.append(" - Nota: ").append(nota.getNota())
                   .append(" | Data: ").append(nota.getData())
                   .append("\n");
      }

      return relatorio.toString();
  }
}
