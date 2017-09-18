/**
 * @author Richard S. Stansbury
 * @version 1.0, 2017-09-18
 *
 * Implementation of a singly linked list node with a head, but no tail.
 */
public class SLList<t> {

    //Class Variables
    protected SLLNode<t> head;

    /**
     * Default constructor for the list.
     */
    public SLList() {
        head = null;
    }

    /**
     * Inserts an item into the list at the list's end.
     * @param value - value to be stored in node.
     */
    public void add(t value) {
        //Empty List Case
        if (head == null) {
            head = new SLLNode<>(value);
        }
        else {

            //Traverse the list until last node is reached
            SLLNode<t> cur = head;
            while (cur.next != null) {
                cur = cur.next;
            }

            //Add new note after last item on list (i.e. cur.next)
            cur.next = new SLLNode<>(value);

        }
    }

    /**
     * Returns value of the ith node in the list
     * @param i - index (zero-indexed) of target node
     * @return value of target node.
     */
    public t getValueAt(int i) {

        //Special Case - empty list
        if (head == null) return null;

        //Special Case - index less than zero
        if (i < 0) return null;

        //Special Case - first item
        if (i==0) {
            return head.info;
        }

        //Traverse to the ith indexed item (zero indexed)
        int j = 0;
        SLLNode<t> cur = head;
        while (j != i) {
            cur = cur.next;
            j++;

            //Special Case - index is out of bounds;
            if (cur == null) {
                return null;
            }
        }

        //Normal Case - return ith value
        return cur.info;
    }

    /**
     * Deletes the ith node in the list and returns its value
     * @param i - index (zero indexed) of the node to delete
     * @return value stored in the deleted node.
     */
    public t deleteValueAt(int i) {

        t tmp;

        //Special cases - empty list or bad index.
        if ((head == null) || (i < 0)) return null;

        //Special case - delete head item (i = 0)
        if (i==0) {
            tmp = head.info;
            head = head.next;
            return tmp;
        }

        //Traverse to the ith indexed item (zero indexed)
        int j = 0;
        SLLNode<t> cur = head;
        SLLNode<t> prev = null;
        while (j != i) {
            prev = cur;
            cur = cur.next;
            j++;

            //Special Case - index is out of bounds;
            if (cur == null) {
                return null;
            }
        }

        //Normal Case - delete ith node and return its value.
        prev.next = cur.next;
        return cur.info;

    }

    /**
     * Prints all elements in the list.
     */
    public void printAll()  {

        SLLNode<t> cur = head;
        while (cur != null) {
            System.out.println(cur);
            cur = cur.next;
        }
    }

    public static void main(String [] args) {

        SLList<String> list = new SLList<>();

        //Test Case - Empty List
        System.out.println("Empty List Cases");
        list.printAll(); //Nothing should be printed
        System.out.println(list.deleteValueAt(0)); //Should print null
        System.out.println(list.getValueAt(0)); //Should print null

        //Add Values
        System.out.println("Test Add");
        list.add("Tom");
        list.add("Dick");
        list.add("Gary");
        list.printAll();


        //Delete First Item
        System.out.println("Delete First Item");
        System.out.println(list.deleteValueAt(0)); //Should print null
        list.printAll();


        //Test - Add after delete
        System.out.println("Add after delete tests");
        list.add("Larry");
        list.printAll();

        //Test - get values at locations
        System.out.println("Get Tests");
        System.out.println(list.getValueAt(-1)); //Should print null
        System.out.println(list.getValueAt(3)); //Should print null
        System.out.println(list.getValueAt(0)); //Dick
        System.out.println(list.getValueAt(1)); //Gary
        System.out.println(list.getValueAt(2)); //Larry


        //Test - delete at locations
        System.out.println("Delete Tests");
        System.out.println(list.deleteValueAt(-1)); //Should print null
        System.out.println(list.deleteValueAt(3)); //Should print null
        System.out.println(list.deleteValueAt(2)); //Larry
        System.out.println(list.deleteValueAt(1)); //Gary
        System.out.println(list.deleteValueAt(0)); //Dick
        list.printAll();

    }


}
