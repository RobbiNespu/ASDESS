package com.robbinespu.asdess.util;

import com.robbinespu.asdess.exception.BusinessIntegrityException;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class MenuUtils {
    Scanner scanner = new Scanner(System.in);

    public void commandMethod() throws BusinessIntegrityException {
        boolean loop=true;
        while (loop) {
            System.out.println("Please Enter Command Below: \n"
                    + "...ADD      => Add any item to database...\n"
                    + "...EDIT     => Edit any item from database...\n"
                    + "...DELETE   => Delete any item from database...\n"
                    + "...CHECKOUT => Checkout all item from database...\n"
                    + "...EXIT     => Exit from program...\n");

            String input = inputFromTerminal();
        }
    }

    public String inputFromTerminal() throws BusinessIntegrityException {
        System.out.print("Input: ");
        String input = scanner.nextLine();
        return input;
    }
}
