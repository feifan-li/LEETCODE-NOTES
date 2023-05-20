package Graph.LC399EvaluateDivision;

import java.util.*;

public class Solution399 {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        double[] result = new double[queries.size()];
        HashMap<String, HashMap<String,Double>> graph = new HashMap<>();
        for(int i=0;i<equations.size();++i){
            List<String> equation = equations.get(i);
            String u = equation.get(0), v = equation.get(1);
            if(!graph.containsKey(u))   graph.put(u,new HashMap<String,Double>());
            graph.get(u).put(v,values[i]);
            if(!graph.containsKey(v))   graph.put(v,new HashMap<String,Double>());
            graph.get(v).put(u,1/values[i]);
        }
        for(int i=0;i<queries.size();++i){
            List<String> query = queries.get(i);
            boolean found = false;
            if(!graph.containsKey(query.get(0)) || !graph.containsKey(query.get(1)))    result[i] = -1.0;
            else if(query.get(0).equals(query.get(1)))  result[i] = 1.0;
            else{
                Queue<String> qS = new LinkedList<>();
                Queue<Double> qD = new LinkedList<>();
                HashSet<String> visited = new HashSet<>();
                qS.offer(query.get(0));
                qD.offer(1.0);
                visited.add(query.get(0));
                while(!qS.isEmpty()){
                    String u = qS.poll();
                    Double product = qD.poll();
                    for(Map.Entry<String,Double> node:graph.get(u).entrySet()){
                        String v = node.getKey();
                        if(!visited.contains(v)){
                            visited.add(v);
                            qS.offer(v);
                            qD.offer(product*node.getValue());
                            if(v.equals(query.get(1))){
                                result[i] = product*node.getValue();
                                found = true;
                                break;
                            }
                        }
                    }
                    if(found) break;
                }
                if(!found) result[i] = -1.0;
            }
        }
        return result;
    }
}
