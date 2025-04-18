# L08-HuffmanCoding

> One of the earliest forms of data compression was through Morse code, which allowed for the transmission of textual information over a wire. Each letter has been encoded based on its typical frequency of occurrence, with more common letters receiving shorter messages (such as the letter 'e' being represented as a single dot). A later version of data compression, called Huffman encoding, arose with the rise of the internet in the 1970s. Being dynamically generated on input data, Huffman encoding was an efficient means of data compression until the invention of the LZ77 algorithm in 1977.

## Huffman Tree Encoder
We will be encoding and decoding our names using the HuffmanCoding.

```
Valid chars:
A-Z (upper case letter) characters
a-z (lower case letter) characters
0-9 (digit) characters
only allowed symbols: space ( ), tab (\t), newline (\n), exclamation mark (!), period (.), question mark (?)
```

**Provide a driver** to demonstrate your `HuffmanTree` implementation works by:
1. Build a Huffman tree that can encode your original text into an encoded version
2. Using your existing Huffman tree, decode the text to its original format
3. Stretch Goal: Compare the encoded length with the original length (multiply by 16 for the orinal to represent size!)
4. Stretch Goal: Covert your Huffman tree to a key that can be passed and restored to create a new Huffman tree

## Implementation Notes
- Your `HuffmanTree` must implement the given `HuffmanInterface`, which includes the `encode` and `decode` methods which accept a single String parameter.
- **DO NOT USE BINARY FILES FOR THIS PROJECT**. You will encode by outputting the 1’s and 0’s to the console -- you do not need to work with actual binary files!
- You cannot use any data structure we have not covered in the course so far (i.e., HashTables are not allowed).

> ***PRO-TIPS:***
> - A thorough explanation of a Huffman tree can be found on Canvas
> - for(char c : string.toCharArray()) // this is your friend

## Example ##
```
// Professor Horton
//
// p = 1    1101
// f = 1    1100
// e = 1    0101
// h = 1    0100
// t = 1    0111
// n = 1    1111
// s = 2    1110
// r = 2    00
// o = 4    10
// _ = 1    0110
//
//        16
//      /    \
//     7      9
//    r       o
//   / \     / \
//  2   2   2   3
// H   e   _   t
//         f   p s n
```

## Personal to Student ##
```
// Derek Dreblow
//
// D 2
// e 3
// r 2
// k 1
// _ 1
// b 1
// l 1
// o 1
// w 1
//
//
//                    13
//                /         \
//               /          8
//              /        /       \
//             5        4         4
//           /   \     / \      /   \
//           2   e    D   r    2     2
//          w o               l b   _ k
```