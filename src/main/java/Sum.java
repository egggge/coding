import java.util.HashMap;
import java.util.Map;

/**
 * @author chendan
 * @date 2019/6/24 10:10
 */
public class Sum {
    /**
     * 不改变数组的位置，找出两个数的和
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        int[] res={0,0};
        HashMap<Integer,Integer> hashMap=new HashMap<Integer, Integer>();
        if (nums==null){
            return res;
        }
        for (int k=0;k<nums.length;k++){
            hashMap.put(nums[k],k);
        }
        for (int j=0;j<nums.length;j++){
            //避免3+3这种情况
            if (hashMap.containsKey(target-nums[j])){
                int temp=hashMap.get(target-nums[j]);
                if(temp!=j){
                    res[0]=j;
                    res[1]=hashMap.get(target-nums[j]);
                    break;
                }
            }
        }
        return res;
    }
    public int[] twoSumII(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(16);
        for (int i = 0; i < nums.length; i++) {
            //这样做就避免了自己加自己
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }

}
