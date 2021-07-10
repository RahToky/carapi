package mg.rmahatoky.carapi.security;

import mg.rmahatoky.carapi.exception.TokenException;
import mg.rmahatoky.carapi.service.TokenManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Permet de verifier le token
 *
 * @author Mahatoky
 */
@Component
public class BearerTokenInterceptor implements HandlerInterceptor {

    @Autowired
    TokenManagementService tokenManagementService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        final String authorization = request.getHeader("Authorization");
        if (authorization == null)
            throw new TokenException("Vous devez vous connecter pour effectuer cette opération");
        if (!authorization.contains("Bearer")) {
            throw new TokenException("Vous devez utiliser Bearer comme type d'autorisation");
        }

        final String token = authorization.substring(7);
        if (!tokenManagementService.isValidToken(token)) {
            throw new TokenException("Token invalide");
        }
        return true;
    }

}
