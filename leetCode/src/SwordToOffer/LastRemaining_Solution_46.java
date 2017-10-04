package SwordToOffer;

/**
 * Created by LXY on 2017/9/27.
 */
public class LastRemaining_Solution_46 {

    //每年六一儿童节,牛客都会准备一些小礼物去看望孤儿院的小朋友,今年亦是如此。HF作为牛客的资深元老,自然也准备了一些小游戏。其中,有个游戏是这样的:首先,让小朋友们围成一个大圈。然后,他随机指定一个数m,让编号为0的小朋友开始报数。每次喊到m-1的那个小朋友要出列唱首歌,然后可以在礼品箱中任意的挑选礼物,并且不再回到圈中,从他的下一个小朋友开始,继续0...m-1报数....这样下去....直到剩下最后一个小朋友,可以不用表演,并且拿到牛客名贵的“名侦探柯南”典藏版(名额有限哦!!^_^)。请你试着想下,哪个小朋友会得到这份礼品呢？(注：小朋友的编号是从0到n-1)
    public int lastRemaining_Solution(int n, int m) {

        if(n==0 || m==0) return -1;
        if(n==1) return 0;
        //方法一，用一个list维护这个圈，其中list每个元素代表一个小朋友，其中的值代表小朋友的编号
//        List<Integer> list = new ArrayList<>();
//        for(int i=0;i<n;i++)
//            list.add(i);
//
//        int start = 0;      //开始报号的元素坐标
//        int removeIndex; //记录需要移除的元素下标
//        while(list.size()>1){
//            removeIndex =   (start+m-1)%list.size();
//            if(removeIndex == list.size()-1){       //移除的是最后一个元素，那么下一次开始元素为0
//                start = 0;
//            }else{
//                start = removeIndex ;       //直接下一个元素
//            }
//            list.remove(removeIndex);
//        }
//        return list.get(0);

        //方法二，约瑟夫环。
        if(n==0||m==0)return -1;
        int s=0;
        for(int i=2;i<=n;i++)
        {
            s=(s+m)%i;
        }
        return s ;
    }

    public static void main(String[] args){
        LastRemaining_Solution_46 a = new LastRemaining_Solution_46();
        System.out.println(a.lastRemaining_Solution(9,3));
    }
}
