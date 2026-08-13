import java.util.*;

public class SortedListToBST {

    private List<Integer> values = new ArrayList<>();

    public TreeNode sortedListToBST(ListNode head) {

        ListNode current = head;

        while (current != null) {
            values.add(current.val);
            current = current.next;
        }

        return buildBST(0, values.size() - 1);
    }

    private TreeNode buildBST(int left, int right) {

        if (left > right) {
            return null;
        }

        int mid = left + (right - left) / 2;

        TreeNode leftSubtree = buildBST(left, mid - 1);

        TreeNode rightSubtree = buildBST(mid + 1, right);

        TreeNode root = new TreeNode(
                values.get(mid),
                leftSubtree,
                rightSubtree
        );

        return root;
    }

    // Print tree in inorder
    public static void printInorder(TreeNode root) {

        if (root == null) {
            return;
        }

        printInorder(root.left);
        System.out.print(root.val + " ");
        printInorder(root.right);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        ListNode head = null;
        ListNode tail = null;

        System.out.println("Enter sorted list elements:");

        for (int i = 0; i < n; i++) {

            int value = sc.nextInt();

            ListNode newNode = new ListNode(value);

            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        SortedListToBST obj = new SortedListToBST();

        TreeNode root = obj.sortedListToBST(head);

        System.out.print("BST Inorder: ");
        printInorder(root);

        sc.close();
    }
}

// Linked List Node
class ListNode {

    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

// Binary Tree Node
class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}