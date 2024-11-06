import java.io.FileWriter;

public class Nota {
  private double nota;
  private String data;
  private Disciplina disciplina;

  public Nota(double nota, String data, Disciplina disciplina) {
    this.nota = nota;
    this.data = data;
    this.disciplina = disciplina;
  }

  public double getNota() {
    return this.nota;
  }

  public String getData() {
    return this.data;
  }

  public Disciplina getDisciplina() {
    return disciplina;
  }

  public void CadastrarNota(Nota nota, String nomeAluno) {
    try {
      FileWriter escrita = new FileWriter("Notas.txt", true);

      escrita.append(nota.getNota() + " - " + nota.getData() + " - " + nomeAluno + " - " + nota.getDisciplina().getNome() + '\n');

      escrita.close();
    } catch (Exception e) {
      System.out.println("Falha na escrita da nota!");
    }
  }
}