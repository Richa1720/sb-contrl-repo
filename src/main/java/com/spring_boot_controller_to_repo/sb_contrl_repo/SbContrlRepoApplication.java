package com.spring_boot_controller_to_repo.sb_contrl_repo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SbContrlRepoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbContrlRepoApplication.class, args);
		System.out.println("Hi, change 1 ... to sb-ctrl-rep-new-branch....");
		System.out.println("Hi, change 2 ... to sb-ctrl-rep-new-branch....");
		System.out.println("Hello, Change 3 ... after pull request....");
	}

}
