package br.senac.taskmaster.telas;

public class UsuarioDTO {

    private UsuarioDTO usuarioDTO;
    private int id;
    private String nome;
    private String email;
    private String senha;

    // ✅ Construtor vazio — necessário para usar setters depois de criar o objeto
    public UsuarioDTO() {
    }

    // Construtor adicional que não exige o nome
    public UsuarioDTO(String email, String senha) {
        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("Email não pode ser vazio");
        }
        if (senha == null || senha.trim().isEmpty()) {
            throw new IllegalArgumentException("Senha não pode ser vazia");
        }

        this.id = 0; // ou gere um ID se quiser
        this.nome = email; // usa o email como nome por padrão
        this.email = email;
        this.senha = senha;
    }

    public boolean autenticar(String email, String senha) {
        // Simulação de autenticação (exemplo)
        if (email.equals("admin") && senha.equals("123")) {
            usuarioDTO = new UsuarioDTO(email, senha);
            usuarioDTO.setId(1); // Ou o ID que quiser
            usuarioDTO.setEmail(email); // Opcional, já é feito no construtor

            return true;
        }

        return false;
    }

    // Construtor completo
    public UsuarioDTO(int id, String nome, String email, String senha) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome não pode ser vazio");
        }
        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("Email não pode ser vazio");
        }
        if (senha == null || senha.trim().isEmpty()) {
            throw new IllegalArgumentException("Senha não pode ser vazia");
        }

        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome não pode ser vazio");
        }
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("Email não pode ser vazio");
        }
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        if (senha == null || senha.trim().isEmpty()) {
            throw new IllegalArgumentException("Senha não pode ser vazia");
        }
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "UsuarioDTO{"
                + "id=" + id
                + ", nome='" + nome + '\''
                + ", email='" + email + '\''
                + ", senha='******'}"; // Para não mostrar a senha real no log
    }
}
