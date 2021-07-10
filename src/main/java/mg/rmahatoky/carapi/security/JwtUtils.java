package mg.rmahatoky.carapi.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import mg.rmahatoky.carapi.model.dto.request.AuthRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtils {

    private final static String jwtSecret = "com.abnex.jwt";

    public String generateJwtToken(AuthRequest authRequest) {

        return Jwts.builder()
                .setSubject((authRequest.getPseudo()))
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }

}
