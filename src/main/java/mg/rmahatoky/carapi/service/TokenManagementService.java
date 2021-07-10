package mg.rmahatoky.carapi.service;

import mg.rmahatoky.carapi.repository.IUserTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TokenManagementService {

    @Autowired
    IUserTokenRepository userTokenRepository;

    public boolean isValidToken(String token){
        return userTokenRepository.findFirstByToken(token) != null;
    }

}
