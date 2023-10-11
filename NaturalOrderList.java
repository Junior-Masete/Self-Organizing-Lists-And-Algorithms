public class NaturalOrderList<T extends Comparable<T>> extends SelfOrderingList<T> {
    @Override
    public SelfOrderingList<T> getBlankList() {
        //TODO: Implement the function
        NaturalOrderList<T> obj = new NaturalOrderList<>();
        return obj;
    }

    @Override
    public void access(T data) {
        
    }

    @Override
    public void insert(T data) {
        Node<T> nodePtr = head;
        if(nodePtr == null){
            head = new Node<T>(data);
        }
    }
}
