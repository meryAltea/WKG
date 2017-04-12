package br.com.wkgcosmeticos.controller;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.filter.GenericFilterBean;

import io.jsonwebtoken.Jwts;

public class TokenFilter extends GenericFilterBean {
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		String header = req.getHeader("Authorization");

		if (header == null || !header.startsWith("Bearer")) {
			throw new ServletException("Token inexistente ou inválido");
		}
		String token = header.substring(7); // Extraindo a string do token sem o
											// bearer


		chain.doFilter(request, response);

		//TODO : TODA HORA TOKEN TÁ INVALIDANDO
		/*
		// verifica se o token é valido
		try {
			Jwts.parser().setSigningKey("banana").parseClaimsJws(token).getBody();
			chain.doFilter(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			//((HttpServletResponse)response).sendError(HttpServletResponse.SC_UNAUTHORIZED, "Token Inválido!");
			throw new ServletException("Token Inválido");
		}*/
		
	}
}
