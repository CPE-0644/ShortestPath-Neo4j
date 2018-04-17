/*
** Created by Patsakorn Towatrakool
*  # 590610644
*
*    ## To run this
        0. 	Start neo4j server at 'bolt://localhost:7687' user = 'neo4j' password='neo4j' role = admin
        1.	Extract / import zip file
        2.	cd 260_261218_hw4_590610644/src/main/java
        3.	compile `$ javac -cp "..\..\..\libs\neo4j-java-driver-1.5.1.jar;"  Homework4.java`
        4.	run `$ java -cp "..\..\..\libs\neo4j-java-driver-1.5.1.jar;"  Homework4 <start_node default=A> <goal_node default=H> <threshold default=5>`

        example
            >> $ java -cp "..\..\..\libs\neo4j-java-driver-1.5.1.jar;"  Homework4 A H 3
            >> NO

            >> $ java -cp "..\..\..\libs\neo4j-java-driver-1.5.1.jar;"  Homework4 A C 3
            >> YES
*
*
**
 */

import org.neo4j.driver.v1.*;

import java.util.*;

import static java.lang.Integer.MAX_VALUE;
import static org.neo4j.driver.v1.Values.parameters;

public class Homework4 implements AutoCloseable {
    private final Driver driver;

    public Homework4(String uri, String user, String password) {
        driver = GraphDatabase.driver(uri, AuthTokens.basic(user, password));
    }

    @Override
    public void close() throws Exception {
        driver.close();
    }

    public void findShortestPath(String start, String goal, int threshold) {
        try (Session session = driver.session()) {
            String path = session.writeTransaction(new TransactionWork<String>() {
                @Override
                public String execute(Transaction tx) {
                    StatementResult result = tx.run("MATCH (a:Node) return a.name");
                    List<Record> allRecordVertex = result.list();
                    Map<String, Vertex> vertices = new HashMap<>();
                    for (int i = 0; i < allRecordVertex.size(); i++) {
                        String u = allRecordVertex.get(i).values().toString();
                        u = u.charAt(2) + "";
                        vertices.put(u, new Vertex(u));
//                        System.out.println(vertices.get(u).name);
                    }
                    vertices.get(start).dist = 0;
                    Queue<String> q = new LinkedList<>();
                    q.add(start);
                    while (q.size() > 0) {
                        String u = q.remove();
                        result = tx.run("MATCH (a:Node)-[:CONNECTS]-(b:Node)" +
                                        "where a.name = $start return b.name",
                                parameters("start", u));
                        List<Record> records = result.list();
                        int s = records.size();
//                        System.out.println(s);
                        for (int i = 0; i < s; i++) {
                            String v = records.get(i).values().toString();
                            v = v.charAt(2) + "";
//                            System.out.println(v);
                            if (vertices.get(v).dist == MAX_VALUE) {
                                q.add(v);
                                vertices.get(v).dist = vertices.get(u).dist + 1;
                            }
                        }
                    }
                    for (int i = 0; i < allRecordVertex.size(); i++) {
                        String u = allRecordVertex.get(i).values().toString();
                        u = u.charAt(2) + "";
//                        System.out.println(vertices.get(u).name + " " + vertices.get(u).dist);
                    }
//                    actually path length
//                    System.out.println(start + " -> " + goal + " use " + vertices.get(goal).dist);
                    return (vertices.get(goal).dist <= threshold) ? "YES" : "NO";
                }

            });
            System.out.println(path);
        }
    }

    public static void main(String... args) throws Exception {
        String start, goal;
        int threshold;
        if (args.length >= 3) {
            start = args[0];
            goal = args[1];
            threshold = Integer.parseInt(args[2]);
        } else { // initialize if user not defined
            start = "A";
            goal = "H";
            threshold = 5;
        }
//      user input
//        System.out.println(start + " -> " + goal + " : " + threshold);

        // FIXME: change user, password to relate to your server
        try (Homework4 findPathLength = new Homework4("bolt://localhost:7687", "neo4j", "neo4j")) {
            findPathLength.findShortestPath(start, goal, threshold);
        }
    }

    public class Vertex {
        String name;
        int dist;
        Vertex prev;

        public Vertex(String name) {
            this.name = name;
            this.dist = MAX_VALUE;
            this.prev = null;
        }
    }
}
