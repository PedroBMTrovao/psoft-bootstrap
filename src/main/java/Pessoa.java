import java.util.Objects;

public class Pessoa {
	private String nome;
	private int idade;
	private String cpf;
	private String telefone;
	private String[] enderecos = new String[100];
	private String ocupacao;
	private String role;
	
	public Pessoa(String name, int age, String cpf, String phone, String address, String occ, String role) {
	  this.nome = name;
	  this.idade = age;
	  this.cpf = cpf;
	  this.telefone = phone;
    this.ocupacao = occ;
    this.enderecos[0] = address;
	  if (role.equals("cliente") || role.equals("funcionário")) {
      this.role = role;
    } else {
      throw new IllegalArgumentException();
    }
	}
  public String getName() {
    return nome;
  }
  public int getAge() {
    return idade;
  }
  public void updateAge(int age) {
    this.idade = age;
  }
  public String getCPF() {
    return cpf;
  }
  public String getPhone() {
    return telefone;
  }
  public void updatePhone(String phone) {
    this.telefone = phone;
  }
  public String getOcc() {
    return ocupacao;
  }
  public void updateOcc(String occ) {
    this.ocupacao = occ;
  }
  public void changeRole() {
    if (role.equals("cliente")) {
      role = "funcionário";
    } else {
      role = "cliente";
    }
  }
  public void newAddress(String address) {
    for (int i = 0; i < enderecos.length; i++) {
      if (enderecos[i] == null) {
        enderecos[i] = address;
        break;
      }
    }
  }
  public boolean remAddress(String address) {
    for (int i = 0; i < enderecos.length; i++) {
      if (enderecos[i] != null && enderecos[i].equals(address)) {
        enderecos[i] = null;
        return true;
      }
    }
    return false;
  }
  public String getAddress() {
    String addresses = ""; 
    for (int i = 0; i < enderecos.length; i++) {
      if (enderecos[i] != null) {
        if (addresses.isEmpty()) {
          addresses = enderecos[i];
        } else {
          addresses = addresses + ", " + enderecos[i];
        }
      }
    }
    return addresses;
  }
  @Override
  public int hashCode() {
    return Objects.hash(cpf);
  }
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    };
    if (o == null || getClass() != o.getClass()) {
      return false;
    };
    Pessoa pessoa = (Pessoa) o;
    return Objects.equals(cpf, pessoa.cpf);
  }
  @Override
  public String toString() {
    return role + ": " + nome + " CPF: " + cpf;
  }
}
