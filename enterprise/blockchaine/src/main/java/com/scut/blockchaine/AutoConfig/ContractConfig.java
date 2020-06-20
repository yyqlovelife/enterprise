package com.scut.blockchaine.AutoConfig;

import com.scut.blockchaine.Constants.ConnectConstants;
import com.scut.blockchaine.Constants.GasConstants;
import com.scut.blockchaine.Contracts.QAQ;
import org.fisco.bcos.web3j.crypto.Credentials;
import org.fisco.bcos.web3j.protocol.Web3j;
import org.fisco.bcos.web3j.tx.gas.StaticGasProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ContractConfig {

    @Bean
    public QAQ getQaq(Web3j web3j, Credentials credentials){
        return QAQ.load(ConnectConstants.QaqAddress,web3j,credentials,new StaticGasProvider(GasConstants.GAS_PRICE, GasConstants.GAS_LIMIT));
    }
}
