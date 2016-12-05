package ua.dp.daragan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.dp.daragan.entities.Task;
import ua.dp.daragan.repos.Tasks;

/**
 * Created by Bogdan Daragan on 05.12.16.
 */
@RestController
public class Controller {

    @Autowired
    private Tasks tasksRepo;

    @RequestMapping(value = "/tasks")
    public Iterable<Task> getTasks(){
        return tasksRepo.findAll();
    }

    @RequestMapping(value = "/tasks/delete/{id}", method = RequestMethod.POST)
    public void deleteTask(@PathVariable long id) {
        tasksRepo.delete(id);
    }

    @RequestMapping(value = "/tasks/add", method = RequestMethod.POST)
    public void message(@RequestParam(value = "name", required = true) String name,
                        @RequestParam(value = "priority", required = true) String priority) {

        if(name.isEmpty() || priority.isEmpty() ) return;
        tasksRepo.save(new Task(null, name, priority) );
    }
}