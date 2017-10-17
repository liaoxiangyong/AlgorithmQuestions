package NiuKeWangLeetCode;

import com.sun.xml.internal.ws.api.pipe.ServerTubeAssemblerContext;
import sun.text.normalizer.UBiDiProps;

import java.awt.geom.QuadCurve2D;
import java.util.*;

/**
 * Created by LXY on 2017/10/17.
 */
class UndirectedGraphNode {
    int label;
    ArrayList<UndirectedGraphNode> neighbors;
    UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
};
public class Java_18 {
    //复制无向图
//    HashMap<UndirectedGraphNode,UndirectedGraphNode> hashMap = new HashMap<>();
//    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
//        if(node == null) return node;
//
//        //BFS
//        if(hashMap.containsKey(node)){
//            return hashMap.get(node);
//        }
//        UndirectedGraphNode newHead = new UndirectedGraphNode(node.label);      //不存在则添加进去
//        hashMap.put(node,newHead);
//        for(UndirectedGraphNode undirectedGraphNode : node.neighbors){
//            newHead.neighbors.add(cloneGraph(undirectedGraphNode));
//        }
//
//        return newHead;
//    }

    //DFS
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null) return node;

        HashMap<UndirectedGraphNode,UndirectedGraphNode> map = new HashMap<>();
        Queue<UndirectedGraphNode> queue = new LinkedList<>();

        queue.add(node);
        UndirectedGraphNode newHead = new UndirectedGraphNode(node.label);
        map.put(node,newHead);

        while(!queue.isEmpty()){
            UndirectedGraphNode cur = queue.poll();
            List<UndirectedGraphNode> curNeighbors=cur.neighbors;       //遍历该点所有邻节点
            for(UndirectedGraphNode undirectedGraphNode : curNeighbors){
                if(map.containsKey(undirectedGraphNode)){//如果已经被遍历过，那么将该点加入到点邻节点中
                    map.get(cur).neighbors.add(map.get(undirectedGraphNode));
                }else{      //创建该节点，并将该节点添加到queue中
                    queue.add(undirectedGraphNode);
                    map.put(undirectedGraphNode,new UndirectedGraphNode(undirectedGraphNode.label));
                    map.get(cur).neighbors.add(map.get(undirectedGraphNode));
                }
            }

        }
        return newHead;
    }
}
