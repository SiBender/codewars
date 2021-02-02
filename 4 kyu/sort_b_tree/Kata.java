import java.util.*;

class Kata {
  private static ArrayDeque<Node> queue;
  private static List<Integer> out;
  
  public static List<Integer> treeByLevels(Node node)
  {
    queue = new ArrayDeque<Node>();
    out = new ArrayList<Integer>();
    if (node == null) { return out; }
    
    queue.add(node);
    traversal();
    
    return out;
  }
  
  public static void traversal(){
    Node tmp;
    while(queue.isEmpty() == false){
      tmp = queue.poll();
      out.add(tmp.value);
      if(tmp.left != null){ 
        queue.add(tmp.left);
      }
      if(tmp.right != null){
        queue.add(tmp.right);
      }
    }
  }
}