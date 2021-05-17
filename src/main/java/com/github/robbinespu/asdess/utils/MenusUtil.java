package com.github.robbinespu.asdess.utils;

import com.github.robbinespu.asdess.exceptions.BusinessIntegrityException;
import com.github.robbinespu.asdess.repo.StoreRepo;
import com.github.robbinespu.asdess.services.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class MenusUtil {
    Scanner scanner = new Scanner(System.in);

    @Autowired
    StoreRepo storeRepo;

    @Autowired
    SystemService systemService;

    public String inputFromTerminal() throws BusinessIntegrityException {
        System.out.print("Input: ");
        String input = scanner.nextLine();
        return input;
    }

    public void commandMethod() throws BusinessIntegrityException{

        boolean loop=true;
        while (loop) {
            System.out.println("...Please Enter Command Below...\n"
                    + "...ADD      => Add any item to database...\n"
                    + "...EDIT     => Edit any item from database...\n"
                    + "...DELETE   => Delete any item from database...\n"
                    + "...CHECKOUT => Checkout all item from database...\n"
                    + "...EXIT     => Exit from program...\n");
            //systemService.checkOutItemList();
            //systemService.checkoutListSize();
            String input = inputFromTerminal();
            if (input.equalsIgnoreCase("ADD")) {
                systemService.checkOutItemList();
                systemService.checkoutListSize();
                System.out.println("...Please Enter Item Name...\n");
                systemService.addItemtoDatabase(inputFromTerminal());
                continue;

            } else if (input.equalsIgnoreCase("EDIT")) {
                if(systemService.checkoutListSize().equals(false)){
                    continue;
                }else{
                    systemService.checkOutItemList();
                    System.out.println("...Please Enter Item Name...\n");
                    systemService.editItemFromDatabase(inputFromTerminal());

                    continue;
                }

            } else if (input.equalsIgnoreCase("DELETE")) {
                if(systemService.checkoutListSize().equals(false)){
                    continue;
                }else{
                    systemService.checkOutItemList();
                    System.out.println("...Please Enter Item Name...\n");
                    systemService.deleteItemFromDatabase(inputFromTerminal());
                    continue;
                }

            } else if (input.equalsIgnoreCase("CHECKOUT")) {
                if(systemService.checkoutListSize().equals(false)){
                    continue;
                }else{
                    systemService.checkOutItemList();
                    continue;
                }

            } else if(input.equalsIgnoreCase("EXIT")){
                systemService.checkOutItemList();
                systemService.checkoutListSize();
                System.out.println("...Exit from Program...\n");
                System.exit(0);
            } else {
                System.out.println("...Invalid command. Retry...\n");
                commandMethod();
            }
            //System.out.println(input+"...Invalid command. Retry...\n");
        }
    }



}
