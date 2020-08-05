package  io.pactflow.example.xml.todo;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@CrossOrigin(origins = { "*" })
@RequestMapping(value = "/", produces = MediaType.APPLICATION_XML_VALUE)
class ProjectController {

  private final ProjectsRepository repository;

  ProjectController(ProjectsRepository repository) {
    this.repository = repository;
  }

  @GetMapping("/projects")
  Projects all() {
    return repository.getProjects();
  }

  // @PostMapping("/projects")
  // Project newProject(@RequestBody Project newProject) {
  //   return repository.save(newProject);
  // }

  // @GetMapping({ "/project/{id}" })
  // Project one(@PathVariable Long id) {

  //   return repository.findById(id).orElseThrow(() -> new ProjectNotFoundException(id));
  // }

  // @PutMapping({ "/project/{id}" })
  // Project replaceProject(@RequestBody Project newProject, @PathVariable Long id) {

  //   return repository.findById(id).map(Project -> {
  //     Project.setName(newProject.getName());
  //     Project.setType(newProject.getType());
  //     return repository.save(Project);
  //   }).orElseGet(() -> {
  //     newProject.setId(id);
  //     return repository.save(newProject);
  //   });
  // }

  // @DeleteMapping({ "/project/{id}" })
  // void deleteProject(@PathVariable Long id) {
  //   repository.deleteById(id);
  // }
}