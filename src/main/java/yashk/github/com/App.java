package yashk.github.com;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        System.out.println(5|3|1);
    }

    /**
     * if input consist of all unique characters
     * @param input
     * @return
     */
    public static boolean  hasAllUniqueChars(String input){
        boolean [] char_set = new boolean[256];

        for(char c : input.toCharArray()){
            if(char_set[(int)c]) {
                return false;
            }
            char_set[(int)c] = true;

        }
        return true;
    }

    /**
     * reverse a string
     * @param input
     * @return
     */
    public static String reverse(String input){
        char [] input_array = input.toCharArray();


        if(input_array.length == 1){
            return input;
        }

        int start = 0;
        int end = input_array.length -1;
        char tmp;
        while(start < end){
            tmp = input_array[start];
            input_array[start] = input_array[end];
            input_array[end] = tmp;
            start ++;
            end --;
        }
        return new String(input_array);

    }


    public boolean anagrams(String f,String s){
         //f.chars().collect(groupingBy(i -> i, counting()));

        return false;

    }
}
