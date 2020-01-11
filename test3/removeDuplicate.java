import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class removeDuplicate {
    public static void main(String[] args){
        ArrayList<Integer> list = new ArrayList<>();
        Scanner input = new Scanner(System.in);

        int n, a;
        System.out.print("Enter the length of list: ");
        n = input.nextInt();
        System.out.print("Enter the list: ");
        for(int i = 0; i < n; ++i){
            a = input.nextInt();
            list.add(a);
        }

        removeDuplicate(list);
        System.out.print("List after removing deplicate: ");
        for(int i = 0; i < list.size(); ++i){
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }

    public static void removeDuplicate(ArrayList<Integer> list){
        for(int i = 0; i < list.size(); ++i){
            for(int j = 0; j < i; ++j){
                if(Objects.equals(list.get(j), list.get(i))){
                    list.remove(i);
                    i--;
                    break;
                }
            }
        }
    }

}

