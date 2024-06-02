package cpclub.weekfour;

import java.util.LinkedList;
import java.util.Scanner;

public class CdAndPwd {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        LinkedList<String> pathStack = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            String input = sc.nextLine();

            if ("pwd".equals(input)) {
                StringBuilder currentPath = new StringBuilder("/");
                for (String dir : pathStack) currentPath.append(dir).append("/");
                System.out.println(currentPath);
            } else {
                String newPath = input.substring(3);
                if (newPath.startsWith("/")) {
                    pathStack.clear();
                    newPath = newPath.substring(1);
                }

                String[] components = newPath.split("/");
                for (String component : components) {
                    if (component.equals("..")) {
                        if (!pathStack.isEmpty()) pathStack.removeLast();
                    } else if (!component.isEmpty()) {
                        pathStack.add(component);
                    }
                }
            }
        }
    }
}

