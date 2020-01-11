import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
public class Test3 {
    public static void main(String[] args){
        int[] a = new int[100];
        Random random = new Random(10);
        Scanner input = new Scanner(System.in);
        boolean getNext = true;
        for(int i = 0; i < 100; ++i){
            a[i] = random.nextInt(100);
        }

        while(getNext){
            try {
                System.out.print("Enter a index: ");
                int index = input.nextInt();
                if(index < 0 || index >= 100)
                    throw new IndexOutOfBoundsException();

                System.out.println("Element a[" + index + "] is " + a[index]);
                getNext = false;
            }
            catch(InputMismatchException ex1){
                System.out.println("Input Mismatch.");
                input.nextLine();
            }
            catch(IndexOutOfBoundsException ex2){
                System.out.println("Out of Bounds.");
                input.nextLine();
            }
        }
    }

}
