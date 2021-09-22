package com.bitlo.controller;

import com.bitlo.repository.WalletRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WalletController extends ApiController {

    private final WalletRepository walletRepository;

    public WalletController(WalletRepository walletRepository) {
        this.walletRepository = walletRepository;
    }

}
