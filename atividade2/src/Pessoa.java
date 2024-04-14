public class Pessoa {
    private String nome;
    private String email;


    public Pessoa(String nome, String email){
        this.nome = nome;
    }
    
    public String getNome(){
        return this.nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "nome: " + this.nome + "\temail: " + this.email;
    }


}
