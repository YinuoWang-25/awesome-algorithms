# Dynamic Connectivity

## Description

![dynamic connectivity](assets/dynamic_connectivity.png)

<br>

## Modeling

### Modeling the objects

Applications involve manipulating objects of all types:

- Pixels in a digital photo.
- Computers in a network.
- Friends in a social network.

  ...

When programming, convenient to name objects 0 to N –1.

- Use integers as array index

- Suppress details not relevant to union-find.

### Modeling the connections

We assume **is connected to** is an equivalence relation:

- Reflexive: p is connected to p.
- Symmetric: if p is connected to q, then q is connected to p.
- Transitive: if p is connected to q and q is connected to r, then p is connected to r.

**Connected components** - Maximal **set** of objects that are mutually
connected.

![connected component](assets/connected_component.png)

<br>

## Implementing the operations

### Find query

Check if two objects are in the same component

### Union command

Replace components containing two objects with their union

![union command](assets/union_command.png)

<br>

## Union-find data type (API)

Design efficient data structure for union-find

- Number of objects _N_ can be huge.

- Number of operations _M_ can be huge.

- Find queries and union commands may be intermixed.

![class UF](assets/class_uf.png)

<br>

## Dynamic-connectivity client

Read in number of objects N from standard input.

Repeat

- read in pair of integers from standard input

- if they are not yet connected, connect them and print out pair

![UF client](assets/uf_client.png)

<br>

# Quick Find [eager approach]

## Data structure

- Integer array id[] of length N

- Interpretation: p and q are connected iff (if and only if) they have the same id

![quick find](assets/quick_find.png)

## Find

Check if p and q have the same id.

id[6] = 0; id[1] = 1
6 and 1 are not connected

## Union

To merge components containing p and q, change all entries whose id equals id[p] to id[q]

![quick find union](assets/quick_find_union.png)

## Java implementation

![quick find java](assets/quick_find_java.png)

## Too Slow

### Cost model

![quick find cost](assets/quick_find_cost.png)

### Union is too expensive

It takes N^2 (quadratic) array accesses to process a sequence of
N union commands on N objects.
