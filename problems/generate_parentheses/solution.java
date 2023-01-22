class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        Stack<Task> stack = new Stack<>();
        stack.push(new Task("", n, n));

        while (!stack.isEmpty()) {
            Task task = stack.pop();

            if (task.left == 0 && task.right == 0) {
                result.add(task.text);
                continue;
            }

            if (task.left > 0) {
                stack.push(new Task(task.text + "(", task.left - 1, task.right));
            }

            if (task.left < task.right) {
                stack.push(new Task(task.text + ")", task.left, task.right - 1));
            }
        }

        return result;
    }

    private static class Task {
        final String text;
        final int left;
        final int right;

        Task(String text, int left, int right) {
            this.text = text;
            this.left = left;
            this.right = right;
        }
    }
}