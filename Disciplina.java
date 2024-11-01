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
}
