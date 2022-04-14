package springBootTests;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.gerch.justpractice.JustPracticeApplication;
import ru.gerch.justpractice.models.Human;
import ru.gerch.justpractice.models.Profession;
import ru.gerch.justpractice.repository.HumanRepository;
import ru.gerch.justpractice.repository.ProfessionRepository;

@SpringBootTest(classes = JustPracticeApplication.class)
@RunWith(SpringRunner.class)
public class HumanServiceTest {

    @Autowired
    private HumanRepository humanRepository;
    @Autowired
    private ProfessionRepository professionRepository;

    public long init() {
        Profession profession = new Profession();
        profession.setId(12312312213L);
        profession.setName("Dev");
        profession.setSalary(150);
        Human human = new Human();
        human.setId(493276598L);
        human.setName("qwe");
        human.setAge(22);
        human.setSecondName("zxc");
        human.setProfession(profession);
        professionRepository.save(profession);
        humanRepository.save(human);
        return human.getId();
    }

    @Test
    public void humanTest() {
        long id = init();
        Human actualHuman = humanRepository.findHumanById(id);
        Assert.assertEquals(id, actualHuman.getId());
    }
}
