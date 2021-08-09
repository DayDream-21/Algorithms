package Chap07;

import org.w3c.dom.ls.LSOutput;

import java.util.*;

public class ShellSortApp {
    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>();

        arrayList.add(41);
        arrayList.add(26);
        arrayList.add(36);
        arrayList.add(68);
        arrayList.add(48);
        arrayList.add(18);
        arrayList.add(14);
        arrayList.add(34);
        arrayList.add(44);
        arrayList.add(59);
        arrayList.add(69);
        arrayList.add(29);

        System.out.println(shellSort(arrayList));

    }

    static List<Integer> shellSort(List<Integer> arrayList) {
        Integer[] theArray = arrayList.toArray(new Integer[0]);

        int nElems = theArray.length;
        int h = 1;

        while (h <= nElems / 3) {
            h = h * 3 + 1;
        }

        int inner, outer, temp;

        while (h > 0) {
            for (outer = h; outer < nElems; outer++) {
                temp = theArray[outer];
                inner = outer;

                while (inner > h - 1 && theArray[inner - h] >= temp) {
                    theArray[inner] = theArray[inner - h];
                    inner -= h;
                }
                theArray[inner] = temp;
            }
            h = (h - 1) / 3;
        }

        return Arrays.asList(theArray);
    }
}


