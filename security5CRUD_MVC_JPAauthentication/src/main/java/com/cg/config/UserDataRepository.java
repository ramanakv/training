package com.cg.config;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.dto.UserData;
@Repository
public interface UserDataRepository  extends JpaRepository<UserData, String>{

}
