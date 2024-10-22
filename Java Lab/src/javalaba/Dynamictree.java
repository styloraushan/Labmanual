package javalaba;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;

public class Dynamictree {
    public static void main(String[] args) {
        JFrame f = new JFrame("Avit");

        // Create the root node
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Root");

        // Create the first parent node
        DefaultMutableTreeNode parent1 = new DefaultMutableTreeNode("parent1");
        DefaultMutableTreeNode child1 = new DefaultMutableTreeNode("child1");
        DefaultMutableTreeNode child2 = new DefaultMutableTreeNode("child2");
        parent1.add(child1);
        parent1.add(child2);

        // Create the second parent node
        DefaultMutableTreeNode parent2 = new DefaultMutableTreeNode("parent2");
        DefaultMutableTreeNode child3 = new DefaultMutableTreeNode("child3");
        DefaultMutableTreeNode child4 = new DefaultMutableTreeNode("child4"); // Changed to child4
        parent2.add(child3);
        parent2.add(child4);

        // Add parent nodes to the root
        root.add(parent1); // Corrected order (parent1 before parent2 for consistency)
        root.add(parent2);

        // Create the tree by passing the root node
        JTree tree = new JTree(root);

        // Add the tree to a scroll pane and then to the frame
        f.add(new JScrollPane(tree)); // Corrected to add the scroll pane

        // Set frame properties
        f.setSize(400, 400);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
