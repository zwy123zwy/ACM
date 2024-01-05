package org.example.yitutest;

import java.util.*;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
        //this.next=next;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

class ProcessScheduling {
    private int numProcesses; // 工序数量
    private List<List<Integer>> adjacencyList; // 邻接表表示工序依赖关系

    public ProcessScheduling(int numProcesses) {
        this.numProcesses = numProcesses;
        adjacencyList = new ArrayList<>(numProcesses);
        for (int i = 0; i < numProcesses; i++) {
            adjacencyList.add(new ArrayList<>());
        }
    }

    public void addDependency(int a, int b) {
        adjacencyList.get(a).add(b);
    }

    public boolean isSchedulingPossible() {
        int[] inDegrees = new int[numProcesses]; // 记录每个工序的入度

        // 统计每个工序的入度
        for (int i = 0; i < numProcesses; i++) {
            for (int j : adjacencyList.get(i)) {
                inDegrees[j]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numProcesses; i++) {
            if (inDegrees[i] == 0) {
                queue.add(i);
            }
        }

        int processedCount = 0;
        while (!queue.isEmpty()) {
            int currProcess = queue.poll();
            processedCount++;

            for (int neighbor : adjacencyList.get(currProcess)) {
                inDegrees[neighbor]--;

                if (inDegrees[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }

        return processedCount == numProcesses;
    }


}



