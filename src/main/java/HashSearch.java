import java.io.IOException;
import java.util.Scanner;

/**
 * @Author: egg
 * @Date: 2019-05-05 19:53
 */
public class HashSearch {
    static int hashLength = 7;
    static int[] hashTable = new int[hashLength];

    static int[] list = {13, 29, 27, 28, 26, 30, 38};
    public static void main(String[] args) throws IOException {
        System.out.println("*******哈希查找*******");

        // 创建哈希表
        for (int i = 0; i < list.length; i++) {
            insert(hashTable, list[i]);
        }
        System.out.println("展示哈希表中的数据：" + display(hashTable));

        while (true) {
            // 哈希表查找
            System.out.print("请输入要查找的数据：");
            int data = new Scanner(System.in).nextInt();
            int result = search(hashTable, data);
            if (result == -1) {
                System.out.println("对不起，没有找到！");
            } else {
                System.out.println("数据的位置是：" + result);
            }
        }
    }
    /**
     * 方法：哈希表插入
     */
    public static void insert(int[] hashTable, int data) {
        // 哈希函数，除留余数法
        int hashAddress = hash(hashTable, data);
        System.out.println("insert"+hashAddress);

        // 如果不为0，则说明发生冲突
        while (hashTable[hashAddress] != 0) {
            // 利用 开放定址法 解决冲突
            hashAddress = (++hashAddress) % hashTable.length;
            System.out.println("开放地址"+hashAddress);
        }

        // 将待插入值存入字典中
        hashTable[hashAddress] = data;
    }

    /**
     * 方法：哈希表查找
     */
    public static int search(int[] hashTable, int data) {
        // 哈希函数，除留余数法
        int hashAddress = hash(hashTable, data);
        System.out.println(hashAddress);

        while (hashTable[hashAddress] != data) {
            // 利用 开放定址法 解决冲突
            hashAddress = (++hashAddress) % hashTable.length;
            // 查找到开放单元 或者 循环回到原点，表示查找失败
            if (hashTable[hashAddress] == 0 || hashAddress == hash(hashTable, data)) {
                return -1;
            }
        }
        // 查找成功，返回下标
        return hashAddress;
    }

    /**
     * 方法：构建哈希函数（除留余数法）
     *
     * @param hashTable
     * @param data
     * @return
     */
    public static int hash(int[] hashTable, int data) {
        System.out.println("hash"+data % hashTable.length);
        return data % hashTable.length;
    }

    /**
     * 方法：展示哈希表
     */
    public static String display(int[] hashTable) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i : hashTable) {
            stringBuffer = stringBuffer.append(i + " ");
        }
        return String.valueOf(stringBuffer);
    }
}
