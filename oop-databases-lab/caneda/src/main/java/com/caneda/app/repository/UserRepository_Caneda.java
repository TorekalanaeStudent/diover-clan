package com.caneda.app.repository;

import com.caneda.app.entities.User_Caneda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UserRepository_Caneda extends JpaRepository<User_Caneda, Long> {
    User_Caneda findByUserName(String userName);
    User_Caneda findByUserAge(int userAge);
    User_Caneda findByUserEmail(String userEmail);
    User_Caneda findByUserCountry(String userCountry);
    List<User_Caneda> findAllByUserRole(String userRole);
}
