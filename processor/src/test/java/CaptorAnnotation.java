import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CaptorAnnotation {

    @Mock
    List<String> list  = new ArrayList<>();

    @Captor
    ArgumentCaptor argumentCaptor;

    @Test
    void test() {
        list.add("test");
        Mockito.verify(list).add(String.valueOf(argumentCaptor.capture()));//достаем то, что было добавлено в методе

        Assert.assertEquals("test", argumentCaptor.getValue());
    }
}
