package home;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;

public class Create_array {
    public ArrayList<Integer> arr = new ArrayList<>();
    private Random random = new Random();
    public Create_array() {
        Scanner input = new Scanner(System.in);
        System.out.print("Input a shape array: ");
        int arr_size = 0;
        while (arr_size < 10){
            try {
                arr_size = input.nextInt();
                if (arr_size < 10) {
                    System.out.println("size array have been more 10 elements");
                    input.nextLine();
                }
            } catch (InputMismatchException e) {
                System.out.println("Please give me positive number)");
                input.nextLine();
            }

        }
        input.close();
        setArr(arr_size);
        deleteRandomElementArray();
        shuffleArray();
        findMissingElement();
    }

    public void setArr(int arr_size) {
        for(int i=1; i<=arr_size; i++) {
            this.arr.add(i);
        }
    }
    private void deleteRandomElementArray () {
        int elm = random.nextInt(arr.size()-1);
        arr.remove(elm);
        System.out.println(elm  + 1 + " is removing");
    }

    private void shuffleArray() {
        int randomIndex;
        int temp;
        for (int i = 0; i<arr.size(); i++) {
            randomIndex = random.nextInt(arr.size()-1);
            temp = arr.get(randomIndex);
            arr.set(randomIndex, arr.get(i));
            arr.set(i, temp);
        }
    }

    private void findMissingElement () {
        int sumArrayBefore = (1 + (arr.size()+1))*(arr.size()+1)/2;
        int sumArrayAfter  = arr.stream().mapToInt(Integer::intValue).sum();
        int s = sumArrayBefore-sumArrayAfter;
        System.out.println("number "+ s + " is removing");
    }
}
