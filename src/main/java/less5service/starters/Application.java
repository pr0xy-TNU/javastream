package less5service.starters;


import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
@EnableAutoConfiguration
public class Application {

    /*@Bean
    CommandLineRunner init(IAccountRepository accountRepository, IBookRepository bookRepository){
        return (evt) -> Arrays.asList(
            "jhoeller,dsyer,pwebb,ogierke,rwinch,mfisher,mpollack,jlong".split(","))
            .forEach(
                a -> {
                    Account account = accountRepository.save(new Account(a,
                        "password"));
                    bookRepository.save(new Bookmark(account,
                        "http://bookmark.com/1/" + a, "A description"));
                    bookRepository.save(new Bookmark(account,
                        "http://bookmark.com/2/" + a, "A description"));
                });
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

    }*/

}
