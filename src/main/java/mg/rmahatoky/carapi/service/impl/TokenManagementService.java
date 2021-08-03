package mg.rmahatoky.carapi.service.impl;

import mg.rmahatoky.carapi.model.entity.User;
import mg.rmahatoky.carapi.repository.IUserRepository;
import mg.rmahatoky.carapi.service.ITokenManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class TokenManagementService implements ITokenManagementService {

    @Autowired
    IUserRepository userRepository;

    @Override
    public boolean isValidToken(String token){
        User user = userRepository.findFirstByToken(token);
        return user != null;
    }

    @Override
    public String generateToken(){
        return null;
    }

}
