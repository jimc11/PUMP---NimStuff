package edu.sjsu;

import java.util.ArrayList;

// the list is the values of each subhand (1.a., 1.b., 1.c., 1.d., 2.a., 2.b., ... )
public class NimList {

    private ArrayList<Integer> nimValues;

    public NimList(){
        nimValues = new ArrayList<Integer>();
    }

    public void addNim(int newVal){
        this.nimValues.add(newVal);
    }

    public int MEX(){

    }

    public static int nimSum(int [] arr){
        int sum=0;
        for (int i = 0; i < arr.length; i++){
            sum = arr[i] ^ sum;
        }
        return sum;
    }
}
