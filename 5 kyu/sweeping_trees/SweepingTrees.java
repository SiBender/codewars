import java.util.List;
import java.util.*;
import java.util.Set;

public class SweepingTrees {
  public List<String> clearTree(List<String> tree, List<String> nodesToRemove){
    List<String> newBadNodes = new ArrayList<String>();
   // System.out.println("inRec:"+tree+" --> "+nodesToRemove);
    String[] node = new String[2];

    for(String nodeRem : nodesToRemove){
      for(int i = 0; i < tree.size(); i++){
        //System.out.println("tempNode:"+tempNode);
        node = tree.get(i).split(",");
        if (node[0].equals("root")) {continue;}
        if( node[1].equals(nodeRem)) {
          newBadNodes.add(node[0]);
          tree.remove(i);
          i--;

        }
      }
    }
    
    if (newBadNodes.size() == 0) {return tree;}
    return clearTree(tree, newBadNodes);
  }
  
  public Set<String> determineValidIds(List<String> dirtyTree) {
    System.out.println(dirtyTree.size());
    
    List<String> myDirtyTree = new LinkedList<String>();
    
    List<String> badNodes = new ArrayList<String>();
    String[] nodeArray = new String[3];
    for(int i = 0; i < dirtyTree.size(); i++){
      nodeArray = dirtyTree.get(i).split(",");
      if( nodeArray[2].equals("invalid") ){
        if (nodeArray[0].equals("root") == true ) {
        Set<String> emptySet = new HashSet<String>();
        return emptySet;
        }
        badNodes.add(nodeArray[0]);
        //dirtyTree.remove(i);
        //i--;
      } else {
      myDirtyTree.add(nodeArray[0]+","+nodeArray[1]);
      }
      //System.out.println(mydirtyTree);
    }
    
    List<String> outTree = clearTree(myDirtyTree, badNodes);
    Set<String> treeSet = new HashSet<String>();
    for(String node : outTree){
      nodeArray = node.split(",");
      treeSet.add(nodeArray[0]);
    }
    //System.out.println(treeSet);
    return treeSet;
  }
}
