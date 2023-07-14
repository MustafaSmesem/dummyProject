package com.joumer.dummyproject;

import co.mobileaction.dummylibrary.TestMethods;
import co.mobileaction.dummylibrary.User;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
public class DummyLibraryTesterService implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) {
        System.out.println("Running waiting test methods call.");
        TestMethods.testPrint("Mustafa");

        var user = new User();
        user.setId(1000L);
        user.setName("Tolga");
        user.setGerekSizTarih(LocalDateTime.now());
        user.info();
    }
}
