package com.caneda.springboot.service.interfaces;

import com.caneda.springboot.dto.UserResponseDTO;

// SOLID: DIP - controllers depend on this abstraction not concrete class
// SOLID: ISP - contains only wallet operations, separated from user operations
// SOLID: OCP - new wallet behavior added without modifying this interface
public interface IWalletService {
    UserResponseDTO processWallet(long id, float amount, WalletOperation operation);
}