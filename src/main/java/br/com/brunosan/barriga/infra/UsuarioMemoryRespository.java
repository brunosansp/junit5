package br.com.brunosan.barriga.infra;

import br.com.brunosan.barriga.domain.Usuario;
import br.com.brunosan.barriga.repositories.UsuarioRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UsuarioMemoryRespository implements UsuarioRepository {
    private List<Usuario> users;
    private Long currentId;
    
    public UsuarioMemoryRespository() {
        currentId = 0L;
        users = new ArrayList<>();
        salvar(new Usuario(nextId(), "User #1", "user1@mail.com", "123456"));
    }
    
    @Override
    public Usuario salvar(Usuario usuario) {
        Usuario newUser = new Usuario(currentId, usuario.getNome(), usuario.getEmail(), usuario.getSenha());
        users.add(newUser);
        return newUser;
    }
    
    @Override
    public Optional<Usuario> getUserByEmail(String email) {
        return users.stream()
            .filter(usuario -> usuario.getEmail().equalsIgnoreCase(email))
            .findFirst();
    }
    
    public void printUsers() {
        System.out.println(users);
    }
    
    private Long nextId() {
        return ++currentId;
    }
    
    public static void main(String[] args) {
        UsuarioMemoryRespository repo = new UsuarioMemoryRespository();
        repo.printUsers();
        repo.salvar(new Usuario(null, "Outro usuário", "outro@mail.com", "654321"));
        repo.printUsers();
    }
}
