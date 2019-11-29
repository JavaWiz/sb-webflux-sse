## Spring Boot WebFlux + Thymeleaf reactive example

Spring Boot will configure everything, and the key is using the Thymeleaf ReactiveDataDriverContextVariable to enable the data-driven mode in Thymeleaf template.

We have to wraps the data with ReactiveDataDriverContextVariable, it will enable the reactive data-driven model in Thymeleaf template.

```
import com.javawiz.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.spring5.context.webflux.IReactiveDataDriverContextVariable;
import org.thymeleaf.spring5.context.webflux.ReactiveDataDriverContextVariable;

@Controller
public class MovieController {

    @Autowired
    private MovieRepository movieRepository;

    @RequestMapping("/")
    public String index(final Model model) {

        // loads 1 and display 1, stream data, data driven mode.
        IReactiveDataDriverContextVariable reactiveDataDrivenMode =
                new ReactiveDataDriverContextVariable(movieRepository.findAll(), 1);

        model.addAttribute("movies", reactiveDataDrivenMode);
        return "index";
    }
}
```