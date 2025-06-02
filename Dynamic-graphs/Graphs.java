import java.util.Stack;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Graphs {

    public static void main(String[] args) {

        Map<Character, Character[]> graph = new HashMap<>();
        graph.put('a', createEdge('c', 'b'));
        graph.put('b', createEdge('d'));
        graph.put('c', createEdge('e'));
        graph.put('d', createEdge('f'));
        graph.put('e', createEdge());
        graph.put('f', createEdge());

        // depthFirstTraversal(graph, 'a');
        // System.out.println();
        // depthFirstTraversalRecurse(graph, 'a');

        // breadthFirstTraversal(graph, 'a');
        // System.out.println(hasPathDepthTraversal(graph, 'a', 'f'));
        // System.out.println(hasPathBreadthTraversal(graph, 'a', 'f'));

        List<Character[]> edges = new ArrayList<>();
        edges.add(createEdge('i', 'j'));
        edges.add(createEdge('k', 'i'));
        edges.add(createEdge('m',  'k'));
        edges.add(createEdge('k', 'l'));
        edges.add(createEdge('o', 'n'));

        Map<Character, List<Character>> graphs = createUnidirectedGraph(edges);
        // System.out.println(hasPathCyclic(graphs, 'o', 'l', new HashSet<>()));
        System.out.println(connectedComponents(graphs));
    }

    @SafeVarargs
    public static <T> T[] createEdge(T...e) {
        return e;
    }

    public static <T> Map<T, List<T>> createUnidirectedGraph(List<T[]> edges) {
        Map<T, List<T>> graph = new HashMap<>();

        for(T[] current : edges) {

            if ( !graph.containsKey(current[0])) graph.put(current[0], new ArrayList<>());
            if ( !graph.containsKey(current[1])) graph.put(current[1], new ArrayList<>());

            graph.get(current[0]).add(current[1]);
            graph.get(current[1]).add(current[0]);
        }

        return graph;
    } 

    public static void depthFirstTraversal(Map<Character, Character[]> graph, char src) {
        // Breadth 
        Stack<Character> stack = new Stack<>();
        stack.push(src);

        while (!stack.isEmpty()) {

            char current = stack.pop();
            System.out.print(current + " ");

            for( char neighbour: graph.get(current)) {
                stack.push(neighbour);
            }
        }
    }

    public static void breadthFirstTraversal(Map<Character, Character[]> graph, Character src) {
        Queue<Character> q = new LinkedList<>();
        q.add(src);

        while (!q.isEmpty()) {
            
            char current = q.poll();
            System.out.print(current);

            for( char neighbours : graph.get(current)) {
                q.add(neighbours);
            }
        }
    }

    public static void depthFirstTraversalRecurse(Map<Character, Character[]> graph, Character src) {

        System.out.print(src + " ");
        for( Character neighbour:  graph.get(src)) {
            depthFirstTraversalRecurse(graph, neighbour);
        }
    }


    public static boolean hasPathDepthTraversal(Map<Character, Character[]> graph, Character src, Character target) {
        if ( src.equals(target))
            return true;

        for( Character neighbour: graph.get(src)) {
            if ( hasPathDepthTraversal(graph, neighbour, target) ) 
                return true;
        }

        return false;
    }

    public static boolean hasPathBreadthTraversal(Map<Character, Character[]> graph, Character src, Character target) {

        Queue<Character> q = new LinkedList<>();
        q.add(src);

        while (!q.isEmpty()) {

            Character current = q.poll();
            if ( current.equals(target))
                return true;
            
            for( Character neighbour: graph.get(current)) {
                q.add(neighbour);
            }
        }

        return false;
    }

    public static <T> boolean hasPathCyclic(Map<T, List<T>> graph, T src, T target, Set<T> visited) {
        if ( src.equals(target)) return true;
        if ( visited.contains(src)) return false;

        visited.add(src);

        for(T neighbour: graph.getOrDefault(src, new ArrayList<>())) {
            if ( hasPathCyclic(graph, neighbour, target, visited))
                return true;
        }

        return false;
    }

    public static <T> boolean explore(Map<T, List<T>> graph, T src, Set<T> visited) {
        if( visited.contains(src)) return false;

        visited.add(src);

        for( T neighbour: graph.get(src)) {
            explore(graph, neighbour, visited);
        }

        return true;
    }

    public static <T> int connectedComponents(Map<T, List<T>> graph) {

        Set<T> visited = new HashSet<>();
        int count = 0;

        for(T keys : graph.keySet()) {

            if ( explore(graph, keys, visited))
                count += 1;
        }

        return count;
    }
}