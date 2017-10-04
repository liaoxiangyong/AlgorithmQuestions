package NiuKeWangLeetCode;

/**
 * Created by LXY on 2017/10/2.
 */
class Point {
    int x;
    int y;
    Point() { x = 0; y = 0; }
    Point(int a, int b) { x = a; y = b; }
 }

public class Java_3 {

    //求一个平面上共线的最多点数
    public int maxPoints(Point[] points) {

        //方法一：对每个点，直接求它和其他点的比例，但是要注意x1=x2的点和重合点，double保存精度，可能回出错。
        //方法二：在map中保存x1/y1的化简后的格式，
//        int res = 0;
//        for(int i=0;i<points.length;i++){
//            HashMap<Map<Integer,Integer>,Integer> countHashMap = new HashMap<>();
//            int duplicate = 1;      //用于记录和当前点重合点
//            for(int j=i+1;j<points.length;j++){
//                if(points[i].x==points[j].x && points[i].y == points[j].y){
//                    duplicate++;
//                }else {
//                    int dx = points[j].x - points[i].x;
//                    int dy = points[j].y - points[i].y;
//                    int d = gcd(dx, dy);
//                    Map<Integer, Integer> t = new HashMap<>();
//                    t.put(dx / d, dy / d);
//                    if(countHashMap.containsKey(t))
//                        countHashMap.put(t, countHashMap.get(t) + 1);
//                    else
//                        countHashMap.put(t,1);
//                }
//            }
//            res = Math.max(res, duplicate);
//            for (Map.Entry<Map<Integer, Integer>, Integer> e : countHashMap.entrySet()) {
//                res = Math.max(res, e.getValue() + duplicate);
//            }
//        }


        //方法三：通过判断叉积为零的面积法判断三点是否一线。比如说有三个点A(x1, y1)、B(x2, y2)、C(x3, y3)，那么判断三点共线就是判断下面这个等式是否成立：
        // x1 * y2 + x2 * y3 + x3 * y1 - x3 * y2 - x2 * y1 - x1 * y3 == 0
        int res = 0, n = points.length;
        for (int i = 0; i < n; ++i) {
            int duplicate = 1;
            for (int j = i + 1; j < n; ++j) {
                int cnt = 0;
                long x1 = points[i].x, y1 = points[i].y;
                long x2 = points[j].x, y2 = points[j].y;
                if (x1 == x2 && y1 == y2) {++duplicate;continue;}
                for (int k = 0; k < n; ++k) {
                    int x3 = points[k].x, y3 = points[k].y;
                    if (x1*y2 + x2*y3 + x3*y1 - x3*y2 - x2*y1 - x1 * y3 == 0) {
                        ++cnt;
                    }
                }
                res = Math.max(res, cnt);
            }
            res = Math.max(res, duplicate);
        }
        return res;
    }

    private int gcd(int a,int b){       //求分子和分母的最大公约数
        if(b==0) return a;
        return gcd(b,a%b);
    }

    public static void main(String[] args) {
        Java_3 a  = new Java_3();
        int c = a.gcd(12,2);
    }
}
