package com.freedom.tree.huffman;

/**
 * @author freedom
 * @date 2020/11/8 20:40
 */
public class HuffmanCodingTest {

    public static void main(String[] args) {
//        String content = "i like like like java do you like a java";
//        byte[] contentBytes = content.getBytes();
//
//        Map<Byte, String> huffmanCodes = HuffmanCoding.getHuffmanCodes(contentBytes);
//
//        byte[] huffmanCompress = HuffmanCoding.huffmanCompress(contentBytes, huffmanCodes);
//        System.out.println("编码过后的字节 = " + Arrays.toString(huffmanCompress));
//
//        byte[] sourceBytes = HuffmanCoding.huffmanDecode(huffmanCompress, huffmanCodes);
//        System.out.println("原来的字符串 = " + new String(sourceBytes));

        String srcFilePath = "D://test.bmp";
        String dstFilePath = "D://test.zip";
//        HuffmanCoding.zipFile(srcFilePath, dstFilePath);

        String dstFilePath1 = "D://test1.bmp";
        HuffmanCoding.unZipFile(dstFilePath, dstFilePath1);
    }
}
