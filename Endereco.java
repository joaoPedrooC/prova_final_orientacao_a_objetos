public class Endereco {
  private String cidade;
  private String estado;
  private String cep;

  public Endereco(String cidade, String estado, String cep) {
    this.cidade = cidade;
    this.estado = estado;
    this.cep = cep;
  }

  public String getCidade() {
    return this.cidade;
  }

  public String getEstado() {
    return this.estado;
  }

  public String getCep() {
    return cep;
  }

  @Override
  public String toString() {
    return "Cidade: " + this.cidade + " | Estado: " + this.estado + " | CEP: " + this.cep;
  }
}