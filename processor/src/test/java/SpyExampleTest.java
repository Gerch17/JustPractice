import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class SpyExampleTest {
    //эта аннотация позволяет следить за поведением объекта
    @Spy
    List<String> list = new ArrayList<>();

    @Test
    void test() {
        list.add("example");
        list.size();
        list.isEmpty();

        //проверяет, вызывался ли указанный метод
        Mockito.verify(list).add("example");
        Mockito.verify(list).add(Mockito.anyString()); // вызывался ли метод добавления любой строки
        Mockito.verify(list).add(Mockito.any(String.class));// вызывался ли метод добавления любой строки(другой способ записи)

        //проверка, сколько раз вызывался метод со строки 18
        Mockito.verify(list, Mockito.times(1)).add("example");
        Mockito.verify(list, Mockito.atLeast(1)).size(); //вызывался ли хотя бы раз
        Mockito.verify(list, Mockito.atMost(100)).size(); //вызывался не более 100 раз
        Mockito.verify(list, Mockito.never()).clear();//что метод никогда не вызывался

        //проверяет, в таком ли порядке вызывались методы
        InOrder inOrder = Mockito.inOrder(list);
        inOrder.verify(list).add("example");
        inOrder.verify(list).size();
        inOrder.verify(list).isEmpty();
    }
}
