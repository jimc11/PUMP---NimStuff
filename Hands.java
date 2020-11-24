package edu.sjsu;

public class Hands {
    private int [][] table; // mex values for H(row,column)

    public Hands(){
        table = new int [20][20];
        table [0] = new int[]{1, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2};
    }

    public void computeMex(int n, int k){
        NimList nl = new NimList();

        // 1a
        nl.addNim(this.table[n-1][k+1] );
        // 1b
        int [] b1 = new int[]{this.table[n-1][k] , 1};
        nl.addNim( NimList.nimSum(b1));
        // 1c
        if (n%2 == 0 && k%2 == 0)
            nl.addNim(0);
        if (n%2 == 0 && k%2 == 1)
            nl.addNim(1);
        if (n%2 == 1 && k%2 == 0)
            nl.addNim(2);
        if (n%2 == 1 && k%2 == 1)
            nl.addNim(3);
        // 1d
        if (k > 0)
            nl.addNim(this.table[n][k-1]);

        // 2a
        if (n>0)
        nl.addNim(this.table[n-1][k]);
        // 2b
        if (n > 0) {
            if ((n - 1) % 2 == 0 && (k + 1) % 2 == 0)
                nl.addNim(0);
            if ((n - 1) % 2 == 0 && (k + 1) % 2 == 1)
                nl.addNim(1);
            if ((n - 1) % 2 == 1 && (k + 1) % 2 == 0)
                nl.addNim(2);
            if ((n - 1) % 2 == 1 && (k + 1) % 2 == 1)
                nl.addNim(3);
        }
        // 2c
        if (k > 0) {
            if ((n) % 2 == 0 && (k - 1) % 2 == 0)
                nl.addNim(0);
            if ((n) % 2 == 0 && (k - 1) % 2 == 1)
                nl.addNim(1);
            if ((n) % 2 == 1 && (k - 1) % 2 == 0)
                nl.addNim(2);
            if ((n) % 2 == 1 && (k - 1) % 2 == 1)
                nl.addNim(3);
        }

        // 3a
        if (n>0) {
            if ((n - 1) % 2 == 0 && (k) % 2 == 0)
                nl.addNim(0);
            if ((n - 1) % 2 == 0 && (k) % 2 == 1)
                nl.addNim(1);
            if ((n - 1) % 2 == 1 && (k) % 2 == 0)
                nl.addNim(2);
            if ((n - 1) % 2 == 1 && (k) % 2 == 1)
                nl.addNim(3);
        }
        // 3b
        if (n>1) {
            if ((n - 2) % 2 == 0 && (k + 2) % 2 == 0)
                nl.addNim(0);
            if ((n - 2) % 2 == 0 && (k + 2) % 2 == 1)
                nl.addNim(1);
            if ((n - 2) % 2 == 1 && (k + 2) % 2 == 0)
                nl.addNim(2);
            if ((n - 2) % 2 == 1 && (k + 2) % 2 == 1)
                nl.addNim(3);
        }
        // 3c
        if (k>0) {
            if ((n + 1) % 2 == 0 && (k - 1) % 2 == 0)
                nl.addNim(0);
            if ((n + 1) % 2 == 0 && (k - 1) % 2 == 1)
                nl.addNim(1);
            if ((n + 1) % 2 == 1 && (k - 1) % 2 == 0)
                nl.addNim(2);
            if ((n + 1) % 2 == 1 && (k - 1) % 2 == 1)
                nl.addNim(3);
        }
        // 3d
        if (k>1) {
            if (n % 2 == 0 && (k - 2) % 2 == 0)
                nl.addNim(0);
            if (n % 2 == 0 && (k - 2) % 2 == 1)
                nl.addNim(1);
            if (n % 2 == 1 && (k - 2) % 2 == 0)
                nl.addNim(2);
            if (n % 2 == 1 && (k - 2) % 2 == 1)
                nl.addNim(3);
        }

        // 4a
        if (n > 1) {
            if ((n - 2) % 2 == 0 && (k + 1) % 2 == 0)
                nl.addNim(0);
            if ((n - 2) % 2 == 0 && (k + 1) % 2 == 1)
                nl.addNim(1);
            if ((n - 2) % 2 == 1 && (k + 1) % 2 == 0)
                nl.addNim(2);
            if ((n - 2) % 2 == 1 && (k + 1) % 2 == 1)
                nl.addNim(3);
        }
        // 4b
        if (n > 0 && k > 0) {
            if ((n - 1) % 2 == 0 && (k - 1) % 2 == 0)
                nl.addNim(0);
            if ((n - 1) % 2 == 0 && (k - 1) % 2 == 1)
                nl.addNim(1);
            if ((n - 1) % 2 == 1 && (k - 1) % 2 == 0)
                nl.addNim(2);
            if ((n - 1) % 2 == 1 && (k - 1) % 2 == 1)
                nl.addNim(3);
        }

        // 5
        if (n>1) {
            if ((n - 2) % 2 == 0 && k % 2 == 0)
                nl.addNim(0);
            if ((n - 2) % 2 == 0 && k % 2 == 1)
                nl.addNim(1);
            if ((n - 2) % 2 == 1 && k % 2 == 0)
                nl.addNim(2);
            if ((n - 2) % 2 == 1 && k % 2 == 1)
                nl.addNim(3);
        }
        int mex = nl.MEX();

        table[n][k] = mex;
    }

    public static void main(String[] args) {
        Hands hand = new Hands();

        for (int n = 1; n < hand.table[0].length-1; n++){ // start at 1 since 0 is filled already
            for (int k = 0; k < hand.table[0].length-1; k++){
                hand.computeMex(n,k);
            }
        }
        for (int n = 0; n < hand.table[0].length; n++){ // start at 1 since 0 is filled already
            for (int k = 0; k < hand.table[0].length; k++){
                System.out.print(hand.table[n][k]+ ", ");
            }
            System.out.println();
        }

    }
}
