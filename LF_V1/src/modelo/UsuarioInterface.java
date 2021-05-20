package modelo;

import java.util.Map;

public interface UsuarioInterface {
	
	public void altaUsuario(Usuario usuario);
	
	public Map<String, Usuario> todosUsuarios();
	
}
