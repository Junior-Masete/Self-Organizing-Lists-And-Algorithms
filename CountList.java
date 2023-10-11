public class CountList<T extends Comparable<T>> extends SelfOrderingList<T>{
    @Override
    public SelfOrderingList<T> getBlankList() {
        
         CountList<T> newList = new CountList<>();
         return newList;
    }

    @Override
    public void access(T data) {
        Node<T> curr = head;
        Node<T> curr_prev = curr.prev;

        while(curr != null){
            if(curr.data == data){
                curr.accessCount++;

                if(curr != head){
                    Node<T> temp = head;
                    Node<T> temp_prev = null;

                    while(curr.accessCount < temp.accessCount){
                        temp_prev = temp;
                        temp = temp.next;
                    }

                    if(curr != temp){
                        curr_prev = curr.next;
                        curr.next = temp;

                        if(temp == head){
                            head = curr;
                        }
                        else{
                            temp_prev.next= curr;
                        }
                    }
                    
                }
                curr_prev = curr;
                curr = curr.next;
            }
        }


        /* 
        Node<T> node = new Node<T>(data);
        if(head == null){
            return;
        }
        else{
            if(head.data == data){
                node.accessCount++;
           }
           else{
                Node<T> nodePtr = head;
                while(nodePtr.next != null || nodePtr.data != data){
                    nodePtr = nodePtr.next;
                }

                node.accessCount += 1;

           }
        }*/
    }
}
