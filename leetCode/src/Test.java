import jdk.nashorn.internal.objects.NativeUint16Array;

import java.util.*;

/**
 * Created by LXY on 2017/5/14.
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
public class Test {

    public ListNode mergeKLists(ListNode[] lists) {
        return null;
    }

    public static void main(String[] args) {
//        ListNode node1 = new ListNode(1);
//        ListNode node2 = new ListNode(2);
//        ListNode node3 = new ListNode(3);
//        ListNode node4 = new ListNode(4);
//        ListNode node5 = new ListNode(5);
//        node1.next = node2;
//        node2.next = node3;
//        node3.next = node4;
//        node4.next= node5;
//
//        Stack stack = new Stack();
//        stack.peek();
//
        Test test = new Test();
////        test.removeNthFromEnd(node1,2);
////        System.out.println(test.fourSum("54564523424563"));
//        String s = "+-2";
        char[] cc = {'a','b','c','d'};
        String a = "abcd";
        char[] c = a.toCharArray();
//        System.out.println(cc.equals(c));
//
//        System.out.println(a.lastIndexOf("bd"));
//        int[] arr = {3,4,51,23,4,1,8,9,26};
//        System.out.println(test.sunday("dasdfa","dasdfaj"));
//
//        double d1 = 3.2,d2 = 3.2;
//        System.out.println("d1==d2:"+ (d1==d2));


        int[][] array = {{2,4,6,8},{3,5,7,9},{65,432,3456,23245}};
        int[] adddd = {1};
        System.out.println(test.minNumberInRotateArray(adddd));
        int[] a1 = {1,2,3,4,5,6,7};
        int[] a2 ={3,2,4,1,6,5,7};
        TreeNode root = test.reConstructBinaryTree(a1,a2);


    }

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        int size = stack1.size();
        for(int i=0;i<size-1;i++){
            stack2.push(stack1.pop());
        }
        int res = stack1.pop();
        while(!stack2.isEmpty())
            stack1.push(stack2.pop());
        return res;
    }
    public int minNumberInRotateArray(int [] array) {
        if(array==null || array.length==0) return 0;
        int low = 0,high = array.length-1;
        int mid = low;
        while(array[low] >= array[high]){
            if(low + 1== high) return array[high];
            mid = (low + high)/2;
            if(array[low] == array[mid] && array[mid] == array[high]){      //只能一个一个遍历
                for(int i = low+1;i<=high;i++)
                    if(array[i]<array[i-1]) return array[i];
            }
            if(array[mid] >= array[low]){        //链表左边有序，那么结果一定在链表的右边
                low = mid;
            }else if(array[mid] <= array[high]){        //链表右边有序，结果在链表的左边
                high = mid;
            }
        }
        return array[mid];
    }
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        return helper(pre,0,pre.length-1,in,0,in.length-1);
    }

    private TreeNode helper(int[] pre,int preBegin,int preEnd,int[] in,int inBegin,int inEnd){
        if(preBegin > preEnd) return null;
        TreeNode root = new TreeNode(pre[preBegin]);
        int index = inBegin;
        for(int i=inBegin;i<=inEnd;i++){
            if(pre[preBegin] == in[i]){
                index = i;
                break;
            }
        }
        root.left = helper(pre,preBegin+1,preBegin+index-inBegin,in,inBegin,index-1);
        root.right = helper(pre,preBegin+index-inBegin+1,preEnd,in,index+1,inEnd);
        return root;
    }


    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> res = new ArrayList<>();
        Stack<ListNode> stack = new Stack<>();
        while(listNode!=null){
            stack.add(listNode);
            listNode = listNode.next;
        }
        while(!stack.isEmpty()){
            res.add(stack.pop().val);
        }
        return res;
    }

    public String replaceSpace(StringBuffer str) {
        int count  = 0;
        for(int i = 0;i<str.length();i++){
            if(str.charAt(i) == ' ')
                count++;
        }
        char[] arr = new char[str.length() + count*2];
        int indexNew = arr.length-1;
        int indexOld = str.length()-1;
        while(indexNew>=0 && indexOld>=0){
            if(str.charAt(indexOld)==' '){
                arr[indexNew--] = '0';
                arr[indexNew--] = '2';
                arr[indexNew--] = '%';
            }else{
                arr[indexNew--] = str.charAt(indexOld);
            }
            indexOld--;
        }
        return String.valueOf(arr);
    }

    public void xuanzepaixu(int[] arr){
        for(int i=1;i<=arr.length/2;i++){		//从每趟中找出最小的数和未排序中第一个数交换
            int minIndex = i;
            int maxIndex = i;
            for(int j=i+1;j<=arr.length-i;j++){
                if(arr[maxIndex] < arr[j]){
                    maxIndex = j;
                    continue;
                }
                if(arr[minIndex] > arr[j]){
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i-1];
            arr[i-1] = temp;

            temp = arr[maxIndex];
            arr[maxIndex] = arr[arr.length-i];
            arr[arr.length-i] = temp;
        }
    }


    public void duipaixu(int[] arr){        //最小堆排序
        build(arr);
        for(int i=arr.length-1;i>0;i--){
            int tmp = arr[i];
            arr[i] = arr[0];
            arr[0] = tmp;
            adjust(arr,0,i);
        }
    }

    private void adjust(int[] arr,int s,int length){
        int tmp = arr[s];
        int child = 2*s+1;
        while(child < length){
            if(child +1 < length && arr[child] < arr[child+1]){
                child++;
            }
            if(arr[child] > arr[s]){
                arr[s] = arr[child];
                s = child;
                child = 2*s +1;
            }else
                break;
            arr[s] = tmp;
        }
    }

    private void build(int[] arr){
        for(int i=(arr.length-1)/2;i>=0;i--)
            adjust(arr,i,arr.length);
    }

    public void heapSort(int[] arr){
        buildHeap(arr);
        for (int i = arr.length - 1; i > 0; --i)
        {
            //交换堆顶元素H[0]和堆中最后一个元素
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            //每次交换堆顶元素和堆中最后一个元素之后，都要对堆进行调整
            adjustHeap(arr,0,i);
        }
    }

    private void buildHeap(int[] arr){
        //最后一个有孩子的节点的位置 i=  (length -1) / 2
        for (int i = (arr.length -1) / 2 ; i >= 0; --i)
            adjustHeap(arr,i,arr.length);
    }

    private void adjustHeap(int[] arr,int index,int length){
        int child = 2*index+1; //左孩子结点的位置。(i+1 为当前调整结点的右孩子结点的位置)
        int temp = arr[index];
        while (child < length) {
            if(child+1 <length && arr[child]<arr[child+1]) { // 如果右孩子大于左孩子(找到比当前待调整结点大的孩子结点)
                ++child ;
            }
            if(arr[child] > arr[index]){      //// 如果较小的子结点大于父结点
                arr[index] = arr[child]; // 那么把较小的子结点往上移动，替换它的父结点
                index = child;       // 重新设置s ,即待调整的下一个结点的位置
                child = 2*index+1;
            }else
                break;
            arr[index] = temp;
        }
    }


    public void bubbleSort(int[] arr){      //每次遍历将最大的数沉到最后面

        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length-i-1;j++){
                if(arr[j]>arr[j+1]){
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }
    }

    public void bubble_1(int[] arr){
        int low = 0,high = arr.length-1;
        while (low < high){
            for(int j=low;j<high;j++){
                if (arr[j]> arr[j+1]) {
                    int tmp = arr[j]; arr[j]=arr[j+1];arr[j+1]=tmp;
                }
            }
            high--;
            for(int j=high;j>low;j--){
                if(arr[j]<arr[j-1]){
                    int tmp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = tmp;
                }
            }
            low++;
        }
    }


    public void bubble_2(int[] arr){
        int i=arr.length-1;
        while(i>0){
            int pos = 0;
            for(int j=0;j<i;j++){
                if(arr[j]>arr[j+1]){
                    pos = j;
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
            i = pos;
        }

    }


    public void quickSort(int[] arr){       //找出基准点，分成两半，大的一边，小的一边，递归到只有一个元素
        quickSort(arr,0,arr.length-1);
    }
    public void quickSort(int[] arr,int low,int high){       //找出基准点，分成两半，大的一边，小的一边，递归到只有一个元素
        if(low < high){
            int proLocation = quickSortHelper(arr,low,high);
            quickSort(arr,low,proLocation-1);
            quickSort(arr,proLocation+1,high);
        }
    }

    public int quickSortHelper(int[] arr,int low,int high){     //用于查找每次遍历后的基准点的位置
        int proIndex = (int)Math.random()%(high-low) + low;//随机选取基准点
        int tmp = arr[low];
        arr[low] = arr[proIndex];
        arr[proIndex] = tmp;
        int privotKey = arr[low];
        while(low < high){          //从表中间交替向两端扫描
           while(low < high && arr[high] >= privotKey) high--;
           tmp = arr[low];
           arr[low] = arr[high];
           arr[high] = tmp;
           while (low < high && arr[low] <= privotKey) low++;
           tmp = arr[low];
           arr[low] = arr[high];
           arr[high] = tmp;
        }
        return low;
    }


    public void mergeSort(int[] arr){       //归并排序，一直分，分到每个序列只有一个元素的时候合并直到最后
        split(arr,0,arr.length-1);
    }

    public void split(int[] arr,int start,int end){
        if(start == end) return;
        int mid = (start + end)/2;
        split(arr,start,mid);
        split(arr,mid+1,end);
        merage(arr,start,mid,mid+1,end);
    }

    public void merage(int[] arr,int lowStart,int lowEnd,int highStart,int highEnd){
        int[] temp = new int[lowEnd-lowStart + highEnd - highStart +2];
        int i= lowStart,j = highStart,index = 0;
        while(i <= lowEnd && j <= highEnd){
            if(arr[i] > arr[j]){
                temp[index] = arr[j];
                j++;
            }else{
                temp[index] = arr[i];
                i++;
            }
            index++;
        }
        while(i<=lowEnd){
            temp[index++] = arr[i++];
        }
        while (j<=highEnd){
            temp[index++] = arr[j++];
        }
        for(int m=0;m<temp.length;m++){
            arr[lowStart + m] = temp[m];
        }

    }


    //三位取中快排
    public void quickSort_3(int[] arr){
        QSort(arr,0,arr.length-1);
    }

    public void quickSort_helper(int[] arr,int low,int high){
        if(low < high){
            int loc = findLocation(arr,low,high);
            quickSort_helper(arr,low,loc-1);
            quickSort_helper(arr,low+1,high);
        }
    }


    private int findPro(int[] arr,int low,int high){      //使用三位取中寻找基准点的值
        int mid = low + (high - low)/2;//计算数组中间的元素的下标
        int tmp = 0;
        if(arr[high] < arr[mid]){
            tmp = arr[high];
            arr[high] = arr[mid];
            arr[mid] = tmp;
        }
        if(arr[low] > arr[high]){
            tmp = arr[high];
            arr[high] = arr[low];
            arr[low] = tmp;
        }
        if(arr[low] <arr[mid]){
            tmp = arr[low];
            arr[low] = arr[mid];
            arr[mid] = tmp;
        }
        return arr[low];
    }

    private int findLocation(int[] arr,int low,int high){   //寻找基准点的最后坐标
        int tmp = findPro(arr,low,high);
        while(low < high){
            while(low < high && arr[high]>=tmp) high--;
            int a = arr[high];
            arr[high] = arr[low];
            arr[low] = a;
            while(low < high && arr[low]<=tmp) low++;
            a = arr[high];
            arr[high] = arr[low];
            arr[low] = a;
        }
        return low;
    }

    void QSort(int[] arr,int low,int high){
        if(low > high) return;
        int first = low;
        int last = high;

        int left = low;
        int right = high;

        int leftLen = 0;
        int rightLen = 0;
        int key = findPro(arr,low,high);
        while(low < high){
            while(low <high && arr[high] >= key){
                if(arr[high] == key){
                    int tmp = arr[right];
                    arr[right] = arr[high];
                    arr[high] = tmp;
                    right--;
                    rightLen++;
                }
                high--;
            }
            arr[low] = arr[high];
            while(low <high && arr[low]<= key){
                if(arr[low] == key){
                    int tmp = arr[left];
                    arr[left] = arr[low];
                    arr[low] = tmp;
                    left++;
                    leftLen++;
                }
                low++;
            }
            arr[high] = arr[low];
        }
        arr[low] = key;

        //一次快排结束，将于key相同的元素一道key位置周围
        int i = low - 1;
        int j = first;
        while(j < left && arr[i] != key){
           int tmp = arr[i];
           arr[i] = arr[j];
           arr[j] = tmp;
           j++;
           i--;
        }
        i = low + 1;
        j = last;
        while(j > right && arr[i] != key) {
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
            i++;
            j--;
        }
        QSort(arr,first,low - 1 - leftLen);
        QSort(arr,low + 1 + rightLen,last);
    }

    public int[] findNext(String s){
        int length  = s.length();
        int[] next = new int[length];
        int k = -1;
        next[0] = -1;
        int j=0;
        while(j<length-1){
            if(k==-1 || s.charAt(k)==s.charAt(j)){
                j++;
                k++;
                if(s.charAt(j)!=s.charAt(k))
                    next[j] = k;
                else
                    next[j] = next[k];
            }else
                k = next[k];
        }
        return next;
    }

    public int kmp(String s,String p){
        int sLength = s.length();
        int pLength = p.length();
        int i=0,j=0;
        int[] next = findNext(s);
        while(j<sLength && i<pLength){
            if(j==-1 || p.charAt(i)==s.charAt(j)){
                i++;
                j++;
            }else
                j = next[j];
        }

        if(j == sLength)
            return i-j;
        return -1;
    }

    public int sunday(String s,String p){
        int sLength = s.length();
        int pLength = p.length();
        int i=0,j=0;
        int loc = 0;    //匹配开始位置
        while(i<pLength && j<sLength){
            if(p.charAt(i) == s.charAt(j)){
                i++;
                j++;
            }else if(i+(sLength-j) < pLength){     //如果对齐点后面还有点
                int index = s.lastIndexOf(p.charAt(i+sLength-j)+"");
                if(index == -1)
                    i = i +sLength -j+1;
                else
                    i += sLength - index;
                loc = i;
                j=0;
            }else
                return -1;
        }
        if(j<sLength) return -1;
        return loc;
    }

    public int JumpFloorII(int target) {
        if(target<=0) return -1;
        if(target==1) return 1;
        return 2 * JumpFloorII(target -1);
    }

    public int NumberOf1(int n) {
        int count = 0;
        while(n>=0){
            count++;
            n = n&(n-1);
        }
        return count;
    }
}

