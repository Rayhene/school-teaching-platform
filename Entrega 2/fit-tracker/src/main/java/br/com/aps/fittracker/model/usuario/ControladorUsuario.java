package br.com.aps.fittracker.model.usuario;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;

//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
//import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

//import javax.servlet.http.Cookie;
//import javax.servlet.http.HttpServletResponse;
import java.util.Date;

@Service
public class ControladorUsuario { //extends UserDetailsServiceAutoConfiguration {
    
    @Autowired
    private CadastroUsuario usuarioCadastro;

    /*
    @Value("${app.jwtSecret}") // Defina a chave secreta no arquivo application.properties
    private String jwtSecret;

    @Value("${app.jwtExpirationMs}") // Defina o tempo de expiração do token no arquivo application.properties
    private long jwtExpirationMs; */

    public void inserir(Usuario usuario) {
        usuarioCadastro.inserir(usuario);
    }

    public void atualizar(Usuario usuario) {
        usuarioCadastro.atualizar(usuario);
    }

    public void remover(Long id) {
        usuarioCadastro.remover(id);
    }

    public Usuario buscarPorEmail(String email) {
        // realizar alguma lógica de verificação para o controlador
        //String regexPattern = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
        
        return usuarioCadastro.buscarPorEmail(email);
    }

    public Usuario getUsuario(Long id) {
        return usuarioCadastro.get(id);
    }

    /*
    //Autenticação
    // Método para gerar o token JWT
    public String generateToken(UserDetails userDetails) {
        return Jwts.builder()
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + jwtExpirationMs))
                .signWith(SignatureAlgorithm.HS256, jwtSecret)
                .compact();
    }

    // Método para criar um cookie com o token JWT e enviar para o frontend
    public void addTokenToResponse(HttpServletResponse response, String token) {
        Cookie cookie = new Cookie("token", token);
        cookie.setPath("/"); // Defina o caminho no qual o cookie será válido, normalmente "/"
        cookie.setHttpOnly(true); // Impede que o cookie seja acessível por scripts no frontend
        cookie.setMaxAge((int) (jwtExpirationMs / 1000)); // Define a duração do cookie (em segundos)
        response.addCookie(cookie);
        System.out.println("Cookie adicionado");
    }
     */

}
