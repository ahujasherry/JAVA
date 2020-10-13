import java.util.ArrayList;


//Node chains of each bucket
class HashNode<K,V>
{
	K key;
	V val;
	
	//pointer to next node in link list
	HashNode<K,V> next;
	
	public HashNode(K key, V val)
	{
		this.key=key;
		this.val=val;
	}
}


//hash table implementation
public class JavaHashMap<K,V>
{
	//array list to store chains
	private ArrayList<HashNode<K,V>> bucketArray;
	
	//current size of hash table
	private int size; 
	
	//current capacity of array List
	private int numBuckets;
	
	//constructor
	public JavaHashMap()
	{
		bucketArray=new ArrayList<HashNode<K,V>>();
		size=0;
		numBuckets=10;
		
		for (int i = 0; i < numBuckets; i++) {
			bucketArray.add(null);
		}
	}
	
	
	//calculate hash function
	private int hashFunc(K key)
	{
		int hash=key.hashCode();
		return hash%numBuckets;
	}
	
	//return new hash node
	private HashNode<K,V> getNode(K key, V val)
	{
		HashNode<K,V> newnode= new HashNode<K,V>(key,val);
		newnode.next=null;
		return newnode;
	}
	
	public int size()
	{
		return size;
	}
	
	public boolean isEmpty()
	{
		return size==0;
	}
	
	
	//add key value pair to hash table
	public void insert(K key, V val)
	{
		//1. find index
		int index=hashFunc(key);
		HashNode<K,V> head=bucketArray.get(index);
		
		
		//search if already present of not
		while( head!=null)
		{
			if(head.key.equals(key))
			{
				head.val=val;
				return;
			}
			head=head.next;
		}
		
		//insert key,value pair
		size++;
		head=bucketArray.get(index);
		HashNode<K,V> node=this.getNode(key, val);
		node.next=head;
		bucketArray.set(index, node);
		
		
		//check load factor and rehash if required
		if ( (1.0*size)/numBuckets >= 0.7) 
        { 
            ArrayList<HashNode<K, V>> tempBucketArray = bucketArray; 
            bucketArray = new ArrayList<>(); 
            numBuckets = 2 * numBuckets; 
            size = 0; 
            for (int i = 0; i < numBuckets; i++) 
                bucketArray.add(null); 
  
            for (HashNode<K, V> i : tempBucketArray) 
            { 
                while (i != null) 
                { 
                    insert(i.key, i.val); 
                    i = i.next; 
                } 
            } 
        } 
    } 
		
		
	
	public V remove(K key)
	{
		int index=hashFunc(key);
		HashNode<K,V> head =bucketArray.get(index);
		HashNode<K,V> prev=null;
		
		
		//find index of key present
		while(head!=null)
		{
			if( head.key.equals(key) )
				break;
			prev=head;	
			head=head.next;
		}
		
		//key not present
		if(head==null) return null;
		
		size--;
		
		//key present at head of linked list
		if(prev==null)
		{
			bucketArray.set(index, head.next);
		}
		else
		{	
					prev.next=head.next;
					head.next=null;
		}
		
		return head.val;
		
		
	}
	
	public V search(K key)
	{
		int index=hashFunc(key);
		HashNode<K,V> head=bucketArray.get(index);
		
		//search key in chain
		while(head!=null)
		{
			if(head.key.equals(key)) 
					return head.val;
			head=head.next;
		}
		return null;
	}
	
	public static void main(String[] args) 
	{
		JavaHashMap<String,Integer> hashtable=new JavaHashMap<String, Integer>();
		hashtable.insert("this", 1);
		hashtable.insert("coder", 2);
		hashtable.insert("sd", 3);
		hashtable.insert("hi", 4);
		Integer removeRes=hashtable.remove("this");
		if(removeRes==null)
			System.out.println(" key not present");
		else 
			System.out.println( removeRes);
		
		
		Integer res=hashtable.search("this");
		if(res==null)
			System.out.println("not found");
		else 
			System.out.println("found "+ res);
		
		
		
	}

}
