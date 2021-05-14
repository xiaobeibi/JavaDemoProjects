package com.bjpowernode.sys.utils;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 2020/2/14 17:19
 */
public class TreeNodeBuilder {
        /**
         * 把简单的集合转成有层级关系的集合
         * @param nodes
         * @param topid
         * @return
         */
        public static List<TreeNode> builder(List<TreeNode> nodes, Integer topid) {
            List<TreeNode> treeNodes = new ArrayList<>();
            for (TreeNode n1:nodes) {
                if(n1.getPid()==topid){
                    treeNodes.add(n1);
                }
                for (TreeNode n2:nodes) {
                    if(n2.getPid()==n1.getId()){
                        n1.getChildren().add(n2);
                    }
                }
            }
            return treeNodes;
        }

}
