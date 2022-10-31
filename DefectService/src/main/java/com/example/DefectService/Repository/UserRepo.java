package com.example.DefectService.Repository;

import com.example.DefectService.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User,Integer> {
    @Query(value = "select * from user where availability>0",nativeQuery = true)
    public List<User>filterByAvailability();

    @Query(value  ="select designation from user where id=?",nativeQuery = true )
    public String designationById(int id);


}
