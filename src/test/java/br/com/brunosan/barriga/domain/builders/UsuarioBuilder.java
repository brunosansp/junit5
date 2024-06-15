package br.com.brunosan.barriga.domain.builders;

import br.com.brunosan.barriga.domain.Usuario;

public class UsuarioBuilder {
    
    private Long id;
    private String nome;
    private String email;
    private String senha;
    
    private UsuarioBuilder() {
    }
    
    public static UsuarioBuilder umUsuario() {
        UsuarioBuilder builder = new UsuarioBuilder();
        inicializaUsuarioPadrao(builder);
        return builder;
    }
    
    private static void inicializaUsuarioPadrao(UsuarioBuilder builder) {
        builder.id = 1L;
        builder.nome = "Usuário Válido";
        builder.email = "user@email.com";
        builder.senha = "12345678";
    }
    
    public UsuarioBuilder comId(Long param) {
        id = param;
        return this;
    }
    
    public UsuarioBuilder comNome(String param) {
        nome = param;
        return this;
    }
    
    public UsuarioBuilder comEmail(String param) {
        email = param;
        return this;
    }
    
    public UsuarioBuilder comSenha(String param) {
        senha = param;
        return this;
    }
    
    public Usuario agora() {
        return new Usuario(id, nome, email, senha);
    }
}
