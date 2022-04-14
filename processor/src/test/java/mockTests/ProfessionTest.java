package mockTests;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import ru.gerch.justpractice.models.Profession;
import ru.gerch.justpractice.repository.ProfessionRepository;
import ru.gerch.justpractice.service.ProfessionService;

//Лучший способ Подключение Мокито!
@RunWith(MockitoJUnitRunner.class)
public class ProfessionTest {

    // Второй способ подключения Мокито
    //@Rule
    //    public MockitoRule initRule = MockitoJUnit.rule();
    //Есть и третий способ, но он уже депрекейтид

    @Mock
    private ProfessionRepository professionRepository;

    @InjectMocks
    private ProfessionService professionService;

    @Test
    public void test() {
        Profession profession = getProfession();
        Mockito.when(professionRepository.findProfessionById(Mockito.anyLong())).thenReturn(profession);

        String actualName = professionService.getProfessionNameById(10);
        Assert.assertEquals(profession.getName(), actualName);
    }

    public Profession getProfession() {
        Profession profession = new Profession();
        profession.setName("Manager");
        profession.setSalary(100000);
        profession.setId(10);
        return profession;
    }

}
