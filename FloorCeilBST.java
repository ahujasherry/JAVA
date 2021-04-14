

public class FloorCeilBST
{
	
	public static int Ceil(Node root, int key)
	{
		if(root==null) return -1;

		if(root.val== key) return root.val;


		//find in right subtree
		if(root.val < key)
		{
			 return Ceil(root.right, key);
		} 

		//find in left subtree if present
		else if( root.val > key)
		{
			int ans=Ceil(root.left, key);
			return (ans>= key && ans!=-1) ? ans : root.val)

		}


	}


	public static int floor(Node root, int key)
	{
		if(root==null) return -1;

		if(root.val== key) return root.val;


		//find in right subtree and find smallest of right subtree and check with key
		if(root.val < key)
		{
			int ans=floor(root.right, key);
			return (ans<= key && ans!=-1) ? ans : root.val);
			 
		} 

		//find in left subtree if present
		else if( root.val > key)
		{
			return floor(root.left, key);

		}


	}





}
