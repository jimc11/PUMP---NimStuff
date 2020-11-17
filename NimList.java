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

    //Uses boolean list to calculate the MEX value of a hand
    //Assuming that the list of nim values is ordered from least to greatest ex.[0,1,2,4]
    public int MEX(ArrayList<Integer> nValues)
    {
     	int mexValue=0;
     	
     	//get the length equal to the last nim value in an array
     	//(should be the largest nim value)
    	int size = nValues.get(nValues.size()-1);
    	
    	//create an ArrayList of booleans 
    	ArrayList<Boolean> booleans = new ArrayList<Boolean>(size);
    	
    	
    	for (int i = 0; i < size-1; i++)
    	{
    		if (nValues.contains(i))
    		{
    			booleans.set(i, true);
    		}
    		else
    		{
    			booleans.set(i, false);
    		}
    	}
    	
        //Go through boolean list to find first false
    	for (int j = 0; j <size-1; j++)
    	{
    		if (booleans.get(j)==false)
    		{
    			mexValue = j;
    			break;
    		}
    	}
    	return mexValue;
    }

    public static int nimSum(int [] arr){
        int sum=0;
        for (int i = 0; i < arr.length; i++){
            sum = arr[i] ^ sum;
        }
        return sum;
    }
}
