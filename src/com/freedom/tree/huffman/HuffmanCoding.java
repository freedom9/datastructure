package com.freedom.tree.huffman;

import java.io.*;
import java.util.*;

/**
 * @author freedom
 * @date 2020/11/8 20:43
 * @description 字符的编码都不能是其他字符编码的前缀，符号此要求的编码叫做前缀编码，赫夫曼编码就属于前缀编码。
 */
public class HuffmanCoding {

    private static Map<Byte, String> huffmanCodes = new HashMap<>();

    /**
     * 文件压缩
     *
     * @param srcFilePath
     * @param dstFilePath
     */
    public static void zipFile(String srcFilePath, String dstFilePath) {
        try (InputStream is = new FileInputStream(srcFilePath);
             OutputStream os = new FileOutputStream(dstFilePath);
             ObjectOutputStream oos = new ObjectOutputStream(os)) {
            byte[] b = new byte[is.available()];
            is.read(b);

            Map<Byte, String> huffmanCodes = getHuffmanCodes(b);
            byte[] huffmanBytes = huffmanCompress(b, huffmanCodes);
            oos.writeObject(huffmanBytes);
            // 注意一定要把赫夫曼编码写入压缩文件，解压需要用到
            oos.writeObject(huffmanCodes);

            System.out.println("压缩完成！");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 解压文件
     *
     * @param zipFilePath
     * @param dstFilePath
     */
    public static void unZipFile(String zipFilePath, String dstFilePath) {
        try (InputStream is = new FileInputStream(zipFilePath);
             ObjectInputStream ois = new ObjectInputStream(is);
             OutputStream os = new FileOutputStream(dstFilePath)) {
            // 读取byte数组
            byte[] huffmanBytes = (byte[]) ois.readObject();
            // 读取赫夫曼编码表
            Map<Byte, String> huffmanCodes = (Map<Byte, String>) ois.readObject();

            byte[] bytes = huffmanDecode(huffmanBytes, huffmanCodes);
            os.write(bytes);
            System.out.println("解压成功！");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 赫夫曼解码
     *
     * @param huffmanBytes 被赫夫曼编码过的字节
     * @param huffmanCodes 赫夫曼编码
     * @return
     */
    public static byte[] huffmanDecode(byte[] huffmanBytes, Map<Byte, String> huffmanCodes) {
        StringBuilder sb = new StringBuilder();
        // 将byte数组转为二进制的字符串
        for (int i = 0; i < huffmanBytes.length; i++) {
            // 判断是否最后一个字节
            boolean flag = (i != huffmanBytes.length - 1);
            sb.append(byteToBitString(huffmanBytes[i], flag));
        }

        // 将赫夫曼编码表进行调换
        Map<String, Byte> map = new HashMap<>(huffmanCodes.size());
        for (Map.Entry<Byte, String> entry : huffmanCodes.entrySet()) {
            map.put(entry.getValue(), entry.getKey());
        }

        // 创建要给集合，存放byte
        List<Byte> list = new ArrayList<>();
        int i = 0;
        while (i < sb.length()) {
            int count = 1;
            boolean flag = true;
            Byte b = null;

            while (flag) {
                String key = sb.substring(i, i + count);
                b = map.get(key);

                if (b != null) {
                    flag = false;
                    break;
                }
                count++;
            }
            list.add(b);
            i += count;
        }

        // 把list中的数据放入到byte数组并返回
        byte[] b = new byte[list.size()];
        for (int j = 0; j < b.length; j++) {
            b[j] = list.get(j);
        }
        return b;
    }

    /**
     * 赫夫曼压缩
     *
     * @param bytes        字节
     * @param huffmanCodes 赫夫曼编码
     * @return
     */
    public static byte[] huffmanCompress(byte[] bytes, Map<Byte, String> huffmanCodes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(huffmanCodes.get(b));
        }

//        int len;
//        if (sb.length() % 8 == 0) {
//            len = sb.length() / 8;
//        } else {
//            len = sb.length() / 8 + 1;
//        }
        // 等价于上面
        int len = (sb.length() + 7) / 8;

        byte[] huffmanCodeBytes = new byte[len];
        // 记录是第几个byte
        int index = 0;
        for (int i = 0; i < sb.length(); i += 8) {
            String strByte;
            if (i + 8 > sb.length()) {
                strByte = sb.substring(i);
            } else {
                strByte = sb.substring(i, i + 8);
            }
            huffmanCodeBytes[index] = (byte) Integer.parseInt(strByte, 2);
            index++;
        }
        return huffmanCodeBytes;
    }

    /**
     * 获取赫夫曼编码
     *
     * @param bytes
     * @return
     */
    public static Map<Byte, String> getHuffmanCodes(byte[] bytes) {
        List<HuffmanCodingNode> nodes = getNodes(bytes);

        HuffmanCodingNode root = buildHuffmanTree(nodes);

        Map<Byte, String> codes = getCodes(root, "", new StringBuilder());

        // 为了可以压缩和解压多个赫夫曼编码
        huffmanCodes = new HashMap<>();

        return codes;
    }

    /**
     * 将一个byte转成一个二进制的字符串
     *
     * @param b
     * @param flag 标志是否需要补高位，true表示需要补高位，最后是最后一个字节，无需补高位
     * @return
     */
    private static String byteToBitString(Byte b, Boolean flag) {
        // 使用变量保存b
        int temp = b;
        if (flag) {
            // 1 0000 0000 | 0000 0001 = 1 0000 0001
            temp |= 256;
        }
        String str = Integer.toBinaryString(temp);
        return flag ? str.substring(str.length() - 8) : str;
    }

    private static List<HuffmanCodingNode> getNodes(byte[] contentBytes) {
        List<HuffmanCodingNode> nodes = new ArrayList<>();

        // 统计byte出现的次数
        Map<Byte, Integer> counts = new HashMap<>();
        for (byte b : contentBytes) {
            Integer count = counts.get(b);
            if (count == null) {
                counts.put(b, 1);
            } else {
                counts.put(b, count + 1);
            }
        }

        for (Map.Entry<Byte, Integer> entry : counts.entrySet()) {
            nodes.add(new HuffmanCodingNode(entry.getKey(), entry.getValue(), null, null));
        }
        return nodes;
    }

    /**
     * 创建赫夫曼树
     *
     * @param nodes
     * @return 头结点
     */
    private static HuffmanCodingNode buildHuffmanTree(List<HuffmanCodingNode> nodes) {
        while (nodes.size() > 1) {
            Collections.sort(nodes);

            HuffmanCodingNode leftNode = nodes.get(0);
            HuffmanCodingNode rightNode = nodes.get(1);
            HuffmanCodingNode parentNode = new HuffmanCodingNode(null,
                    leftNode.getWeight() + rightNode.getWeight(), leftNode, rightNode);

            nodes.remove(leftNode);
            nodes.remove(rightNode);
            nodes.add(parentNode);
        }
        return nodes.get(0);
    }

    /**
     * 将传入的node结点的所有叶子结点的赫夫曼编码，并放入到huffmanCodes
     *
     * @param node
     * @param code 路径：左子结点为0，右子结点为1
     * @param sb   用于拼接路径
     * @return
     */
    private static Map<Byte, String> getCodes(HuffmanCodingNode node, String code, StringBuilder sb) {
        StringBuilder stringBuilder = new StringBuilder(sb);
        stringBuilder.append(code);

        if (node != null) {
            // 判断当前结点是叶子结点，还是非叶子结点，data为非叶子结点
            if (node.getData() == null) {
                getCodes(node.getLeft(), "0", stringBuilder);
                getCodes(node.getRight(), "1", stringBuilder);
            } else {
                huffmanCodes.put(node.getData(), stringBuilder.toString());
            }
        }
        return huffmanCodes;
    }

    public void preOrderTraversal(HuffmanCodingNode root) {
        if (root != null) {
            root.preOrderTraversal();
        } else {
            System.out.println("赫夫曼树为空，不能遍历！");
        }
    }
}
