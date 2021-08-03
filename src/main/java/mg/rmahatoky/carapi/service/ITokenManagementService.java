package mg.rmahatoky.carapi.service;

/**
 * Interface métier pour les Token
 *
 * @author Mahatoky
 */
public interface ITokenManagementService {

    boolean isValidToken(String token);

    String generateToken();


}
