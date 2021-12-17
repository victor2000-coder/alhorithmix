package com.company.Code.BynaryTree;

import java.util.*;

public class SortedBinaryTree{
    private static class Node implements Comparable<Node>{
        public Node[] children = new Node[2];
        Integer value;
        public void addChild(Integer p){
            if (p.hashCode() > value.hashCode()){
                if (children[1] != null){
                    children[1].addChild(p);
                }else{
                    children[1] = new Node(p);
                }
            }else if (p.hashCode() < value.hashCode()){
                if (children[0] != null){
                    children[0].addChild(p);
                }else{
                    children[0] = new Node(p);
                }
            }
        }
        public void addChild(Node p){
            if (p.value > value){
                if (children[1] != null){
                    children[1].addChild(p);
                }else{
                    children[1] = p;
                }
            }else if (p.value < value){
                if (children[0] != null){
                    children[0].addChild(p);
                }else{
                    children[0] = p;
                }
            }
        }
        public Node(Integer value) {
            this.value = value;
        }

        @Override
        public int compareTo(Node o) {
            return this.value - o.value;
        }
    }
    public void add(Integer p){
        if (root == null){
            root = new Node(p);
            System.out.println(root);
        }
        root.addChild(p);
    }
    public void add(Integer[] params){
        for (Integer e: params){
            add(e);
        }
        sort();
    }
    public Node root = null;
    public void insert(Integer[] arr){
        for (Integer e: arr){
            root.addChild(e);
        }
    }
    public static void getAllValues(Node root, ArrayList<Node> arr){
        arr.add(new Node(root.value));
        if (root.children[0] != null){
            getAllValues(root.children[0], arr);
        }
        if (root.children[1] != null){
            getAllValues(root.children[1], arr);
        }
    }
    public void sort(){
        ArrayDeque<Node> deque = new ArrayDeque<>();
        ArrayList<Node> temp = new ArrayList<>();
        if (root.children[0] != null){
            getAllValues(root.children[0], temp);
        }
        if (root.children[1] != null){
            getAllValues(root.children[1], temp);
        }

        deque.addAll(temp);
        deque = dequeSort(deque);

        while (deque.size() > 1){
            Node a = deque.pop();
            Node b = deque.pop();
            if (deque.size() > 2){
                Node c = deque.pop();
                b.addChild(c);
            }
            b.addChild(a);
            deque.push(b);
            deque = dequeInvert(deque);
        }
        root = deque.pop();
    }
    public static ArrayDeque<Node> dequeInvert(Deque<Node> p){
        ArrayList<Node> array = new ArrayList<>();
        array.addAll(p);
        Collections.reverse(array);
        ArrayDeque<Node> out = new ArrayDeque<>();
        out.addAll(array);
        return out;
    }
    public static ArrayDeque<Node> dequeSort(Deque<Node> p){
        Node[] a = p.toArray(new Node[0]);
        Arrays.sort(a);
        return new ArrayDeque<>(Arrays.asList(a));
    }
    public void draw(int step){
        Stack<Node> stack = new Stack<>();
        Stack<Integer> steps = new Stack<>();
        steps.push(step);
        stack.push(root);
        while (!stack.isEmpty()){
            Node n = stack.pop();
            step = steps.pop();
            if(n.children[0] != null){
                stack.push(n.children[0]);
                steps.push(step + 1);
            }
            if(n.children[1] != null){
                stack.push(n.children[1]);
                steps.push(step + 1);
            }
            for (int i = 0; i < step; i++){
                System.out.print("| ");
            }
            System.out.println(n.value);
        }
    }
}
