class Solution {
    public String simplifyPath(String path) {
        String[] dirs = path.split("/");
        int read = 0;
        int write = 0;
        
        while (read < dirs.length) {
            String dir = dirs[read];
            ++read;

            if (dir.isEmpty() || dir.equals(".")) {
                continue;
            } else if (dir.equals("..")) {
                if (write > 0) {
                    --write;
                }
            } else {
                dirs[write] = dir;
                ++write;
            }
        }

        if (write == 0) {
            return "/";
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < write; ++i) {
            builder.append("/").append(dirs[i]);
        }
        return builder.toString();
    }
}