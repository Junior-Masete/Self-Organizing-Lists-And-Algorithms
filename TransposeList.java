public class TransposeList<T extends Comparable<T>> extends SelfOrderingList<T> {
    @Override
    public SelfOrderingList<T> getBlankList() {
        //TODO: Implement the function
        TransposeList<T> obj = new TransposeList<>();
        return obj;
    }

    @Override
    public void access(T data) {
        Node<T> nodePtr = head;
        if(nodePtr == null){
            head = new Node<T>(data);
            //return;
        }

        Node<T> prev = null;
        while(nodePtr != null){
            if((nodePtr.data).compareTo(data) == 0){
                break;
            }
            prev = nodePtr;
            nodePtr = nodePtr.next;
        }

        if(nodePtr == null){
            prev.next = new Node<T>(data);
            //return;
        }
        else if(prev != null){
            prev.next = nodePtr.next;
            nodePtr.next = head;
            head = nodePtr;
        }
    }
}
