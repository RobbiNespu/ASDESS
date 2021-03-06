package com.robbinespu.asdess.util;

import com.robbinespu.asdess.exception.BusinessIntegrityException;
import com.robbinespu.asdess.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class MenuUtils {
    Scanner scanner = new Scanner(System.in);

    @Autowired
    UserService userService;


    public void commandMethod() throws BusinessIntegrityException {
        boolean loop = true;
        while (loop) {
            System.out.println("Please Enter Command Below: \n"
                    + "...ADD      => Add any item to database...\n"
                    + "...EDIT     => Edit any item from database...\n"
                    + "...DELETE   => Delete any item from database...\n"
                    + "...CHECKOUT => Checkout all item from database...\n"
                    + "...EXIT     => Exit from program...\n");
            userService.checkOutItemList();
            userService.checkoutListSize();
            String input = inputFromTerminal();

            if (input.equalsIgnoreCase("ADD")) {
                userService.checkOutItemList();
                userService.checkoutListSize();
                System.out.println("...Please Enter Item Name...\n");
                userService.addItemtoDatabase(inputFromTerminal());
                continue;
            } else if (input.equalsIgnoreCase("EDIT")) {
                if (userService.checkoutListSize().equals(false)) {
                    continue;
                } else {
                    userService.checkOutItemList();
                    System.out.println("...Please Enter Item Name...\n");
                    userService.editItemFromDatabase(inputFromTerminal());

                    continue;
                }
            } else if (input.equalsIgnoreCase("DELETE")) {
                if (userService.checkoutListSize().equals(false)) {
                    continue;
                } else {
                    userService.checkOutItemList();
                    System.out.println("...Please Enter Item Name..\n");
                    userService.deleteItemFromDatabase(inputFromTerminal());
                    continue;
                }
            } else if (input.equalsIgnoreCase("CHECKOUT")) {
                if (userService.checkoutListSize().equals(false)) {
                    continue;
                } else {
                    userService.checkOutItemList();
                    continue;
                }
            } else if (input.equalsIgnoreCase("EXIT")) {
                userService.checkOutItemList();
                userService.checkoutListSize();
                System.out.println("...Exit from Program...\n");
                System.exit(0);
            } else {
                System.out.println("...Invalid command. Retry...\n");
                commandMethod();
            }
        }
    }

    public String inputFromTerminal() throws BusinessIntegrityException {
        System.out.print("Input: ");
        String input = scanner.nextLine();
        return input;
    }
}
