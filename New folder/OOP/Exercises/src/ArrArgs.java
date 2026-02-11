
class ArrArgs {
    static int mul(int a, int b) {
        return a * b;
    }

    public static void main(String[] args) {
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);

        int product = mul(a, b);

        System.out.printf("The product of %d and %d is %d", a, b, product);
    }
}
