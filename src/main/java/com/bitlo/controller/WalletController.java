package com.bitlo.controller;

import com.bitlo.repository.WalletRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WalletController extends ApiController {

    private final WalletRepository walletRepository;

    private static final String ENTITY_NAME = "Wallet";

    public WalletController(WalletRepository walletRepository) {
        this.walletRepository = walletRepository;
    }

}
