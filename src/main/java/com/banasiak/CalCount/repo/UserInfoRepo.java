package com.banasiak.CalCount.repo;

import com.banasiak.CalCount.model.user.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInfoRepo extends JpaRepository<UserInfo, Long> {


    @Query("SELECT max(userInfoId) from UserInfo ")
    Long findLastId();

}
