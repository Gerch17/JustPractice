package mockTests;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import ru.gerch.justpractice.models.Human;
import ru.gerch.justpractice.models.Profession;
import ru.gerch.justpractice.repository.HumanRepository;
import ru.gerch.justpractice.service.HumanService;

@RunWith(MockitoJUnitRunner.class)
public class InjectMockTest {
    //что мокаем
    @Mock
    private HumanRepository humanRepository;

    //куда ставим эти моки
    @InjectMocks
    private HumanService humanService;

    @Test
    public void test() {
        Human human = getHuman();
        Mockito.when(humanRepository.findHumanById(1)).thenReturn(human);
        Human actualHuman = humanService.changeName(1, "Ann");
        Assert.assertEquals("Ann", actualHuman.getName());
    }

    private Human getHuman() {
        Profession profession = new Profession();
        profession.setId(1);
        profession.setName("Dev");
        profession.setSalary(150);
        Human human = new Human();
        human.setName("qwe");
        human.setAge(22);
        human.setSecondName("zxc");
        human.setProfession(profession);
        return human;
    }
}
