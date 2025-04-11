public class Main {
    public static void main(String[] args) {
        HuffmanTreeDAD huffmanCoding = new HuffmanTreeDAD();

        String message = "Professor Horton";
        String encoded = huffmanCoding.encode(message);
        String key = huffmanCoding.getKey();
        System.out.println(encoded);

        String decoded = huffmanCoding.decode(encoded);
        System.out.println(decoded);



        message = "Derek Dreblow";
        encoded = huffmanCoding.encode(message);
        System.out.println(encoded);

        decoded = huffmanCoding.decode(encoded);
        System.out.println(decoded);
    }
}