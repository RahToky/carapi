package mg.rmahatoky.carapi.service;

import mg.rmahatoky.carapi.model.entity.User;
import mg.rmahatoky.carapi.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TokenManagementService {

    @Autowired
    IUserRepository userRepository;

    public boolean isValidToken(String token){
        User user = userRepository.findFirstByToken(token);
        return user != null;
    }

    public String generateToken(){
        return null;
    }

}
