# To create the 14.9 graph relation
```
create (a:Node{name:"A"}),
(b:Node{name:"B"}),
(c:Node{name:"C"}),
(d:Node{name:"D"}),
(e:Node{name:"E"}),
(f:Node{name:"F"}),
(g:Node{name:"G"}),
(h:Node{name:"H"}),
(i:Node{name:"I"}),
(j:Node{name:"J"}),
(k:Node{name:"K"}),
(l:Node{name:"L"}),
(m:Node{name:"M"}),
(n:Node{name:"N"}),
(o:Node{name:"O"}),
(p:Node{name:"P"}),
(a)-[:CONNECTS]->(b),
(b)-[:CONNECTS]->(c),
(c)-[:CONNECTS]->(d),
(a)-[:CONNECTS]->(e),
(e)-[:CONNECTS]->(f),
(f)-[:CONNECTS]->(b),
(a)-[:CONNECTS]->(f),
(c)-[:CONNECTS]->(g),
(d)-[:CONNECTS]->(h),
(d)-[:CONNECTS]->(g),
(e)-[:CONNECTS]->(i),
(i)-[:CONNECTS]->(f),
(i)-[:CONNECTS]->(m),
(i)-[:CONNECTS]->(j),
(j)-[:CONNECTS]->(g),
(h)-[:CONNECTS]->(l),
(l)-[:CONNECTS]->(p),
(o)-[:CONNECTS]->(k),
(k)-[:CONNECTS]->(g),
(g)-[:CONNECTS]->(l),
(j)-[:CONNECTS]->(k),
(m)-[:CONNECTS]->(n),
(i)-[:CONNECTS]->(n),
(n)-[:CONNECTS]->(k)
```

# Delete all node
```
MATCH (n)
OPTIONAL MATCH (n)-[r]-()
DELETE n,r
```



