package com.robbinespu.asdess.repo;

import com.robbinespu.asdess.dao.AsdessApplicationDAO;
import com.robbinespu.asdess.exception.BusinessIntegrityException;
import com.robbinespu.asdess.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

@Repository
public class UserRepo {
    public static AsdessApplicationDAO asdessApplicationDAO;


    public UserRepo(AsdessApplicationDAO asdessApplicationDAO) {
        UserRepo.asdessApplicationDAO = asdessApplicationDAO;
    }

    public static Boolean listSize() throws BusinessIntegrityException {
        List<User> itemList = asdessApplicationDAO.findAll();
        return itemList.size() > 0;
    }

    public static void checkOutItem() throws BusinessIntegrityException {
        List<User> itemList = asdessApplicationDAO.findAll();
        for (User item : itemList) {
            System.out.println("- " + item.getName());
        }
    }

    public static boolean isThisItemExist(String inputFromTerminal) throws BusinessIntegrityException {
        User databaseInfo = asdessApplicationDAO.findByName(inputFromTerminal);
        return Objects.nonNull(databaseInfo);
    }

    public static void addItem(String inputFromTerminal) throws BusinessIntegrityException {
        User user = new User();
        user.setName(inputFromTerminal);
        asdessApplicationDAO.save(user);
    }

    public static void editItem(String inputFromTerminal, String editedItem) throws BusinessIntegrityException {
        User user = asdessApplicationDAO.findByName(inputFromTerminal);
        user.setName(editedItem);
        asdessApplicationDAO.save(user);
    }

    public static void deleteItem(String inputFromTerminal) throws BusinessIntegrityException {
        asdessApplicationDAO.delete(asdessApplicationDAO.findByName(inputFromTerminal));
    }
}
