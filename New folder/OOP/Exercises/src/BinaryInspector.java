
public class BinaryInspector {
    public static void inspectShort(short number) {
        short mask = (short) (1 << 15); 

        System.out.println("Binary representation of " + number + " (2 bytes):");
        for (int i = 0; i < 16; i++) { 
            if ((number & mask) != 0) {
                System.out.print("1");
            } else {
                System.out.print("0");
            }
            mask >>= 1;
        }
        System.out.println(); 
    }

    public static void main(String[] args) {
        short exampleNumber = 289; 
        inspectShort(exampleNumber); 
    }
}
