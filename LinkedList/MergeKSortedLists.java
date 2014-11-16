import java.util.*;

public class MergeKSortedLists{

	public ListNode mergeKLists(List<ListNode> lists) {
        
		if(lists == null || lists.size() == 0)
			return null;
		ListNode head = new ListNode(0);
		Comparator<ListNode> order = new Comparator<ListNode>(){

			public int compare(ListNode n1, ListNode n2){
				return n1.val - n2.val;
			}
		};
		PriorityQueue<ListNode> heap = new PriorityQueue(lists.size(), order);
		for(int i = 0; i < lists.size(); i++){
			ListNode n = lists.get(i);
			if(n != null)
				heap.add(n);
		}
		ListNode rear = head;
		while(!heap.isEmpty()){
			ListNode p = heap.poll();
			rear.next = p;
			if(rear.next != null)
				heap.add(rear.next);
			rear = rear.next;
		}
        return head.next;
    }

}