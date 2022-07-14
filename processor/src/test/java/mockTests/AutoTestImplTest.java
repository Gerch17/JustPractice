package mockTests;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import ru.gerch.justpractice.service.AutoTestImpl;
import ru.gerch.justpractice.service.Calculate;

@RunWith(MockitoJUnitRunner.class)
public class AutoTestImplTest {
    @Mock
    AutoTestImpl autoTest;

    @InjectMocks
    Calculate calculate;

    @Test
    void CalculateTest() {
        Mockito.when(autoTest.createAutoTest()).thenReturn(true);

        String actual = calculate.calculateTests();

        Assert.assertEquals("OK", actual);
    }
}
