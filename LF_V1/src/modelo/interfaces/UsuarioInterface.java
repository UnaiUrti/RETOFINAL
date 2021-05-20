package modelo.interfaces;

import java.util.Map;

import modelo.entidades.Usuario;

public interface UsuarioInterface {
	
	public void altaUsuario(Usuario usuario);
	
	public Map<String, Usuario> todosUsuarios();
	
}
