import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;

public class Prob4 extends JFrame {

    private JTree tree;
    private DefaultMutableTreeNode root;
    private DefaultMutableTreeNode[] nodes;

    public Prob4() {
        super("MyTree");

        root = new DefaultMutableTreeNode("Product");
        tree = new JTree(root);
        nodes = new DefaultMutableTreeNode[8];

        String[] data = {
                "HardwareProduct",
                "VideoCard",
                "Monitor",
                "SoftwareProduct", "OperatingSystem", "UtilitySoftware", "Game", "ProgrammingLanguage"};

        for(int i = 0; i < data.length; i++) {
            nodes[i] = new DefaultMutableTreeNode(data[i], true);
        }

        root.add(nodes[0]);
        root.add(nodes[3]);
        nodes[0].add(nodes[1]);
        nodes[0].add(nodes[2]);
        nodes[3].add(nodes[4]);
        nodes[3].add(nodes[5]);
        nodes[3].add(nodes[6]);
        nodes[3].add(nodes[7]);

        add(tree);
    }

    public static void main(String[] args) {
        var f = new Prob4();
        f.setSize(650, 300);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

