package Array;

/**
 * @Author: egg
 * @Date: 2019-09-25 17:14
 */
public class FindMedianSortedArrays {
    /**
     * 从两个有序数组中找到中位数
     * 新建一个数组存储存储合并排序后的数组
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArraysII(int[] nums1, int[] nums2){
        int len1 = nums1.length;
        int len2 = nums2.length;
        int len=len1+len2;
        //记录nums1，nums2，nums的下标。
        int index1=0,index2=0,index=0;
        int[] nums = new int[len1+len2];
        //将nums1，2有序插入到nums中
        while(index1<len1 && index2<len2 &&index<=len){
            nums[index++]=nums1[index1]<nums2[index2]?nums1[index1++]:nums2[index2++];
        }
        //连个if用于其中一个数组插入完毕，剩余数组继续插入。
        if(index1!=len1){
            while(index1<len1)
                nums[index++]=nums1[index1++];
        }
        if(index2!=len2){
            while(index2<len2)
                nums[index++]=nums2[index2++];
        }
        //为奇数直接返回中间数，#注意，此时index并非数组下标，因为插入完毕后执行了index++，
        //index是数组长度
        if(index%2!=0)
            return nums[index/2];
        //为偶数时
        return ((double)(nums[index/2-1]+nums[index/2]))/2;




    }
}
