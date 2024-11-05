public class Nota {
  private double nota;
  private String data;

  public Nota(double nota, String data) {
    this.nota = nota;
    this.data = data;
  }

  public double getNota() {
    return this.nota;
  }

  public String getData() {
    return this.data;
  }
}