package mg.rmahatoky.carapi.service;

public interface ITokenManagementService {

    boolean isValidToken(String token);

    String generateToken();


}
