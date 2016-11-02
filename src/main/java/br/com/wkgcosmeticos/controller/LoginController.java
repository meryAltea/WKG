package br.com.wkgcosmeticos.controller;

import java.util.Date;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.wkgcosmeticos.entidades.Usuario;
import br.com.wkgcosmeticos.service.UsuarioService;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
public class LoginController {
	@Autowired
	private UsuarioService usuarioService;

	@RequestMapping(value = "/autenticar", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public LoginResponse autenticar(@RequestBody Usuario usuario) throws ServletException {
		if(usuario.getLogin() ==null|| usuario.getSenha()==null){
			throw new ServletException("Login e senha são obrigatórios!");
		}

		// Consulta no banco

		Usuario usuAtenticado = usuarioService.buscarPorUsername(usuario.getLogin());
		if(usuAtenticado==null){
			throw new ServletException("Usuário não encontrado!");
		}
		
		if(!usuAtenticado.getSenha().equals(usuario.getSenha())){
			throw new ServletException("Usuário ou senha incorretos!");
		}
		String token= Jwts.builder()
				.setSubject(usuAtenticado.getLogin())
				.signWith(SignatureAlgorithm.HS512, "banana")
				.setExpiration(new Date (System.currentTimeMillis()+5*60*1000))
				.compact();
		return new LoginResponse(token);
	}

	private class LoginResponse {
		public String token;

		public LoginResponse(String token) {
			this.token = token;
		}

	}
}
