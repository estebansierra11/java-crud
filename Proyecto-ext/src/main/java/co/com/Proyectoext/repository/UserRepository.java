package co.com.Proyectoext.repository;

import co.com.Proyectoext.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {


    }


