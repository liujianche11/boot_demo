package com.ljc.spring.boot.demo.service;

import com.ljc.spring.boot.demo.exception.GlobalException;
import com.ljc.spring.boot.demo.mapper.UserMapper;
import com.ljc.spring.boot.demo.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

@Service
public class UserService {

    Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private DataSourceTransactionManager transactionManager;

    @Autowired
    UserMapper userMapper;

   public User getUser(Long id){
        return userMapper.getUser(id);
    }

    @Transactional
    public void addUser(User user){
       userMapper.addUser(user);
       throw new GlobalException("9999","统一异常");
    }

    public void addUserTwo(){
        DefaultTransactionDefinition def = new DefaultTransactionDefinition();
        def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
        TransactionStatus status = transactionManager.getTransaction(def);

        try {
            User user1 = new User();
            user1.setName("user1");
            user1.setAge(22);
            User user2 = new User();
            user2.setName("user2");
            user2.setAge(23);
            userMapper.addUser(user1);

            int i = 1/0;

            userMapper.addUser(user2);
            transactionManager.commit(status);
        }catch (Exception e){
            logger.error("UserService.addUserTwo error:{}",e);
            transactionManager.rollback(status);
            throw e;
        }
    }

}
