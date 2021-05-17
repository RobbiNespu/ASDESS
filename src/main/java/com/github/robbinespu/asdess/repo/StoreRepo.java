package com.github.robbinespu.asdess.repo;

import com.github.robbinespu.asdess.AsdEssApplication;
import com.github.robbinespu.asdess.dao.AsdEssApplicationDAO;
import com.github.robbinespu.asdess.exceptions.BusinessIntegrityException;
import com.github.robbinespu.model.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

@Repository
public class StoreRepo {

    AsdEssApplicationDAO asdEssApplicationDAO;

    public boolean isThisItemExist(String inputFromTerminal) throws BusinessIntegrityException {
        Store databaseInfo = asdEssApplicationDAO.findByName(inputFromTerminal);
        return Objects.nonNull(databaseInfo);
    }

    public void  addItem(String inputFromTerminal) throws BusinessIntegrityException {
        Store store = new Store();
        store.setName(inputFromTerminal);
        asdEssApplicationDAO.save(store);
    }

    public void deleteItem(String inputFromTerminal) throws BusinessIntegrityException{
        asdEssApplicationDAO.delete(asdEssApplicationDAO.findByName(inputFromTerminal));
    }

    public void editItem(String inputFromTerminal, String edittedItem) throws BusinessIntegrityException{
        Store store = asdEssApplicationDAO.findByName(inputFromTerminal);
        store.setName(edittedItem);
        asdEssApplicationDAO.save(store);
    }

    public void checkOutItem() throws BusinessIntegrityException {
        List<Store> itemList;
        itemList = asdEssApplicationDAO.findAll();
        for ( Store item: itemList) {
            System.out.println("- "+ item.getName());
        }
    }

    public Boolean listSize() throws BusinessIntegrityException {
        List<Store> itemList = asdEssApplicationDAO.findAll();
        if(!(itemList.size()>0) && itemList !=  null){
            return false;
        }
        return true;
    }

}
