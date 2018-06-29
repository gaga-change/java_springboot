package com.yanjd.java.girl;

import com.yanjd.java.girl.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GirlRepository extends JpaRepository<Girl, Integer> {
    List<Girl> findByAge(Integer id);
}
