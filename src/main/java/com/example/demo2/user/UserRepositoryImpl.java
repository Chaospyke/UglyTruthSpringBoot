package com.example.demo2.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

public class UserRepositoryImpl implements UserRepositoryCustom{
    
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getUserByUsername(String username){
        String sql ="SELECT e FROM User e WHERE e.username LIKE :username";
        final TypedQuery<User> query = entityManager.createQuery(sql, User.class);
        return query
        .setParameter("username",username).getResultList();
    }

    @Override
    @Transactional
    public User postUserData(User user){
        return entityManager.merge(user);
    }

    @Override
    public List<User> insertUser(User user){
        List<User> toReturn = new ArrayList<User>();

        try{
            StoredProcedureQuery procedureQuery = entityManager
                .createStoredProcedureQuery("INSERT_USER");
            procedureQuery.registerStoredProcedureParameter("username",String.class,ParameterMode.IN);
            procedureQuery.setParameter("username",user.getUsername());
            procedureQuery.registerStoredProcedureParameter("fname",String.class,ParameterMode.IN);
            procedureQuery.setParameter("fname",user.getFname());
            procedureQuery.registerStoredProcedureParameter("lname",String.class,ParameterMode.IN);
            procedureQuery.setParameter("lname",user.getLname());
            procedureQuery.registerStoredProcedureParameter("email",String.class,ParameterMode.IN);
            procedureQuery.setParameter("email",user.getEmail());
            procedureQuery.registerStoredProcedureParameter("password",String.class,ParameterMode.IN);
            procedureQuery.setParameter("password",user.getPassword());
            procedureQuery.registerStoredProcedureParameter("dob",LocalDate.class,ParameterMode.IN);
            procedureQuery.setParameter("dob",user.getDob());
            procedureQuery.registerStoredProcedureParameter("age",Integer.class,ParameterMode.IN);
            procedureQuery.setParameter("age",user.getAge());
            procedureQuery.registerStoredProcedureParameter("alignment",String.class,ParameterMode.IN);
            procedureQuery.setParameter("alignment",user.getAlignment());
            procedureQuery.execute();

            toReturn.addAll(getUserByUsername(user.getUsername()));
            
            return toReturn;
        }
        catch(Error e){
            System.out.println("Error"+ e);
            return Collections.emptyList();
        }
    }

    @Override
    public User loginUser(User user){
        String sql ="SELECT e FROM User e WHERE e.username LIKE :username AND e.password LIKE :password";
        final TypedQuery<User> query = entityManager.createQuery(sql, User.class);
        return query
        .setParameter("username",user.getUsername())
        .setParameter("password",user.getPassword())
        .getSingleResult();
    }
}
