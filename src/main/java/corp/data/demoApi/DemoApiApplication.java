package corp.data.demoApi;

import corp.data.demoApi.repositories.ClienteRepositoryImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class DemoApiApplication {
	public static BplusTree btree;

	public static void main(String[] args) {
		SpringApplication.run(DemoApiApplication.class, args);
		DemoApiApplication.btree = new BplusTree(3);
		ClienteRepositoryImpl clienteRepositoryImpl = new ClienteRepositoryImpl();
		clienteRepositoryImpl.completeFileRead();
	}

}
