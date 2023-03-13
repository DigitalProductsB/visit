package com.internal.visit.service


import com.internal.visit.model.User
import com.internal.visit.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


@Service
class UserService {

    @Autowired
    UserRepository userRepository

    Boolean authenticate(User user) {
        User authenticateUser = userRepository.findByUsername(user.getUsername())
        if(authenticateUser) {
            String password = new String(Base64.getDecoder().decode(user.getPassword()))
            if(password.equalsIgnoreCase(authenticateUser.getPassword())) {
                return true
            }
            return false
        }
        return false
    }
}
