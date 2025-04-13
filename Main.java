public class Main {
    public static void main(String[] args) {
        HuffmanTreeDAD huffmanCoding = new HuffmanTreeDAD();

        String message = "Professor Horton";
        String encoded = huffmanCoding.encode(message);
        String key = huffmanCoding.getKey();
        System.out.println("Encoded: " + encoded);
        System.out.println("key: " + key);

        HuffmanTreeDAD decoder = new HuffmanTreeDAD(key);
        String decoded = decoder.decode(encoded);
        System.out.println("Decoded: " + decoded);

        System.out.println("");

        message = "Derek Dreblow";
        encoded = huffmanCoding.encode(message);
        key = huffmanCoding.getKey();
        System.out.println("Encoded: " + encoded);
        System.out.println("key: " + key);

        HuffmanTreeDAD decoderDAD = new HuffmanTreeDAD(key);
        String decodedDAD = decoderDAD.decode(encoded);
        System.out.println("Decoded: " + decodedDAD);
    }
}