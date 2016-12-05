package ua.dp.daragan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ua.dp.daragan.entities.Task;
import ua.dp.daragan.repos.Tasks;

@SpringBootApplication
public class TodoListApplication implements CommandLineRunner
{
	@Autowired
	private Tasks tasksRepo;

	public static void main(String[] args) {
		SpringApplication.run(TodoListApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
		tasksRepo.save(new Task(null, "Name0", "HIGH"));
		tasksRepo.save(new Task(null, "Name2", "DEFAULT"));
		tasksRepo.save(new Task(null, "Name1", "LOW"));
	}
}