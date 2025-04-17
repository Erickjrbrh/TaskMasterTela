package br.senac.taskmaster.telas;

public class Usuario {

    private UsuarioDTO usuarioDTO;

    private static UsuarioDAO usuarioDAO = new UsuarioDAO(); // Usando DAO estático

    public Usuario() {
        usuarioDTO = new UsuarioDTO("default@taskmaster.com", "default"); // dados temporários
    }

    public Usuario(int id, String nome, String email, String senha) {
        usuarioDTO = new UsuarioDTO(id, nome, email, senha);
    }

    public boolean autenticar(String email, String senha) {
    UsuarioDTO autenticado = usuarioDAO.autenticar(email, senha);
    if (autenticado != null) {
        this.usuarioDTO = autenticado; // <-- ISSO AQUI FAZ FUNCIONAR o getUsuarioDTO()
        return true;
    }
    return false;
}


    // Métodos de acesso ao usuário logado
    public UsuarioDTO getUsuarioLogado() {
        return usuarioDTO;
    }

    public UsuarioDTO getUsuarioDTO() {
        return this.usuarioDTO;
    }

    public int getId() {
        return usuarioDTO.getId();
    }

    public void setId(int id) {
        usuarioDTO.setId(id);
    }

    public String getNome() {
        return usuarioDTO.getNome();
    }

    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome não pode ser vazio");
        }
        usuarioDTO.setNome(nome);
    }

    public String getEmail() {
        return usuarioDTO.getEmail();
    }

    public void setEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("Email não pode ser vazio");
        }
        usuarioDTO.setEmail(email);
    }

    public String getSenha() {
        return usuarioDTO.getSenha();
    }

    public void setSenha(String senha) {
        if (senha == null || senha.trim().isEmpty()) {
            throw new IllegalArgumentException("Senha não pode ser vazia");
        }
        usuarioDTO.setSenha(senha);
    }

    // Cadastrar usuário com nome, email e senha
    public boolean cadastrarUsuario(String nome, String email, String senha) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome não pode ser vazio");
        }
        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("Email não pode ser vazio");
        }
        if (senha == null || senha.trim().isEmpty()) {
            throw new IllegalArgumentException("Senha não pode ser vazia");
        }

        if (usuarioDAO.emailExiste(email)) {
            throw new IllegalArgumentException("Já existe um usuário com esse email");
        }

        int novoId = usuarioDAO.listarTodosUsuarios().size() + 1; // ID sequencial
        UsuarioDTO novoUsuario = new UsuarioDTO(novoId, nome, email, senha);
        usuarioDAO.adicionarUsuario(novoUsuario);

        return true;
    }

    @Override
    public String toString() {
        return "Usuario{"
                + "id=" + usuarioDTO.getId()
                + ", nome='" + usuarioDTO.getNome() + '\''
                + ", email='" + usuarioDTO.getEmail() + '\''
                + ", senha='******'}";
    }
}
