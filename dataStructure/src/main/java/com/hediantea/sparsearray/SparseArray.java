package com.hediantea.sparsearray;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;

/**
 * @Author HedianTea
 * @Date 2022/6/19 17:10
 * @Version 1.0
 * @Description: 二维数组与稀疏数组互转代码案例
 */
@Slf4j
public class SparseArray {
    @Test
    public void testSparseArray() {
        // 创建一个原始的二维数组 11 * 11
        // 0: 表示没有棋子，1: 表示 黑子， 2: 表示蓝子
        int[][] chessArray1 = new int[11][11];
        chessArray1[1][2] = 1;
        chessArray1[2][3] = 2;

        // 快速打印一个二维数组的数据元素列表
        // System.out.println(Arrays.deepToString(chessArray1));
        // 输出原始的二维数组： for each 循环语句不能自动处理二维数组的每一个元素，他会循环处理行，而这些行本身就是一个一维数组。想要访问二维数组chessArray1的所有元素，需要使用两个嵌套的循环。
        System.out.println("原始的二维数组为：");
        printfChessArray(chessArray1);
        /**
         * 一、将二维数组转成稀疏数组
         *  1.遍历原始的二维数组，得到有效数据的个数sum;
         *  2、根据sum创建稀疏数组sparseArr: int[sum + 1][3];
         *  3、将二维数组中的有效数据存入到 稀疏数组中;
         */

        // sum表示有效数据的个数
        int sum = 0;
        for (int i = 0; i < chessArray1.length; i++) {
            for (int j = 0; j < chessArray1[i].length; j++) {
                if (chessArray1[i][j] != 0) {
                    sum++;
                    System.out.println("二维数组中有效数据的坐标为：" + "(" + i + "," + j + "),值为" + chessArray1[i][j]);
                }
            }
        }
        System.out.println("二维数组中有效数据的个数sum：" + sum);
        // 2、根据sum创建稀疏数组sparseArr: int[sum + 1][3];
        int[][] sparseArr = new int[sum + 1][3];    //3*3

        // 3、将二维数组中的有效数据存入到 稀疏数组中
        // 初始化第一行
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = sum;
        // System.out.println(Arrays.deepToString(sparseArr));

        // 遍历二维数组，将非0的值存入到稀疏数组中去
        int count = 0;  // count用于记录是第几个非0数据
        for (int i = 0; i < chessArray1.length; i++) {
            for (int j = 0; j < chessArray1[i].length; j++) {
                if (chessArray1[i][j] != 0) {
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][sum] = chessArray1[i][j];
                }
            }
        }
        System.out.println();
        System.out.println("将二维数组转换成稀疏数组之后：");
        for (int i = 0; i < sparseArr.length; i++) {
            System.out.printf("%d\t%d\t%d\t\n", sparseArr[i][0], sparseArr[i][1], sparseArr[i][2]);
        }
        System.out.println(Arrays.deepToString(sparseArr));

        /**
         * 二、稀疏数组转原始的二维数组
         *      1. 先读取稀疏数组的第一行，根据第一行的数据，创建原始的二维数组，比如上面的  chessArr2 = int [11][11]
         *      2. 在读取稀疏数组后几行的数据，并赋给 原始的二维数组 即可。
         *          row col value
         *          11	11	2
         *          1	2	1
         *          2	3	2
         */

        // 1、读取稀疏数字的第一行，创建原始数组
        int row = sparseArr[0][0];    // 二维数组有几行
        int col = sparseArr[0][1];    // 二维数组有几列
        int val = sparseArr[0][2];    // 有几个非0的数据
        // 根据第一行的数据创建原始二维数组
        int[][] chessArray2 = new int[row][col];

        // 2、遍历稀疏数组，读取稀疏数组后几行的数据，赋值给二维数组
        for (int i = 1; i < sparseArr.length; i++) {
            int someRow = sparseArr[i][0];  // 代表二维数组的第几行
            int someCol = sparseArr[i][1];  // 代表二维数组的第几列
            int someVal = sparseArr[i][2];  // 代表二维数组所处位置的值
            chessArray2[someRow][someCol] = someVal;
        }
        System.out.println();
        System.out.println("将稀疏数组转换成的二维数组如下：");
        printfChessArray(chessArray2);
    }

    /**
     * 按照特殊格式打印二维数组
     *
     * @param chessArray
     */
    private void printfChessArray(int[][] chessArray) {
        for (int[] rows : chessArray) {
            for (int value : rows) {
                System.out.printf("%d\t", value);
            }
            System.out.println();
        }
    }
}
