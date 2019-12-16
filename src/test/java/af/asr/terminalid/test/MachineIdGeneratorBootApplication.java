package af.asr.terminalid.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({ "af.asr.*" })
public class MachineIdGeneratorBootApplication {
	public static void main(String[] args) {
		SpringApplication.run(MachineIdGeneratorBootApplication.class, args);
	}
}
