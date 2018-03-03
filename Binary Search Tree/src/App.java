import java.util.*;
public class App {

    static void insertionSort(int[] list)
    {
        int comps = 0;
        int swaps = 0;
        boolean didSwap = true;

        for(int j = 0; j < list.length - 1 && didSwap; j++) {
            didSwap = false;

            for(int i = 0; i < list.length - 1 - j; i++) {

                comps++;

                if(list[i] > list[i+1]) {

                    didSwap = true;

                    int temp = list[i];
                    list[i] = list[i + 1];
                    list[i + 1] = temp;

                    swaps++;
                }
            }
        }

        System.out.println(comps-swaps);
    }

    public static void main(String[] v){

        Scanner s = new Scanner(System.in);
        int test = s.nextInt();

        while (test-- >0){
            int n = s.nextInt();
            int[] a = new int[n];
            for (int i=0;i<n;i++){
                a[i] = s.nextInt();
            }
            insertionSort(a);

        }


    }

}
