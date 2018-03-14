package com.hnqc.matcher.ac;

import com.hnqc.matcher.MatcherResult;

import java.util.*;

/**
 * Ac自动机算法
 *
 * @author zido
 */
public class Ac {
    private int lastState = 1;
    /**
     * 状态机根节点
     */
    private AcNode root = new AcNode(0);

    private AcNode[] failure;

    public Ac(List<String> modes) {
        buildTree(modes);
        buildFailure();
    }

    private void buildTree(List<String> modes) {
        for (String mode : modes) {
            buildTree(mode);
        }
    }

    private void buildTree(String mode) {
        char[] chs = mode.toCharArray();
        AcNode last = root;
        for (char ch : chs) {
            AcNode newNode = new AcNode(lastState++);
            last.next(ch, newNode);
            last = newNode;
        }
        last.setFinish(true);
        last.setMode(mode);
    }

    private void buildFailure() {
        failure = new AcNode[lastState];
        Queue<AcNode> queue = new LinkedList<>();
        Set<Character> nextChars = root.nextChars();
        for (Character nextChar : nextChars) {
            AcNode nextNode = root.next(nextChar);
            failure[nextNode.getState()] = root;
            queue.offer(nextNode);
        }
        while (!queue.isEmpty()) {
            AcNode known = queue.poll();
            Set<Character> characters = known.nextChars();
            for (Character character : characters) {
                AcNode nxt = known.next(character);
                AcNode last = failure[known.getState()];
                while (last != root && last.next(character) != null) {
                    last = failure[last.getState()];
                }
                if (last.next(character) == null) {
                    failure[nxt.getState()] = root;
                } else
                    failure[nxt.getState()] = last.next(character);
                queue.offer(nxt);
            }
        }
    }

    public MatcherResult findFirst(String target) {
        AcNode node = root;
        char[] chars = target.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            AcNode next = node.next(chars[i]);
            if (next != null) {
                node = next;
            } else {
                if (i == 0 || node == root) {
                    continue;
                }
                --i;
                node = failure[node.getState()];
            }
            if (node.isFinish()) {
                MatcherResult result = new MatcherResult();
                String mode = node.getMode();
                result.setKeyword(mode);
                result.setStart(i - mode.length() + 1);
                return result;
            }
        }
        return null;
    }

    public List<MatcherResult> findAll(String target) {
        List<MatcherResult> results = new LinkedList<>();
        AcNode node = root;
        char[] chars = target.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            AcNode next = node.next(chars[i]);
            if (next != null) {
                node = next;
            } else {
                if (i == 0 || node == root) {
                    continue;
                }
                --i;
                node = failure[node.getState()];
            }
            if (node.isFinish()) {
                MatcherResult result = new MatcherResult();
                String mode = node.getMode();
                result.setKeyword(mode);
                result.setStart(i - mode.length() + 1);
                results.add(result);
                if (i == 0 || node == root) {
                    continue;
                }
                i = i - mode.length() + 1;
                node = failure[node.getState()];
            }
        }
        return results;
    }
}
