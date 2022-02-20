class BrowserHistory {
    
    private HistoryItem history;

    public BrowserHistory(String homepage) {
        history = new HistoryItem(homepage);
    }
    
    public void visit(String url) {
        HistoryItem item = new HistoryItem(url);
        item.prev = history;
        history.next = item;
        history = item;
    }
    
    public String back(int steps) {
        while (steps-- > 0 && history.prev != null) {
            history = history.prev;
        }
        return history.url;
    }
    
    public String forward(int steps) {
        while (steps-- > 0 && history.next != null) {
            history = history.next;
        }
        return history.url;
    }
    
    private class HistoryItem {
        String url;
        HistoryItem prev;
        HistoryItem next;
        
        HistoryItem (String url) {
            this.url = url;
        }
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */