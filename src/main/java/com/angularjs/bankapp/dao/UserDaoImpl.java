/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.angularjs.bankapp.dao;

import com.angularjs.bankapp.model.User;
import com.angularjs.bankapp.shared.AbstractDao;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ravindra.palli
 */
@Repository
@Transactional
public class UserDaoImpl extends AbstractDao<Integer, User> implements IUserDao {

    private static final Logger LOGGER =
            Logger.getLogger(UserDaoImpl.class.getName());

    @Override
    public User findById(int id) {
        User user = getByKey(id);
        if(user!=null){
            Hibernate.initialize(user.getAuthorities());
        }
        return user;
    }

    @Override
    public User findUserByUsername(String username) {
        LOGGER.log(Level.INFO, "SSO : {0}", username);
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("username", username));
        User user = (User)crit.uniqueResult();
        if(user!=null){
            Hibernate.initialize(user.getAuthorities());
        }
        return user;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<User> findAllUsers() {
        Criteria criteria = createEntityCriteria().addOrder(Order.asc("firstName"));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
        List<User> users = (List<User>) criteria.list();
        users.forEach((user) -> {
            Hibernate.initialize(user.getAuthorities());
        });
        return users;
    }

    @Override
    public void save(User user) {
        save(user);
    }

    @Override
    public void delete(User user) {
        delete(user);
    }

    @Override
    public void deleteByUsername(String username) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("username", username));
        User user = (User)crit.uniqueResult();
        delete(user);
    }
    
}
