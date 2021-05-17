package com.robbinespu.asdess.service;

import com.robbinespu.asdess.exception.BusinessIntegrityException;
import com.robbinespu.asdess.repo.UserRepo;
import com.robbinespu.asdess.util.MenuUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserService {
    @Autowired
    UserRepo userRepo;
    @Autowired
    MenuUtils menuUtils;

    public void checkOutItemList() throws BusinessIntegrityException{
        System.out.println("...List...");
        UserRepo.checkOutItem();
        System.out.println("\n");
    }

    public Boolean checkoutListSize() throws BusinessIntegrityException {
        if(UserRepo.listSize().equals(false)){
            System.out.println("...There is any item in database...\n");
            return false;
        }return true;
    }


    public void addItemtoDatabase (String inputFromTerminal) throws BusinessIntegrityException{
        if (!UserRepo.isThisItemExist(inputFromTerminal)){
            UserRepo.addItem(inputFromTerminal);
            System.out.println("..." + inputFromTerminal + " is added...\n");
        }else System.out.println("..." + inputFromTerminal + " is already added to database.Retry...\n");
    }
}
