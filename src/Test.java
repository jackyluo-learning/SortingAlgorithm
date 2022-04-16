import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;

import java.sql.Time;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.TimeUnit;


public class Test {
    private static int[] a = new int[100];
    private static int[] testArray;
    private static int[] resultArray;
    private long l;

    @Rule
    public TestName name = new TestName();


    static {
        Random random = new Random();
        for (int t = 0; t < a.length; t++) a[t] = (random.nextInt(10000));
        testArray = Arrays.copyOf(a, a.length);
        Arrays.sort(a);
    }

    @Before//在每个测试方法之前运行
    public void testBegin(){
        l = System.currentTimeMillis();
    }


    @org.junit.Test
    public void testBS(){
        resultArray = BS.BS(testArray);
        Assert.assertArrayEquals(a, resultArray);
    }

    @org.junit.Test
    public void testSS(){
        resultArray = SS.selectionSort(testArray);
        Assert.assertArrayEquals(a, resultArray);
    }

    @org.junit.Test
    public void testIS(){
        resultArray = IS.insertionSort(testArray);
        Assert.assertArrayEquals(a, resultArray);
    }

    @org.junit.Test
    public void testMS(){
        resultArray = MS.merageSort(testArray);
        Assert.assertArrayEquals(a, resultArray);
    }

    @org.junit.Test
    public void testQS(){
        resultArray = QS.quickSort(testArray);
        Assert.assertArrayEquals(a, resultArray);
    }

    @After//在每个方法之后运行
    public void testEnd(){
        l=System.currentTimeMillis()-l;
//        System.out.println("\nInput: "+Arrays.toString(testArray));
        System.out.println(name.getMethodName()+" run for "+l+"ms");
//        System.out.println(String.format("%s result: %s", name.getMethodName(), Arrays.toString(resultArray)));
    }

}
