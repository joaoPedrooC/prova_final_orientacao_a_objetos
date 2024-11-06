import java.io.FileWriter;
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
  
  public int getCargaHoraria() {
    return cargaHoraria;
  }

  public int getCodigo() {
    return codigo;
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

  public ArrayList<Professor> getProfessores() {
    return professores;
  }

  public void CadastrarDisciplina(Disciplina disciplina) {
    try {
      FileWriter escrita = new FileWriter("Disciplinas.txt", true);
      ArrayList<Professor> professores = disciplina.getProfessores();
      
      String dadosProfessores = "";

      escrita.append(disciplina.getNome() + " - " + disciplina.getCargaHoraria() + " - " + disciplina.getCodigo() + "\n");
      for (Professor professor : professores) {
        dadosProfessores += professor.getNome() + " - ";
      }

      escrita.append(dadosProfessores + "\n");
      
      escrita.close();
    } catch (Exception e) {
      System.out.println("Falha na escrita da disciplina!");
    }
  }
}