import static org.junit.Assert.*;
import org.junit.Test;
public class TestArrayDequeGold {

    @Test
    public void test1(){
        StudentArrayDeque<Integer> sad1 = new StudentArrayDeque<>();

        for (int i = 0; i < 10; i += 1) {
        Integer  numberBetweenZeroAndOne = StdRandom.uniform(100);
        double te=StdRandom.uniform();
        if (te < 0.5) {
            sad1.addLast(numberBetweenZeroAndOne);
        } else {
            sad1.addFirst(numberBetweenZeroAndOne);
        }
    }

        sad1.printDeque();
    }
    @Test
    public void test2(){
        StudentArrayDeque<Integer> sad1 = new StudentArrayDeque<>();

        for (int i = 0; i < 10; i += 1) {
            Integer  numberBetweenZeroAndOne = StdRandom.uniform(100);
            double te=StdRandom.uniform();
            if (te < 0.5) {
                sad1.addLast(numberBetweenZeroAndOne);
                Integer actual = sad1.removeFirst();
                assertEquals("Oh noooo!\nThis is bad:\n   Random number " + actual
                                + " not equal to " + numberBetweenZeroAndOne + "!",
                        numberBetweenZeroAndOne, actual);
            } else {
                sad1.addFirst(numberBetweenZeroAndOne);
                Integer actual = sad1.removeLast();
                assertEquals("Oh noooo!\nThis is bad:\n   Random number " + actual
                                + " not equal to " + numberBetweenZeroAndOne + "!",
                        numberBetweenZeroAndOne, actual);

            }

        }

    }
    @Test
    public void test3(){
        StudentArrayDeque<Integer> sad2 = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> sad3 = new ArrayDequeSolution<>();
        String failsequence = new String();
        for(int i=0;i<200;i+=1){
            if(i%5==0){
                failsequence+="size()\n";
                assertEquals(failsequence,sad3.size(),sad2.size());
            }
           double  numberBetweenZeroAndOne = StdRandom.uniform();
            if(numberBetweenZeroAndOne>0.75){
                sad2.addFirst(i);
                sad3.addFirst(i);
                failsequence+="addFirst("+i+")\n";
                assertEquals(failsequence,sad3.get(0),sad2.get(0));
            }else if(numberBetweenZeroAndOne>0.5){
                sad2.addLast(i);
                sad3.addLast(i);
                failsequence+="addLast("+i+")\n";
                assertEquals(failsequence,sad3.get(sad3.size()-1),sad2.get(sad3.size()-1));
            }else if(numberBetweenZeroAndOne>0.25){
                if(!sad2.isEmpty()&&!sad3.isEmpty()){
                Integer num1=sad2.removeFirst();
                Integer num2=sad3.removeFirst();
                failsequence = failsequence + "removeFirst()\n";
                assertEquals(failsequence,num2,num1);


                }
            }else{
                if(!sad2.isEmpty()&&!sad3.isEmpty()) {
                    Integer num1 = sad2.removeLast();
                    Integer num2 = sad3.removeLast();
                    failsequence = failsequence + "removeLast()\n";
                    assertEquals(failsequence, num2, num1);


                }
            }

        }
    }

}
