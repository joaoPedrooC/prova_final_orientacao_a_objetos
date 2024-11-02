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

  public abstract String Relatorio();
  
  public String getNome() {
    return this.nome;
  }

  public String getDataNascimento() {
    return this.dataNascimento;
  }

  public Endereco getEndereco() {
    return this.endereco;
  }

  public String getTelefone() {
    return this.telefone;
  }
}
