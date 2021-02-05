/*
	print Bottom view of BT
	Sol: do BFS and keep sorted pair in treemap on basis of keys which has horizontal distance
	left child= hor distance( root) -1;
	right child = hor distance(root )+1;

	print node which comes later if both are at same hor distance
*/

class Node
{
	int hd;
	int data;
	Node left;
	Node right;

	public Node(int key) 
    { 
        data = key; 
        hd = Integer.MAX_VALUE; 
        left = right = null; 
    } 
}

class Tree()
{

	Node root;
	public Tree(Node node) 
    { 
        root = node; 
    } 

    public void bottomView() 
    {
		int hd=0;

		//to keep nodes of each level
		Queue<Node> que=new LinkedList<Node>();
		

		//key = hor distance, val - Node
		Map<Integer, Integer> map = new TreeMap<>();


		//add root to queue
		root.hd=hd;
		que.add(root);
		
		while(!que.isEmpty())
		{
			//get front node
			Node temp=que.remove();
			hd=temp.hd;


			//add node in map which will update val of node at that distance if needed
			map.put(hd,temp);

			//add children to queue
			if (temp.left != null) 
            { 
                temp.left.hd = hd-1; 
                queue.add(temp.left); 
            }
             if (temp.right != null) 
            { 
                temp.right.hd = hd+1; 
                queue.add(temp.right); 
            }  
		}


		//extract each node from map for every hd
		// an iterator over that. 
        Set<Entry<Integer, Integer>> set = map.entrySet(); 
  
        // Make an iterator 
        Iterator<Entry<Integer, Integer>> iterator = set.iterator(); 
  
        // Traverse the map elements using the iterator. 
        while (iterator.hasNext()) 
        { 
            Map.Entry<Integer, Integer> me = iterator.next(); 
            System.out.print(me.getValue()+" "); 
        } 
	}

}


public class BottomView 
{ 
	    public static void main(String[] args) 
	    { 
	        Node root = new Node(20); 
	        root.left = new Node(8); 
	        root.right = new Node(22); 
	        root.left.left = new Node(5); 
	        root.left.right = new Node(3); 
	        root.right.left = new Node(4); 
	        root.right.right = new Node(25); 
	        root.left.right.left = new Node(10); 
	        root.left.right.right = new Node(14); 
	        Tree tree = new Tree(root); 
	        System.out.println("Bottom view of the given binary tree:"); 
	        tree.bottomView(); 
	    } 

}


