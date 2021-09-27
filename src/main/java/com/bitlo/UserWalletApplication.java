package com.bitlo;

import com.bitlo.model.*;
import com.bitlo.repository.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableSwagger2
public class UserWalletApplication {

    public static void main(String[] args) {
        //SpringApplication.run(UserWalletApplication.class, args);

        ConfigurableApplicationContext context = SpringApplication.run(UserWalletApplication.class, args);
        UserRepository userRepository = context.getBean(UserRepository.class);
        WalletRepository walletRepository = context.getBean(WalletRepository.class);
        CurrencyRepository currencyRepository = context.getBean(CurrencyRepository.class);
        TransactionTypeRepository transactionTypeRepository = context.getBean(TransactionTypeRepository.class);
        TransactionRepository transactionRepository = context.getBean(TransactionRepository.class);
        BCryptPasswordEncoder encoder = context.getBean(BCryptPasswordEncoder.class);


        //Mock Users
        List<User> users = new ArrayList<>();
        users.add(new User("Mevlüt", "Beder", "mevlut1", encoder.encode("123"), "mev@bitlo.com"));
        users.add(new User("Ahmet", "Demir", "ahmet1", encoder.encode("1234"), "ahmet@bitlo.com"));
        users.add(new User("Mehmet", "Çelik", "mehmet1", encoder.encode("12345"), "mehmet@bitlo.com"));
        userRepository.saveAll(users);


        //Mock Currency
        List<Currency> currencies = new ArrayList<>();
        currencies.add(new Currency("USD","United States dollar"));
        currencies.add(new Currency("EUR","EURO"));
        currencies.add(new Currency("JPY","Japanese yen"));
        currencies.add(new Currency("TRY","Turkish Lira"));
        currencies.add(new Currency("ETH","Ethereum"));
        currencies.add(new Currency("BTC","Bitcoin"));
        currencyRepository.saveAll(currencies);


        //Mock TransactionType
        List<TransactionType> transactionTypes = new ArrayList<>();
        transactionTypes.add(new TransactionType("C","CREDIT"));
        transactionTypes.add(new TransactionType("D","DEBIT"));
        transactionTypeRepository.saveAll(transactionTypes);


        //Mock wallet
        List<Wallet> wallets = new ArrayList<>();
        wallets.add(new Wallet(1L,new BigDecimal(15.20),currencyRepository.getByCurrencyCode("USD")));
        wallets.add(new Wallet(1L,new BigDecimal(45.50),currencyRepository.getByCurrencyCode("EUR")));
        wallets.add(new Wallet(2L,new BigDecimal(20.50),currencyRepository.getByCurrencyCode("USD")));
        walletRepository.saveAll(wallets);


        //Mock Transaction
        List<Transaction> transactions = new ArrayList<>();
        transactions.add(new Transaction(new BigDecimal(22.5),transactionTypeRepository.findAllByType("C"),new Wallet(1L),currencyRepository.getByCurrencyCode("EUR"),1L,2L,"add money"));
        transactionRepository.saveAll(transactions);


        //tokenManager.generateToken("mevlut1")

        //encoder.matches("123", user.getPassword());


    }


}
