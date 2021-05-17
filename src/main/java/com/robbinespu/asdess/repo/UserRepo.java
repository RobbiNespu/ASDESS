package com.robbinespu.asdess.repo;

import com.robbinespu.asdess.dao.AsdessApplicationDAO;
import com.robbinespu.asdess.exception.BusinessIntegrityException;
import com.robbinespu.asdess.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

@Repository
public class UserRepo {
    public static AsdessApplicationDAO asdessApplicationDAO;


    public UserRepo(AsdessApplicationDAO asdessApplicationDAO) {
        this.asdessApplicationDAO = asdessApplicationDAO;
    }

    public static Boolean listSize() throws BusinessIntegrityException {
        List<User> itemList = (List<User>) asdessApplicationDAO.findAll();
        if(!(((List<?>) itemList).size()>0)){
            return false;
        }
        return true;
    }

    public static void checkOutItem() throws BusinessIntegrityException {
        List<User> itemList = (List<User>) asdessApplicationDAO.findAll();
        for ( User item: itemList) {
            System.out.println("- "+ item.getName());
        }
    }

    public static boolean isThisItemExist(String inputFromTerminal) throws BusinessIntegrityException {
        User databaseInfo = asdessApplicationDAO.findByName(inputFromTerminal);
        return Objects.nonNull(databaseInfo);
    }

    public static void  addItem(String inputFromTerminal) throws BusinessIntegrityException {
        User user = new User();
        user.setName(inputFromTerminal);
        asdessApplicationDAO.save(user);
    }

    public static void editItem(String inputFromTerminal, String editedItem) throws BusinessIntegrityException{
        User user = asdessApplicationDAO.findByName(inputFromTerminal);
        user.setName(editedItem);
        asdessApplicationDAO.save(user);
    }
}
