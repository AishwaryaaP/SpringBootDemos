/**
 * 
 */
package com.eazybytes.accounts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.eazybytes.accounts.AccountServiceConfig;
import com.eazybytes.accounts.model.Accounts;
import com.eazybytes.accounts.model.Customer;
import com.eazybytes.accounts.model.Properties;
import com.eazybytes.accounts.repository.AccountsRepository;

/**
 * @author Aish Bytes
 *
 */

@RestController
public class AccountsController {
	
	@Autowired
	private AccountServiceConfig accountServiceConfig;
	
	@Autowired
	private AccountsRepository accountsRepository;
	
	@GetMapping("/accounts/properties")
	public Properties getPropertyDetails() {
		Properties properties = new Properties(accountServiceConfig.getMsg(), accountServiceConfig.getBuildVersion(), accountServiceConfig.getMailDetails(), accountServiceConfig.getActiveBranches());
		return properties;
	}

	@PostMapping("/myAccount")
	public Accounts getAccountDetails(@RequestBody Customer customer) {
		
		accountsRepository.findAll()
			.forEach(c -> System.out.println(c));

		Accounts accounts = accountsRepository.findByCustomerId(customer.getCustomerId());
		
		if (accounts != null) {
			return accounts;
		} else {
			return null;
		}

	}

}
