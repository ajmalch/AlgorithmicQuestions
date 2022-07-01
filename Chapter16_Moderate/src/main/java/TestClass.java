import static java.lang.Math.sqrt;

public class TestClass {

    public static void main(String[] args) {

        System.out.println(largesPrimeFactor(600851475143L));

    }

    static long largesPrimeFactor(long n){

        long largestPrimeFactor = 0;
        if(n%2==0){
            largestPrimeFactor =2;
            n=n/2;
        }

        for(long i=3; i< sqrt(n) ; i++){

            if(n%i == 0){
                largestPrimeFactor = i;
                n= n/i;
            }
        }

        if(n>2)
            largestPrimeFactor = n;
        return largestPrimeFactor;


    }
}
