package com.yanjd.girl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class GirlService {

    @Autowired
    private GirlRepository girlRepository;

    @Transactional
    public void insertTwo() {
        Girl girl1 = new Girl(1, "name1", "F");
        Girl girl2 = new Girl(2, "name1", "FF");

        girlRepository.save(girl1);
        girlRepository.save(girl2);
    }
}
