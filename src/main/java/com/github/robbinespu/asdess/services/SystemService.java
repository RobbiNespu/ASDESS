package com.github.robbinespu.asdess.services;

import com.github.robbinespu.asdess.exceptions.BusinessIntegrityException;
import com.github.robbinespu.asdess.repo.StoreRepo;
import com.github.robbinespu.asdess.utils.MenusUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SystemService {
    @Autowired
    MenusUtil menusUtil;

    @Autowired
    StoreRepo storeRepo;

    public void addItemtoDatabase (String inputFromTerminal) throws BusinessIntegrityException{
        if (!storeRepo.isThisItemExist(inputFromTerminal)){
            storeRepo.addItem(inputFromTerminal);
            System.out.println("..." + inputFromTerminal + " is added...\n");
        }else System.out.println("..." + inputFromTerminal + " is already added to database.Retry...\n");
    }

    public void editItemFromDatabase(String inputFromTerminal)throws BusinessIntegrityException{
        if(storeRepo.isThisItemExist(inputFromTerminal)){
            System.out.println("...Please Enter New Item Name For Editing...\n");
            String editedItem= menusUtil.inputFromTerminal();
            if(!storeRepo.isThisItemExist(editedItem)){
                storeRepo.editItem(inputFromTerminal, editedItem);
                System.out.println("..." +inputFromTerminal + " is edited as " + editedItem + "...\n");
            }else System.out.println("..." + editedItem + " is already existed in database...\n");
        }else System.out.println("..." + inputFromTerminal + " didn't found in database...\n");
    }

    public void deleteItemFromDatabase (String inputFromTerminal) throws BusinessIntegrityException{
        if (storeRepo.isThisItemExist(inputFromTerminal)){
            storeRepo.deleteItem(inputFromTerminal);
            System.out.println(inputFromTerminal + " is deleted...\n");
        }else System.out.println("..." + inputFromTerminal + " didn't found in database, Retry...\n");
    }

    public void checkOutItemList() throws BusinessIntegrityException{
        System.out.println("...List...");
        storeRepo.checkOutItem();
        System.out.println("\n");
    }

    public Boolean checkoutListSize()throws BusinessIntegrityException{
        if(storeRepo.listSize().equals(false)){
            System.out.println("...There is any item in database...\n");
            return false;
        }return true;
    }
}
