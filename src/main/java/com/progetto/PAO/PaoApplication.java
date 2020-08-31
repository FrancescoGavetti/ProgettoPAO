package com.progetto.PAO;

import com.progetto.PAO.utils.ConnectDropbox;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PaoApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaoApplication.class, args);
		ConnectDropbox.request();
	}

}
