package com.jwt.user.service.service;

import com.jwt.user.service.VO.Department;
import com.jwt.user.service.VO.ResponseTemplateVO;
import com.jwt.user.service.entity.User;
import com.jwt.user.service.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    public User saveUser(User user) {
        log.info("Inside saveUser method of the UserService");
        return userRepository.save(user);
    }

    public ResponseTemplateVO getUserWithDepartment(String userId) {
        log.info("Inside getUserWithDepartment method of the UserService");
        ResponseTemplateVO vo = new ResponseTemplateVO();
        User user = userRepository.findByUserId(userId);

        Department department =
                restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/" + user.getDepartmentId()
                        , Department.class);

        //restTemplate.getForObject("http://localhost:8080/departments/" + user.getDepartmentId()
        //, Department.class);

        vo.setUser(user);
        vo.setDepartment(department);

        return vo;
    }
}
