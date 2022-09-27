package com.example.demo2.user;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository  extends JpaRepository<User,Long>,UserRepositoryCustom{
    
    // @Transactional
    // @Modifying
    // @Query(value ="""
    //     UPDATE User e
    //     SET e.username = :username,
    //         e.fname = :fname,
    //         e.lname = :lname,
    //         e.email = :email,
    //         e.password = :password,
    //         e.dob = :dob,
    //         e.age = :age,
    //         e.alignment = :alignment,
    //     WHERE e.id = :id
    //     """)
    //     public void postUserData(User user);

}
