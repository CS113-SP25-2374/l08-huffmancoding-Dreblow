import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class HuffmanTreeDAD implements HuffmanInterface {

    // Private Internal Class
    private class HuffmanNode implements Comparable<HuffmanNode> {
        int count;
        char value;
        HuffmanNode left;
        HuffmanNode right;

        public HuffmanNode(int count, char value) {
            this.count = count;
            this.value = value;
            left = right = null;
        }
        
        public HuffmanNode(HuffmanNode left, HuffmanNode right) {
            this.left = left;
            this.right = right;
            this.count = left.count + right.count;
            this.value = 0;
        }

        @Override
        public int compareTo(HuffmanTreeDAD.HuffmanNode o) {
            return this.count - o.count;
        }

        public boolean isLeaf() {
            return left == null && right == null;
        }
    }

    private class HuffmanCode {
        String code;
        char value;

        public HuffmanCode(char value, String code) {
            this.code = code;
            this.value = value;
        }
    }

    // Private Fields
    private PriorityQueue<HuffmanNode> priorityQueue = new PriorityQueue<>();
    private HuffmanNode root;
    private List<HuffmanCode> codes;

    // Constructor
    public HuffmanTreeDAD() {
        root = null;
        codes = new ArrayList<>();
    }

    public HuffmanTreeDAD(String key) {
        root = null;
        codes = new ArrayList<>();
        generateTreeFromKey(key);
    }

    // Public Methods
    @Override
    public String decode(String codedMessage) {
        if (codedMessage == null || codedMessage.length() == 0 || root == null) { 
            return ""; 
        }

        String decodedString = "";
        HuffmanNode node = root;
        for (char c : codedMessage.toCharArray()) {
            if (c == '0') {
                node = node.left;
            }
            if (c == '1') {
                node = node.right;
            }
            if (node.isLeaf()) {
                decodedString += node.value;
                node = root;
            }
        }

        return decodedString;
    }

    @Override
    public String encode(String message) {
        priorityQueue.clear(); // need to clear if doing multiple tests.
        codes.clear();

        int[] counts = new int[256];

        for (char c : message.toCharArray()) {
            counts[c]++;
        }

        for (char c = 0; c < counts.length; c++) {
            if (counts[c] > 0) {
                HuffmanNode huffmanNode = new HuffmanNode(counts[c], c);
                priorityQueue.add(huffmanNode);
            }
        }

        while (priorityQueue.size() > 1) {
            HuffmanNode left = priorityQueue.poll();
            HuffmanNode right = priorityQueue.poll();
            HuffmanNode composite = new HuffmanNode(left, right);
            priorityQueue.add(composite);
        }

        root = priorityQueue.poll();

        generateCodes(root, "");

        String encodedMessage = "";
        for (char c : message.toCharArray()) {
            encodedMessage += findCodes(c);
        }

        return encodedMessage;
    }

    public String getKey() {

        return generateKeyFromTree(root, "");
    }

    public void generateTreeFromKey(String key) {
        root = new HuffmanNode(-1, '0');
        HuffmanNode node = root;
        boolean leaf = false;

        for(char c : key.toCharArray()) {
            if (leaf) {
                leaf = false;
                node.value = c;
                node = root;
                continue;
            }
            if (c == '0') {
                if (node.left == null) {
                    node.left = new HuffmanNode(-1, '0');
                }
                node = node.left;
            }
            if (c == '1') {
                if (node.right == null) {
                    node.right = new HuffmanNode(-1, '0');
                }
                node = node.right;
            }
            if (c == ':') {
                leaf = true;
            }
        }
    }

    // Private Methods
    private void generateCodes(HuffmanNode node, String code) {
        if (node == null) { return; }

        if (node.isLeaf()) {
            // reached a leaf, save the code
            codes.add(new HuffmanCode(node.value, code));
        }
        generateCodes(node.left,  code + "0");
        generateCodes(node.right,  code + "1");
    } 

    private String findCodes(char c) {
        for (HuffmanCode code : codes) {
            if (code.value == c) {
                return code.code;
            }
        }
        return "";
    }

    private  String generateKeyFromTree (HuffmanNode node, String codes) {
        if (node == null) { return ""; }

        if (node.isLeaf()) {
            return codes + ":" + node.value;
        }

        String left = generateKeyFromTree(node.left, codes + "0");
        String right = generateKeyFromTree(node.right, codes + "1");

        return left + right;
    }
    
}

// Derek Dreblow
//
// V C Code
//
// D 2 100
// e 3 01
// r 2 101
// k 1 1111
// _ 1 1110
// b 1 1101
// l 1 1100
// o 1 001
// w 1 000
//
//                    13
//                /         \
//               /          8
//              /        /       \
//             5        4         4
//           /   \     / \      /   \
//           2   e    D   r    2     2
//          w o               l b   _ k