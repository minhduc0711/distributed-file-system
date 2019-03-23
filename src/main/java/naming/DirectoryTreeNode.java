package naming;

import storage.Storage;

import java.nio.file.Path;
import java.util.HashMap;
import java.util.Iterator;

public class DirectoryTreeNode {
    private HashMap<String, DirectoryTreeNode> children;
    private boolean isDir;
    private Storage storage;


    public DirectoryTreeNode() {
        children = new HashMap<>();
        isDir = true;
        storage = null;
    }

    public void setIsDir(boolean isDir) {
        this.isDir = isDir;
    }

    public void addChild(String name, DirectoryTreeNode child) {
        children.put(name, child);
    }

    private boolean addPath(Iterator<Path> pathIterator, boolean isDir, Storage storage) {
        if (pathIterator.hasNext()) {
            String nodeName = pathIterator.next().toString();
            if (this.children.containsKey(nodeName)) {
                DirectoryTreeNode nextNode = children.get(nodeName);
                return nextNode.addPath(pathIterator, isDir, storage);
            } else {
                DirectoryTreeNode currentNode = this;
                while (true) {
                    DirectoryTreeNode newNode = new DirectoryTreeNode();
                    currentNode.addChild(nodeName, newNode);
                    if (!pathIterator.hasNext()) {
                        newNode.setIsDir(isDir);
                        if (!isDir) this.storage = storage;
                        break;
                    }
                    currentNode = newNode;
                    nodeName = pathIterator.next().toString();
                }
                return true;
            }
        }
        return false;
    }

    public boolean addPath(Path p, boolean isDir, Storage storage) {
        return addPath(p.iterator(), isDir, storage);
    }

    public HashMap<String, DirectoryTreeNode> getChildren() {
        return children;
    }

    public boolean isDir() {
        return isDir;
    }
}
