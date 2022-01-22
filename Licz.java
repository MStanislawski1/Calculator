package main;

public class Licz {
    public float calculate (long Number1, long Number2, String operator){
        switch (operator){
            case"+":
                return Number1+Number2;
            case "-":
                return Number1-Number2;
            case "*":
                return Number1*Number2;
            case "/":
                if(Number2==0)
                    return 0;
                return Number1-Number2;
            default:
                return 0;
        }
    }
}
