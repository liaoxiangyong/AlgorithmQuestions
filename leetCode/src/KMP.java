/**
 * Created by LXY on 2017/11/13.
 */
public class KMP {

    public int KMP(String source,String target){

        int i=0,j=0;
        int sSource = source.length();
        int sTarget = target.length();

        int[] next = getNext(target);
        while(i<sSource && j<sTarget){
            if(j==-1 || source.charAt(i)==target.charAt(j)){
                i++;
                j++;
            }else{
                j = next[j];            //数组的前缀为next[j]长，这样就不用重新匹配。
            }
        }
        if (j == sTarget)
            return i - j;

        return -1;
    }

    public int[] getNext(String b){     //获取next数组
        // 已知next[j] = k,利用递归的思想求出next[j+1]的值
        // 如果已知next[j] = k,如何求出next[j+1]呢?具体算法如下:
        // 1. 如果b[j] = b[k], 则next[j+1] = next[k] + 1;
        // 2. 如果b[j] != b[k], 则令k=next[k],如果此时b[j]==b[k],则next[j+1]=k+1,
        // 如果不相等,则继续递归前缀索引,令 k=next[k],继续判断,直至k=-1(即k=next[0])或者b[j]=b[k]为止
        int length = b.length();
        int[] next = new int[length];
        next[0] = -1;
        int k=-1;
        int j=0;
        while(j<length - 1){
            if(k == -1 || b.charAt(k)==b.charAt(j)){
                j++;
                k++;
                if(b.charAt(j) != b.charAt(k))
                    next[j] = k;
                else
                    next[j] = next[k];
            }else
                k = next[k];
        }
        return next;
    }


    public int sunday(String source,String pattern){
        int  i = 0,j=0;
        int sLength = source.length();
        int pLength = pattern.length();

        int loc=0;          //匹配开始位置

        while(i<sLength  && j<pLength ){
            if(source.charAt(i) == pattern.charAt(j)){
                i++;
                j++;
            }else if(i+pLength<sLength){
                if(pattern.contains(source.charAt(i+pLength)+"")){   //判断重合点后面一个点,若有相等的，则移动
                    int index = pattern.lastIndexOf(source.charAt(i+pLength));
                    i += pLength - index;           //向右移动pattern的最后点到最后一个判断点的距离+1
                    loc  = i;
                    j=0;
                }else{      //不包含直接跳到最后一个的下一个点
                    i += pLength + 1;
                    loc = i;
                    j = 0;
                }
            }else
                return -1;
        }
        if(j<pLength)
            return -1;
        return loc;
    }
    public static void main(String[] args) {
        KMP kmp = new KMP();
        System.out.println(kmp.sunday("abababdfdasdfcdsadcd","cdsa"));
//        kmp.getNext("abcabcdba");
    }
}

