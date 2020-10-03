
import java.awt.*;
import java.util.ArrayList;

public class BadGuy {
	private Node[][] grid = new Node[40][40];
	private Image myImage;
	private int x=0,y=0;
	private boolean hasPath=false;

	public BadGuy( Image i ) {
		myImage=i;
		x = 30;
		y = 10;


	}
	
	public ArrayList<Node> reCalcPath(boolean[][] map, int targx, int targy) {
		// TO DO: calculate A* path to targx,targy, taking account of walls defined in map[][]
		for (int k = 0; k < grid.length; k++) {
			for (int w = 0; w < grid[k].length; w++) {
				grid[k][w] = new Node(k, w);
			}
		}

		for (int i = 0; i < 40; i++) {
			for (int j = 0; j < 40; j++) {
				if (map[i][j] = false) {
					grid[i][j].setWall(true);
				}
			}
		}



		Node start = new Node(x, y);
		Node end = new Node(targx, targy);

		start.setParent(start);

		ArrayList<Node> openList = new ArrayList<Node>();
		ArrayList<Node> closedList = new ArrayList<Node>();
		openList.add(start);

		while (!openList.isEmpty() && !closedList.contains(end)) {
			calculateWeights(start.p,end.p);
			Node current = getMinFNode(openList);
			current.setVisited(true);
			closedList.add(current);
			openList.remove(current);


			ArrayList<Node> neighbors = getNeighbors(current.p);
			//Add neighbors to openList
			for (Node n : neighbors) {
				if (!openList.contains(n))
					openList.add(n);
				//Set parent node
				if ((n.getParent() == null) || (n.getParent() != null && n.getParent().F() > current.F()))
					n.setParent(current);


			}

			// sleep to view realtime
		}

		//reconstitute path
		Node tmp = end;
		ArrayList<Node> path = new ArrayList<>();
		if (tmp.getParent() == null) {
			System.out.println("NO SOLUTION FOUND");
			return null;
		} else {
			while (tmp != null) {
				System.out.println(tmp.p);
				if (!tmp.p.equals(start.p) && !tmp.p.equals(end.p)) {
					path.add(tmp);
				}
				tmp = tmp.getParent();
			}
			hasPath = true;
			return path;
		}
	}


	
	public void move(boolean map[][],int targx, int targy) {
		ArrayList<Node> path = reCalcPath(map,targx,targy);
		if (hasPath) {
			while(!path.isEmpty()) {
				for (int i = 0; i <  path.size(); i--) {
					targx = path.get(i).p.x;
					targy = path.get(i).p.y;
					int newx = x;
					int newy = y;

					if (targx<x)
						newx--;
					else if (targx>x)
						newx++;
					if (targy<y)
						newy--;
					else if (targy>y)
						newy++;
					if (!map[newx][newy]) {
						x=newx;
						y=newy;
					}
					else if(newx == targx && newy == targy){
						System.exit(0);
					}
					else
						path = reCalcPath(map,targx,targy);

				}
			}

		}
		else {
			// no path known, so just do a dumb 'run towards' behaviour
			int newx=x, newy=y;
			if (targx<x)
				newx--;
			else if (targx>x)
				newx++;
			if (targy<y)
				newy--;
			else if (targy>y)
				newy++;
			if (!map[newx][newy]) {
				x=newx;
				y=newy;
			}
		}
	}


	public int manhattan(Point a, Point b){
		return Math.abs(a.x - b.x) + Math.abs(a.y - b.y);
	}

	public void calculateWeights(Point s, Point e) {
		for (int i = 0; i < 40; i++) {
			for (int j = 0; j < 40; j++) {
				if (!grid[i][j].isWall()) {
						grid[i][j].setG(manhattan(s, grid[i][j].p));
						grid[i][j].setH(manhattan(e, grid[i][j].p));
				}
			}
		}
	}

	public Node getNode(Point p) {
		return grid[p.x][p.y];
	}

	public ArrayList<Node> getNeighbors(Point current) {
		Node up = null, down = null, left = null, right = null;
		ArrayList<Node> neighbors = new ArrayList<Node>();
		//up
		if (current.x - 1 >= 0)
			up = getNode(new Point(current.x - 1, current.y));
		if (current.x + 1 < 40)
			down = getNode(new Point(current.x + 1, current.y));

		if (current.y - 1 >= 0)
			left = getNode(new Point(current.x, current.y - 1));
		if (current.y + 1 < 40)
			right = getNode(new Point(current.x, current.y + 1));

		if (up != null && !up.isWall() && !up.isVisited())
			neighbors.add(up);
		if (down != null && !down.isWall() && !down.isVisited())
			neighbors.add(down);
		if (left != null && !left.isWall() && !left.isVisited())
			neighbors.add(left);
		if (right != null && !right.isWall() && !right.isVisited())
			neighbors.add(right);

		return neighbors;
	}

	public Node getMinFNode(ArrayList<Node> nodes) {
		if (!nodes.isEmpty()) {
			Node minNode = nodes.get(0);
			for (Node n : nodes) {
				if (n.F() < minNode.F())
					minNode = n;
			}
			return minNode;
		}
		return null;
	}

	public void paint(Graphics g) {
		g.drawImage(myImage, x*20, y*20, null);
	}
	
}

