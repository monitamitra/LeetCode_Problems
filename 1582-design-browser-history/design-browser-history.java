class BrowserHistory {
    class Node {
        Node prev;
        Node next;
        String url;

        Node (String url) {
            this.url = url;
            this.next = null;
            this.prev = null;
        }
    }

    Node currPage;

    public BrowserHistory(String homepage) {
        currPage = new Node(homepage);
    }
    
    public void visit(String url) {
        Node newPage = new Node(url);
        currPage.next = newPage;
        newPage.prev = currPage;
        currPage = newPage;
    }
    
    public String back(int steps) {
        for (int i = 0; i < steps; i++) {
            // reached homepage before steps => too many steps
            if (currPage.prev == null) {
                return currPage.url;
            }
            currPage = currPage.prev;
        }
        return currPage.url;
    }
    
    public String forward(int steps) {
        for (int i = 0; i < steps; i++) {
            // reached end of history before steps => too many steps
            if (currPage.next == null) {
                return currPage.url;
            }
            currPage = currPage.next;
        }
        return currPage.url;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */