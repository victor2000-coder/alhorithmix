package com.company;

import com.company.Code.BynaryTree.SortedBinaryTree;
import com.company.Code.PrefTree;
import com.company.SortingAlhorithms.UniversalSorts;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;

import static com.company.DiscreteMath.Combinatorics.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Integer[] arr = new Integer[] {10, 4, 2, 6, 3, 5, 7};
        for (int i: UniversalSorts.sortFF(arr, Integer::compareTo)){
            System.out.println(i);
        }




        /*
        SortedBinaryTree tree = new SortedBinaryTree();
        ArrayList<Integer> ints = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            ints.add(i);
        }
        tree.add(ints.toArray(new Integer[1000]));
        tree.draw(0);

         */
        /*
        PrefTree.TreeNode root = new PrefTree.TreeNode(' ');
        ArrayList<String> arr = new ArrayList<>();
        root.getAllNumbers("", arr);
        File input = new File("src/com/company/Code/data");
        FileReader reader = new FileReader(input);
        BufferedReader bReader = new BufferedReader(reader);
        String temp = bReader.readLine();
        while (temp != null){
            root.insert(temp);
            temp = bReader.readLine();
        }
        root.recursionDraw(0);
        PrefTree.writeToFile("src/com/company/Code/encoded", root);

         */
    }
}
