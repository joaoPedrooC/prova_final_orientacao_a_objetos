public abstract class Pessoa {
  private String nome;
  private String dataNascimento;
  private Endereco endereco;
  private String telefone;

  public Pessoa(String nome, String dataNascimento, Endereco endereco, String telefone) {
    this.nome = nome;
    this.dataNascimento = dataNascimento;
    this.endereco = endereco;
    this.telefone = telefone;
  }
}
