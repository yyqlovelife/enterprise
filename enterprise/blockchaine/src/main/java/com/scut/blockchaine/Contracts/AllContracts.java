package com.scut.blockchaine.Contracts;

import com.google.common.collect.Lists;
import com.scut.blockchaine.AutoConfig.Web3jConfig;
import com.scut.blockchaine.Constants.GasConstants;
import org.checkerframework.checker.units.qual.A;
import org.fisco.bcos.channel.client.Service;
import org.fisco.bcos.web3j.protocol.Web3j;
import org.fisco.bcos.web3j.crypto.Credentials;
import org.fisco.bcos.web3j.tx.Contract;
import org.fisco.bcos.web3j.tx.gas.StaticGasProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.security.auth.login.CredentialException;
import java.util.ArrayList;

public class AllContracts {
    private HelloWorld helloWorld;
    private School school;
    private School_crud school_crud;
    private static AllContracts instance;

    private AllContracts() {
    }

    public static AllContracts getContracts() {
        if (instance == null) {
            instance = new AllContracts();
        }
        return instance;
    }

    public void setHelloWorld(HelloWorld helloWorld) {
        instance.helloWorld = helloWorld;
    }

    public void setSchool(School school) {
        instance.school = school;
    }

    public void setSchool_crud(School_crud school_crud) {
        instance.school_crud = school_crud;
    }

    public HelloWorld getHelloWorld() {
        return helloWorld;
    }

    public School getSchool() {
        return school;
    }

    public School_crud getSchool_crud() {
        return school_crud;
    }
}
