package sg.edu.nus.iss.vttp5a_ssf_day15L.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sg.edu.nus.iss.vttp5a_ssf_day15L.repository.RedisListRepo;
import sg.edu.nus.iss.vttp5a_ssf_day15L.repository.RedisValueRepo;

@Service
public class RedisTestService {

    @Autowired
    RedisListRepo lRepo;

    @Autowired
    RedisValueRepo vRepo;
    
}
