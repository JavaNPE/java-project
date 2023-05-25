package main.java.com.youliao.java;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author Dali
 * @Date 2021/5/30 23:31
 * @Version 1.0
 * @Description: 键盘输入数字对其进行冒泡排序
 */
public class BubbleSortMain {
    public static void main(String[] args) {
        //1、键盘录入
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入一串用英文逗号隔开的整数：");
        String input = scanner.next();
        String[] string = input.split(",");
        int[] nums = new int[string.length];
        System.out.print("数字转换格式后：");
        for (int i = 0; i < string.length; i++) {
            //将字符串参数作为有符号的十进制整数进行解
            nums[i] = Integer.parseInt(string[i]);
            System.out.print(nums[i] + ",");

        }
        bubbleSort(nums);   //冒泡排序
        System.out.println();
        System.out.print("冒泡排序之后：" + Arrays.toString(nums));
    }

    /**
     * 冒泡排序
     *
     * @param arr
     */
    private static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
