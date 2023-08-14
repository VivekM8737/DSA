import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class swapInterval {
    public static class Pair implements Comparable<Pair> {
        int st;
        int ed;

        public Pair(int st, int ed) {
            this.st = st;
            this.ed = ed;
        }

        public int compareTo(Pair other) {
            if (this.st != other.st) {
                return this.st - other.st;
            } else {
                return this.ed - other.ed;

            }
        }
    }

    public static void creatPairArr(int[][] arr) {
        Pair[] pairs = new Pair[arr.length];
        for (int i = 0; i < arr.length; i++) {
            pairs[i] = new Pair(arr[i][0], arr[i][1]);
        }
        Arrays.sort(pairs);
        Stack<Pair> pSt = new Stack<>();
        pSt.push(pairs[0]);
        int x = arr.length;
        int i = 1;
        while (x > 1) {

            if (pSt.peek().ed >= pairs[i].st) {
                Pair p1 = pSt.pop();
                if (p1.ed >= pairs[i].ed) {

                } else {
                    p1.ed = pairs[i].ed;
                }
                pSt.push(p1);
            } else {
                pSt.push(pairs[i]);
            }

            i++;
            x--;
        }
        // System.out.println(pSt.size());

        int[][] arr1 = new int[pSt.size()][2];
        int j = 0;
        while (pSt.size() > 0) {
            arr1[j][0] = pSt.peek().st;
            arr1[j][1] = pSt.peek().ed;
            // System.out.println(pSt.peek().st+" "+pSt.peek().ed);
            pSt.pop();
            j++;
        }
        for (int k = arr1.length - 1; k >= 0; k--) {
            System.out.println(arr1[k][0] + " " + arr1[k][1]);
        }
    }

    public static void main(String[] args) {
        System.out.print("Enter the length of arr: ");
        Scanner s1 = new Scanner(System.in);
        int len = s1.nextInt();
        int[][] arr = new int[len][2];
        System.out.print("Enter the value of arr: ");
        for (int i = 0; i < len; i++) {
            arr[i][0] = s1.nextInt();
            arr[i][1] = s1.nextInt();
        }
        creatPairArr(arr);
    }
}
